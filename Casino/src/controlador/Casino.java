package controlador;
import java.util.ArrayList;

import view.MaquinaView;
import view.PremioView;

import java.util.Collection;
import java.util.List;

import modelo.Comprobante;
import modelo.Maquina;
import modelo.Ticket;

public class Casino {
	private static Casino instancia;
	private Collection<Ticket> tickets;
	private Collection<Comprobante> comprobantes;
	private Collection<Maquina> maquinas;
	
	private Casino() {
		tickets = new ArrayList<Ticket>();
		comprobantes = new ArrayList<Comprobante>();
		maquinas = new ArrayList<Maquina>();
	}
	
	public static Casino getInstancia() {
		if(instancia == null) {
			instancia = new Casino();
		}
		return instancia;
	}
	
	public List<MaquinaView> obtenerMaquinas(){
		List<MaquinaView> retorno = new ArrayList<MaquinaView>();
		for(Maquina m: maquinas) {
			retorno.add( m.toView() );
		}
		return retorno;
	}
	
	public MaquinaView obtenerUnaMaquina(int id){
		MaquinaView retorno = new MaquinaView();
		for(Maquina m: maquinas) {
			if(m.soyEsaMaquina(id)) {
				retorno = m.toView();				
			}
		}
		return retorno;
	} 
	
	public void crearMaquina( int nroCasillas, int importeInicial, int precioFijo ) {
		Maquina maquina = new Maquina(nroCasillas, importeInicial, precioFijo);
		this.maquinas.add( maquina );
	}
	public int crearTicket(int monto) {
		Ticket ticket = new Ticket( monto );
		tickets.add( ticket );
		return ticket.getNroTicket();
	}
	private Maquina buscarMaquina( int nroMaquina ) {
		for(Maquina m: maquinas) {
			if( m.soyEsaMaquina( nroMaquina ) ) {
				return m;
			}
		}
		return null;
	}
	public void crearPremio( int nroMaquina, int monto, ArrayList<String> frutas ) {
		Maquina maquina = buscarMaquina( nroMaquina );
		if(maquina != null) {
			maquina.crearPremio(monto, frutas);
		}
		
	}
	public void jugar(int nroMaquina) {
		Maquina maquina = buscarMaquina( nroMaquina );
		
		if(maquina != null) {
			maquina.jugar();
		}
	}
	public void eliminarPremio( int nroMaquina, ArrayList<String> combinacioFrutas ) {
		Maquina maquina = buscarMaquina( nroMaquina );
		if(maquina != null) {
			maquina.eliminarPremio(combinacioFrutas);;
		}
	}
	public List<PremioView> obtenerPremios(int nroMaquina) {
		List<PremioView> retorno = new ArrayList<PremioView>();
		Maquina maquina = buscarMaquina( nroMaquina );
		if(maquina != null) {
			retorno = maquina.obtenerPremios();
		}
		return retorno;
	}
	
	public Comprobante buscarComprobante(int nroComprobante) {
		for(Comprobante c: comprobantes) {
			if( c.soyEseComprobante( nroComprobante ) ) {
				return c;
			}
		}
		return null;
	}
	public void eliminarMaquina( int nroMaquina ) {
		Maquina maquina = buscarMaquina( nroMaquina );
		if(maquina != null) {
			maquinas.remove( maquina );
		}
	}
	private Ticket buscarTicket(int nroTicket) {
		for(Ticket t: tickets) {
			if( t.soyEseTicket( nroTicket ) ) {
				return t;
			}
		}
		return null;
	}
	public void cargarSaldoMaquina(int nroMaquina, int nroTicket) {
		Ticket ticket = buscarTicket(nroTicket);
		if( ticket != null ) {
			
			if( !ticket.fueUsado() ) {
				
				Maquina maquina = buscarMaquina( nroMaquina );
				if( maquina != null ) {
					maquina.cargarSaldo( ticket.retornarCredito() );
					ticket.usar();
				}				
			}
		}
	}
	public void altaComprobante(int nroComprobante) {}
	public void emitirComprobante(int nroMaquina) {
		Maquina maquina = buscarMaquina( nroMaquina );
		if( maquina != null ) {
			maquina.crearComprobante();
		}
		
	}
}
