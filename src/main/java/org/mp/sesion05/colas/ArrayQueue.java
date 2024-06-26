package org.mp.sesion05.colas;

import java.util.NoSuchElementException;

// TODO: Auto-generated Javadoc
/**
 * The Class ArrayQueue.
 *
 * @param <E> the element type
 */
public class ArrayQueue<E> implements Queue<E> {

	/** Capacidad inicial. */
	private int INITIAL_CAPACITY;
	
	/** Cola. */
	Object[] arrayQueue;
	
	/**  front. */
	private int front;
	
	/**  rear. */
	private int rear;
	
	/**  size. */
	private int size;

	/**
	 * Instancia una array queue.
	 */
	public ArrayQueue() {
		INITIAL_CAPACITY = 10;
		arrayQueue = new Object[INITIAL_CAPACITY];
		front = 0;
		rear = 0;
		size = 0;
	}

	/**
	 * Enqueue.
	 *
	 * @param e the e
	 */
	public void enqueue(E e) {
		if (size == arrayQueue.length) {
			expandCapacity();
		}
		arrayQueue[rear] = e;
		rear = (rear + 1) % arrayQueue.length;
		size++;
	}

	/**
	 * Dequeue.
	 *
	 * @return the e
	 */
	public E dequeue() {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		E element = (E) arrayQueue[front];
		arrayQueue[front] = null;
		front = (front + 1) % arrayQueue.length;
		size--;
		return (E) element;
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
	 * Expand capacity.
	 */
	private void expandCapacity() {
		int newCapacity = arrayQueue.length * 2;
		Object[] newArray = new Object[newCapacity];
		for (int i = 0; i < size; i++) {
			newArray[i] = arrayQueue[(front + i) % arrayQueue.length];
		}
		arrayQueue = newArray;
		front = 0;
		rear = size;
	}

}
