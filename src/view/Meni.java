package view;

import controller.KorisnickiInput;

import controller.MeniFunkcionalnost;
import model.Osoba;

public class Meni implements KorisnickiInput {

	public static void meniSluzbenik() {
		System.out.println(
				"\n--Glavni Meni-- \n1) Racunanje troskova za predjeni put!\n2) Racunanje vremena sledeceg servisa!\n3) Dodavanje vozila!\n4) Brisanje vozila!\n5) Izlazak iz aplikacije!");
		System.out.println("\nIzbor: ");
	}

	public static void meniIznajmljivac() {
		System.out.println(
				"\n--Glavni Meni--\n1) Racunanje troskova za predjeni put!\n2) Racunanje vremena sledeceg servisa!\n3) Trazenje odgovarajucih vozila!\n4) Pravljenje rezervacije!\n5) Otkazivanje rezervacije!\n6) Vracanje Vozila!\n7) Izlazak iz aplikacije!");
		System.out.println("\nIzbor: ");
	}

	public static void izborMeniSluzbenik(Osoba o) {
		while (true) {
			meniSluzbenik();
			String unosKorisnikaMeni = input.next();
			if (unosKorisnikaMeni.equals("1")) {
				System.out.println("Izabrali ste racunanje troskova predjenog puta!");
				MeniFunkcionalnost.TroskoviPredjenogPuta();
			} else if (unosKorisnikaMeni.equals("2")) {
				System.out.println("Izabrali ste racunanje vremena sledeceg servisa!");
				MeniFunkcionalnost.proveraServisa();
			} else if (unosKorisnikaMeni.equals("3")) {
				meniDodavanjeVozila();
			} else if (unosKorisnikaMeni.equals("4")) {
				System.out.println("Izabrali ste meni za brisanje vozila!");
				MeniFunkcionalnost.brisanjeVozila();
			} else if (unosKorisnikaMeni.equals("5")) {
				System.out.println("Izabrali ste izlazak iz aplikacije! Dovidjenja :)");
				System.exit(0);
			} else {
				System.out.println("Pogresan unos!");
			}
		}

	}

	public static void izborMeniIznajmljivac(Osoba o) {
		while (true) {
			meniIznajmljivac();
			String unosKorisnikaMeni = input.next();
			if (unosKorisnikaMeni.equals("1")) {
				MeniFunkcionalnost.TroskoviPredjenogPuta();
			} else if (unosKorisnikaMeni.equals("2")) {
				System.out.println("Izabrali ste racunanje vremena sledeceg servisa!");
				MeniFunkcionalnost.proveraServisa();
			} else if (unosKorisnikaMeni.equals("3")) {
				System.out.println("Izabrali ste trazenje odgovarajuceg vozila!");
				MeniFunkcionalnost.trazenjeVozila();
			} else if (unosKorisnikaMeni.equals("4")) {
				System.out.println("Izabrali ste pravljenje rezervacije!");
				MeniFunkcionalnost.pravljenjeRezervacije(o);
			} else if (unosKorisnikaMeni.equals("5")) {
				System.out.println("Izabrali ste otkazivanje rezervacije!");
				MeniFunkcionalnost.otkazivanjeRezervacije(o);
			} else if (unosKorisnikaMeni.equals("6")) {
				System.out.println("Izabrali ste vracanje vozila!");
				MeniFunkcionalnost.vracanjeVozila(o);
			} else if (unosKorisnikaMeni.equals("7")) {
				System.out.println("Izabrali ste izlazak iz aplikacije! Dovidjenja :)");
				System.exit(0);
			}

		}
	}

	// Metoda za dodavanje novih vozila u sistem
	public static void meniDodavanjeVozila() {
		System.out.println("Dobrodosli u Dodavanje novog vozila!");
		System.out.println("Izaberite koju vrstu vozila zelite da napravite!");
		System.out.println("1) Putnicko vozilo \n2) Teretno vozilo\n3) Bicikl\n4) Povratak u glavni meni!");
		String unosKorisnikaMeni = input.next();
		if (unosKorisnikaMeni.equals("1")) {
			System.out.println("Dobrodosli u dodavanje putnickog vozila, unesite zeljene atributa vozila!");
			MeniFunkcionalnost.dodavanjePutnickogVozila();
		} else if (unosKorisnikaMeni.equals("2")) {
			System.out.println("Dobrodosli u dodavanje teretnog vozila, unesite zeljene atribute!");
			MeniFunkcionalnost.dodavanjeTeretnogVozila();
		} else if (unosKorisnikaMeni.equals("3")) {
			System.out.println("Dobrodosli u dodavanje bicikla, unesite zeljene atribute!");
			MeniFunkcionalnost.dodavanjeBicikl();
		} else if (unosKorisnikaMeni.equals("4")) {
		} else {
			System.out.println("Pogresan unos!");
		}

	}

}
