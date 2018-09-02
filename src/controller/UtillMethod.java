package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.InputMismatchException;

import main.Main;
import model.Gorivo;
import model.Rezervacija;
import model.Servis;
import model.Vozilo;

public class UtillMethod implements KorisnickiInput {
	// Metoda za parsuje datum u obliku stringa u LocalDate
	public static LocalDate parsovanjeDatuma(String zeljeniDatum) {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.parse(zeljeniDatum, dateFormat);
		return date;
	}

	// Metoda koja trazi od korisnika da unese datum
	public static LocalDate unosDatum(String s) {
		boolean trig = true;
		do {
			try {
				System.out.println("Unesite " + s + " datum, tipa DD/MM/YYYY");
				String datum = input.next();
				DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate date = LocalDate.parse(datum, dateFormat);
				trig = false;
				return date;

			} catch (DateTimeParseException e) {
				System.out.println("Nevalidan Unos!");
			}

		} while (trig);
		return null;
	}

	// Metoda koja vraca danasnji datum kao string!
	public static String DanasnjiDatum() {
		LocalDate danasnji = LocalDate.now();
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String danasnjidatum = danasnji.format(dateFormat);
		return danasnjidatum;
	}

	// Metoda za listanje vozila
	public static void izlistavanjeVozila() {
		int redniBrojVoz = 0;
		for (Vozilo v : Main.getVozilaAll()) {
			if (!v.isVozObrisano()) {
				System.out.println(redniBrojVoz + "-" + v.getVrstaVozila() + "-" + v.getRegBR());
				redniBrojVoz++;
			} else {
				redniBrojVoz++;
			}
		}

	}

	// Metoda koja racuna cenu iznajmljivanja auta
	public static double cenaIznaj(LocalDate a, LocalDate b, Vozilo v) {
		long daysBetween = ChronoUnit.DAYS.between(a, b);
		double cena = daysBetween * v.getCenaDan();
		return cena;
	}

	// Metoda koja trazi od korisnika da unese int i odma je parsuje!
	public static int unesiteInt() {
		while (true) {
			try {
				int rez = input.nextInt();
				return rez;
			} catch (InputMismatchException e) {
				System.out.println("Vas unos moras biti integer, pokusajte ponovo!");
				input.next();
			}
		}
	}

	// Metoda za unos registarskog broja
	public static int unosRegBroj() {
		while (true) {
			boolean flag = true;
			System.out.println("Unesite registarski broj vozila:");
			int unosTablica = UtillMethod.unesiteInt();
			for (Vozilo v : Main.getVozilaAll()) {
				if (unosTablica == v.getRegBR()) {
					System.out.println("Ovaj registarski broj je vec zauzet, pokusajte ponovo!");
					flag = false;
				}
			}
			if (flag) {
				return unosTablica;
			}

		}

	}

	// Metoda koja od korisnika trazi da izabere vrstu goriva!
	public static Gorivo izabirGoriva() {
		while (true) {
			System.out.println("Izaberite gorivo koje koristi vozilo:");
			System.out.println("1 Benzin");
			System.out.println("2 Dizel");
			int unos = unesiteInt();
			if (unos == 1) {
				return Main.benzin;
			} else if (unos == 2) {
				return Main.dizel;
			} else {
				System.out.println("Pogresan unos pokusajte ponovo");
			}

		}
	}

	// Metoda koja trazi od korisnika da unese potrosnju kao double!
	public static double unesiteDoublePotrosnja() {
		while (true) {
			try {
				System.out.println("Unesite potrosnju(double) na 100km:");
				double rez = input.nextDouble();
				return rez;
			} catch (InputMismatchException e) {
				System.out.println("Vas unos mora biti double, pokusajte ponovo!");
				input.next();
			}
		}
	}

	// Metoda koja radi prvi servis na vozilu!
	public static void prviServis(Vozilo v, int i) {
		Servis prviServis = new Servis(v, DanasnjiDatum(), i);
		v.dodajServis(prviServis);
	}

