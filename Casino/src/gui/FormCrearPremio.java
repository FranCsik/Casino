package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

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

public class FormCrearPremio extends JFrame {

	private static final long serialVersionUID = 1L;
	
	String[] frutas = {"banana", "frutilla", "guinda", "manzana", "sandia", "pera"};
	
	JComboBox<Integer> listaMaquinas = new JComboBox<>();
	JComboBox<String> lista1 = new JComboBox<String>(frutas);
	JComboBox<String> lista2 = new JComboBox<String>(frutas);
	JComboBox<String> lista3 = new JComboBox<String>(frutas);
	
	private JLabel lblListaMaquinas, lblLista1, lblLista2, lblLista3, lblMonto;
	private JTextField txtMonto;
	private JButton btnAceptar;
	
	public FormCrearPremio() {
		
		List<MaquinaView> maquinas = Casino.getInstancia().obtenerMaquinas();
		

		for(MaquinaView m: maquinas) {
			listaMaquinas.addItem( m.getNroMaquina() );	 
		}

		
		
		Container c = this.getContentPane();
		c.setLayout(new GridLayout(7,2));
		lblListaMaquinas = new JLabel("Número de máquina");
		lblLista1 = new JLabel("Fruta 1");
		lblLista2 = new JLabel("Fruta 2");
		lblLista3 = new JLabel("Fruta 3");
		lblMonto = new JLabel("Ingresar monto");
		
		txtMonto = new JTextField();
		
		btnAceptar = new JButton("Aceptar");
		ManejoBotonesInterna m = new ManejoBotonesInterna(this);
		btnAceptar.addActionListener(m);
		btnAceptar.setBackground(Color.decode("#32a84a"));
		
		c.add(lblListaMaquinas);
		c.add(listaMaquinas);
		c.add(lblLista1);
		c.add(lista1);
		c.add(lblLista2);
		c.add(lista2);
		c.add(lblLista3);
		c.add(lista3);
		c.add(lblMonto);
		c.add(txtMonto);	
		c.add(new JLabel());
		c.add(new JLabel());
		c.add(new JLabel());
		c.add(btnAceptar);
		
		txtMonto.addKeyListener(new KeyAdapter() {
	         public void keyPressed(KeyEvent ke) {
	             if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
	            	 txtMonto.setEditable(true);
	             } else {
	            	 txtMonto.setEditable(false);
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
			try {
				if(boton.getActionCommand() == "Aceptar") {
					ArrayList<String> frutas = new ArrayList<String>();
					frutas.add( String.valueOf( lista1.getSelectedItem()) );
					frutas.add( String.valueOf( lista2.getSelectedItem()) );
					frutas.add( String.valueOf( lista3.getSelectedItem()) );
					Integer maquinaSeleccionada =  Integer.parseInt( listaMaquinas.getSelectedItem().toString() ) ;
					Casino.getInstancia().crearPremio(maquinaSeleccionada, Integer.parseInt(txtMonto.getText()), frutas);
					JOptionPane.showMessageDialog(ventana, "Se creó el premio.");
				}				
			}
			catch(NullPointerException e){
				JOptionPane.showMessageDialog(ventana, "Falta agregar la maquina.");
			}
			catch(NumberFormatException e){
				JOptionPane.showMessageDialog(ventana, "Falta agregar el monto.");
			}

		}

		
	}
	
}