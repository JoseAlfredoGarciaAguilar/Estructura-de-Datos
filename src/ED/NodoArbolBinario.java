package ED;

public class NodoArbolBinario<T> {
	//ATRIBUTOS
	T elemento;
	NodoArbolBinario<T> izquierdo;
	NodoArbolBinario<T> derecho;
			
	//CONSTRUCTORES
	public NodoArbolBinario(T elemento){
		this.elemento = elemento;
		this.izquierdo = null;
		this.derecho = null;
	}
			
	public NodoArbolBinario(){
		this(null);
	}
			
	//MÉTODOS SET/GET
	public void setElemento(T elemento) {
		this.elemento = elemento;
	}
			
	public void setIzquierdo(NodoArbolBinario<T> izquierdo) {
		this.izquierdo = izquierdo;
	}
	
	public void setDerecho(NodoArbolBinario<T> derecho) {
		this.derecho = derecho;
	}
			
	public T getElemento() {
		return elemento;
	}
			
	public NodoArbolBinario<T> getIzquierdo(){
		return izquierdo;
	}
	
	public NodoArbolBinario<T> getDerecho(){
		return derecho;
	}
	
	public int numeroDeHijos() {
		int hijos = 0;
		if(izquierdo!=null) {
			hijos = hijos + 1 + izquierdo.numeroDeHijos();
		}
		
		if(derecho!=null) {
			hijos = hijos + 1 + derecho.numeroDeHijos();
			
		}
		return hijos;
	}
}
