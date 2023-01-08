package ED;

import java.util.Iterator;

public interface TDAArbolBinario<T> {
	public void removeLeftSubtree();
	public void removeRightSubtree();
	public void removAllElements();
	public boolean isEmpty();
	public boolean contains(T elemento);
	public int size();
	public String toString();
	public Iterator<T> iteratorPreOrden();
	public Iterator<T> iteratorInOrden();
	public Iterator<T> iteratorPostOrden();
}
