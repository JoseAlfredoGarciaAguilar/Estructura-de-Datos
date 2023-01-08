package Cine;

public class NodoLineal<T> {
	//ATRIBUTOS
	T elemento;
	NodoLineal<T> siguiente;
			
	//CONSTRUCTORES
	public NodoLineal(T elemento){
		this.elemento = elemento;
		this.siguiente = null;
	}
			
	public NodoLineal(){
		this(null);
	}
			
	//MÉTODOS SET/GET
	public void setElemento(T elemento) {
		this.elemento = elemento;
	}
			
	public void setSiguiente(NodoLineal<T> siguiente) {
		this.siguiente = siguiente;
	}
			
	public T getElemento() {
		return elemento;
	}
			
	public NodoLineal<T> getSiguiente(){
		return siguiente;
	}
}
