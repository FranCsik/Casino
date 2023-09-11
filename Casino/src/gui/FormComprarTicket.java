package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controlador.Casino;
import view.MaquinaView;

public class FormComprarTicket extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel lblCredito;
	private JTextField txtCredito;
	private JButton btnAceptar;
	
	public FormComprarTicket() {
		Container c = this.getContentPane();
		c.setLayout(new GridLayout(2,2));
		lblCredito = new JLabel("Comprar crédito");
		txtCredito = new JTextField();

		btnAceptar = new JButton("Aceptar");
		ManejoBotonesInterna m = new ManejoBotonesInterna(this);
		btnAceptar.addActionListener(m);
		btnAceptar.setBackground(Color.decode("#32a84a"));
		
		txtCredito.addKeyListener(new KeyAdapter() {
	         public void keyPressed(KeyEvent ke) {
	             if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
	            	txtCredito.setEditable(true);
	             } else {
	            	txtCredito.setEditable(false);
	             }
	          }
	       });
		
		c.add(lblCredito);
		c.add(txtCredito);
		c.add(new JLabel());
		c.add(btnAceptar);
		
	}
	

	class ManejoBotonesInterna implements ActionListener{

		private JFrame ventana;
		
		public ManejoBotonesInterna(JFrame ventana) {
			this.ventana = ventana;
		}
		
		@Override
		public void actionPerformed(ActionEvent boton) {
			if(boton.getActionCommand() == "Aceptar" && !txtCredito.getText().isEmpty()) {
				
				
				int monto = Integer.parseInt( txtCredito.getText().toString() );
				int nroTicket = Casino.getInstancia().crearTicket( monto );
			
				JOptionPane.showMessageDialog(ventana, "Su nro de ticket es: " + nroTicket );
				
			}
			else {
				JOptionPane.showMessageDialog(ventana, "Ingrese el monto");
			}

		}
		
	}
	
}