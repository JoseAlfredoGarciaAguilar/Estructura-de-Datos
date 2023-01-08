package TareaSortingAndSearching;

import java.util.InputMismatchException;
import java.util.Scanner;

//PROGRAMA QUE IMPLEMENTA LOS 5 TIPOS DE ORDENAMIENTO Y LOS 2 TIPOS DE BÚSQUEDA, USANDO LA CLASE SORTINGANDSEARCHING
public class UsoSortingAndSearching {
	static Scanner entrada = new Scanner(System.in);
	static SortingAndSearching objeto = new SortingAndSearching();
	static Integer[] arreglo = new Integer[10];

	public static void main(String[] args) {
		Procedimiento();
	}

	// MÉTODO QUE ELABORA TODO EL PROCEDIMIENTO DEL PROGRAMA
	public static void Procedimiento() {
		int eleccion = 0;
		// ENTRA SIEMPRE Y CUANDO NO SE ELIJA SALIR EN EL MENÚ
		while (eleccion != 8) {
			try {
				System.out.println();
				System.out.println("\tMENÚ");
				System.out.println("1-ORDENAMIENTO POR SELECCIÓN");
				System.out.println("2-ORDENAMIENTO POR INSERCIÓN");
				System.out.println("3-ORDENAMIENTO POR BURBUJA (MÉTODO DE LA BURBUJA)");
				System.out.println("4-ORDENAMIENTO RÁPIDO");
				System.out.println("5-ORDENAMIENTO POR MEZCLA");
				System.out.println("6-BÚSQUEDA LINEAL");
				System.out.println("7-BÚSQUEDA BINARIA");
				System.out.println("8-SALIR");

				// VALIDA QUE SE INGRESE UNA OPCIÓN ENTRE 1 Y 8
				do {
					System.out.println();
					System.out.print("PROPORCIONE SU OPCIÓN (1-8): ");
					eleccion = entrada.nextInt();
					if (eleccion < 1 || eleccion > 8) {
						System.out.println("OPCIÓN INVÁLIDA...");
					}
				} while (eleccion < 1 || eleccion > 8);
				// EXCEPCIÓN EN CASO DE ERRORES
			} catch (InputMismatchException e) {
				System.out.println("ERROR. INGRESA UN NÚMERO...");
			}

			if (eleccion > 0 && eleccion < 8) {
				// SE GENERAN LOS 10 NÚMEROS ENTEROS ALEATORIOS ENTRE 1 Y 100 Y SE GUARDAN EN EL
				// ARREGLO
				System.out.println();
				System.out.println("LOS 10 NÚMEROS ALEATORIOS SIN ORDENAR");
				for (int i = 0; i < arreglo.length; i++) {
					arreglo[i] = (int) (Math.random() * 100);
					System.out.print(arreglo[i] + " ");
				}
				System.out.println();
				// SE EJECUTA EL MÉTODO SELECCIONADO POR EL USUARIO
				// PARA CADA MÉTODO SE MUESTRA EL ARREGLO ORDENADO
				switch (eleccion) {
				case 1:
					System.out.println();
					System.out.println("OPCIÓN 1: ORDENAMIENTO POR SELECCIÓN");
					objeto.OrdenamientoPorSeleccion(arreglo);
					Imprimir(arreglo);
					break;
				case 2:
					System.out.println();
					System.out.println("OPCIÓN 2: ORDENAMIENTO POR INSERCIÓN");
					objeto.OrdenamientoPorInsercion(arreglo);
					Imprimir(arreglo);
					break;
				case 3:
					System.out.println();
					System.out.println("OPCIÓN 3: ORDENAMIENTO POR BURBUJA (MÉTODO DE LA BURBUJA)");
					objeto.MetodoBurbuja(arreglo);
					Imprimir(arreglo);
					break;
				case 4:
					System.out.println();
					System.out.println("OPCIÓN 4: ORDENAMIENTO RÁPIDO");
					objeto.OrdenamientoRapido(arreglo, 0, arreglo.length - 1);
					Imprimir(arreglo);
					break;
				case 5:
					System.out.println();
					System.out.println("OPCIÓN 5: ORDENAMIENTO POR MEZCLA");
					objeto.OrdenamientoPorMezcla(arreglo, 0, arreglo.length - 1);
					Imprimir(arreglo);
					break;
				case 6:
					System.out.println();
					System.out.println("OPCIÓN 6: BÚSQUEDA LINEAL");
					System.out.print("NÚMERO A BUSCAR: ");
					int num_buscar = entrada.nextInt();
					if (objeto.BusquedaLineal(arreglo, 0, arreglo.length - 1, num_buscar) == -1) {
						System.out.println("ERROR. EL ELEMENTO " + num_buscar + " NO SE ENCUENTRA EN EL ARREGLO");
					} else {
						System.out.println("EL ELEMENTO " + num_buscar + " ESTÁ EN LA POSICIÓN "
								+ objeto.BusquedaLineal(arreglo, 0, arreglo.length - 1, num_buscar) + " DEL ARREGLO");
					}
					break;
				case 7:
					System.out.println();
					System.out.println("OPCIÓN 7: BÚSQUEDA BINARIA");
					objeto.MetodoBurbuja(arreglo);
					System.out.println("ELEMENTOS ORDENADOS DE MENOR A MAYOR");
					Imprimir(arreglo);
					System.out.println();
					System.out.print("NÚMERO A BUSCAR: ");
					int num_buscar2 = entrada.nextInt();
					if (objeto.BusquedaBinaria(arreglo, 0, arreglo.length - 1, num_buscar2) == -1) {
						System.out.println("ERROR. EL ELEMENTO " + num_buscar2 + " NO SE ENCUENTRA EN EL ARREGLO");
					} else {
						System.out.println("EL ELEMENTO " + num_buscar2 + " ESTÁ EN LA POSICIÓN "
								+ objeto.BusquedaBinaria(arreglo, 0, arreglo.length - 1, num_buscar2) + " DEL ARREGLO");
					}
					break;
				}
			} else {
				System.out.println("FIN DEL PROGRAMA");
			}
		}
	}

	// MÉTODO PARA IMPRIMIR TODOS LOS MÉTODOS
	public static void Imprimir(Integer[] arreglo) {
		for (int i = 0; i < arreglo.length; i++) {
			System.out.print(arreglo[i] + " ");
		}
		System.out.println();
	}
}
//JOSÉ ALFREDO GARCÍA AGUILAR. CLASE 5-6 PM. ESTRUCTURA DE DATOS