package org.mp.sesion05.colas;

/**
 * The Class NodeQueue.
 *
 * @param <E> the element type
 */
public class NodeQueue<E> implements Queue<E> {

	/**  front. */
	private Node<E> front;
	
	/**  rear. */
	private Node<E> rear;
	
	/**  size. */
	private int size;

	/**
	 * Array queue.
	 */
	public void ArrayQueue() {
	}

	/**
	 * Enqueue.
	 *
	 * @param e the e
	 */
	public void enqueue(E e) {
		Node<E> newNode = new Node<>(e);
		if (isEmpty()) {
			front = (Node<E>) newNode;
			rear = (Node<E>) newNode;
		} else {
			rear.next = (Node<E>) newNode;
			rear = (Node<E>) newNode;
		}
		size++;
	}

	/**
	 * Dequeue.
	 *
	 * @return the e
	 */
	public E dequeue() {
		if (isEmpty()) {
			throw new IllegalStateException();
		}
		E data = (E) front.data;
		front = front.next;
		if (front == null) {
			rear = null;
		}
		size--;
		return data;
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
	 * Checks if is empty.
	 *
	 * @return true, if is empty
	 */
	private boolean isEmpty() {
		return front == null;
	}

	/**
	 * The Class Node.
	 *
	 * @param <E> the element type
	 */
	private static class Node<E> {

		/** The data. */
		E data;
		
		/** The next. */
		Node<E> next;

		/**
		 * Instantiates a new node.
		 *
		 * @param data the data
		 */
		Node(E data) {
			this.data = data;
			this.next = null;
		}

	}

}
