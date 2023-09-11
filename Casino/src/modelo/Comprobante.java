package modelo;

public class Comprobante {
	private static int numerador = 0;
	private int nroComprobante;
	private int monto;
	private boolean usado;
	
	public Comprobante(int monto) {
		numerador++;
		nroComprobante = numerador;
		this.monto = monto;
	}
	public boolean fueUsado() {
		return usado;
	}
	public boolean soyEseComprobante(int nroComprobante ) {
		return this.nroComprobante == nroComprobante;
	}
	public void usarComprobante() {
		usado = true;
	}
	public String toString() {
		return "nroComprobante: " + nroComprobante + "  |  monto: " + monto;
	}
	
}
