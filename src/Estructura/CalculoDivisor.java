package Estructura;
//PROGRAMA QUE ENCUENTRA EL M�XIMO COM�N DIVISOR DE DOS N�MEROS ENTEROS, USANDO RECURSIVIDAD
public class CalculoDivisor {
	
	//ESTE M�TODO USA LA RECURSIVIDAD PARA ENCONTRAR EL MCD
	public static double MCD(double num1, double num2) {
		if(num1%num2==0) {
			return num2;
		}else {
			return MCD(num2, num1%num2);
		}
	}
}
//JOS� ALFREDO GARC�A AGUILAR
//ESTRUCTURA DE DATOS 5-6 PM