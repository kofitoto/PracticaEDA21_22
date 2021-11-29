package domain;

import java.util.ArrayList;

public class Palabra {
	private String palabra = null;
	private ArrayList<String> link = new ArrayList<>();
	/**
	 * Constructora de la palabra
	 * @param p
	 */
	public Palabra(String p) {
		setPalabra(p);
	}
	/**
	 * Devuelve la palabra
	 * @return palabra
	 */

	public String getPalabra() {
		return palabra;
	}
	
	public ArrayList<String> getlinks(){
		return link;
	}
	/**
	 * Establecer una palabra
	 * @param palabra
	 */
	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}
	/**
	 * Anadir el link a la Palabra
	 * Pre: s no null
	 * @param s
	 */
	public void addLink(String s) {
		if (s!=null)
			link.add(s);
		else
			System.out.println("No se ha añadido nada");
	}
	/**
	 * True si s es igual a la palabra
	 * @param s
	 * @return boolean
	 */
	public boolean equals(String s) {
		return (s == palabra);
	}
	/**
	 * Muestra los liks de la palabra
	 */
	public void showLinks() {
		int i = 0;
		for (String s: link) {
			System.out.println("Link numero "+ i + " es : " + s);
			i++;
			
		}
	}
}
