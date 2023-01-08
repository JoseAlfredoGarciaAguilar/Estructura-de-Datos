package ED;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListaLigada<T> implements TDALista<T>{
	//ATRIBUTOS DE LA LISTA
	protected NodoLineal<T> inicio;
	protected int contador;

	public ListaLigada() {
		inicio = null;
		contador = 0;
	}
	
	public T removeFirst() {
		//VALIDAR QUE LA LISTA NO ESTÉ VACÍA
		if(isEmpty()) {
			throw new ListaVaciaException();
		}
		
		T elemento = inicio.getElemento();
		inicio = inicio.getSiguiente();
		contador--;
		return elemento;
	}
	
	public T removeLast() {
		//VALIDAR QUE LA LISTA NO ESTÉ VACÍA
		if(isEmpty()) {
			throw new ListaVaciaException();
		}
		
		//SI SOLO HAY UN ELEMENTO, LLAMAR
		if(size()==1) {
			return removeFirst();
		}
		
		//BUSCAR EL PENÚLTIMO NODO
		NodoLineal<T> actual = inicio;
		NodoLineal<T> anterior = inicio;
		
		while(actual.getSiguiente()!=null) {
			anterior = actual;
			actual = actual.getSiguiente();
		}
		
		T elemento = actual.getElemento();
		anterior.setSiguiente(actual.getSiguiente());
		//anterior.setSiguiente(null);
		contador--;
		return elemento;
	}
	
	public T remove(T elemento) {
		if(!contains(elemento)) {
			throw new NoSuchElementException();
		}
		
		if(elemento.equals(inicio.getElemento())) {
			return removeFirst();
		}
		
		//BUSCAR EL ELEMENTO
		NodoLineal<T> actual = inicio;
		NodoLineal<T> anterior = null;
		
		while(!elemento.equals(actual.getElemento())) {
			anterior = actual;
			actual = actual.getSiguiente();
		}
		
		T elem = actual.getElemento();
		
		anterior.setSiguiente(actual.getSiguiente());
		contador--;
		
		return elem;
	}
	
	public T first() {
		//VALIDAR QUE LA LISTA NO ESTÉ VACÍA
		if(isEmpty()) {
			throw new ListaVaciaException();
		}
		
		T elemento = inicio.getElemento();
		
		return elemento;
	}
	
	public T last() {
		//VALIDAR QUE LA LISTA NO ESTÉ VACÍA
		if(isEmpty()) {
			throw new ListaVaciaException();
		}
		
		//SI SOLO HAY UN ELEMENTO, LLAMAR
		if(size()==1) {
			return removeFirst();
		}
		
		//BUSCAR EL PENÚLTIMO NODO
		NodoLineal<T> actual = inicio;
		NodoLineal<T> anterior = inicio;
		
		while(actual.getSiguiente()!=null) {
			anterior = actual;
			actual = actual.getSiguiente();
		}
		
		T elemento = actual.getElemento();
		return elemento;
	}
	
	public boolean isEmpty() {
		return contador==0;
	}
	
	public boolean contains(T elemento) {
		if(isEmpty()) {
			return false;
		}
		
		//NO ESÁ VACÍO. BUSCAR EL ELEMENTO
		boolean encontrado = false;
		NodoLineal<T> actual = inicio;
		Iterator<T> iterador = iterator();
		while(iterador.hasNext()) {
			if(elemento.equals(iterador.next())) {
				encontrado = true;
				break;
			}
		}
		return encontrado;
	}
	
	public int size() {
		return contador;
	}
	
	public Iterator<T> iterator(){
		return new ListaIterador<T>(inicio, size());
	}
	
	public String toString() {
		String resultado = "";
		Iterator<T> iterador = iterator();
		while(iterador.hasNext()) {
			resultado = resultado + iterador.next().toString() + "\n";
		}
		
		return resultado;
	}
}
