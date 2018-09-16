package model;

import java.util.ArrayList;



//Basic tmp

public abstract class Vozilo {
	private String vrstaVozila;
	private String regBR;
	private ArrayList<Gorivo> gorivaVozila;
	private int brServisa;
	private double potrosnja100;
	private double predjeno;
	private double preServis;
	private double cenaServis;
	private double cenaDan;
	private int brSedist;
	private int brVrata;
	private boolean vozObrisano;
	private ArrayList<Servis> servisiNadVozilom;

	public Vozilo() {
	}

	public Vozilo(String vrstaVozila, String regBR, ArrayList<Gorivo> gorivaVozila, int brServisa, double potrosnja100, double predjeno,
			double preServis, double cenaServis, double cenaDan, int brSedist, int brVrata, boolean vozObrisano,
			ArrayList<Servis> ServisiNadVozilom) {
		this.vrstaVozila = vrstaVozila;
		this.regBR = regBR;
		this.gorivaVozila = gorivaVozila;
		this.brServisa = brServisa;
		this.potrosnja100 = potrosnja100;
		this.predjeno = predjeno;
		this.preServis = preServis;
		this.cenaServis = cenaServis;
		this.cenaDan = cenaDan;
		this.brSedist = brSedist;
		this.brVrata = brVrata;
		this.vozObrisano = vozObrisano;
		this.servisiNadVozilom = ServisiNadVozilom;
	}

	public Servis getServisiNadVozilom(int i) {
		return servisiNadVozilom.get(i);
	}

	public void dodajServis(Servis s) {
		this.servisiNadVozilom.add(s);
	}

	public int velicinaServisa() {
		return servisiNadVozilom.size();
	}

	public String getVrstaVozila() {
		return vrstaVozila;
	}

	public void setVrstaVozila(String vrstaVozila) {
		this.vrstaVozila = vrstaVozila;
	}

	public abstract String toString();


	public int getBrServisa() {
		return brServisa;
	}

	public void setBrServisa(int brServisa) {
		this.brServisa = brServisa;
	}

	public double getPredjeno() {
		return predjeno;
	}

	public void setPredjeno(double predjeno) {
		this.predjeno = predjeno;
	}

	public double getPreServis() {
		return preServis;
	}

	public void setPreServis(double preServis) {
		this.preServis = preServis;
	}

	public boolean isVozObrisano() {
		return vozObrisano;
	}

	public void setVozObrisano(boolean vozObrisano) {
		this.vozObrisano = vozObrisano;
	}

	public String getRegBR() {
		return regBR;
	}

	public double getPotrosnja100() {
		return potrosnja100;
	}

	public double getCenaServis() {
		return cenaServis;
	}

	public double getCenaDan() {
		return cenaDan;
	}

	public int getBrSedist() {
		return brSedist;
	}

	public void setRegBR(String regBR) {
		this.regBR = regBR;
	}

	public void setPotrosnja100(double potrosnja100) {
		this.potrosnja100 = potrosnja100;
	}

	public void setCenaServis(double cenaServis) {
		this.cenaServis = cenaServis;
	}

	public void setCenaDan(double cenaDan) {
		this.cenaDan = cenaDan;
	}

	public ArrayList<Gorivo> getGorivaVozila() {
		return gorivaVozila;
	}

	public void setGorivaVozila(ArrayList<Gorivo> gorivaVozila) {
		this.gorivaVozila = gorivaVozila;
	}

	public ArrayList<Servis> getServisiNadVozilom() {
		return servisiNadVozilom;
	}

	public void setServisiNadVozilom(ArrayList<Servis> servisiNadVozilom) {
		this.servisiNadVozilom = servisiNadVozilom;
	}

	public void setBrSedist(int brSedist) {
		this.brSedist = brSedist;
	}

	public void setBrVrata(int brVrata) {
		this.brVrata = brVrata;
	}

	public int getBrVrata() {
		return brVrata;
	}
	public void dodajGorivo(Gorivo v) {
		this.gorivaVozila.add(v);
	}
	
}
