package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import main.Main;
import model.Bicikl;
import model.Gorivo;
import model.Osoba;
import model.PutnickoVozilo;
import model.Rezervacija;
import model.Servis;
import model.TeretnaVozila;
import model.Vozilo;

public class MeniFunkcionalnost implements KorisnickiInput {

	// Metoda za racunanje troskova predjenog puta
	public static void TroskoviPredjenogPuta() {
		UtillMethod.izlistavanjeVozila();
		System.out.println("Unesite redni broj vozila za koje zelite da racunate predjeni put!");
		int redniBroj = UtillMethod.unesiteInt();
		if (redniBroj < Main.getVozilaAll().size()) {
			if (!Main.getVozilaAll().get(redniBroj).isVozObrisano()) {
				System.out.println("Unesite broj kilometara koje ste presli sa odgovarajucim vozilom");
				double km = UtillMethod.unesiteInt();
				Vozilo v = Main.getVozilaAll().get(redniBroj);
				double rezultat = cenaTroskaVoz(v, km);
				System.out.println("Cena troskova za predjeni put je " + rezultat + "Dinara!");
			} else {
				System.out.println("Ovo vozilo je obrisano i ne moze da se koristi!");
			}
		} else {
			System.out.println("Uneli ste pogresan redni broj!");
		}
	}

	// Metoda koja dodaje vozilo u listu vozila
	public static void dodajVozilo(Vozilo v) {
		Main.getVozilaAll().add(v);
	}

	// Metoda koja je nastavak metode za racunanje troskova predjenog puta i menja
	// je u zavisnosti od vozila
	public static double cenaTroskaVoz(Vozilo v, double putKm) {
		if (v.getVrstaVozila().equals("Putnicko Vozilo") || v.getVrstaVozila().equals("Teretno Vozilo")) {
			double cena = ((putKm / 100) * v.getPotrosnja100()) * v.getGorivo().getCena();
			return cena;
		} else {
			if (putKm < 60) {
				double cena = 10;
				return cena * 118;
			} else {
				double cena = (putKm / 60) * 10;
				return cena * 118;
			}
		}
	}

	// Metoda za dodavanje putnickog vozila
	public static void dodavanjePutnickogVozila() {
		String vrstaVozila = "Putnicko Vozilo";
		int regBr = UtillMethod.unosRegBroj();
		Gorivo gorivo = UtillMethod.izabirGoriva();
		int brServisa = 1;
		double potrosnja100 = UtillMethod.unesiteDoublePotrosnja();
		System.out.println("Unesite broj km koje je vozilo preslo:");
		int predjeno = UtillMethod.unesiteInt();
		int preServisa = 10000;
		int cenaServisa = 8000;
		System.out.println("Unesite cenu vozila za jedan dan:");
		int cenaDan = UtillMethod.unesiteInt();
		System.out.println("Unesite broj sedista u vozilu:");
		int brSedist = UtillMethod.unesiteInt();
		System.out.println("Unesite broj vrata vozila:");
		int brVrata = UtillMethod.unesiteInt();
		boolean vozObrisano = false;
		ArrayList<Servis> servisiNadVozilom = new ArrayList<Servis>();
		PutnickoVozilo vozilo = new PutnickoVozilo(vrstaVozila, regBr, gorivo, brServisa, potrosnja100, predjeno,
				preServisa, cenaServisa, cenaDan, brSedist, brVrata, vozObrisano, servisiNadVozilom);
		UtillMethod.prviServis(vozilo, predjeno);
		Main.getVozilaAll().add(vozilo);
		System.out.println("Novo vozilo je uspesno dodato u sistem!");
		System.out.println("---------------------------------------");
	}

