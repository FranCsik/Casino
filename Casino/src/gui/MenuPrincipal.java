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
import javax.swing.JPanel;
import javax.swing.JTextField;
//import javax.swing.J VER SI EXISTE COMPONENTE PARA ESCRIBIR SOLO NUMEROS

import controlador.Casino;
import view.MaquinaView;
import view.PremioView;

public class MenuPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	private JLabel lblCargarMaquina;
	private JButton btnCrearMaquina, btnBorrarMaquina, btnCrearPremio, btnBorrarPremio, btnComprarTicket, btnCargarMaquina, btnActualizarJListaMaq;
	JComboBox<Integer> listaMaquinas = new JComboBox<>();

	
	public MenuPrincipal() {
		Container c = this.getContentPane();
		c.setLayout(new GridLayout(6,2));
		
		JButton btnCrearMaquina = new JButton("Crear maquina");
		JButton btnBorrarMaquina = new JButton("Borrar maquina");
		JButton btnCrearPremio = new JButton("Crear premio");
		JButton btnBorrarPremio = new JButton("Borrar premio");
		JButton btnComprarTicket = new JButton("Comprar ticket");
		JButton btnGenerarComprobante = new JButton("Generar Comprobante");
		JButton btnCargarMaquina = new JButton("Cargar maquina");
		JButton btnActualizarJListaMaq = new JButton("Actualizar lista");
		
		btnBorrarMaquina.setBackground(Color.decode("#ed0e30"));
		btnBorrarPremio.setBackground(Color.decode("#ed0e30"));
		
		btnCrearMaquina.setBackground(Color.decode("#1abced"));
		btnCrearPremio.setBackground(Color.decode("#1abced"));
		btnComprarTicket.setBackground(Color.decode("#1abced"));
		btnGenerarComprobante.setBackground(Color.decode("#1abced"));
		btnCargarMaquina.setBackground(Color.decode("#32a84a"));
		
		JPanel panelBtn1 = new JPanel(); //panelBtnACrearMaquina -- > tamos dividiendo los btnes del lado izq del diagrama
		JPanel panelBtn2 = new JPanel();
		JPanel panelBtn3 = new JPanel();
		JPanel panelBtn4 = new JPanel();
		JPanel panelBtn5 = new JPanel();
		JPanel panelBtn6 = new JPanel();
		JPanel paneSelecMaquina = new JPanel();
		
		panelBtn1.setLayout(new GridLayout(1,2));
		panelBtn2.setLayout(new GridLayout(1,2));
		panelBtn3.setLayout(new GridLayout(1,2));
		panelBtn4.setLayout(new GridLayout(1,2));
		panelBtn5.setLayout(new GridLayout(1,2));
		panelBtn6.setLayout(new GridLayout(1,2));
		paneSelecMaquina.setLayout(new GridLayout(1,3));
		
		lblCargarMaquina = new JLabel("Seleccionar maquina");
		
		List<MaquinaView> maquinas = Casino.getInstancia().obtenerMaquinas();
		
		for(MaquinaView m: maquinas) {
			listaMaquinas.addItem( m.getNroMaquina() );	 
		}
		
		panelBtn1.add(btnCrearMaquina);
		panelBtn1.add(new JLabel());
		panelBtn2.add(btnBorrarMaquina);
		panelBtn2.add(new JLabel());
		panelBtn3.add(btnCrearPremio);
		panelBtn3.add(new JLabel());
		panelBtn4.add(btnBorrarPremio);
		panelBtn4.add(new JLabel());
		panelBtn5.add(btnComprarTicket);
		panelBtn5.add(new JLabel());
		panelBtn6.add(btnGenerarComprobante);
		panelBtn6.add(new JLabel());
		paneSelecMaquina.add(lblCargarMaquina);
		paneSelecMaquina.add(listaMaquinas);
		paneSelecMaquina.add(btnActualizarJListaMaq);
		
		c.add(panelBtn1);
		c.add(new JLabel());
		c.add(panelBtn2);
		c.add(new JLabel());
		c.add(panelBtn3);
		c.add(new JLabel());
		c.add(panelBtn4);
		c.add(new JLabel());
		c.add(panelBtn5);
		c.add(paneSelecMaquina);
		c.add(panelBtn6);
		c.add(btnCargarMaquina);
		
		ManejoBotones mb = new ManejoBotones(this);
		btnCrearMaquina.addActionListener(mb);
		btnBorrarMaquina.addActionListener(mb);
		btnCrearPremio.addActionListener(mb);
		btnBorrarPremio.addActionListener(mb);
		btnComprarTicket.addActionListener(mb);
		btnGenerarComprobante.addActionListener(mb);
		btnActualizarJListaMaq.addActionListener(mb);		
		btnCargarMaquina.addActionListener(mb);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	
	
	
	class ManejoBotones implements ActionListener{

		private JFrame ventana;
		
		public ManejoBotones(JFrame ventana) {
			this.ventana = ventana;
		}
		
		@Override
		public void actionPerformed(ActionEvent boton) {
			
			
			
			if(boton.getActionCommand() == "Crear maquina") {
				FormCrearMaquina form = new FormCrearMaquina();
				form.setVisible(true);
				form.setSize(500, 200);
				form.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}

			if(boton.getActionCommand() == "Borrar maquina") {
				FormBorrarMaquina form = new FormBorrarMaquina();
				form.setVisible(true);
				form.setSize(300, 100);
				form.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}
			
			if(boton.getActionCommand() == "Crear premio") {
				FormCrearPremio form = new FormCrearPremio();
				form.setVisible(true);
				form.setSize(400, 250);
				form.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}
			
			if(boton.getActionCommand() == "Borrar premio") {
				FormBorrarPremio form = new FormBorrarPremio();
				form.setVisible(true);
				form.setSize(400, 150);
				form.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}
			
			if(boton.getActionCommand() == "Comprar ticket") {
				FormComprarTicket form = new FormComprarTicket();
				form.setVisible(true);
				form.setSize(400, 150);
				form.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}
			
			if(boton.getActionCommand() == "Generar Comprobante") {
				FormCrearComprobante form = new FormCrearComprobante();
				form.setVisible(true);
				form.setSize(300, 100);
				form.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}
			
			if(boton.getActionCommand() == "Cargar maquina") {
				try {
					int idMaquina = Integer.parseInt( listaMaquinas.getSelectedItem().toString() );
					Maquina maquina = new Maquina( idMaquina );
					maquina.setVisible(true);
					maquina.setSize(1300, 850);
					maquina.setDefaultCloseOperation(DISPOSE_ON_CLOSE);					
				}
				catch (NullPointerException e) {
					JOptionPane.showMessageDialog(ventana, "Selecciona una maquina");
				}
			}
			if(boton.getActionCommand() == "Actualizar lista") {
				
				listaMaquinas.removeAllItems();
				List<MaquinaView> maquinas = Casino.getInstancia().obtenerMaquinas();
				
				for(MaquinaView m: maquinas) {
					listaMaquinas.addItem( m.getNroMaquina() );	 
				}
				
			}
		
		}
	}	
	
}
