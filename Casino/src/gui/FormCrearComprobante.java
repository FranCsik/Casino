package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controlador.Casino;
import view.MaquinaView;

public class FormCrearComprobante extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel lblNumMaquina;
	JComboBox<Integer> listaMaquinas = new JComboBox<>();
	private JButton btnAceptar;
	
	public FormCrearComprobante() {
		Container c = this.getContentPane();
		c.setLayout(new GridLayout(2,2));
		lblNumMaquina = new JLabel("Numero de maquina");
		
		List<MaquinaView> maquinas = Casino.getInstancia().obtenerMaquinas();
		
		for(MaquinaView m: maquinas) {
			listaMaquinas.addItem( m.getNroMaquina() );	 
		}

		btnAceptar = new JButton("Aceptar");
		ManejoBotonesInterna m = new ManejoBotonesInterna(this);
		btnAceptar.addActionListener(m);
		btnAceptar.setBackground(Color.decode("#32a84a"));
		
		c.add(lblNumMaquina);
		c.add(listaMaquinas);
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
			try {
				if(boton.getActionCommand() == "Aceptar") {
					int idMaquina = (Integer) listaMaquinas.getSelectedItem();
					Casino.getInstancia().emitirComprobante(idMaquina);
					JOptionPane.showMessageDialog(ventana, "Se creó el comprobante.");
				}
			}
			catch(RuntimeException e) {
				JOptionPane.showMessageDialog(ventana, "No se puede crear el comprobante.");
			}

		}
		
	}
	
}