	// Metoda za dodavanje teretnog vozila
	public static void dodavanjeTeretnogVozila() {
		String vrstaVozila = "Teretno Vozilo";
		int regBr = UtillMethod.unosRegBroj();
		Gorivo gorivo = UtillMethod.izabirGoriva();
		int brServisa = 1;
		double potrosnja = UtillMethod.unesiteDoublePotrosnja();
		System.out.println("Unesite broj km koje je vozilo preslo:");
		int predjeno = UtillMethod.unesiteInt();
		int preServisa = 20000;
		int cenaServisa = 10000;
		System.out.println("Unesite cenu vozila za jedan dan:");
		int cenaDan = UtillMethod.unesiteInt();
		System.out.println("Unesite broj sedista u vozilu:");
		int brSedista = UtillMethod.unesiteInt();
		System.out.println("Unesite broj vrata vozila:");
		int brVrata = UtillMethod.unesiteInt();
		boolean vozObrisano = false;
		ArrayList<Servis> servisiNadVozilom = new ArrayList<Servis>();
		System.out.println("Unesite maximalnu masu koje vozilo moze da prenosi:");
		int maxMasauKg = UtillMethod.unesiteInt();
		System.out.println("Unesite maximalnu visinu u m:");
		double visinauM = UtillMethod.unesiteDouble();
		TeretnaVozila vozilo = new TeretnaVozila(vrstaVozila, regBr, gorivo, brServisa, potrosnja, predjeno, preServisa,
				cenaServisa, cenaDan, brSedista, brVrata, vozObrisano, servisiNadVozilom, maxMasauKg, visinauM);
		UtillMethod.prviServis(vozilo, predjeno);
		Main.getVozilaAll().add(vozilo);
		System.out.println("Novo vozilo je uspesno dodato u sistem!");
		System.out.println("--------------------------------------");
	}

	// Metoda za dodavanje bicikla
	public static void dodavanjeBicikl() {
		String vrstaVozila = "Bicikl";
		int regBr = UtillMethod.unosRegBroj();
		Gorivo gorivo = null;
		int brServisa = 1;
		double potrosnja100 = 0;
		System.out.println("Unesite broj km koje je vozilo preslo:");
		int predjeno = UtillMethod.unesiteInt();
		int preServisa = 700;
		int cenaServisa = 5000;
		System.out.println("Unesite cenu vozila za jedan dan:");
		int cenaDan = UtillMethod.unesiteInt();
		int brSedist = 1;
		int brVrata = 0;
		boolean vozObrisano = false;
		ArrayList<Servis> servisiNadVozilom = new ArrayList<Servis>();
		Bicikl vozilo = new Bicikl(vrstaVozila, regBr, gorivo, brServisa, potrosnja100, predjeno, preServisa,
				cenaServisa, cenaDan, brSedist, brVrata, vozObrisano, servisiNadVozilom);
		UtillMethod.prviServis(vozilo, predjeno);
		Main.getVozilaAll().add(vozilo);
		System.out.println("Novo vozilo je uspesno dodato u sistem!");
		System.out.println("--------------------------------------");
	}

	// Metoda za koja racuna vreme sledeceg servisa!
	public static void proveraServisa() {
		System.out.println("Unesite redni broj vozila za koje racunate vreme sledeceg servisa:");
		UtillMethod.izlistavanjeVozila();
		int redniBroj = UtillMethod.unesiteInt();
		if (redniBroj < Main.getVozilaAll().size()) {
			if (!Main.getVozilaAll().get(redniBroj).isVozObrisano()) {
				UtillMethod.proveraServisaVozila(Main.getVozilaAll().get(redniBroj));
			} else {
				System.out.println("Ovo vozilo je obrisano i ne moze da se koristi!");
			}
		} else {
			System.out.println("Uneli ste pogresan redni broj!");
		}
	}

