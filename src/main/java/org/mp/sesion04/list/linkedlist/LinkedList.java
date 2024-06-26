package org.mp.sesion04.list.linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.mp.sesion04.list.AbstractList;

/**
 * The Class LinkedList.
 *
 * @param <E> the element type
 */
public class LinkedList<E> extends AbstractList<E> {
	
	/** El primer y ultimo nodo de la lista. */
	private Node<E> head, tail;

	/**
	 *  Crea una lista por defecto.
	 */
	public LinkedList() {
	}

	/**
	 *  Crea una lista a partir de un array de objetos.
	 *
	 * @param objects the objects
	 */
	public LinkedList(E[] objects) {
		super(objects);
	}

	/**
	 *  Compara dos listas.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LinkedList)) {
			return false;
		}

		LinkedList<?> otherList = (LinkedList<?>) obj;

		if (this.size() != otherList.size()) {
			return false;
		}

		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		Node<E> current1 = this.head;
		Node<?> current2 = otherList.head;

		while (current1 != null && current2 != null) {
			if (!current1.element.equals(current2.element)) {
				return false;
			}
			current1 = current1.next;
			current2 = current2.next;
		}

		return true;

	}

	/**
	 *  Devuelve el primer elemento de la lista.
	 *
	 * @return the first
	 */
	public E getFirst() {

		if (isEmpty()) {
			return null;
		} else {
			return head.element;
		}

	}

	/**
	 *  Devuelve el ultimo elemento de la lista.
	 *
	 * @return the last
	 */
	public E getLast() {

		if (head == null) {
			return null;
		} else {
			return tail.element;
		}

	}

	/**
	 *  Anade un nuevo elemento en la posición especifica por index.
	 *
	 * @param e the e
	 */

	public void addFirst(E e) {

		Node<E> nuevoNodo = new Node<E>(e);
		nuevoNodo.next = head;
		head = nuevoNodo;
		size++;
		if (tail == null)
			tail = head;

	}

	/**
	 * Adds the last.
	 *
	 * @param e the e
	 */
	public void addLast(E e) {

		Node<E> nuevoNodo = new Node<>(e);
		if (tail == null) {
			head = tail = nuevoNodo;
		} else {
			tail.next = nuevoNodo;
			tail = tail.next;
		}
		size++;

	}

	/**
	 * Anade un nuevo elemento en la posición especifica por index.
	 *
	 * @param index the index
	 * @param e the e
	 */
	public void add(int index, E e) {

		if (index <= 0)
			addFirst(e);
		else if (index >= size)
			addLast(e);
		else {
			Node<E> current = head;
			for (int i = 1; i < index; i++) {
				current = current.next;
			}
			Node<E> temp = current.next;
			current.next = new Node<E>(e);
			(current.next).next = temp;
			size++;
		}

	}

	/**
	 * Remove the head node and return the object that is contained in the removed
	 * node.
	 *
	 * @return the e
	 */
	public E removeFirst() {

		if (size == 0)
			return null;
		else {
			Node<E> temp = head;
			head = head.next;
			size--;
			if (head == null)
				tail = null;
			return temp.element;
		}

	}

	/**
	 * Elimina el ultimo elemento de la lista y devuelve el elemento eliminado.
	 *
	 * @return the e
	 */
	public E removeLast() {

		if (size == 0)
			return null;
		else if (size == 1) {
			Node<E> temp = head;
			head = tail = null;
			size = 0;
			return temp.element;
		} else {
			Node<E> current = head;
			for (int i = 0; i < size - 2; i++)
				current = current.next;
			Node<E> temp = tail;
			tail = current;
			tail.next = null;
			size--;
			return temp.element;
		}

	}

