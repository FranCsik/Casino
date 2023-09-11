package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.junit.jupiter.params.shadow.com.univocity.parsers.common.processor.core.ColumnOrderDependent;

import controlador.Casino;

public class FormCrearMaquina extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel lblCasillas, lblCostoInicial, lblImporteInicial;
	private JTextField txtCostoInicial, txtImporteInicial;
	private JButton btnAceptar;
	JComboBox<Integer> cantFrutas;
	
	public FormCrearMaquina() {
		Container c = this.getContentPane();
		c.setLayout(new GridLayout(5,2));
		lblCasillas = new JLabel("Numero de casillas");
		lblCostoInicial = new JLabel("Costo de la jugada");
		lblImporteInicial = new JLabel("Importe inicial");

		cantFrutas = new JComboBox<Integer>();
		cantFrutas.addItem(3);
		cantFrutas.addItem(4);
		cantFrutas.addItem(5);
		
		txtCostoInicial = new JTextField();
		txtImporteInicial = new JTextField();
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBackground(Color.decode("#32a84a"));
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,2));
		ManejoBotonesInterna m = new ManejoBotonesInterna(this);
		btnAceptar.addActionListener(m);

		
		c.add(lblCasillas);
		c.add(cantFrutas);
		c.add(lblCostoInicial);
		c.add(txtCostoInicial);
		c.add(lblImporteInicial);
		c.add(txtImporteInicial);
		c.add(new JLabel());
		c.add(new JLabel());
		c.add(new JLabel());
		c.add(btnAceptar);
		
		txtImporteInicial.addKeyListener(new KeyAdapter() {
	         public void keyPressed(KeyEvent ke) {
	             if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
	            	 txtImporteInicial.setEditable(true);
	             } else {
	            	 txtImporteInicial.setEditable(false);
	             }
	          }
	      });
		
		txtCostoInicial.addKeyListener(new KeyAdapter() {
	         public void keyPressed(KeyEvent ke) {
	             if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
	            	 txtCostoInicial.setEditable(true);
	             } else {
	            	 txtCostoInicial.setEditable(false);
	             }
	          }
	      });
		
	}

	class ManejoBotonesInterna implements ActionListener{

		private JFrame ventana;
		
		public ManejoBotonesInterna(JFrame ventana) {
			this.ventana = ventana;
		}
		
		@Override
		public void actionPerformed(ActionEvent boton) {
			if(boton.getActionCommand() == "Aceptar") {
				if(!txtCostoInicial.getText().isEmpty() &&
				   !txtImporteInicial.getText().isEmpty() ) {
					
					Integer numFrutas =  Integer.parseInt( cantFrutas.getSelectedItem().toString() ) ;
					int numImporteInicial = Integer.parseInt(txtImporteInicial.getText());
					int numCostoInicial = Integer.parseInt(txtCostoInicial.getText());
					
					Casino.getInstancia().crearMaquina(numFrutas, numImporteInicial, numCostoInicial);
					borroComponentes();
					JOptionPane.showMessageDialog(ventana, "Se creó la máquina!");
				}
				else{
					JOptionPane.showMessageDialog(ventana, "Los datos son invalidos");
				}
			}
			else{
				borroComponentes();
			}	
		}

		private void borroComponentes() {
			   txtCostoInicial.setText("");
			   txtImporteInicial.setText("");
		}
		
	}

	
}

