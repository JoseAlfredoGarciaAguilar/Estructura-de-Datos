package ED;
//PROGRAMA PARA PROBAR LAS LISTAS LIGADAS ORDENADA Y DESORDENADA
import java.util.Scanner;
import java.util.NoSuchElementException;

public class Prog0301 {
	static Scanner entrada;
	
	public static void main(String[] args) {
		entrada = new Scanner(System.in);
		
		//CREA LAS DOS LISTAS LIGADAS
		TDAListaOrdenada<String> listaOrdenada = new ListaOrdenada<String>();
		TDAListaDesordenada<String> listaDesordenada = new ListaDesordenada<String>();
		
		String elemento;
		int opcion = 0;
		
		while(opcion!=8) {
			opcion = mostrarMenu();
			
			switch(opcion) {
			case 1:
				//AGREGAR
				System.out.println("-OPCI�N 1-");
				System.out.print("PROPORCIONE EL ELEMENTO A AGREGAR: ");
				entrada.nextLine(); //PARA ELIMINAR EL ENTER PENDIENTE
				elemento = entrada.nextLine();
				listaOrdenada.add(elemento);
				listaDesordenada.addToRear(elemento);
				break;
			
			case 2:
				//ELIMINAR PRIMER ELEMENTO DE LA LISTA ORDENADA
				System.out.println("-OPCI�N 2-");
				try {
					System.out.println("EL ELEMENTO ELIMINADO DE LA LISTA ORDENADA ES: " + listaOrdenada.removeFirst());
				}catch(ListaVaciaException lve) {
					System.out.println("ERROR. LA LISTA ORDENADA EST� VAC�A. NO SE PUEDE ELIMINAR EL PRIMER ELEMENTO");
				}
				
				//ELIMINAR PRIMER ELEMENTO DE LA LISTA DESORDENADA
				try {
					System.out.println("EL ELEMENTO ELIMINADO DE LA LISTA DESORDENADA ES: " + listaDesordenada.removeFirst());
				}catch(ListaVaciaException lve) {
					System.out.println("ERROR. LA LISTA DESORDENADA EST� VAC�A. NO SE PUEDE ELIMINAR EL PRIMER ELEMENTO");
				}
				break;
				
			case 3:
				//ELIMINAR �LTIMO ELEMENTO DE LA LISTA ORDENADA
				System.out.println("-OPCI�N 3-");
				try {
					System.out.println("EL ELEMENTO ELIMINADO DE LA LISTA ORDENADA ES: " + listaOrdenada.removeLast());
				}catch(ListaVaciaException lve) {
					System.out.println("ERROR. LA LISTA ORDENADA EST� VAC�A. NO SE PUEDE ELIMINAR EL �LTIMO ELEMENTO");
				}
				
				//ELIMINAR �LTIMO ELEMENTO DE LA LISTA DESORDENADA
				try {
					System.out.println("EL ELEMENTO ELIMINADO DE LA LISTA DESORDENADA ES: " + listaDesordenada.removeLast());
				}catch(ListaVaciaException lve) {
					System.out.println("ERROR. LA LISTA DESORDENADA EST� VAC�A. NO SE PUEDE ELIMINAR EL �LTIMO ELEMENTO");
				}
				break;
				
			case 4:
				//SELECCIONAR ELEMENTO A ELIMINAR
				System.out.println("-OPCI�N 4-");
				System.out.print("PROPORCIONE ELEMENTO A ELIMINAR: ");
				entrada.nextLine();
				elemento = entrada.nextLine();
				
				//ELIMINAR ALG�N ELEMENTO DE LA LISTA ORDENADA
				try {
					System.out.println("EL ELEMENTO ELIMINADO DE LA LISTA ORDENADA ES: " + listaOrdenada.remove(elemento));
				}catch(NoSuchElementException nsee) {
					System.out.println("ERROR. NO EXISTE EL ELEMENTO EN LA LISTA ORDENADA");
				}
				
				//ELIMINAR ALG�N ELEMENTO DE LA LISTA DESORDENADA
				try {
					System.out.println("EL ELEMENTO ELIMINADO DE LA LISTA DESORDENADA ES: " + listaDesordenada.remove(elemento));
				}catch(NoSuchElementException nsee) {
					System.out.println("ERROR. NO EXISTE EL ELEMENTO EN LA LISTA DESORDENADA");
				}
				break;
				
			case 5:
				//MOSTRAR PRIMER ELEMENTO DE LA LISTA ORDENADA
				System.out.println("-OPCI�N 5-");
				try {
					System.out.println("EL PRIMER ELEMENTO DE LA LISTA ORDENADA ES: " + listaOrdenada.first());
				}catch(ListaVaciaException lve) {
					System.out.println("ERROR. LA LISTA ORDENADA EST� VAC�A. NO SE PUEDE MOSTRAR EL PRIMER ELEMENTO");
				}
				
				//MOSTRAR PRIMER ELEMENTO DE LA LISTA DESORDENADA
				try {
					System.out.println("EL PRIMER ELEMENTO DE LA LISTA DESORDENADA ES: " + listaDesordenada.first());
				}catch(ListaVaciaException lve) {
					System.out.println("ERROR. LA LISTA DESORDENADA EST� VAC�A. NO SE PUEDE MOSTRAR EL PRIMER ELEMENTO");
				}
				break;
				
			case 6:
				//MOSTRAR �LTIMO ELEMENTO DE LA LISTA ORDENADA
				System.out.println("-OPCI�N 6-");
				try {
					System.out.println("EL �LTIMO ELEMENTO DE LA LISTA ORDENADA ES: " + listaOrdenada.last());
				}catch(ListaVaciaException lve) {
					System.out.println("ERROR. LA LISTA ORDENADA EST� VAC�A. NO SE PUEDE MOSTRAR EL �LTIMO ELEMENTO");
				}
				
				//MOSTRAR �LTIMO ELEMENTO DE LA LISTA DESORDENADA
				try {
					System.out.println("EL �LTIMO ELEMENTO DE LA LISTA DESORDENADA ES: " + listaDesordenada.last());
				}catch(ListaVaciaException lve) {
					System.out.println("ERROR. LA LISTA DESORDENADA EST� VAC�A. NO SE PUEDE MOSTRAR EL �LTIMO ELEMENTO");
				}
				break;
				
			case 7:
				//MOSTRAR TODOS LOS ELEMENTOS
				System.out.println("-OPCI�N 7-");
				System.out.println("ELEMENTOS DE LA LISTA ORDENADA: ");
				System.out.println(listaOrdenada);
				System.out.println("ELEMENTOS DE LA LISTA DESORDENADA: ");
				System.out.println(listaDesordenada);
				break;
			}//FIN DE SWITCH
		}//FIN DE WHILE
	}//FIN DE MAIN
	
	public static int mostrarMenu() {
		int opcion = 0;
		System.out.println();
		System.out.println("MEN�");
		System.out.println("1 - AGREGAR");
		System.out.println("2 - ELIMINAR PRIMER ELEMENTO");
		System.out.println("3 - ELIMINAR �LTIMO ELEMENTO");
		System.out.println("4 - SELECCIONAR ELEMENTO A ELIMINAR");
		System.out.println("5 - MOSTRAR PRIMER ELEMENTO");
		System.out.println("6 - MOSTRAR �LTIMO ELEMENTO");
		System.out.println("7 - MOSTRAR TODOS LOS ELEMENTOS");
		System.out.println("8 - SALIR");
		
		do {
			System.out.print("PROPORCIONE SU OPCI�N (1-8): ");
			opcion = entrada.nextInt();
			System.out.println();
			if(opcion<1||opcion>8) {
				System.out.println("OPCI�N INV�LIDA...");
			}
		}while(opcion<1||opcion>8);
		
		return opcion;
	}
}