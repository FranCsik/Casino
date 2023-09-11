package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import view.PremioView;

public class FormBorrarPremio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel lblNumMaquina, lblPremio;
	JComboBox<Integer> listaMaquinas = new JComboBox<>();
	JComboBox<String> listaPremios = new JComboBox<>();
	private JButton btnAceptar;
	
	public FormBorrarPremio() {
		Container c = this.getContentPane();
		c.setLayout(new GridLayout(3,2));
		lblNumMaquina = new JLabel("Numero de maquina");
		lblPremio = new JLabel("Seleccionar premio");
		
		List<MaquinaView> maquinas = Casino.getInstancia().obtenerMaquinas();
		
		for(MaquinaView m: maquinas) {
			listaMaquinas.addItem( m.getNroMaquina() );	 
		}
		
		ManejoJComboBox jc = new ManejoJComboBox(this);
		listaMaquinas.addActionListener(jc);

		btnAceptar = new JButton("Aceptar");
		ManejoBotonesInterna m = new ManejoBotonesInterna(this);
		btnAceptar.addActionListener(m);
		btnAceptar.setBackground(Color.decode("#32a84a"));
		
		c.add(lblNumMaquina);
		c.add(listaMaquinas);
		c.add(lblPremio);
		c.add(listaPremios);
		c.add(new JLabel());
		c.add(btnAceptar);
		
	}
	
	class ManejoJComboBox implements ActionListener{
		
		private JFrame ventana;
		
		public ManejoJComboBox(JFrame ventana) {
			this.ventana = ventana;
		}
		
		public void actionPerformed(ActionEvent e) {
			JComboBox comboBox = (JComboBox) e.getSource();
			Object selected = comboBox.getSelectedItem();
			List<PremioView> premios = Casino.getInstancia().obtenerPremios( Integer.parseInt(selected.toString()) );
			listaPremios.removeAll();
			for(PremioView pv: premios) {
				
				listaPremios.addItem( pv.getCombinacionToString() );
			}
			
			
	    }
		
	}

	class ManejoBotonesInterna implements ActionListener{

		private JFrame ventana;
		
		public ManejoBotonesInterna(JFrame ventana) {
			this.ventana = ventana;
		}
		
		@Override
		public void actionPerformed(ActionEvent boton) {
			if(boton.getActionCommand() == "Aceptar" && listaPremios.getSelectedItem() != null && listaMaquinas != null) {
				
				ArrayList<String> frutas = new ArrayList<String>();
				String arrayFrutas[] = listaPremios.getSelectedItem().toString().split( " " );
				for(int i = 0; i <arrayFrutas.length; i++ ) {
					frutas.add(arrayFrutas[i]);
				}
				
				int idMaquina = (Integer) listaMaquinas.getSelectedItem();
				Casino.getInstancia().eliminarPremio(idMaquina, frutas);
			
				listaPremios.removeItem( listaPremios.getSelectedItem() );
				JOptionPane.showMessageDialog(ventana, "Se borró el premio para la máquina " + idMaquina);
	
			} else {
				JOptionPane.showMessageDialog(ventana, "Tenes que seleccionar una máquina y un premio.");
			}

		}
		
	}
	
}