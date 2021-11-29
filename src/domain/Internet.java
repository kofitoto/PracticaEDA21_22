package domain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Internet {

	private static Internet miInternet;
	private ListaWebs internet = new ListaWebs();
	//private ArrayList<Web> web = new ArrayList<>();
	//private ArrayList<int[]> enlace = new ArrayList<int[]>();

	public static Internet getInstance() {
		if (miInternet == null) {
			miInternet = new Internet();
		}
		return miInternet;
	}

	/**
	 * Carga las webs contenidas en el fichero indicado
	 * 
	 * @param nomFich: nombre del fichero que contiene las webs
	 */
	private void cargarWebs(String nomFich) {
		Web w;
		String[] enlace = new String[2];
		try {
			File archivo = new File(nomFich);
			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);

			String linea;
			while ((linea = br.readLine()) != null) {
				enlace = linea.split(" ");
				if (enlace.length > 1) {
					
					w = new Web(enlace[0], Integer.parseInt(enlace[1]));
					internet.anadirWeb(w);
				}
			}
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Carga los enlaces contenidos en el fichero indicado
	 * 
	 * @param nomFich: nombre del fichero que contiene los enlaces
	 */
	private void cargarEnlaces(String nomFich) {
		int[] en = new int[2];
		String[] enlace = new String[2];

		try {
			File archivo = new File(nomFich);
			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);

			String linea;
			while ((linea = br.readLine()) != null) {
				enlace = linea.split("\\s+");
				en[0] = Integer.parseInt(enlace[0]);
				en[1] = Integer.parseInt(enlace[1]);
				internet.anadirEnlace(en[0] , en[1] );
			}
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Inicializa la clase cargando las webs y los enlaces
	 * 
	 * @param nomFichWebs:    nombre del fichero que contiene las webs
	 * @param nomFichEnlaces: nombre del fichero que contiene los enlaces
	 */
	public void inicializar(String nomFichWebs, String nomFichEnlaces) {
		cargarWebs(nomFichWebs);
		cargarEnlaces(nomFichEnlaces);
	}

	/**
	 * Dado un string que contiene una palabra, imprime por pantalla las webs que
	 * tienen dicha palabra clave
	 * 
	 * @param sPalabra: string con la palabra
	 */
	
	public void buscadorWeb(String sPalabra) {
		Diccionario diccionario = Diccionario.getInstance();
		Palabra palabra = diccionario.buscarPalabra(sPalabra);
		if (palabra != null) {
		ArrayList<String> link = palabra.getlinks() ;
		int i = 0;
		for (String l: link) {
				System.out.println("Link numero "+ i + " es : " + l);
				i++;
			}
		}else {System.out.println("La vaina no existe!");}
		
	}


	public ArrayList<Web> getWebs() {
		return internet.getLinks();
	}

	/*
	 * public ArrayList<String> buscadorlinks(String sPalabra) { String link;
	 * ArrayList<String> links = new ArrayList<>(); for (Web w: web) { link =
	 * w.getLink(); if (sPalabra.length()<=10 && sPalabra.length()>=4 &&
	 * link.contains(sPalabra)) links.add(link); } return links; }
	 */
}
