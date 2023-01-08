package Cine;

public class Cola<T> implements TDACola<T> {
	//ATRIBUTOS DE LA COLA
	private NodoLineal<T> inicio;
	private NodoLineal<T> fin;
	private int contador;

	public Cola() {
		inicio = null;
		fin = null;
		contador = 0;
	}
	
	public void enqueue(T elemento) {
		NodoLineal<T> nuevo = new NodoLineal<T>(elemento);
		
		if(isEmpty()) {
			inicio = nuevo;
		}else {
			fin.setSiguiente(nuevo);
			fin = nuevo;
		}
		
		nuevo.setSiguiente(inicio);
		inicio = nuevo;
		contador++;
	}
	
	public T dequeue() {
		//VALIDAR QUE LA COLA NO ESTÉ VACÍA
		if(isEmpty()) {
			throw new ColaVaciaException();
		}
		
		T elemento = inicio.getElemento();
		inicio = inicio.getSiguiente();
		contador--;
		
		if(isEmpty()) {
			fin = null;
		}
		return elemento;
	}
	
	public T first() {
		//VALIDAR QUE LA COLA NO ESTÉ VACÍA
		if(isEmpty()) {
			throw new ColaVaciaException();
		}
		
		T elemento = inicio.getElemento();
		inicio = inicio.getSiguiente();
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
		NodoLineal<T> actual = inicio;
		while(actual!=null) {
			resultado = resultado + actual.getElemento().toString() + "\n";
			actual = actual.getSiguiente();
		}
		
		return resultado;
	}
}

	class ColaVaciaException extends RuntimeException {
	
}