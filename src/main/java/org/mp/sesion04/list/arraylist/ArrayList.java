package org.mp.sesion04.list.arraylist;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.mp.sesion04.list.AbstractList;

/**
 * The Class ArrayList.
 *
 * @param <E> the element type
 */
public class ArrayList<E> extends AbstractList<E> {

	/**  CAPACIDAD_INICIAL. */
	private static final int CAPACIDAD_INICIAL = 16;

	/** The data. */
	private E[] data = (E[]) new Object[CAPACIDAD_INICIAL];

	/**
	 * Instancia una nueva array list vacia.
	 */
	public ArrayList() {
	}

	/**
	 * Instancia una nueva array list con objetos.
	 *
	 * @param objects the objects
	 */
	public ArrayList(E[] objects) {

		for (int i = 0; i < objects.length; i++)
			add(objects[i]); // Advertencia: no usar super(objects)!

	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ArrayList)) {
			return false;
		}
		ArrayList<E> otherList = (ArrayList<E>) obj;
		if (this.size != otherList.size) {
			return false;
		}
		for (int i = 0; i < this.size; i++) {
			if (!this.data[i].equals(otherList.data[i])) {
				return false;
			}
		}
		return true;

	}

	/**
	 * Añade un elemento en el index indicado.
	 *
	 * @param index the index
	 * @param e the e
	 */
	public void add(int index, E e) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException("Indice: " + index + ", Tamaño: " + size);

		ensureCapacity(index, e);

		for (int i = size - 1; i >= index; i--)
			data[i + 1] = data[i];

		data[index] = e;

		size++;
	}

	/**
	 * Asegura la capacidad.
	 *
	 * @param index the index
	 * @param element the element
	 */
	private void ensureCapacity(int index, E element) {

		if (data.length >= size + 1) {
			return;
		}

		int newCapacity = (data.length * 3) / 2 + 1;

		Object[] newData = new Object[newCapacity];
		System.arraycopy(data, 0, newData, 0, index);
		newData[index] = element;
		System.arraycopy(data, index, newData, index + 1, size - index);

		data = (E[]) newData;

	}

	/**
	 * Clear.
	 */
	public void clear() {
		size = 0;
	}

	/**
	 * Contains.
	 *
	 * @param e the e
	 * @return true, if successful
	 */
	public boolean contains(E e) {

		for (int i = 0; i < size; i++) {
			if (data[i].equals(e)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Devuelve el elemento que esta en el indice indicado.
	 *
	 * @param index the index
	 * @return the e
	 */
	public E get(int index) {
		checkIndex(index);
		return data[index];
	}

	/**
	 * Comprueba si el indice esta en el rango.
	 *
	 * @param index the index
	 */
	private void checkIndex(int index) {
		if (index < 0 || index >= size) // Comprueba si index está en el rango
			throw new IndexOutOfBoundsException("Indice: " + index + ", Tamaño: " + size); // Si no, el método lanza esa
																							// Excepción
	}

	/**
	 * Gets the length.
	 *
	 * @return the length
	 */
	private int getLength() {
		return data.length;
	}

	/**
	 * Devuelve el indice del objeto.
	 *
	 * @param e the e
	 * @return the int
	 */
	public int indexOf(E e) {

		for (int i = 0; i < size; i++) {
			if (data[i].equals(e)) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * Last index of.
	 *
	 * @param e the e
	 * @return the int
	 */
	public int lastIndexOf(E e) {

		for (int i = size - 1; i >= 0; i--) {
			if (data[i].equals(e)) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * Removes the.
	 *
	 * @param index the index
	 * @return the e
	 */
	public E remove(int index) {

		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Indice: " + index + ", Tamaño: " + size);
		}

		E element = data[index];

		for (int i = index + 1; i < size; i++) {
			data[i - 1] = data[i];
		}

		size--;

		return null;

	}

	/**
	 * Sets the.
	 *
	 * @param index the index
	 * @param e the e
	 * @return the e
	 */
	public E set(int index, E e) {
		checkIndex(index);
		E antiguo = data[index];
		data[index] = e;
		return antiguo;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {

		StringBuilder resultado = new StringBuilder("[");

		for (int i = 0; i < size; i++) {
			resultado.append(data[i]);
			if (i < size - 1)
				resultado.append(", ");
		}

		return resultado.toString() + "]";

	}

	/**
	 * Trim to size.
	 */
	public void trimToSize() {

		if (data.length != size) {
			Object[] newData = new Object[size];
			System.arraycopy(data, 0, newData, 0, size);
			data = (E[]) newData;
		} else {
			throw new RuntimeException("Guapit@ no necesitas hacer un trim, el tamaño coincide con la capacidad");
		}

	}

	/**
	 * Iterator.
	 *
	 * @return the iterator
	 */
	public Iterator<E> iterator() {
		return new ArrayListIterator();
	}

	/**
	 * The Class ArrayListIterator.
	 */
	private class ArrayListIterator implements Iterator<E> {
		
		/**  current. */
		private int current = 0; // indice current
		
		/**  remove permitido. */
		private boolean removePermitido = false; // solo se permite si se hace next

		/**
		 * Checks for next.
		 *
		 * @return true, if successful
		 */
		@Override
		public boolean hasNext() {

			return current < size;

		}

		/**
		 * Next.
		 *
		 * @return the e
		 */
		@Override
		public E next() {

			if (!hasNext()) {
				throw new NoSuchElementException("No hay más elementos en la lista");
			}

			E element = data[current];
			current++;
			removePermitido = true;
			return element;

		}

		/**
		 * Elimina el elemento.
		 */
		@Override
		public void remove() {

			if (!removePermitido) {
				throw new IllegalStateException("No se puede usar remove() sin hacer next()");
			}

			ArrayList.this.remove(current - 1);
			current--;
			removePermitido = false;

		}
	}

}