package test;

import java.util.ArrayList;
import java.util.List;

import controlador.Casino;

public class Test {

	public static void main(String[] args) {
		
		int nroTicket = Casino.getInstancia().crearTicket(30000);
		Casino.getInstancia().crearMaquina(5, 10000, 100);
		Casino.getInstancia().cargarSaldoMaquina(1, nroTicket);
		ArrayList<String> frutas = new ArrayList<>(List.of("banana", "frutilla", "guinda"));
		Casino.getInstancia().crearPremio(1, 500 ,frutas);
		Casino.getInstancia().jugar(1);
		Casino.getInstancia().jugar(1);
		Casino.getInstancia().jugar(1);
		Casino.getInstancia().jugar(1);
		Casino.getInstancia().jugar(1);
		Casino.getInstancia().jugar(1);


		Casino.getInstancia().emitirComprobante(1);
	}

}
