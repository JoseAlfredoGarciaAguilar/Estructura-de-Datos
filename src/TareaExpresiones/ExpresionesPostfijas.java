package TareaExpresiones;

import java.util.Scanner;
import java.util.StringTokenizer;
//PROGRAMA QUE CALCULA EL RESULTADO AL INGRESAR UNA EXPRESION POSTFIJA
public class ExpresionesPostfijas {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		TDAPila<Integer> pila = new Pila<Integer>();
		
		System.out.print("INGRESA LA EXPRESIÓN POSTFIJA: ");
		String expresion = entrada.nextLine();
		
		StringTokenizer separador = new StringTokenizer(expresion); //STRINGTOKENIZER DIVIDE UN STRING EN SUBSTRING
		
		try {
			while(separador.hasMoreTokens()) { //HASMORETOKENS CHECA SI HAY MÁS TOKENS EN EL ARRAY DE TOKENS QUE TIENE STRINGTOKENIZER
				int x, y, suma, resta, multiplicacion, division;
				String parte = separador.nextToken();
				switch(parte) { //SE CREA UN SWITCH PARA CADA OPERADOR
				case "+":
					x = pila.pop();
					y = pila.pop();
					suma = y + x;
					pila.push(suma);
					break;
					
				case "-":
					x = pila.pop();
					y = pila.pop();
					resta = y - x;
					pila.push(resta);
					break;
					
				case "*":
					x = pila.pop();
					y = pila.pop();
					multiplicacion = y * x;
					pila.push(multiplicacion);
					break;
					
				case "/":
					x = pila.pop();
					y = pila.pop();
					division = y / x;
					pila.push(division);
					break;
				default:
					pila.push(Integer.parseInt(parte));
				}
			}
			
			if(pila.size()==1) {
				System.out.println("EL RESULTADO ES: " + pila.pop()); //SE MUESTRA EL RESULTADO DE LA EXPRESIÓN INGRESADA
			}else {
				System.out.println("ERROR. HAY MÁS OPERADORES QUE OPERANDOS EN LA EXPRESIÓN");
			}
		}catch(PilaVaciaException e) { //SE VERIFICA QUE NO HAYA UN ERROR EN LA PILA
			System.out.println("ERROR");
		}
	}
}