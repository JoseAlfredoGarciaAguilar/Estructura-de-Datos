package ED;
import java.util.Iterator;
import java.util.NoSuchElementException;
//IMPLEMENTACIÓN DE UN ITERADOR PARA UNA LISTA LIGADA
public class ListaIterador<T> implements Iterator<T> {
	private int cuenta; //NÚMERO DE ELEMENTOS EN LA LISTA
	private NodoLineal<T> actual; //EL ELEMENTO ACTUAL DE LA LISTA
	
	public ListaIterador(NodoLineal<T> inicio, int tam) {
		actual = inicio;
		cuenta = tam;
	}
	
	public boolean hasNext() {
		return actual != null;
	}
	
	public T next() {
		if(!hasNext()) {
			throw new NoSuchElementException();
		}
		
		T temporal = actual.getElemento();
		actual = actual.getSiguiente();
		
		return temporal;
	}
	
	public void remove() throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}
}
