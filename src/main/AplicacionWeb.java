package main;

import java.io.IOException;
import java.util.Scanner;
import domain.Diccionario;
import domain.Internet;

public class AplicacionWeb {

	public static void main(String[] args) throws IOException {
		Internet internet = new Internet();
		Diccionario diccionario = new Diccionario();
		internet.inicializar("smallindex.txt", "smallpld-arc.txt");
		diccionario.inicializar("words.txt");

		int opcion = 1;
		Scanner sc = new Scanner(System.in);
		String pal;
		while (opcion != 0) {
			System.out.println("Que deseas hacer?");
			System.out.println("1. Buscar webs por palabra clave");
			System.out.println("0. Salir");
			opcion = Integer.parseInt(sc.nextLine());
			switch (opcion) {
			case 1:
				System.out.println("Mete la palabra a buscar: ");
				pal = sc.nextLine();
				internet.buscadorWeb(pal);
				System.out.println();
				break;
			default:
				break;
			}
		}
		sc.close();

	}

}