	// Metoda za trazenje odgovarajucih vozila!
	public static void trazenjeVozila() {
		LocalDate pocetniDatum = UtillMethod.unosDatum("pocetni");
		LocalDate krajnjiDatum = UtillMethod.unosDatum("krajnji");
		System.out.println("Provera dostupnosti vozila u toku...");
		ArrayList<Vozilo> dostupnaVoz = new ArrayList<Vozilo>();
		int i = 0;
		for (Vozilo v : Main.getVozilaAll()) {
			if (!postojiLiRezervacija(v, pocetniDatum, krajnjiDatum) && !v.isVozObrisano()) {
				System.out.println(i + "-" + v.getVrstaVozila() + "-" + "Registarski broj" + "-" + v.getRegBR()
						+ "-Potrosnja na 100km-" + v.getPotrosnja100() + "litara");
				i++;
				dostupnaVoz.add(v);
			}
		}
		if (i > 0) {
			System.out.println("Unesite redni broj vozila kojeg zelite da rezervisete:");
			int redniBroj = UtillMethod.unesiteInt();
			if (redniBroj < dostupnaVoz.size()) {
				System.out.println("Unesite kilometrazu koju planirate da putujete:");
				int km = UtillMethod.unesiteInt();
				double cena = cenaTroskaVoz(dostupnaVoz.get(redniBroj), km);
				System.out.println("Cena troskova puta je" + cena + "Dinara!");
				double cenaVozDani = UtillMethod.cenaIznaj(pocetniDatum, krajnjiDatum, dostupnaVoz.get(redniBroj));
				System.out.println("Cena troskova iznajmljivanja je:" + cenaVozDani + "Dinara!");
				double ukCena = cenaVozDani + cena * 118;
				System.out.println("Ukupna cena je " + ukCena + "Dinara!");
			} else {
				System.out.println("Izabrali ste nepostojece vozilo!");
			}
		} else {
			System.out.println("Nema dostupnih vozila za rezervaaciju.");
		}
	}

	// metoda koja proverava da li postoji rezervacija!
	public static boolean postojiLiRezervacija(Vozilo v, LocalDate p, LocalDate k) {
		for (Rezervacija e : Main.getRezervacijeAll()) {
			if (e.getVozilo().equals(v) && !e.isRezervacijaObrisana()
					&& UtillMethod.parsovanjeDatuma(e.getDatumPocetka()).isAfter(p)
					&& UtillMethod.parsovanjeDatuma(e.getDatumKraja()).isBefore(k)) {
				return true;
			} else if (e.getVozilo().equals(v) && !e.isRezervacijaObrisana()
					&& UtillMethod.parsovanjeDatuma(e.getDatumPocetka()).isBefore(p)
					&& UtillMethod.parsovanjeDatuma(e.getDatumKraja()).isAfter(p)) {
				return true;
			} else if (e.getVozilo().equals(v) && !e.isRezervacijaObrisana()
					&& UtillMethod.parsovanjeDatuma(e.getDatumPocetka()).isBefore(k)
					&& UtillMethod.parsovanjeDatuma(e.getDatumKraja()).isAfter(k)) {
				return true;
			} else if (e.getVozilo().equals(v) && !e.isRezervacijaObrisana()
					&& UtillMethod.parsovanjeDatuma(e.getDatumPocetka()).isBefore(p)
					&& UtillMethod.parsovanjeDatuma(e.getDatumKraja()).isAfter(k)) {
				return true;
			}
		}
		return false;
	}

	// Metoda za pravljenje rezervacije!
	public static void pravljenjeRezervacije(Osoba o) {
		UtillMethod.izlistavanjeVozila();
		System.out.println("Unesite datume da vidite koja vozila su na raspolaganju u tom periodu:");
		LocalDate pocetniDatum = UtillMethod.unosDatum("pocetni");
		LocalDate krajnjiDatum = UtillMethod.unosDatum("Krajnji");
		
		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d/MM/uuuu");
		String text1 = pocetniDatum.format(formatters);
		String text2 = krajnjiDatum.format(formatters);
		ArrayList<Vozilo> dostupnaVoz = new ArrayList<Vozilo>();
		int i = 0;
		for (Vozilo v : Main.getVozilaAll()) {
			if (!postojiLiRezervacija(v, pocetniDatum, krajnjiDatum) && !v.isVozObrisano()) {
				System.out.println(i + "-" + v.getVrstaVozila() + "-" + "Registarski broj" + "-" + v.getRegBR() + "-"
						+ v.getPotrosnja100() + "litara");
				i++;
				dostupnaVoz.add(v);
			}
		}
		System.out.println("Unesite redni broj vozila kojeg zelite:");
		int redniBroj = UtillMethod.unesiteInt();
		if (redniBroj < dostupnaVoz.size()) {
			double cena = UtillMethod.cenaIznaj(pocetniDatum, krajnjiDatum, dostupnaVoz.get(redniBroj));
			Rezervacija novaRez = new Rezervacija(dostupnaVoz.get(redniBroj), o, cena, false, text1, text2);
			Main.getRezervacijeAll().add(novaRez);
			System.out.println("Uspesno ste napravili rezervaciju!");
			System.out.println("---------------------------------");
			System.out.println(novaRez);
			System.out.println("---------------------------------");
		} else {
			System.out.println("Uneli ste pogresan redni broj!");
		}

	}

