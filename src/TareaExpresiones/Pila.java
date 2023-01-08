package TareaExpresiones;

public class Pila<T> implements TDAPila<T>{
	//ATRIBUTOS DE LA PILA
	private NodoLineal<T> tope;
	private int contador;

	public Pila() {
		tope = null;
		contador = 0;
	}
	
	public void push(T elemento) {
		NodoLineal<T> nuevo = new NodoLineal<T>(elemento);
		
		nuevo.setSiguiente(tope);
		tope = nuevo;
		contador++;
	}
	
	public T pop() {
		//VALIDAR QUE LA PILA NO ESTÉ VACÍA
		if(isEmpty()) {
			throw new PilaVaciaException();
		}
		
		T elemento = tope.getElemento();
		tope = tope.getSiguiente();
		contador--;
		return elemento;
	}
	
	public T peek() {
		//REVISA EL ÚLTIMO DATO DE LA PILA
		if(isEmpty()) {
			throw new PilaVaciaException();
		}
		
		T elemento = tope.getElemento();
		tope = tope.getSiguiente();
		return elemento;
	}
	
	public boolean isEmpty() {
		return contador==0;
	}
	
	public int size() {
		return contador;
	}
	
	public String toString() {
		String resultado = "";
		NodoLineal<T> actual = tope;
		while(actual!=null) {
			resultado = resultado + actual.getElemento().toString() + "\n";
			actual = actual.getSiguiente();
		}
		
		return resultado;
	}
}

	class PilaVaciaException extends RuntimeException {
	
}