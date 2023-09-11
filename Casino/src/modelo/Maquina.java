package modelo;

import java.util.*;

import view.MaquinaView;
import view.PremioView;

public class Maquina {
	private static int numerador = 0;
	private int nroMaquina;
	private int nroCasillas;
	private int importeRecaudado;
	private int costoFijo;
	private static ArrayList<String> frutas = new ArrayList<>(List.of("banana", "frutilla", "guinda", "manzana", "sandia", "pera"));
	private int saldoJugador;
	private Collection<Premio> premios;
	private Collection<Comprobante> comprobantes;
	private ArrayList<String> ultimaJugada;
	private boolean ganoLaUltimaJugada;
	
	public Maquina(int nroCasillas, int importeInicial, int costoFijo) {
		numerador++;
		this.nroMaquina = numerador;
		this.nroCasillas = nroCasillas;
		this.importeRecaudado = importeInicial;
		this.costoFijo = costoFijo;
		this.saldoJugador = 0;
		comprobantes = new ArrayList<Comprobante>();
		premios = new ArrayList<Premio>();
		
	}
	
	private void aumentarImporte() {
		saldoJugador = saldoJugador - costoFijo;
		importeRecaudado = importeRecaudado + costoFijo;
	}
	private void disminuirImporte( int montoPremio ) {
		if( montoPremio < importeRecaudado ) {
			saldoJugador = saldoJugador + montoPremio;
			importeRecaudado = importeRecaudado - montoPremio;
		}else {
			saldoJugador = saldoJugador + importeRecaudado;
			importeRecaudado = 0;
		}
	}
	
	public boolean soyEsaMaquina( int nroMaquina ) {
		return this.nroMaquina == nroMaquina;
	}
	
	public boolean verificacionRecaudacionMinima() {
		boolean retorno = true;
		for( Premio i: premios ) {
			if( i.retornarMonto() > this.importeRecaudado ) {
				retorno = false;
				break;
			}
		}
		return retorno;
	}
	
	public static ArrayList<String> retornarFrutas(){
		return frutas;
	}
	
	public void crearPremio(int monto, ArrayList<String> frutas) {
		Premio premioAux = buscarPremio( frutas );
		
		if(  premioAux == null ) {
			Premio premio = new Premio( monto, frutas );
			this.premios.add( premio );
		}
		
	}
	public Premio buscarPremio(ArrayList<String> frutas) {
		for(Premio i : premios) {
			if(i.combinacionCorrecta(frutas))
				return i;			
		}
		return null;
	}
	
	public void crearComprobante() {
		if( this.saldoJugador > 0 ) {
			Comprobante comprobante = new Comprobante( this.saldoJugador );
			saldoJugador = 0;
			this.comprobantes.add( comprobante );
		}else {
			throw new RuntimeException();
		}
	}
	
	public void eliminarPremio( ArrayList<String> combinacionFrutas ) {
		Premio premio = buscarPremio( combinacionFrutas );
		if( premio != null ) {
			premios.remove( premio );
		}
	}
	
	public void cargarSaldo(int saldo) {
		this.saldoJugador = saldoJugador + saldo;
	}
	
	public ArrayList<String> combinar() {
		ArrayList<String> combinacionFrutas = new ArrayList<String>();
		for( int i=0; i<nroCasillas; i++ ) {
			Random rand = new Random();
			int indiceRandom = rand.nextInt( Maquina.frutas.size() );
			combinacionFrutas.add( Maquina.frutas.get( indiceRandom ) );
		}
		return combinacionFrutas;
	} 
	
	public void jugar() {
		if( this.saldoJugador >= this.costoFijo ) {
			ArrayList<String> combinacionFrutas = new ArrayList<String>();
			
			combinacionFrutas = combinar();
			this.ultimaJugada = combinacionFrutas;		
			
			this.aumentarImporte();
			
			Premio premio = buscarPremio( combinacionFrutas );
			
			if( premio != null ) {
				disminuirImporte( premio.retornarMonto() );
				ganoLaUltimaJugada = true;
			} else {
				ganoLaUltimaJugada = false;
			}
			
		}
	
	}
	public Comprobante buscarComprobante(int nroComprobante) {
		for(Comprobante c: comprobantes) {
			if( c.soyEseComprobante( nroComprobante ) ) {
				return c;
			}
		}
		return null;
	}
	public String toString() {
		return "       importe recaudado: " + this.importeRecaudado + "|      saldo jugador:" + this.saldoJugador + "|      costo jugada:" + this.costoFijo ;
	}
	
	public MaquinaView toView() {
		MaquinaView mv = new MaquinaView();
		mv.setCostoFijo( this.costoFijo );
		mv.setImporteRecaudado( this.importeRecaudado );
		mv.setNroCasillas( this.nroCasillas );
		mv.setNroMaquina( this.nroMaquina );
		mv.setSaldoJugador( this.saldoJugador );
		mv.setUltimaJugada( this.ultimaJugada );
		mv.setGanoLaUltimaJugada( this.ganoLaUltimaJugada );
		
		return mv;
	}
	
	public List<PremioView> obtenerPremios(){
		List<PremioView> retorno = new ArrayList<PremioView>();
		for(Premio p: premios) {
			retorno.add( p.toView() );
		}
		return retorno;
	}
	
	
}
