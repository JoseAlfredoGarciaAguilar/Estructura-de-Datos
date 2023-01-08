package ED;

import java.util.*;

public class ArbolBinarioDeBusquedaLigado<T> extends ArbolBinarioLigado<T> implements TDAArbolBinarioDeBusqueda<T> {
	public ArbolBinarioDeBusquedaLigado() {
		super();
	}

	public ArbolBinarioDeBusquedaLigado(T elemento) {
		super(elemento);
	}

	@Override
	public void addElement(T elemento) {
		NodoArbolBinario<T> nuevo = new NodoArbolBinario<T>(elemento);
		Comparable<T> elementoComparable = (Comparable<T>) elemento;

		if (isEmpty())
			raiz = nuevo;
		else {
			NodoArbolBinario<T> actual = raiz;

			while (true) {
				if (elementoComparable.compareTo(actual.getElemento()) < 0) {
					if (actual.getIzquierdo() == null) {
						actual.setIzquierdo(nuevo);
						break;
					} else
						actual = actual.getIzquierdo();
				} else {
					if (actual.getDerecho() == null) {
						actual.setDerecho(nuevo);
						break;
					} else
						actual = actual.getDerecho();

				}
			} // fin del while
		} // fin del if

		contador++;
	}

	@Override
	public T removeElement(T elemento) throws NoSuchElementException {
		if (!contains(elemento))
			throw new NoSuchElementException();

		T resultado;

		if (elemento.equals(raiz.getElemento())) {
			resultado = raiz.getElemento();
			raiz = nodoReemplazo(raiz);
			contador--;
			return resultado;
		}

		Comparable<T> elementoComparable = (Comparable<T>) elemento;
		NodoArbolBinario<T> actual = null;
		NodoArbolBinario<T> padre = raiz;

		if (elementoComparable.compareTo(raiz.getElemento()) < 0)
			actual = raiz.getIzquierdo();
		else
			actual = raiz.getDerecho();

		while (true) {
			if (elementoComparable.compareTo(actual.getElemento()) == 0) {
				// Eliminar
				resultado = actual.getElemento();
				if (actual == padre.getIzquierdo())
					padre.setIzquierdo(nodoReemplazo(actual));
				else
					padre.setDerecho(nodoReemplazo(actual));
				break;
			} else {
				// Seguir buscando
				padre = actual;
				if (elementoComparable.compareTo(actual.getElemento()) < 0)
					actual = actual.getIzquierdo();
				else
					actual = actual.getDerecho();
			} // fin del if
		} // fin del while
		contador--;
		return resultado;
	}

	private NodoArbolBinario<T> nodoReemplazo(NodoArbolBinario<T> nodo) {
		NodoArbolBinario<T> resultado = null;

		if ((nodo.getIzquierdo() == null) && (nodo.getDerecho() == null))
			resultado = null;
		else if (nodo.getDerecho() == null)
			resultado = nodo.getIzquierdo();
		else if (nodo.getIzquierdo() == null)
			resultado = nodo.getDerecho();
		else {
			NodoArbolBinario<T> actual = nodo.getDerecho();
			NodoArbolBinario<T> padre = nodo;

			while (actual.getIzquierdo() != null) {
				padre = actual;
				actual = actual.getIzquierdo();
			}

			if (nodo.getDerecho() == actual)
				actual.setIzquierdo(nodo.getIzquierdo());
			else {
				padre.setIzquierdo(actual.getDerecho());
				actual.setDerecho(nodo.getDerecho());
				actual.setIzquierdo(nodo.getIzquierdo());
			}

			resultado = actual;
		} // fin del if

		return resultado;

	}

	@Override
	public void removAllElements() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterator<T> iteratorInOrden() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> iteratorPostOrden() {
		// TODO Auto-generated method stub
		return null;
	}

}
// eliminar un nodo hacemos el nosuchelement