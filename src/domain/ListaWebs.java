package domain;

import java.util.ArrayList;

public class ListaWebs {
	private ArrayList<Web> listaWeb = new ArrayList<Web>();
	private ArrayList<int[]> enlace = new ArrayList<int[]>();

	public ListaWebs() {
	}

	/**
	 * A�ade una web a la lista
	 * 
	 * @param web: la web a a�adir PRE: web no est� en la lista
	 */
	public void anadirWeb(Web web) {
		if (!listaWeb.contains(web)) {
			listaWeb.add(web);
		}
	}

	/**
	 * A�ade un enlace a una web de la lista
	 * 
	 * @param idWebOrigen:  id de la web de origen
	 * @param idWebDestino: id de la web de destino PRE: las webs con id idWebOrigen
	 *                      e idWebDestino est�n en la lista
	 */
	public void anadirEnlace(int idWebOrigen, int idWebDestino) {
		int[] i = new int[2];
		i[0] =  idWebOrigen;
		i[1] = idWebDestino;
		enlace.add(i);
	}
	
	public ArrayList<Web> getLinks () {
		return this.listaWeb;
	}
}
