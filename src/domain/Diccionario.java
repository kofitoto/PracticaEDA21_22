package domain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Diccionario {

	private static Diccionario miDiccionario;
	private ListaPalabras diccionario = new ListaPalabras();

	public static Diccionario getInstance() {
		if (miDiccionario == null) {
			miDiccionario = new Diccionario();
		}
		return miDiccionario;
	}

	/**
	 * Carga el diccionario desde el fichero indicado
	 * 
	 * @param nomFich: nombre del fichero que contiene el diccionario
	 */
	private void cargarPalabras(String nomFich) {

		Palabra p;

		try {
			File archivo = new File(nomFich);
			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);

			String linea;
			while ((linea = br.readLine()) != null) {
				p = new Palabra(linea.trim());
				diccionario.anadirPalabra(p);
			}
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Asigna a cada palabra del diccionario las webs a las que hace referencia Pre:
	 * Internet y el diccionario ya est�n cargados
	 */
	/*
	 * private void computarWebsDePalabras() { }
	 */

	public void computarWebsDePalabras() {
		ArrayList<Web> webs = Internet.getInstance().getWebs();
		String palabra = null;
		String link = null;
		ArrayList<Palabra>dicc = diccionario.getListaPalabras();
		
		for (Palabra p : dicc) {
			palabra = p.getPalabra();
			for (Web w : webs) {
				link = w.getLink();
				if (palabra.length()<=10 && palabra.length()>=4 && link.contains(palabra))
					p.addLink(link);
			}
		}
		
		diccionario.setListaPalabras(dicc);

	}

	/**
	 * Carga el diccionario desde el fichero indicado y asigna a cada palabra del
	 * diccionario las webs a las que hace referencia Pre: Internet ya est� cargado
	 * 
	 * @param nomFich: nombre del fichero que contiene el diccionario
	 */
	public void inicializar(String nomFich) {
		cargarPalabras(nomFich);
	}

	/**
	 * Busca una palabra en el diccionario y la devuelve
	 * 
	 * @param sPalabra: texto de la palabra a buscar
	 * @return la Palabra (si est� en el diccionario), null en caso contrario
	 */

	public Palabra buscarPalabra(String sPalabra) {	
		return diccionario.buscarPalabra(sPalabra);
		}
		/*
		 * ArrayList<Palabra> d = this.diccionario; boolean encontrado = false; int
		 * index = 0; while (!encontrado && index < d.size()) { if
		 * (d.get(index).getPalabra().equals(sPalabra)) encontrado = true; else index++;
		 * } if (encontrado) return d.get(index); else return null;
		 */

	

	public ArrayList<Palabra> getDiccionario() {
		return diccionario.getListaPalabras();
	}

}
