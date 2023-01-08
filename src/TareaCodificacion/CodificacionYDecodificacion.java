package TareaCodificacion;
import java.util.Scanner;
//PROYECTO DE COLAS: PROGRAMA QUE PIDE UN MENSAJE, LA CODIFICA Y LA DECODIFICA
public class CodificacionYDecodificacion {
	//SE CREAN DOS COLAS: LA PRIMERA, PARA LA CODIFICACIÓN. LA SEGUNDA, PARA LA DECODIFICACIÓN
	static Cola<Integer> primeraCola = new Cola<Integer>();
	static Cola<Integer> segundaCola = new Cola<Integer>();

	public static void main(String[] args) {
		Pedir();
	}

	//SE PIDE AL USUARIO EL NÚMERO DE VALORES Y EL MENSAJE A CODIFICAR
	public static void Pedir() {
		Scanner entrada = new Scanner(System.in);
		double cuantos = 0;
		
		do {
			System.out.print("¿CUÁNTOS VALORES CODIFICADORES USARÁS?: ");
			cuantos = entrada.nextDouble();
			if(cuantos<0) {
				System.out.println("ERROR. INGRESASTE UN NÚMERO NEGATIVO...");
			}
			else if(cuantos==0) {
				System.out.println("ERROR. NO PUEDES CODIFICAR 0 VALORES...");
			}
			else if((cuantos%1)!=0) {
				System.out.println("ERROR. INGRESASTE UN NÚMERO DECIMAL...");
			}
		}while(cuantos<0||cuantos==0||(cuantos%1)!=0);
		
		//SE CREA UN ARREGLO DE N DIMENSIONES
		int[] arreglo = new int[(int) cuantos];
		
		//SE PIDEN N VALORES
		for(int a=0; a<arreglo.length; a++) {
			System.out.print("INGRESA EL VALOR " + (a+1) + ": ");
			int valor = entrada.nextInt();
			//LOS VALORES INGRESADOS SE GUARDAN EN CADA POSICIÓN DEL ARREGLO
			arreglo[a] = valor;
			primeraCola.enqueue(arreglo[a]);
			segundaCola.enqueue(arreglo[a]);
		}
		
		//SE PIDE EL MENSAJE A CODIFICAR
		System.out.println();
		System.out.print("ESCRIBE EL MENSAJE A CODIFICAR: ");
		String mensaje = entrada.nextLine();
		mensaje = entrada.nextLine();
		//SE REALIZA EL PROCEDIMIENTO UNA VEZ PEDIDOS LOS DATOS PARA LA CODIFICACIÓN
		Procedimiento(mensaje, arreglo);
		entrada.close();
	}
	
	//SE ELABORA TODO EL PROCESO PARA CODIFICAR Y DECODIFICAR EL MENSAJE
	public static void Procedimiento(String mensaje, int[] arreglo) {
		int letra, lugar;
		String codificado="";
		//PRIMERO SE CODIFICA USANDO LA PRIMERA COLA
		for(int b=0; b<mensaje.length(); b++) {
			letra = mensaje.charAt(b);
			lugar = primeraCola.first();
			letra += lugar;
			primeraCola.dequeue();
			primeraCola.enqueue(lugar);
			codificado += (char) letra;
		}
		System.out.println();
		System.out.println("MENSAJE CODIFICADO: " + codificado);
		
		//LUEGO, SE DECODIFICA (CODIFICAR PERO DE REVERSA) USANDO LA SEGUNDA COLA
		String decodificado="";
		for(int c=0; c<codificado.length(); c++) {
			letra = codificado.charAt(c);
			lugar = segundaCola.first();
			letra -= lugar;
			segundaCola.dequeue();
			segundaCola.enqueue(lugar);
			decodificado += (char) letra;
		}
		System.out.println("MENSAJE DECODIFICADO: " + decodificado);
	}
}