
package modelo;

import java.util.ArrayList;
import java.util.Collections;

import view.PremioView;

public class Premio {
	private int monto;
	private ArrayList<String> combinacionCorrecta;
	
	public Premio( int monto, ArrayList<String> combinacion ) {
		this.monto = monto;
		this.combinacionCorrecta = combinacion;
	}
	public boolean combinacionCorrecta( ArrayList<String> combinacion ) {
		boolean retorno = true;
		
		for( int i=0; i<combinacionCorrecta.size(); i++ ) {
			int frutaEnPremio = Collections.frequency( this.combinacionCorrecta, combinacionCorrecta.get(i) );
			int frutaEnParametro = Collections.frequency( combinacion, combinacionCorrecta.get(i) );
			
			if( frutaEnPremio > frutaEnParametro ) {
				retorno = false;
				break;
			}

		}
		return retorno;
	}
	public int retornarMonto() {
		return this.monto;
	}
	public PremioView toView() {
		PremioView pv = new PremioView();
		pv.setCombinacionCorrecta(combinacionCorrecta);
		pv.setMonto(monto);
		pv.setCombinacionToString(combinacionCorrecta);
		return pv;
	}
}