	// Metoda koja vrsi servis na vozilu!
	public static void odlazakNaServis(Vozilo v) {
		Servis servis = new Servis(v, DanasnjiDatum(), v.getPredjeno());
		v.dodajServis(servis);
		if (v.getVrstaVozila().equals("Putnicko Vozilo")) {
			v.setPreServis(10000);
		} else if (v.getVrstaVozila().equals("Teretno Vozilo")) {
			v.setPreServis(20000);
		} else {
			v.setPreServis(700);
		}
	}

	// Metoda koja od korisnika trazi da unese double!
	public static double unesiteDouble() {
		while (true) {
			try {
				System.out.println("Unesite double:");
				double rez = input.nextDouble();
				return rez;
			} catch (InputMismatchException e) {
				System.out.println("Vas unos mora biti double, pokusajte ponovo!");
				input.next();
			}
		}
	}

	// Metoda koja proverava da li treba odraditi servis i odradjuje po potrebi
	public static void proveraServisaVozila(Vozilo v) {
		if (v.getVrstaVozila().equals("Putnicko Vozilo") && v.velicinaServisa() >= 1) {
			Servis prethodniServis = v.getServisiNadVozilom(v.velicinaServisa() - 1);
			int km = v.getPredjeno() - prethodniServis.getBrPredjenihKm();
			if (km >= 10000) {
				System.out.println("Vozilo je preslo dovoljnu razdaljinu za servis!");
				System.out.println("Servis u toku!");
				odlazakNaServis(v);
			} else {
				System.out.println("Vozilu nije neophodan servis!");
			}
		} else if (v.getVrstaVozila().equals("Teretno Vozilo") && v.velicinaServisa() >= 1) {
			Servis prethodniServis = v.getServisiNadVozilom(v.velicinaServisa() - 1);
			int km = v.getPredjeno() - prethodniServis.getBrPredjenihKm();
			if (km >= 20000) {
				System.out.println("Vozilo je preslo dovoljnu razdaljinu za servis!");
				System.out.println("Servis u toku!");
				odlazakNaServis(v);
			} else {
				System.out.println("Vozilu nije neophodan servis!");
			}
		} else if (v.getVrstaVozila().equals("Bicikl") && v.velicinaServisa() >= 1) {
			Servis prethodniServis = v.getServisiNadVozilom(v.velicinaServisa() - 1);
			int km = v.getPredjeno() - prethodniServis.getBrPredjenihKm();
			if (km >= 700) {
				System.out.println("Vozilo je preslo dovoljnu razdaljinu za servis!");
				System.out.println("Servis u toku!");
				odlazakNaServis(v);
			} else {
				System.out.println("Vozilu nije neophodan servis!");
			}
		} else if (v.getVrstaVozila().equals("Putnicko Vozilo") && v.velicinaServisa() < 1) {
			if (v.getPredjeno() > 10000) {
				System.out.println("Vozilo je preslo dovoljnu razdaljinu za servis!");
				System.out.println("Servis u toku!");
				odlazakNaServis(v);
			} else {
				System.out.println("Vozilu nije neophodan servis!");
			}
		} else if (v.getVrstaVozila().equals("Teretno Vozilo") && v.velicinaServisa() < 1) {
			if (v.getPredjeno() > 20000) {
				System.out.println("Vozilo je preslo dovoljnu razdaljinu za servis!");
				System.out.println("Servis u toku!");
				odlazakNaServis(v);
			} else {
				System.out.println("Vozilu nije neophodan servis!");
			}
		} else {
			if (v.getPredjeno() > 700) {
				System.out.println("Vozilo je preslo dovoljnu razdaljinu za servis!");
				System.out.println("Servis u toku!");
				odlazakNaServis(v);
			} else {
				System.out.println("Vozilu nije neophodan servis!");
			}
		}
	}

	// Metoda koja proverava da li vozilo ima aktivne rezervacije!
	public static boolean voziloImaRezervacije(Vozilo v) {
		for (Rezervacija e : Main.getRezervacijeAll()) {
			if (e.getVozilo().equals(v) && !e.isRezervacijaObrisana()) {
				return true;
			}
		}
		return false;
	}

