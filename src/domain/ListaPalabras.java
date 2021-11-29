package domain;

import java.util.ArrayList;

public class ListaPalabras {
	private ArrayList<Palabra> listaPalabras = new ArrayList<>();

	public ListaPalabras() {
	}

	/**
	 * A�ade una palabra a la lista
	 * 
	 * @param palabra: palabra a a�adir
	 */
	public void anadirPalabra(Palabra palabra) {
		if (!listaPalabras.contains(palabra)) {
			listaPalabras.add(palabra);
		}
	}

	/**
	 * Busca una palabra en la lista y la devuelve
	 * 
	 * @param sPalabra: texto de la palabra a buscar
	 * @return la Palabra (si est� en la lista), null en caso contrario
	 */
	public Palabra buscarPalabra(String sPalabra) {
		Palabra p = new Palabra(sPalabra);

		if (listaPalabras.contains(p))
			return p;
		else
			return null;

	}
	
	public ArrayList<Palabra> getListaPalabras(){
		return listaPalabras;
}
	public void setListaPalabras(ArrayList<Palabra> l) {
		listaPalabras = l;
	}
}
