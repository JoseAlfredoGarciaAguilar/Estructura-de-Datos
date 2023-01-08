package Estructura;
import java.util.Scanner;
//PROGRAMA QUE ENCUENTRA EL M�XIMO COM�N DIVISOR DE DOS N�MEROS ENTEROS, USANDO RECURSIVIDAD
public class UsoCalculoDivisor {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		double num1=0, num2=0; //SE DECLARAN LAS VARIABLES A USAR
		System.out.println("-�CALCULA EL M�XIMO COM�N DIVISOR (MCD) AQU�!-");
		do {
			System.out.print("INGRESE EL PRIMER N�MERO ENTERO: ");
			num1 = entrada.nextDouble();
			if((num1%1)!=0){ //MUESTRA UN MENSAJE AL USUARIO EN CASO DE INGRESAR UN N�MERO NO ENTERO
				System.out.println(num1 + " NO ES UN N�MERO ENTERO. INGRESA DE NUEVO...");
			}else { //SI INGRES� UN N�MERO ENTERO, MUESTRA UN MENSAJE
				System.out.println("MUY BIEN, " + (int) num1 + " ES EL PRIMER N�MERO GUARDADO");
				System.out.println();
			}
		}while((num1%1)!=0); //SE VALIDA QUE SOLO SE INGRESEN N�MEROS ENTEROS
		do {
			System.out.print("INGRESE EL SEGUNDO N�MERO ENTERO: ");
			num2 = entrada.nextDouble();
			if((num2%1)!=0){ //MUESTRA UN MENSAJE AL USUARIO EN CASO DE INGRESAR UN N�MERO NO ENTERO
				System.out.println(num2 + " NO ES UN N�MERO ENTERO. INGRESA DE NUEVO...");
			}else { //SI INGRES� UN N�MERO ENTERO, MUESTRA UN MENSAJE
				System.out.println("MUY BIEN, " + (int) num2 + " ES EL SEGUNDO N�MERO GUARDADO");
				System.out.println();
			}
		}while((num2%1)!=0); //SE VALIDA QUE SOLO SE INGRESEN N�MEROS ENTEROS
		
		//SE MUESTRA EL RESULTADO FINAL, USANDO LA CLASE CALCULODIVISOR Y SU M�TODO MCD
		System.out.println("EL M�XIMO COM�N DIVISOR (MCD) DE " + (int) num1 + " Y " + (int) num2 + " ES: " + (int) CalculoDivisor.MCD(num1, num2));
		System.out.println("-FIN DEL PROGRAMA-");
	}
}
//JOS� ALFREDO GARC�A AGUILAR
//ESTRUCTURA DE DATOS 5-6 PM