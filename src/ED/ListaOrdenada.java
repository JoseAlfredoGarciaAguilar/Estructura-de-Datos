package ED;

public class ListaOrdenada<T> extends ListaLigada<T> implements TDAListaOrdenada<T> {
	public void add(T elemento) {
		NodoLineal<T> nuevo = new NodoLineal<T>(elemento);
		//VERIFICAR SI LA LISTA ESTÁ VACÍA
		if(isEmpty()) {
			inicio = nuevo;
			contador++;
			return;
		}
		
		//VERIFICAR SI VA ANTES DEL PRIMER NODO
		Comparable<T> temporal = (Comparable<T>) elemento;
		
		if(temporal.compareTo(inicio.getElemento())<0) {
			nuevo.setSiguiente(inicio);
			inicio = nuevo;
			contador++;
			return;
		}
		
		//CICLO PARA ENCONTRAR LA POSICIÓN CORRECTA DEL NUEVO ELEMENTO
		NodoLineal<T> actual = inicio;
		NodoLineal<T> anterior = null;
		
		while(actual!=null) {
			if(temporal.compareTo(actual.getElemento())<0){
				break;
			}
			
			anterior = actual;
			actual = actual.getSiguiente();
		}
		
		nuevo.setSiguiente(actual);
		anterior.setSiguiente(nuevo);
		contador++;
	}
}