	// Metoda za otkazivanje rezervacije!
	public static void otkazivanjeRezervacije(Osoba o) {
		ArrayList<Rezervacija> rezervacijeIznaj = new ArrayList<Rezervacija>();
		int i = 0;
		for (Rezervacija r : Main.getRezervacijeAll()) {
			if (r.getIznajmljivac().equals(o) && !r.isRezervacijaObrisana()) {
				System.out.println("Rezervacija-" + i + "--" + r.getIznajmljivac() + " " + r.getVozilo()
						+ "pocetak rezervacije|" + r.getDatumKraja() + "kraj rezervacije|" + r.getDatumKraja());
				rezervacijeIznaj.add(r);
				i++;
			}
		}
		System.out.println("Unesite redni broj rezervacije koju zelite da otkazete:");
		int redniBroj = UtillMethod.unesiteInt();
		if (redniBroj < rezervacijeIznaj.size()) {
			Rezervacija temp = rezervacijeIznaj.get(redniBroj);
			temp.setRezervacijaObrisana(true);
			System.out.println("Rezervacija je uspesno izbrisana!");
		} else {
			System.out.println("Ne postoji rezervacija sa tim brojem!");
		}
	}

	// Metoda za brisanje vozila!
	public static void brisanjeVozila() {
		int i = 0;
		for (Vozilo v : Main.getVozilaAll()) {
			System.out.println(i + "-Vrsta Vozila|" + v.getVrstaVozila() + " Registarski broj|" + v.getRegBR()
					+ " Status izbrisanosti vozila|" + v.isVozObrisano());
			i++;
		}
		System.out.println("Unesite redni broj vozila koje zelite da izbrisete ili vratite u neobrisano stanje");
		int redniBroj = UtillMethod.unesiteInt();
		if (redniBroj < Main.getVozilaAll().size()) {
			Vozilo temp = Main.getVozilaAll().get(redniBroj);
			if (UtillMethod.voziloImaRezervacije(temp)) {
				System.out.println("Ovo vozilo ima aktivne rezervacije i ne moze biti obrisano!");
			} else {
				if (temp.isVozObrisano()) {
					temp.setVozObrisano(false);
					System.out.println("Vozilo je vraceno u sistem(neobrisano stanje)");
				} else {
					temp.setVozObrisano(true);
					System.out.println("Vozilo je uspesno izbrisano!");
				}
			}
		} else {
			System.out.println("Ne postoji vozilo sa tim brojem!");
		}
	}

	// Metoda za vracanje vozila!
	public static void vracanjeVozila(Osoba o) {
		ArrayList<Rezervacija> temp = new ArrayList<Rezervacija>();
		int i = 0;
		for (Rezervacija r : Main.getRezervacijeAll()) {
			if (r.getIznajmljivac().equals(o)
					&& UtillMethod.parsovanjeDatuma(r.getDatumKraja()).isBefore(LocalDate.now())
					&& !r.isRezervacijaObrisana()) {
				System.out.println(i + "-Iznajmljivac|" + r.getIznajmljivac() + " Vozilo|" + r.getVozilo()
						+ " Datum pocetka rezervacije|" + r.getDatumPocetka() + " Datum kraja rezervacije|"
						+ r.getDatumKraja());
				temp.add(r);
				i++;
			}
		}
		System.out.println("Unesite redni broj rezervacije vozila kojeg zelite da vratite:");
		int redniBroj = UtillMethod.unesiteInt();
		if (redniBroj < temp.size()) {
			System.out.println("Unesite koliko kilometara ste presli sa vozilom:");
			int brojKm = UtillMethod.unesiteInt();
			Rezervacija rezervTemp = temp.get(redniBroj);
			double cenaIznajm = UtillMethod.ukupnaCenaIznajmljivanja(rezervTemp, brojKm);
			System.out.println("Cena iznajmljivanja je " + cenaIznajm + " Dinara!");
			int prePromene = rezervTemp.getVozilo().getPredjeno();
			rezervTemp.getVozilo().setPredjeno(prePromene + brojKm);
		}

	}

}
