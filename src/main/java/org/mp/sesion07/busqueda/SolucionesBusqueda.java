package org.mp.sesion07.busqueda;

import java.util.Arrays;

// TODO: Auto-generated Javadoc
/**
 * The Class SolucionesBusqueda.
 */
public class SolucionesBusqueda {

	/**
	 * Busqueda lineal.
	 *
	 * @param <T> the generic type
	 * @param busqueda the busqueda
	 * @return the int
	 * @throws ElementoNoEncontradoException the elemento no encontrado exception
	 */
	public static <T extends Comparable<T>> int busquedaLineal(Busqueda<T> busqueda)
			throws ElementoNoEncontradoException {
		T[] datos = busqueda.getDatos();
		T numBuscado = busqueda.getNumBuscado();
		for (int i = 0; i < datos.length; i++) {
			if (numBuscado.compareTo(datos[i]) == 0) {
				return i;
			}
		}
		throw new ElementoNoEncontradoException("El elemento no se encuentra en el array");
	}

	/**
	 * Busqueda binaria iter.
	 *
	 * @param <T> the generic type
	 * @param busqueda the busqueda
	 * @return the int
	 * @throws ElementoNoEncontradoException the elemento no encontrado exception
	 */
	public static <T extends Comparable<T>> int busquedaBinariaIter(Busqueda<T> busqueda)
			throws ElementoNoEncontradoException {
		T[] datos = busqueda.getDatos();
		T numBuscado = busqueda.getNumBuscado();
		int inicio = 0;
		int fin = datos.length - 1;
		while (inicio <= fin) {
			int medio = (inicio + fin) / 2;
			int comparacion = datos[medio].compareTo(numBuscado);
			if (comparacion == 0) {
				return medio;
			} else if (comparacion < 0) {
				inicio = medio + 1;
			} else {
				fin = medio - 1;
			}
		}
		throw new ElementoNoEncontradoException("El elemento no fue encontrado.");
	}

	/**
	 * Busqueda binaria rec.
	 *
	 * @param <T> the generic type
	 * @param busqueda the busqueda
	 * @return the int
	 * @throws ElementoNoEncontradoException the elemento no encontrado exception
	 */
	public static <T extends Comparable<T>> int busquedaBinariaRec(Busqueda<T> busqueda)
			throws ElementoNoEncontradoException {
		T[] datos = busqueda.getDatos();
		T numBuscado = busqueda.getNumBuscado();
		return busquedaBinariaRec(datos, numBuscado, 0, datos.length - 1);
	}

	/**
	 * Busqueda binaria rec.
	 *
	 * @param <T> the generic type
	 * @param datos the datos
	 * @param numBuscado the num buscado
	 * @param inicio the inicio
	 * @param fin the fin
	 * @return the int
	 * @throws ElementoNoEncontradoException the elemento no encontrado exception
	 */
	private static <T extends Comparable<T>> int busquedaBinariaRec(T[] datos, T numBuscado, int inicio, int fin)
			throws ElementoNoEncontradoException {
		if (inicio > fin) {
			throw new ElementoNoEncontradoException("El elemento no fue encontrado.");
		}
		int medio = (inicio + fin) / 2;
		int comparacion = datos[medio].compareTo(numBuscado);
		if (comparacion == 0) {
			return medio;
		} else if (comparacion < 0) {
			return busquedaBinariaRec(datos, numBuscado, medio + 1, fin);
		} else {
			return busquedaBinariaRec(datos, numBuscado, inicio, medio - 1);
		}
	}

	/**
	 * Busqueda binaria rec elemento no encontrado.
	 *
	 * @param <T> the generic type
	 * @param busqueda the busqueda
	 * @return the int
	 * @throws ElementoNoEncontradoException the elemento no encontrado exception
	 */
	public static <T extends Comparable<T>> int busquedaBinariaRec_ElementoNoEncontrado(Busqueda<T> busqueda)
			throws ElementoNoEncontradoException {
		T[] datos = busqueda.getDatos();
		T numBuscado = busqueda.getNumBuscado();
		return busquedaBinariaRec(datos, numBuscado, 0, datos.length - 1);
	}

	/**
	 * Busqueda arrays binary search.
	 *
	 * @param <T> the generic type
	 * @param busqueda the busqueda
	 * @return the int
	 */
	public static <T extends Comparable<T>> int busquedaArraysBinarySearch(Busqueda<T> busqueda) {
		T[] datos = busqueda.getDatos();
		T numBuscado = busqueda.getNumBuscado();
		return Arrays.binarySearch(datos, numBuscado);
	}

}
