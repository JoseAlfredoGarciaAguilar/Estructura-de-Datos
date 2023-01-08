package ED;

public interface TDAListaDesordenada<T> extends TDALista<T>{
	public void addToFront(T elemento); //SE AGREGA EL ELEMENTO AL INICIO
	public void addToRear(T elemento);
	public void addAfter(T elemento, T previo);
}
