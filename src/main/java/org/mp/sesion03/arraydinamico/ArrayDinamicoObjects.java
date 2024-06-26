package org.mp.sesion03.arraydinamico;

import java.util.Arrays;

// TODO: Auto-generated Javadoc
/**
 * The Class ArrayDinamicoObjects.
 */
public class ArrayDinamicoObjects {

	/**  elementos. */
	private Object[] elementos;
	
	/**  num elementos. */
	private int numElementos;

	/**
	 * Instancia un nuevo array dinamico.
	 */
	public ArrayDinamicoObjects() {
		elementos = new Object[10];
		numElementos = 0;
	}

	/**
	 * Obtener el elemento del indice indicado.
	 *
	 * @param indice the indice
	 * @return the object
	 */
	public Object obtener(int indice) {
		if (indice < 0 || indice >= numElementos)
			throw new ArrayIndexOutOfBoundsException();
		return elementos[indice];
	}

	/**
	 * Establecer un elemento en un indice.
	 *
	 * @param indice the indice
	 * @param elemento the elemento
	 */
	public void establecer(int indice, Object elemento) {
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
	public void agregar(Object elemento) {
		if (numElementos == elementos.length) {
			elementos = Arrays.copyOf(elementos, 2 * elementos.length);
		}
		elementos[numElementos] = elemento;
		numElementos++;
	}

	/**
	 * Eliminar.
	 *
	 * @param indice the indice
	 */
	public void eliminar(int indice) {
		if (indice < 0 || indice >= numElementos)
			throw new ArrayIndexOutOfBoundsException("Indice no válido, " + indice);
		for (int j = indice + 1; j < numElementos; j++)
			elementos[j - 1] = elementos[j];
		numElementos--;
	}

}
