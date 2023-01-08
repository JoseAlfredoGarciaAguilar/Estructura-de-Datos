package ED;
import java.util.Scanner;
//PROGRAMA QUE COMPRUEBA QUE SE INGRESE UN TEXTO PARENTIZADO DE FORMA CORRECTA
public class Prog0302 {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("PROPORCIONE UNA EXPRESIÓN: ");
		String expresion = entrada.nextLine();
		
		TDAPila<Character> pila = new Pila<Character>();
		
		boolean error = false;
		
		for(int i=0; i<expresion.length(); i++) {
			char c = expresion.charAt(i);
			
			try {
				if(c=='{'||c=='['||c=='(') {
					pila.push(c);
				}
				else if(c=='}') {
					if(pila.pop()=='{') {
						//OK. NO HACER NADA
					}else {
						System.out.println("ERROR. PARÉNTESIS NO COINCIDENTE");
						error = true;
						break;
					}
				}
				else if(c==']') {
					if(pila.pop()=='[') {
						//OK. NO HACER NADA
					}else {
						System.out.println("ERROR. PARÉNTESIS NO COINCIDENTE");
						error = true;
						break;
					}
				}
				else if(c==')') {
					if(pila.pop()=='(') {
						//OK. NO HACER NADA
					}else {
						System.out.println("ERROR. PARÉNTESIS NO COINCIDENTE");
						error = true;
						break;
					}
				}
			}catch(PilaVaciaException pve){
				System.out.println("ERROR. HAY MÁS PARÉNTESIS DE CIERRE QUE DE APERTURA");
				error = true;
				break;
			}
		}//FIN DEL CICLO
		
		if(!error) {
			//VERIFICAR QUE LA PILA ESTÁ VACÍA
			if(pila.isEmpty()) {
				System.out.println("EXPRESIÓN CORRECTAMENTE PARENTIZADA");
			}else {
				System.out.println("ERROR. HAY MÁS PARÉNTESIS DE APERTURA QUE DE CIERRE");
			}
		}
	}//FIN DEL MAIN
}