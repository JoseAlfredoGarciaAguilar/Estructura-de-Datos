package ED;

import java.util.NoSuchElementException;

public class ListaDesordenada<T> extends ListaLigada<T> implements TDAListaDesordenada<T>{
	public void addToFront(T elemento) {
		NodoLineal<T> nuevo = new NodoLineal<T>(elemento);
		nuevo.setSiguiente(inicio);
		inicio = nuevo;
		contador++;
	}
	
	public void addToRear(T elemento) {
		if(isEmpty()) {
			addToFront(elemento);
			return;
		}
		
		//RECORRER LA LISTA HASTA EL FINAL
		NodoLineal<T> actual = inicio;
		while(actual.getSiguiente()!=null) {
			actual = actual.getSiguiente();
		}
		
		NodoLineal<T> nuevo = new NodoLineal<T>(elemento);
		actual.setSiguiente(nuevo);
		contador++;
	}
	
	public void addAfter(T elemento, T previo) {
		if(!contains(previo)) {
			throw new NoSuchElementException();
		}
		
		//BUSCAR EL ELEMENTO PREVIO
		NodoLineal<T> actual = inicio;
		while(actual!=null) {
			if(previo.equals(actual.getElemento())) {
				break;
			}
			actual = actual.getSiguiente();
		}
		
		NodoLineal<T> nuevo = new NodoLineal<T>(elemento);
		nuevo.setSiguiente(actual.getSiguiente());
		actual.setSiguiente(nuevo);
		contador++;
	}
}