	/**
	 * Elimina el elemento especificado por index y devuelve el eliminado.
	 *
	 * @param index the index
	 * @return the e
	 */
	public E remove(int index) {

		if (index < 0 || index >= size) {
			return null;
		} else if (index == 0) {
			return removeFirst();
		} else if (index == size - 1) {
			return removeLast();
		} else {
			Node<E> previous = head;
			for (int i = 0; i < index - 1; i++) {
				previous = previous.next;
			}
			Node<E> current = previous.next;
			previous.next = current.next;
			size--;
			return current.element;
		}

	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override /** Sobre-escribe toString() */
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append("[");
		Node<E> current = head;
		while (current != null) {
			sb.append(current.element);
			if (current.next != null) {
				sb.append(", ");
			}
			current = current.next;
		}
		sb.append("]");
		return sb.toString();

	}

	/**
	 *  Elimina todos los elementos de la lista.
	 */
	public void clear() {

		head = null;
		tail = null;
		size = 0;

	}

	/**
	 *  Devuelve true si la lista contiene el elemento e.
	 *
	 * @param e the e
	 * @return true, if successful
	 */
	public boolean contains(E e) {

		Node<E> current = head;

		while (current != null) {
			if (current.element.equals(e)) {
				return true;
			}
			current = current.next;
		}
		return false;

	}

	/**
	 *  Devuelve el elemento especificado por la posicion index.
	 *
	 * @param index the index
	 * @return the e
	 */
	public E get(int index) {
		return null;
	}

	/**
	 * Devuelve el indice de la primera ocurrencia de e en la lista. Devuelve -1 si
	 * no esta.
	 *
	 * @param e the e
	 * @return the int
	 */
	public int indexOf(E e) {

		Node<E> current = head;

		int index = 0;

		while (current != null) {
			if (current.element.equals(e)) {
				return index;
			}
			current = current.next;
			index++;
		}

		return -1;
	}

	/**
	 * Devuelve el indice de la ultima ocurrencia de e en la lista. Devuelve -1 si
	 * no esta.
	 *
	 * @param e the e
	 * @return the int
	 */
	public int lastIndexOf(E e) {

		Node<E> current = tail;
		int index = size - 1;

		while (current != null) {
			if (current.element.equals(e)) {
				return index;
			}
			current = current.next;
			index--;
		}

		return -1;
	}

	/**
	 * Sustituye el elemento en la posicion especificada por index por el elemento
	 * e.
	 *
	 * @param index the index
	 * @param e the e
	 * @return the e
	 */
	public E set(int index, E e) {

		if (index < 0) {
			return null;
		} else if (index >= size) {
			return null;
		} else {
			E oldValue = remove(index);
			add(index, e);
			return oldValue;
		}

	}

	/**
	 * Iterator.
	 *
	 * @return the iterator
	 */
	@Override
	/** Sobre-escribe iterator() definido en Iterable */
	public Iterator<E> iterator() {
		return new LinkedListIterator();
	}

	/**
	 * The Class LinkedListIterator.
	 */
	private class LinkedListIterator implements Iterator<E> {
		
		/** The current. */
		private Node<E> current = head; // nodo current
		
		/** The previous. */
		private Node<E> previous = null; // nodo previous
		
		/** The removible. */
		boolean removible;

		/**
		 * Checks for next.
		 *
		 * @return true, if successful
		 */
		@Override
		public boolean hasNext() {

			return current != null;

		}

		/**
		 * Next.
		 *
		 * @return the e
		 */
		@Override
		public E next() {

			if (!hasNext()) {
				throw new NoSuchElementException("No hay más elementos");
			}
			E element = current.element;
			previous = current;
			current = current.next;
			removible = true;
			return element;

		}

		/**
		 * Removes the.
		 */
		@Override
		// elimina el ultimo elemento devuelto por el iterador.
		public void remove() {

			if (!removible) {
				throw new IllegalStateException("No se puede eliminar el elemento");
			}

			if (previous == null) {
				throw new IllegalStateException("No se puede eliminar antes de llamar a next()");
			}

			if (size != 0) {
				LinkedList.this.remove(previous.element);
				removible = false;
			}

		}
	}

	/**
	 * The Class Node.
	 *
	 * @param <E> the element type
	 */
	private static class Node<E> {
		
		/** The element. */
		E element;
		
		/** The next. */
		Node<E> next;

		/**
		 * Instantiates a new node.
		 *
		 * @param element the element
		 */
		public Node(E element) {
			this.element = element;
		}
	}

}
