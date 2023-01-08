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
			System.out.println("MEN�");
			System.out.println("1 - INSERTAR UN N�MERO");
			System.out.println("2 - ELIMINAR UN N�MERO");
			System.out.println("3 - RECORRIDO PREORDEN");
			System.out.println("4 - RECORRIDO INORDEN");
			System.out.println("5 - RECORRIDO POSTORDEN");
			System.out.println("6 - SALIR");
			
			do {
				System.out.print("PROPORCIONE SU OPCI�N (1-6): ");
				eleccion = entrada.nextInt();
				System.out.println();
				if(eleccion<1||eleccion>6) {
					System.out.println("OPCI�N INV�LIDA");
				}
			}while(eleccion<1||eleccion>6);
		}catch(Exception e) {
			System.out.println("ERROR. INGRESA UN N�MERO...");
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
				//INSERTAR UN N�MERO
				try {
					System.out.println("-OPCI�N 1-");
					System.out.print("ESCRIBE EL N�MERO A AGREGAR: ");
					int a�adir_num = entrada.nextInt();
					arbolito.addElement(a�adir_num);
					System.out.println("EL N�MERO " + a�adir_num + " FUE A�ADIDO");
				}catch(NumberFormatException e) {}
				break;
			case 2:
				//ELIMINAR UN N�MERO
				try {
					System.out.println("-OPCI�N 2-");
					System.out.print("ESCRIBE EL N�MERO A ELIMINAR: ");
					int eliminar_num = entrada.nextInt();
					arbolito.removeElement(eliminar_num);
					System.out.println("EL N�MERO " + eliminar_num + " FUE ELIMINADO");
				}catch(NoSuchElementException e) {
					System.out.println("ERROR. N�MERO NO EXISTENTE..");
				}
				break;
			case 3:
				//RECORRIDO PREORDEN
				System.out.println("-OPCI�N 3-");
				imprimir(arbolito.iteradorPreOrden());
				break;
			case 4:
				//RECORRIDO INORDEN
				System.out.println("-OPCI�N 4-");
				imprimir(arbolito.iteradorInOrden());
				break;
			case 5:
				//RECORRIDO POSTORDEN
				System.out.println("-OPCI�N 5-");
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