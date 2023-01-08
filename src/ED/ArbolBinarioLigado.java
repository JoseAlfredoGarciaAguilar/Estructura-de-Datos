package ED;

import java.util.Iterator;

public abstract class ArbolBinarioLigado<T> implements TDAArbolBinario<T>{
	//ATRIBUTOS DEL ÁRBOL
	protected NodoArbolBinario<T> raiz;
	protected int contador;
	
	//CONSTRUCTORES
	public ArbolBinarioLigado() {
		raiz = null;
		contador = 0;
	}
	
	public ArbolBinarioLigado(T r) {
		raiz = new NodoArbolBinario<T>(r);
		contador = 1;
	}
	
	public ArbolBinarioLigado(T r, ArbolBinarioLigado<T> i, ArbolBinarioLigado<T> d) {
		raiz = new NodoArbolBinario<T>(r);
		contador = 1;
		
		//PREGUNTAR SI TIENE HIJO IZQUIERDO
		if(i!=null) {
			raiz.setIzquierdo(i.getRaiz());
			contador += i.size();
		}
		
		//PREGUNTAR SI TIENE HIJO DERECHO
		if(d!=null) {
			raiz.setDerecho(d.getRaiz());
			contador += d.size();
		}
	}
	
	//MÉTODOS SET/GET
	public void setRaiz(NodoArbolBinario<T> r) {
		raiz = r;
	}
	
	public NodoArbolBinario<T> getRaiz(){
		return raiz;
	}
	
	public void removeLeftSubtree() {
		//PREGUNTAR SI TIENE HIJO IZQUIERDO
		if(raiz.getIzquierdo()!=null) {
			contador -= (1+raiz.getIzquierdo().numeroDeHijos());
			
			raiz.setIzquierdo(null);
		}
	}
	
	public void removeRightSubtree() {
		//PREGUNTAR SI TIENE HIJO DERECHO
		if(raiz.getDerecho()!=null) {
			contador -= (1+raiz.getDerecho().numeroDeHijos());
			raiz.setDerecho(null);
		}
	}
	
	public void removeAllElements() {
		raiz = null;
		contador = 0;
	}
	
	public boolean isEmpty() {
		return contador == 0;
	}
	
	public int size() {
		return contador;
	}
	
	public boolean contains(T elemento) {
		if(isEmpty()) {
			return false;
		}
		
		//NO ESTÁ VACÍO. BUSCAR EL ELEMENTO
		boolean encontrado = false;
		Iterator<T> iterador = iteratorInOrden();
		while(iterador.hasNext()) {
			if(elemento.equals(iterador.next())) {
				encontrado = true;
				break;
			}
		}
		return encontrado;
	}
	
	public String toString() {
		String resultado = "";
		Iterator<T> iterador = iteratorInOrden();
		while(iterador.hasNext()) {
			resultado = resultado + iterador.next().toString() + "\n";
		}
		return resultado;
	}
	
	public Iterator<T> iteratorPreOrden(){
		TDAListaDesordenada<T> lista = new ListaDesordenada<T>();
		preOrden(raiz,lista);
		return lista.iterator();
	}
	
	public void preOrden(NodoArbolBinario<T> nodo, TDAListaDesordenada<T> lista) {
		if(nodo!=null) {
			lista.addToRear(nodo.getElemento());
			preOrden(nodo.getIzquierdo(), lista);
			preOrden(nodo.getDerecho(), lista);
		}
	}
	
	public void inOrden(NodoArbolBinario<T> nodo, TDAListaDesordenada<T> lista) {
		if(nodo!=null) {
			inOrden(nodo.getIzquierdo(), lista);
			lista.addToRear(nodo.getElemento());
			inOrden(nodo.getDerecho(), lista);
		}
	}
	
	public void postOrden(NodoArbolBinario<T> nodo, TDAListaDesordenada<T> lista) {
		if(nodo!=null) {
			postOrden(nodo.getIzquierdo(), lista);
			postOrden(nodo.getDerecho(), lista);
			lista.addToRear(nodo.getElemento());
		}
	}
}
