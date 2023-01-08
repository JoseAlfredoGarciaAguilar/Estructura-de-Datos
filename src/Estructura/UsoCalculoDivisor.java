package Estructura;
import java.util.Scanner;
//PROGRAMA QUE ENCUENTRA EL MÁXIMO COMÚN DIVISOR DE DOS NÚMEROS ENTEROS, USANDO RECURSIVIDAD
public class UsoCalculoDivisor {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		double num1=0, num2=0; //SE DECLARAN LAS VARIABLES A USAR
		System.out.println("-¡CALCULA EL MÁXIMO COMÚN DIVISOR (MCD) AQUÍ!-");
		do {
			System.out.print("INGRESE EL PRIMER NÚMERO ENTERO: ");
			num1 = entrada.nextDouble();
			if((num1%1)!=0){ //MUESTRA UN MENSAJE AL USUARIO EN CASO DE INGRESAR UN NÚMERO NO ENTERO
				System.out.println(num1 + " NO ES UN NÚMERO ENTERO. INGRESA DE NUEVO...");
			}else { //SI INGRESÓ UN NÚMERO ENTERO, MUESTRA UN MENSAJE
				System.out.println("MUY BIEN, " + (int) num1 + " ES EL PRIMER NÚMERO GUARDADO");
				System.out.println();
			}
		}while((num1%1)!=0); //SE VALIDA QUE SOLO SE INGRESEN NÚMEROS ENTEROS
		do {
			System.out.print("INGRESE EL SEGUNDO NÚMERO ENTERO: ");
			num2 = entrada.nextDouble();
			if((num2%1)!=0){ //MUESTRA UN MENSAJE AL USUARIO EN CASO DE INGRESAR UN NÚMERO NO ENTERO
				System.out.println(num2 + " NO ES UN NÚMERO ENTERO. INGRESA DE NUEVO...");
			}else { //SI INGRESÓ UN NÚMERO ENTERO, MUESTRA UN MENSAJE
				System.out.println("MUY BIEN, " + (int) num2 + " ES EL SEGUNDO NÚMERO GUARDADO");
				System.out.println();
			}
		}while((num2%1)!=0); //SE VALIDA QUE SOLO SE INGRESEN NÚMEROS ENTEROS
		
		//SE MUESTRA EL RESULTADO FINAL, USANDO LA CLASE CALCULODIVISOR Y SU MÉTODO MCD
		System.out.println("EL MÁXIMO COMÚN DIVISOR (MCD) DE " + (int) num1 + " Y " + (int) num2 + " ES: " + (int) CalculoDivisor.MCD(num1, num2));
		System.out.println("-FIN DEL PROGRAMA-");
	}
}
//JOSÉ ALFREDO GARCÍA AGUILAR
//ESTRUCTURA DE DATOS 5-6 PM