package ED;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class UsoArbol {
	static Scanner entrada = new Scanner(System.in);
	static TDAArbolBinarioDeBusqueda<Integer> arbolito = new ArbolBinarioDeBusquedaLigado<Integer>();
	
	public static int MostrarMenu() {
		int eleccion = 0;
		try {
			System.out.println();
			System.out.println("MENÚ");
			System.out.println("1 - INSERTAR UN NÚMERO");
			System.out.println("2 - ELIMINAR UN NÚMERO");
			System.out.println("3 - RECORRIDO PREORDEN");
			System.out.println("4 - RECORRIDO INORDEN");
			System.out.println("5 - RECORRIDO POSTORDEN");
			System.out.println("6 - SALIR");
			
			do {
				System.out.print("PROPORCIONE SU OPCIÓN (1-6): ");
				eleccion = entrada.nextInt();
				System.out.println();
				if(eleccion<1||eleccion>6) {
					System.out.println("OPCIÓN INVÁLIDA");
				}
			}while(eleccion<1||eleccion>6);
		}catch(Exception e) {
			System.out.println("ERROR. INGRESA UN NÚMERO...");
		}
		return eleccion;
	}
	
	public static void Imprimir(Iterator<Integer> iterador) {
		String salida="";
		while(iterador.hasNext()) {
			salida = salida + iterador.next().toString() + "";
		}
		System.out.println(salida);
	}
	
	public static void main(String[] args) {
		int eleccion=0;
		while(eleccion!=6) {
			eleccion = MostrarMenu();
			
			switch(eleccion) {
			case 1:
				//INSERTAR UN NÚMERO
				try {
					System.out.println("-OPCIÓN 1-");
					System.out.print("ESCRIBE EL NÚMERO A AGREGAR: ");
					int añadir_num = entrada.nextInt();
					arbolito.addElement(añadir_num);
					System.out.println("EL NÚMERO " + añadir_num + " FUE AÑADIDO");
				}catch(NumberFormatException e) {}
				break;
			case 2:
				//ELIMINAR UN NÚMERO
				try {
					System.out.println("-OPCIÓN 2-");
					System.out.print("ESCRIBE EL NÚMERO A ELIMINAR: ");
					int eliminar_num = entrada.nextInt();
					arbolito.removeElement(eliminar_num);
					System.out.println("EL NÚMERO " + eliminar_num + " FUE ELIMINADO");
				}catch(NoSuchElementException e) {
					System.out.println("ERROR. NÚMERO NO EXISTENTE..");
				}
				break;
			case 3:
				//RECORRIDO PREORDEN
				System.out.println("-OPCIÓN 3-");
				imprimir(arbolito.iteradorPreOrden());
				break;
			case 4:
				//RECORRIDO INORDEN
				System.out.println("-OPCIÓN 4-");
				imprimir(arbolito.iteradorInOrden());
				break;
			case 5:
				//RECORRIDO POSTORDEN
				System.out.println("-OPCIÓN 5-");
				imprimir(arbolito.iteradorPostOrden());
				break;
			case 6:
				//SALIR DEL PROGRAMA
				System.out.println("FIN DEL PROGRAMA");
				break;
			}
		}	
	}
}