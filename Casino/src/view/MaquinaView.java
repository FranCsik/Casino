package view;

import java.util.ArrayList;
import java.util.List;

public class MaquinaView {
	private int nroMaquina;
	private int nroCasillas;
	private int importeRecaudado;
	private int costoFijo;
	private static ArrayList<String> frutas = new ArrayList<>(List.of("banana", "frutilla", "guinda", "manzana", "sandia", "pera"));
	private int saldoJugador;
	private ArrayList<String> ultimaJugada = new ArrayList<String>();
	private boolean ganoLaUltimaJugada;
	
	public MaquinaView() {}

	public int getNroMaquina() {
		return nroMaquina;
	}

	public void setNroMaquina(int nroMaquina) {
		this.nroMaquina = nroMaquina;
	}

	public int getNroCasillas() {
		return nroCasillas;
	}

	public void setNroCasillas(int nroCasillas) {
		this.nroCasillas = nroCasillas;
	}

	public int getImporteRecaudado() {
		return importeRecaudado;
	}

	public void setImporteRecaudado(int importeRecaudado) {
		this.importeRecaudado = importeRecaudado;
	}

	public int getCostoFijo() {
		return costoFijo;
	}

	public void setCostoFijo(int costoFijo) {
		this.costoFijo = costoFijo;
	}

	public int getSaldoJugador() {
		return saldoJugador;
	}

	public void setSaldoJugador(int saldoJugador) {
		this.saldoJugador = saldoJugador;
	}
	
	public void setUltimaJugada(ArrayList<String> jugada) {
		ultimaJugada = jugada;
	}
	
	public ArrayList<String> getUltimaJugada(){
		return ultimaJugada;
	}
	
	public boolean getGanoLaUltimaJugada() {
		return ganoLaUltimaJugada;
	}

	public void setGanoLaUltimaJugada(boolean x) {
		this.ganoLaUltimaJugada = x;
	}
	
	
	
}
