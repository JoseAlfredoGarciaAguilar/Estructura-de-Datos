package ED;

import java.util.Iterator;;

public interface TDALista<T> {
	public T removeFirst();
	public T removeLast();
	public T remove(T elemento);
	public T first();
	public T last();
	public boolean isEmpty();
	public boolean contains(T elemento);
	public int size();
	public Iterator<T> iterator();
	public String toString();
}
