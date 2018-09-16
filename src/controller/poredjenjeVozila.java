package controller;

import java.util.Comparator;

import model.Vozilo;

public class poredjenjeVozila implements Comparator<Vozilo> {
	private  int poredi;
	
	public poredjenjeVozila(int poredi) {
		this.poredi = poredi;
	}

	public  int getPoredi() {
		return poredi;
	}
	
	public int compare(Vozilo a, Vozilo b) {
		double putPrvogVozila = MeniFunkcionalnost.cenaTroskaVoz(a, getPoredi(), a.getGorivaVozila().get(0));
		double putDrugogVozila = MeniFunkcionalnost.cenaTroskaVoz(b, getPoredi(), b.getGorivaVozila().get(0));
		
		return (int) (putPrvogVozila-putDrugogVozila);
	}
		
	

}
