package TareaSortingAndSearching;

//PROGRAMA QUE ELABORA TODO EL PROCESAMIENTO PARA TODOS LOS MÉTODOS DE ORDENACIÓN
public class SortingAndSearching<T extends Comparable> {
	public void OrdenamientoPorSeleccion(T[] data) {
		int minimo;
		T temporal;
		for (int i = 0; i < data.length; i++) {
			minimo = i;
			for (int j = i + 1; j < data.length; j++) {
				if (data[j].compareTo(data[minimo]) < 0) {
					minimo = j;
				}
			}

			// INTERCAMBIAR LOS VALORES
			temporal = data[minimo];
			data[minimo] = data[i];
			data[i] = temporal;
		}
	}

	public void OrdenamientoPorInsercion(T[] data) {
		for (int i = 0; i < data.length; i++) {
			T key = data[i];
			int posicion = i;

			// DESPLAZAR LOS VALORES MAYORES HACIA LA DERECHA
			while (posicion > 0 && data[posicion - 1].compareTo(key) > 0) {
				data[posicion] = data[posicion - 1];
				posicion--;
			}
			data[posicion] = key;
		}
	}

	public void MetodoBurbuja(T[] data) {
		T temporal;
		for (int i = data.length - 1; i >= 0; i--) {
			for (int j = 0; j <= i - 1; j++) {
				if (data[j].compareTo(data[j + 1]) > 0) {
					// INTERCAMBIAR LOS VALORES
					temporal = data[j];
					data[j] = data[j + 1];
					data[j + 1] = temporal;
				}
			}
		}
	}

	public void OrdenamientoRapido(T[] data, int minimo, int maximo) {
		int particion;
		if (maximo - minimo > 0) {
			// CREA LAS PARTICIONES
			particion = EncontrarParticion(data, minimo, maximo);

			// ORDENA EL LADO IZQUIERDO
			OrdenamientoRapido(data, minimo, particion - 1);

			// ORDENA EL LADO DERECHO
			OrdenamientoRapido(data, particion + 1, maximo);
		}
	}

	// ESTE MÉTODO COMPLEMENTA EL USO DEL MÉTODO ORDENAMIENTORAPIDO
	public int EncontrarParticion(T[] data, int minimo, int maximo) {
		int izquierdo, derecho;
		T temporal, elemento_particion;

		// UTILIZAR EL PRIMER ELEMENTO COMO ELEMENTO DE PARTICIÓN
		elemento_particion = data[minimo];

		izquierdo = minimo;
		derecho = maximo;

		while (izquierdo < derecho) {
			// BUSCAR UN ELEMENTO QUE SEA MAYOR QUE EL ELEMENTO DE PARTICIÓN
			while (data[izquierdo].compareTo(elemento_particion) <= 0 && izquierdo < derecho) {
				izquierdo++;
			}

			// BUSCAR UN ELEMENTO QUE SEA MENOR QUE EL ELEMENTO DE PARTICIÓN
			while (data[derecho].compareTo(elemento_particion) > 0) {
				derecho--;
			}

			// INTERCAMBIAR LOS ELEMENTOS
			if (izquierdo < derecho) {
				temporal = data[izquierdo];
				data[izquierdo] = data[derecho];
				data[derecho] = temporal;
			}
		}

		// MOVER EL ELEMENTO DE PARTICIÓN HASTA EL ÍNDICE DE PARTICIÓN
		temporal = data[minimo];
		data[minimo] = data[derecho];
		data[derecho] = temporal;

		return derecho;
	}

	public void OrdenamientoPorMezcla(T[] data, int minimo, int maximo) {
		T[] temporal;
		int izquierdo, derecho;

		// VOLVER AL ENCONTRARSE UNA LISTA DE LONGITUD UNO
		if (minimo == maximo) {
			return;
		}

		// CALCULAR LA LONGITUD Y EL PUNTO MEDIO DE LA LISTA
		int tamaño = maximo - minimo + 1;
		int pivote = (minimo + maximo) / 2;

		temporal = (T[]) (new Comparable[tamaño]);

		// ORDENAR LA MITAD IZQUERDA DE LA LISTA
		OrdenamientoPorMezcla(data, minimo, pivote);

		// ORDENAR LA MITAD DERECHA DE LA LISTA
		OrdenamientoPorMezcla(data, pivote + 1, maximo);

		// COPIAR LOS DATOS ORDENADOS AL ESPACIO DE TRABAJO
		for (int i = 0; i < tamaño; i++) {
			temporal[i] = data[minimo + i];
		}

		// MEZCLAR LAS DOS LISTAS ORDENADAS
		izquierdo = 0;
		derecho = pivote - minimo + 1;
		for (int i = 0; i < tamaño; i++) {
			if (derecho <= maximo - minimo) {
				if (izquierdo <= pivote - minimo) {
					if (temporal[izquierdo].compareTo(temporal[derecho]) > 0) {
						data[i + minimo] = temporal[derecho++];
					} else {
						data[i + minimo] = temporal[izquierdo++];
					}
				} else {
					data[i + minimo] = temporal[derecho++];
				}
			} else {
				data[i + minimo] = temporal[izquierdo++];
			}
		}
	}

	public int BusquedaLineal(T[] data, int minimo, int maximo, T target) {
		int i = minimo, posicion = -1;
		;
		boolean encontrado = false;

		while (!encontrado && i <= maximo) {
			if (data[i].compareTo(target) == 0) {
				encontrado = true;
				posicion = i;
			}
			i++;
		}
		return posicion;
	}

	public int BusquedaBinaria(T[] data, int minimo, int maximo, T target) {
		int punto_central = (minimo + maximo) / 2, posicion = -1; // DETERMINA EL PUNTO CENTRAL

		if (data[punto_central].compareTo(target) == 0) {
			posicion = punto_central;
		} else if (data[punto_central].compareTo(target) > 0) {
			if (minimo <= punto_central - 1) {
				posicion = BusquedaBinaria(data, minimo, punto_central - 1, target);
			}
		} else if (punto_central + 1 <= maximo) {
			posicion = BusquedaBinaria(data, punto_central + 1, maximo, target);
		}
		return posicion;
	}
}