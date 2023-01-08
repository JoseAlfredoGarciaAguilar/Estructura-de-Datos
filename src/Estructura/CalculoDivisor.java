package Estructura;
//PROGRAMA QUE ENCUENTRA EL MÁXIMO COMÚN DIVISOR DE DOS NÚMEROS ENTEROS, USANDO RECURSIVIDAD
public class CalculoDivisor {
	
	//ESTE MÉTODO USA LA RECURSIVIDAD PARA ENCONTRAR EL MCD
	public static double MCD(double num1, double num2) {
		if(num1%num2==0) {
			return num2;
		}else {
			return MCD(num2, num1%num2);
		}
	}
}
//JOSÉ ALFREDO GARCÍA AGUILAR
//ESTRUCTURA DE DATOS 5-6 PM