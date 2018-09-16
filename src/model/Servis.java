package model;
//Basic tmp
public class Servis {
	private Vozilo vozilo;
	private String datumServis;
	private double brPredjenihKm;

	public Servis() {
	}

	public Servis(Vozilo vozilo, String datumServis, double brPredjenihKm) {
		super();
		this.vozilo = vozilo;
		this.datumServis = datumServis;
		this.brPredjenihKm = brPredjenihKm;
	}

	public Vozilo getVozilo() {
		return vozilo;
	}

	public void setVozilo(Vozilo vozilo) {
		this.vozilo = vozilo;
	}

	public String getDatumServis() {
		return datumServis;
	}

	public void setDatumServis(String datumServis) {
		this.datumServis = datumServis;
	}

	public double getBrPredjenihKm() {
		return brPredjenihKm;
	}

	public void setBrPredjenihKm(double brPredjenihKm) {
		this.brPredjenihKm = brPredjenihKm;
	}

}
