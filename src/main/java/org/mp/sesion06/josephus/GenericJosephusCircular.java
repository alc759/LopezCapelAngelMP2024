package org.mp.sesion06.josephus;

import java.util.Iterator;

import org.mp.sesion06.circularlist.CircularList;

/**
 * The Class GenericJosephusCircular.
 *
 * @param <E> the element type
 */
public class GenericJosephusCircular<E> {

	/** k. */
	private int k;
	
	/** n. */
	private int n;
	
	/** lista circular. */
	private CircularList<E> listaCircular;

	/**
	 * Instancia un josephus circular.
	 *
	 * @param k the k
	 * @param n the n
	 * @param arr the arr
	 */
	public GenericJosephusCircular(int k, int n, E[] arr) {
		this.k = k;
		this.n = n;
		listaCircular = new CircularList<>();

		if (arr != null) {
			for (int i = 0; i < n; i++) {
				listaCircular.addElement(arr[i]);
			}
		}
	}

	/**
	 * Determina el orden en el que elimina elementos.
	 *
	 * @return the string
	 */
	public String ordenEliminar() {
		StringBuilder salida = new StringBuilder();
		Iterator<E> iterador = listaCircular.iterator();

		if (n == 0) {
			throw new RuntimeException("No hay ninguna persona");
		} else if (n == 1) {
			salida.append("Solo hay una persona");
		} else {
			salida.append("Orden de eliminación:\n");
			while (listaCircular.getSize() > 1) {
				for (int i = 1; i < k; i++) {
					if (!iterador.hasNext()) {
						iterador = listaCircular.iterator();
					}
					iterador.next();
				}
				E eliminado = iterador.next();
				iterador.remove();
				salida.append("Debe morir " + eliminado + "\n");
			}
			salida.append("Debe morir " + listaCircular.getElement(0) + "\n");
		}
		return salida.toString();
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		return "Problema de Josephus: k=" + k + ", n=" + n + "\nCola: " + listaCircular.toString();
	}

}
