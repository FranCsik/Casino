package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.Casino;
import view.MaquinaView;
import view.PremioView;

public class Maquina extends JFrame {

	private static final long serialVersionUID = 1L;

	
	private JLabel[] lblCasillas;
	private JLabel lblSaldoJugador, lblCostoJugada;
	private JTextField txtNroTicket;
	private JButton btnJugar, btnCargarTicket;
	private JPanel panelCasillas, panel2, panel3, panelCargarTicket;
	private int numMaquina;
	
	public Maquina(int idMaquina) {

		Container c = this.getContentPane();
		c.setLayout(new GridLayout(4,1));
		
		MaquinaView maquina = Casino.getInstancia().obtenerUnaMaquina(idMaquina);
		numMaquina = maquina.getNroMaquina();
		
		lblCasillas = new JLabel[ maquina.getNroCasillas() ];
		lblSaldoJugador = new JLabel("Saldo jugador: " + maquina.getSaldoJugador());
		lblCostoJugada = new JLabel("Costo jugada: " + maquina.getCostoFijo());
		
		lblSaldoJugador.setFont(new Font("Serif", Font.PLAIN, 30));
		lblCostoJugada.setFont(new Font("Serif", Font.PLAIN, 30));
		
		panelCasillas = new JPanel();
		panelCasillas.setLayout(new GridLayout(1,5));
		for(int i = 0; i < maquina.getNroCasillas(); i++ ) {
			//panelCasillas.add(new JLabel( "banana" ));
			lblCasillas[i] = new JLabel( new ImageIcon(getClass().getResource("imagenes/banana.png")) );
			panelCasillas.add( lblCasillas[i] );
		}
		
		
		panelCargarTicket = new JPanel();
		panelCargarTicket.setLayout(new GridLayout(1,3));
		panelCargarTicket.add(new JLabel("Cargar ticket"));
		txtNroTicket = new JTextField();
		panelCargarTicket.add(txtNroTicket);
		btnCargarTicket = new JButton("Cargar");
		btnCargarTicket.setBackground(Color.decode("#1abced"));
		panelCargarTicket.add(btnCargarTicket);
				
		
		panel2 = new JPanel();
		panel2.setLayout(new GridLayout(1,3));
		panel2.add( lblSaldoJugador );
		panel2.add(new JLabel());
		panel2.add( panelCargarTicket );
		
		panel3 = new JPanel();
		panel3.setLayout(new GridLayout(1, 3));
		panel3.add( lblCostoJugada );
		panel3.add( new JLabel() );
		btnJugar = new JButton("Jugar");
		panel3.add(btnJugar);
		
		
		ManejoBotonesInterna m = new ManejoBotonesInterna(this);
		btnJugar.addActionListener(m);
		btnJugar.setBackground(Color.decode("#32a84a"));
		btnCargarTicket.addActionListener(m);
		
		c.add(panelCasillas);
		c.add(new JLabel());
		c.add(panel2);
		c.add(panel3);

		
	}
	


	class ManejoBotonesInterna implements ActionListener{

		private JFrame ventana;
		
		public ManejoBotonesInterna(JFrame ventana) {
			this.ventana = ventana;
		}
		
		@Override
		public void actionPerformed(ActionEvent boton) {
			if(boton.getActionCommand() == "Jugar") {
				Casino.getInstancia().jugar(numMaquina);
				MaquinaView maquina = Casino.getInstancia().obtenerUnaMaquina( numMaquina );
				for(int i = 0; i < maquina.getNroCasillas(); i++ ) {
					String fruta = maquina.getUltimaJugada().get(i);
					lblCasillas[i].setIcon(new ImageIcon(getClass().getResource("imagenes/"+ fruta +".png")));
				}
				lblSaldoJugador.setText("Saldo jugador: " + maquina.getSaldoJugador());
				
				if( maquina.getGanoLaUltimaJugada() ) {
					JOptionPane.showMessageDialog(ventana, "Ganaste un premio!");
				}

			}
			
			if(boton.getActionCommand() == "Cargar") {
				
				int numTicket = Integer.parseInt( txtNroTicket.getText().toString() );
				Casino.getInstancia().cargarSaldoMaquina(numMaquina, numTicket);
				MaquinaView maquina = Casino.getInstancia().obtenerUnaMaquina( numMaquina );
				lblSaldoJugador.setText("Saldo jugador: " + maquina.getSaldoJugador());
				
			}

		}

		
	}
	
}