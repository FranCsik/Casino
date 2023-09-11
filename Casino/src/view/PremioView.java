package view;

import java.util.ArrayList;

public class PremioView {
	private int monto;
	private ArrayList<String> combinacionCorrecta;
	private String combinacionToString;
	
	public PremioView () {}

	public int getMonto() {
		return monto;
	}

	public void setMonto(int monto) {
		this.monto = monto;
	}

	public ArrayList<String> getCombinacionCorrecta() {
		return combinacionCorrecta;
	}

	public void setCombinacionCorrecta(ArrayList<String> combinacionCorrecta) {
		this.combinacionCorrecta = combinacionCorrecta;
	};
	public void setCombinacionToString(ArrayList<String> combinacionCorrecta) {
		String combinacion = "";
		for(String a: combinacionCorrecta) {
			combinacion = combinacion + " " + a;
		}
		this.combinacionToString = combinacion;
	}
	public String getCombinacionToString() {
		return this.combinacionToString;
	}
	
	
}
