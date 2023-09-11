package modelo;

public class Ticket {
	private static int numerador = 0;
	private int nroTicket;
	private int credito;
	private boolean usado;
	
	public Ticket(int credito){
		numerador++;
		nroTicket = numerador;
		this.credito = credito;
		usado = false;
	}
	public int retornarCredito() {
		return credito;
	}
	public boolean soyEseTicket(int numero) {
		return this.nroTicket == numero;
	}
	public boolean fueUsado() {
		return this.usado;
	}
	public void usar() {
		usado = true;
	}
	public int getNroTicket() {
		return nroTicket;
	}
	
}