	// Metoda koja racuna cenu za vracanje vozila
	public static double ukupnaCenaIznajmljivanja(Rezervacija r, int i) {
		double cenaPuta = MeniFunkcionalnost.cenaTroskaVoz(r.getVozilo(), i);
		double cenaIznaj = cenaIznaj(UtillMethod.parsovanjeDatuma(r.getDatumPocetka()),
				UtillMethod.parsovanjeDatuma(r.getDatumKraja()), r.getVozilo());
		r.getVozilo().setPredjeno(r.getVozilo().getPredjeno() + i);
		if (proveraServisaVozilaBool(r.getVozilo())) {
			System.out.println("Troskovi servisa ce biti dodati u cenu!");
			double ukupnaCena = cenaPuta + cenaIznaj + r.getVozilo().getCenaServis();
			return ukupnaCena;
		} else {
			double ukupnaCena = cenaPuta + cenaIznaj;
			return ukupnaCena;
		}

	}

	// Metoda koja proverava da li treba odraditi servis i odradjuje po potrebi i
	// bool
	public static boolean proveraServisaVozilaBool(Vozilo v) {
		if (v.getVrstaVozila().equals("Putnicko Vozilo") && v.velicinaServisa() > 1) {
			Servis prethodniServis = v.getServisiNadVozilom(v.velicinaServisa() - 1);
			int km = v.getPredjeno() - prethodniServis.getBrPredjenihKm();
			if (km >= 10000) {
				System.out.println("Vozilo je preslo dovoljnu razdaljinu za servis!");
				System.out.println("Servis u toku!");
				odlazakNaServis(v);
				return true;
			} else {
				System.out.println("Vozilu nije neophodan servis!");
				return false;
			}
		} else if (v.getVrstaVozila().equals("Teretno Vozilo") && v.velicinaServisa() > 1) {
			Servis prethodniServis = v.getServisiNadVozilom(v.velicinaServisa() - 1);
			int km = v.getPredjeno() - prethodniServis.getBrPredjenihKm();
			if (km >= 20000) {
				System.out.println("Vozilo je preslo dovoljnu razdaljinu za servis!");
				System.out.println("Servis u toku!");
				odlazakNaServis(v);
				return true;
			} else {
				System.out.println("Vozilu nije neophodan servis!");
				return false;
			}
		} else if (v.getVrstaVozila().equals("Bicikl") && v.velicinaServisa() > 1) {
			Servis prethodniServis = v.getServisiNadVozilom(v.velicinaServisa() - 1);
			int km = v.getPredjeno() - prethodniServis.getBrPredjenihKm();
			if (km >= 700) {
				System.out.println("Vozilo je preslo dovoljnu razdaljinu za servis!");
				System.out.println("Servis u toku!");
				odlazakNaServis(v);
				return true;
			} else {
				System.out.println("Vozilu nije neophodan servis!");
				return false;
			}
		} else if (v.getVrstaVozila().equals("Putnicko Vozilo") && v.velicinaServisa() <= 1) {
			if (v.getPredjeno() > 10000) {
				System.out.println("Vozilo je preslo dovoljnu razdaljinu za servis!");
				System.out.println("Servis u toku!");
				odlazakNaServis(v);
				return true;
			} else {
				System.out.println("Vozilu nije neophodan servis!");
				return false;
			}
		} else if (v.getVrstaVozila().equals("Teretno Vozilo") && v.velicinaServisa() <= 1) {
			if (v.getPredjeno() > 20000) {
				System.out.println("Vozilo je preslo dovoljnu razdaljinu za servis!");
				System.out.println("Servis u toku!");
				odlazakNaServis(v);
				return true;
			} else {
				System.out.println("Vozilu nije neophodan servis!");
				return false;
			}
		} else {
			if (v.getPredjeno() > 700) {
				System.out.println("Vozilo je preslo dovoljnu razdaljinu za servis!");
				System.out.println("Servis u toku!");
				odlazakNaServis(v);
				return true;
			} else {
				System.out.println("Vozilu nije neophodan servis!");
				return false;
			}
		}
	}

}
