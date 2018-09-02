package controller;

import main.Main;
import model.Osoba;

public class Init implements KorisnickiInput {
	// Metoda koja gleda ulogu korisnika
	public static boolean uloga(Osoba s) {
		if (s.getUloga().equals("Sluzbenik")) {
			return true;
		} else {
			return false;
		}
	}

	// Metoda za login
	public static Osoba Login() {
		boolean login = true;
		System.out.println("----------------------------");
		System.out.println("Dobrodosli u rent-a-car app!");
		System.out.println("----------------------------\n");
		while (login) {
			System.out.println("Unesite vase korisnicko ime!");
			String loginUser = input.nextLine();
			System.out.println("Unesite vasu lozinku");
			String loginPass = input.nextLine();
			for (Osoba s : Main.getOsobeAll()) {
				if ((s.getKorisnIme().equals(loginUser)) && (s.getLozinka().equals(loginPass))
						&& (s.getUloga().equals("Sluzbenik"))) {
					login = false;
					System.out.println("\n\nDobrodosli! " + s.getIme() + " " + s.getPrezime());
					System.out.println("Uspesno ste se ulogovali kao Sluzbenik!");
					return s;
				} else if ((s.getKorisnIme().equals(loginUser)) && (s.getLozinka().equals(loginPass))
						&& (s.getUloga().equals("Iznajmljivac"))) {
					login = false;
					System.out.println("\n\nDobrodosli! " + s.getIme() + " " + s.getPrezime());
					System.out.println("Uspesno ste se ulogovali kao Iznajmljivac");
					return s;
				}

			}
			System.out.println("Vase korisnicko ime i/ili lozinka nisu tacni!");
			System.out.println("-------------------------------------------------\n\n");
		}
		return null;
	}

}
