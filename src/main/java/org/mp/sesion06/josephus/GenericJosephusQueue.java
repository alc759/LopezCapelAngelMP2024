package org.mp.sesion06.josephus;

import java.util.LinkedList;
import java.util.Queue;

/**
 * The Class GenericJosephusQueue.
 *
 * @param <E> the element type
 */
public class GenericJosephusQueue<E> {

	/** k. */
	private int k;
	
	/** n. */
	private int n;
	
	/** personas. */
	private Queue<E> personas;

	/**
	 * Instancia josephus queue.
	 *
	 * @param k the k
	 * @param n the n
	 * @param arr the arr
	 */
	public GenericJosephusQueue(int k, int n, E[] arr) {
		this.k = k;
		this.n = n;
		this.personas = new LinkedList<>();
		if (arr != null) {
			for (int i = 0; i < n; i++) {
			personas.offer(arr[i]);
			}
		}
	}

	/**
	 * Determina el orden de eliminacion para el problema.
	 *
	 * @return the string
	 */
	public String ordenEliminar() {
		String salida = "";

		if (n == 0) {
			throw new RuntimeException("No hay ninguna persona");
		} else if (n == 1) {
			salida += "Solo hay una persona";
		} else {
			salida += "Orden de eliminación:\n";
			while (personas.size() != 0) {
				for (int i = 1; i < k; i++) {
					personas.offer(personas.poll());
				}
				salida += "Debe morir " + personas.poll();
				salida += "\n";
			}
		}
		return salida;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		return "Problema de Josephus: k=" + k + ", n=" + n + "\nCola: " + personas;
	}

}
