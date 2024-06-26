package org.mp.sesion05.pilas;

import java.util.Arrays;

// TODO: Auto-generated Javadoc
/**
 * The Class ArrayStack.
 *
 * @param <E> the element type
 */
public class ArrayStack<E> implements Stack<E> {

	/** Capacidad por defecto. */
	private static final int DEFAULT_CAPACITY = 10;
	
	/** array. */
	private E[] array;
	
	/** tamano. */
	private int size;

	/**
	 * Instancia nuevo array pila.
	 */
	public ArrayStack() {
		array = (E[]) new Object[DEFAULT_CAPACITY];
		size = 0;
	}

	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	@Override
	public int getSize() {
		return size;
	}

	/**
	 * Peek.
	 *
	 * @return the e
	 */
	@Override
	public E peek() {

		if (isEmpty()) {
			return null;
		}
		return array[size - 1];

	}

	/**
	 * Push.
	 *
	 * @param o the o
	 */
	@Override
	public void push(E o) {
		if (size == array.length) {
			resizeArray();
		}
		array[size++] = o;
	}

	/**
	 * Pop.
	 *
	 * @return the e
	 */
	@Override
	public E pop() {
		if (isEmpty()) {
			return null;
		}
		E removedElement = array[--size];
		array[size] = null;
		return removedElement;
	}

	/**
	 * Comprueba si la pila esta vacia.
	 *
	 * @return true, if is empty
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Cambia el tamaño del array.
	 */
	private void resizeArray() {
		int newSize = array.length * 2;
		array = Arrays.copyOf(array, newSize);
	}

}
