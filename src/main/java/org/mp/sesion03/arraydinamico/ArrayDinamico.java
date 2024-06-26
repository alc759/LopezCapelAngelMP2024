package org.mp.sesion03.arraydinamico;

import java.util.Arrays;

/**
 * The Class ArrayDinamico.
 *
 * @param <T> the generic type
 */
public class ArrayDinamico<T> {

	/**  elementos. */
	private Object[] elementos;
	
	/**  num elementos. */
	private int numElementos;

	/**
	 * Instancia un nuevo array dinamico.
	 */
	public ArrayDinamico() {
		elementos = new Object[10];
		numElementos = 0;
	}

	/**
	 * Obtener el elemento del indice indicado.
	 *
	 * @param indice indice a obtener
	 * @return the t
	 */
	public T obtener(int indice) {
		if (indice < 0 || indice >= numElementos)
			throw new ArrayIndexOutOfBoundsException();
		T elemento = (T) elementos[indice];
		return elemento;
	}

	/**
	 * Establecer un elemento a un indice particular.
	 *
	 * @param indice the indice
	 * @param elemento the elemento
	 */
	public void establecer(int indice, T elemento) {
		if (indice < 0 || indice >= numElementos)
			throw new ArrayIndexOutOfBoundsException();
		elementos[indice] = elemento;
	}

	/**
	 * Capacidad.
	 *
	 * @return the int
	 */
	public int capacidad() {
		return numElementos;
	}

	/**
	 * Agregar elemento al array.
	 *
	 * @param elemento the elemento
	 */
	public void agregar(T elemento) {
		if (numElementos == elementos.length) {
			elementos = Arrays.copyOf(elementos, 2 * elementos.length);
		}
		elementos[numElementos] = elemento;
		numElementos++;
	}

	/**
	 * Eliminar elemento.
	 *
	 * @param indice the indice
	 */
	public void eliminar(int indice) {
		if (indice < 0 || indice >= numElementos)
			throw new ArrayIndexOutOfBoundsException();
		for (int j = indice + 1; j < numElementos; j++)
			elementos[j - 1] = elementos[j];
		numElementos--;
	}

}
