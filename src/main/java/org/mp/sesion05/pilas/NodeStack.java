package org.mp.sesion05.pilas;

// TODO: Auto-generated Javadoc
/**
 * The Class NodeStack.
 *
 * @param <E> the element type
 */
public class NodeStack<E> implements Stack<E> {

	/** top. */
	private Node<E> top;
	
	/** size. */
	private int size;

	/**
	 * Instancia una pila de nodos.
	 */
	public NodeStack() {
		top = null;
		size = 0;
	}

	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Peek.
	 *
	 * @return the e
	 */
	public E peek() {
		if (isEmpty()) {
			return null;
		}
		return top.getData();
	}

	/**
	 * Push.
	 *
	 * @param o the o
	 */
	public void push(E o) {
		Node<E> newNode = new Node<>(o, top);
		top = newNode;
		size++;
	}

	/**
	 * Pop.
	 *
	 * @return the e
	 */
	public E pop() {
		if (isEmpty()) {
			return null;
		}
		E removedElement = top.getData();
		top = top.getNext();
		size--;
		return removedElement;
	}

	/**
	 * Checks if is empty.
	 *
	 * @return true, if is empty
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * The Class Node.
	 *
	 * @param <E> the element type
	 */
	private static class Node<E> {
		
		/** data. */
		private E data;
		
		/** next. */
		private Node<E> next;

		/**
		 * Instantiates a new node.
		 *
		 * @param data the data
		 * @param next the next
		 */
		public Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}

		/**
		 * Gets the data.
		 *
		 * @return the data
		 */
		public E getData() {
			return data;
		}

		/**
		 * Gets the next.
		 *
		 * @return the next
		 */
		public Node<E> getNext() {
			return next;
		}
	}

}
