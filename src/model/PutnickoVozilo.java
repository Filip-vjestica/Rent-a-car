package model;

import java.util.ArrayList;

import controller.KorisnickiInput;

//Basic tmp
public class PutnickoVozilo extends Vozilo implements KorisnickiInput {

	public PutnickoVozilo() {
	}

	public PutnickoVozilo(String vrstaVozila, String regBR, ArrayList<Gorivo> gorivaVozila, int brServisa, double potrosnja100,
			double predjeno, double preServis, double cenaServis, double cenaDan, int brSedist, int brVrata, boolean vozObrisano,
			ArrayList<Servis> ServisiNadVozilom) {
		super(vrstaVozila, regBR, gorivaVozila, brServisa, potrosnja100, predjeno, preServis, cenaServis, cenaDan, brSedist,
				brVrata, vozObrisano, ServisiNadVozilom);
	}

	public String toString() {
		return "Putnicko vozilo-Registarski broj:" + super.getRegBR() + " | Gorivo:" + super.getGorivaVozila()
				+ " | Prosecna potrosnja/100km:" + super.getPotrosnja100() + " | Cena na dan:" + super.getCenaDan()
				+ " | Broj sedista:" + super.getBrSedist() + " | Broj vrata:" + super.getBrVrata();
	}

}
