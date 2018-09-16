package model;
import controller.KorisnickiInput;

//Basic tmp
public class Rezervacija implements KorisnickiInput {
	private Vozilo vozilo;
	private Iznajmljivac iznajmljivac;
	private double cenaRezerv;
	private boolean rezervacijaObrisana;
	private String datumPocetka;
	private String datumKraja;

	public Rezervacija() {
	}

	public Rezervacija(Vozilo vozilo, Iznajmljivac iznajmljivac, double cenaRezerv, boolean rezervacijaObrisana,
			String datumPocetka, String datumKraja) {
		this.vozilo = vozilo;
		this.iznajmljivac = iznajmljivac;
		this.cenaRezerv = cenaRezerv;
		this.rezervacijaObrisana = rezervacijaObrisana;
		this.datumPocetka = datumPocetka;
		this.datumKraja = datumKraja;
	}

	@Override
	public String toString() {
		return "Rezervacija-iznajmljivac: " + this.getIznajmljivac().getIme() + " "
				+ this.getIznajmljivac().getPrezime() + " Iznajmljeno vozila:" + this.getVozilo().getVrstaVozila() + " "
				+ this.getVozilo().getRegBR() + "\n Cena rezervacije: " + this.getCenaRezerv() + " Dinara!"
				+ "\n Datum pocetka:" + this.getDatumPocetka() + " Datum kraja:" + this.getDatumKraja();
	}

	public Vozilo getVozilo() {
		return vozilo;
	}

	public void setVozilo(Vozilo vozilo) {
		this.vozilo = vozilo;
	}

	public Iznajmljivac getIznajmljivac() {
		return iznajmljivac;
	}

	public void setIznajmljivac(Iznajmljivac iznajmljivac) {
		this.iznajmljivac = iznajmljivac;
	}

	public double getCenaRezerv() {
		return cenaRezerv;
	}

	public void setCenaRezerv(double cenaRezerv) {
		this.cenaRezerv = cenaRezerv;
	}

	public boolean isRezervacijaObrisana() {
		return rezervacijaObrisana;
	}

	public void setRezervacijaObrisana(boolean rezervacijaObrisana) {
		this.rezervacijaObrisana = rezervacijaObrisana;
	}

	public String getDatumPocetka() {
		return datumPocetka;
	}

	public void setDatumPocetka(String datumPocetka) {
		this.datumPocetka = datumPocetka;
	}

	public String getDatumKraja() {
		return datumKraja;
	}

	public void setDatumKraja(String datumKraja) {
		this.datumKraja = datumKraja;
	}

}
