package model;

import java.util.ArrayList;

import controller.KorisnickiInput;

public class Bicikl extends Vozilo implements KorisnickiInput {
	// Basic tmp
	public Bicikl() {
	}

	public Bicikl(String vrstaVozila, String regBR, ArrayList<Gorivo> gorivaVozila, int brServisa, double potrosnja100, double predjeno,
			double preServis, double cenaServis, double cenaDan, int brSedist, int brVrata, boolean vozObrisano,
			ArrayList<Servis> ServisiNadVozilom) {
		super(vrstaVozila, regBR, gorivaVozila, brServisa, potrosnja100, predjeno, preServis, cenaServis, cenaDan, brSedist,
				brVrata, vozObrisano, ServisiNadVozilom);
	}

	public String toString() {
		return "\nBicikl-Registarski broj:" + super.getRegBR() + " | Broj predjenih KM:" + super.getPredjeno()
				+ " | Cena na dan:" + super.getCenaDan();
	}

}
