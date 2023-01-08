package TareaSortingAndSearching;

import java.util.InputMismatchException;
import java.util.Scanner;

//PROGRAMA QUE IMPLEMENTA LOS 5 TIPOS DE ORDENAMIENTO Y LOS 2 TIPOS DE B�SQUEDA, USANDO LA CLASE SORTINGANDSEARCHING
public class UsoSortingAndSearching {
	static Scanner entrada = new Scanner(System.in);
	static SortingAndSearching objeto = new SortingAndSearching();
	static Integer[] arreglo = new Integer[10];

	public static void main(String[] args) {
		Procedimiento();
	}

	// M�TODO QUE ELABORA TODO EL PROCEDIMIENTO DEL PROGRAMA
	public static void Procedimiento() {
		int eleccion = 0;
		// ENTRA SIEMPRE Y CUANDO NO SE ELIJA SALIR EN EL MEN�
		while (eleccion != 8) {
			try {
				System.out.println();
				System.out.println("\tMEN�");
				System.out.println("1-ORDENAMIENTO POR SELECCI�N");
				System.out.println("2-ORDENAMIENTO POR INSERCI�N");
				System.out.println("3-ORDENAMIENTO POR BURBUJA (M�TODO DE LA BURBUJA)");
				System.out.println("4-ORDENAMIENTO R�PIDO");
				System.out.println("5-ORDENAMIENTO POR MEZCLA");
				System.out.println("6-B�SQUEDA LINEAL");
				System.out.println("7-B�SQUEDA BINARIA");
				System.out.println("8-SALIR");

				// VALIDA QUE SE INGRESE UNA OPCI�N ENTRE 1 Y 8
				do {
					System.out.println();
					System.out.print("PROPORCIONE SU OPCI�N (1-8): ");
					eleccion = entrada.nextInt();
					if (eleccion < 1 || eleccion > 8) {
						System.out.println("OPCI�N INV�LIDA...");
					}
				} while (eleccion < 1 || eleccion > 8);
				// EXCEPCI�N EN CASO DE ERRORES
			} catch (InputMismatchException e) {
				System.out.println("ERROR. INGRESA UN N�MERO...");
			}

			if (eleccion > 0 && eleccion < 8) {
				// SE GENERAN LOS 10 N�MEROS ENTEROS ALEATORIOS ENTRE 1 Y 100 Y SE GUARDAN EN EL
				// ARREGLO
				System.out.println();
				System.out.println("LOS 10 N�MEROS ALEATORIOS SIN ORDENAR");
				for (int i = 0; i < arreglo.length; i++) {
					arreglo[i] = (int) (Math.random() * 100);
					System.out.print(arreglo[i] + " ");
				}
				System.out.println();
				// SE EJECUTA EL M�TODO SELECCIONADO POR EL USUARIO
				// PARA CADA M�TODO SE MUESTRA EL ARREGLO ORDENADO
				switch (eleccion) {
				case 1:
					System.out.println();
					System.out.println("OPCI�N 1: ORDENAMIENTO POR SELECCI�N");
					objeto.OrdenamientoPorSeleccion(arreglo);
					Imprimir(arreglo);
					break;
				case 2:
					System.out.println();
					System.out.println("OPCI�N 2: ORDENAMIENTO POR INSERCI�N");
					objeto.OrdenamientoPorInsercion(arreglo);
					Imprimir(arreglo);
					break;
				case 3:
					System.out.println();
					System.out.println("OPCI�N 3: ORDENAMIENTO POR BURBUJA (M�TODO DE LA BURBUJA)");
					objeto.MetodoBurbuja(arreglo);
					Imprimir(arreglo);
					break;
				case 4:
					System.out.println();
					System.out.println("OPCI�N 4: ORDENAMIENTO R�PIDO");
					objeto.OrdenamientoRapido(arreglo, 0, arreglo.length - 1);
					Imprimir(arreglo);
					break;
				case 5:
					System.out.println();
					System.out.println("OPCI�N 5: ORDENAMIENTO POR MEZCLA");
					objeto.OrdenamientoPorMezcla(arreglo, 0, arreglo.length - 1);
					Imprimir(arreglo);
					break;
				case 6:
					System.out.println();
					System.out.println("OPCI�N 6: B�SQUEDA LINEAL");
					System.out.print("N�MERO A BUSCAR: ");
					int num_buscar = entrada.nextInt();
					if (objeto.BusquedaLineal(arreglo, 0, arreglo.length - 1, num_buscar) == -1) {
						System.out.println("ERROR. EL ELEMENTO " + num_buscar + " NO SE ENCUENTRA EN EL ARREGLO");
					} else {
						System.out.println("EL ELEMENTO " + num_buscar + " EST� EN LA POSICI�N "
								+ objeto.BusquedaLineal(arreglo, 0, arreglo.length - 1, num_buscar) + " DEL ARREGLO");
					}
					break;
				case 7:
					System.out.println();
					System.out.println("OPCI�N 7: B�SQUEDA BINARIA");
					objeto.MetodoBurbuja(arreglo);
					System.out.println("ELEMENTOS ORDENADOS DE MENOR A MAYOR");
					Imprimir(arreglo);
					System.out.println();
					System.out.print("N�MERO A BUSCAR: ");
					int num_buscar2 = entrada.nextInt();
					if (objeto.BusquedaBinaria(arreglo, 0, arreglo.length - 1, num_buscar2) == -1) {
						System.out.println("ERROR. EL ELEMENTO " + num_buscar2 + " NO SE ENCUENTRA EN EL ARREGLO");
					} else {
						System.out.println("EL ELEMENTO " + num_buscar2 + " EST� EN LA POSICI�N "
								+ objeto.BusquedaBinaria(arreglo, 0, arreglo.length - 1, num_buscar2) + " DEL ARREGLO");
					}
					break;
				}
			} else {
				System.out.println("FIN DEL PROGRAMA");
			}
		}
	}

	// M�TODO PARA IMPRIMIR TODOS LOS M�TODOS
	public static void Imprimir(Integer[] arreglo) {
		for (int i = 0; i < arreglo.length; i++) {
			System.out.print(arreglo[i] + " ");
		}
		System.out.println();
	}
}
//JOS� ALFREDO GARC�A AGUILAR. CLASE 5-6 PM. ESTRUCTURA DE DATOS