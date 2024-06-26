package org.mp.sesion06.circularlist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * The Class CircularList.
 *
 * @param <T> the generic type
 */
public class CircularList<T> {

	/** The list. */
	private List<T> list;
	
	/** The current. */
	private int current;

	/**
	 * Instancia una lista circular.
	 */
	public CircularList() {
		list = new ArrayList<>();
		current = 0;
	}

	/**
	 * Adds the element.
	 *
	 * @param element the element
	 */
	public void addElement(T element) {
		list.add(element);
	}

	/**
	 * Removes the element.
	 *
	 * @param element the element
	 * @return true, if successful
	 */
	public boolean removeElement(T element) {
		boolean removed = list.remove(element);
		if (removed && current >= list.size()) {
			current = 0;
		}
		return removed;
	}

	/**
	 * Gets the element.
	 *
	 * @param index the index
	 * @return the element
	 */
	public T getElement(int index) {
		return list.get(wrapIndex(index));
	}

	/**
	 * Gets the index.
	 *
	 * @param element the element
	 * @return the index
	 */
	public int getIndex(T element) {
		int index = list.indexOf(element);
		return index != -1 ? wrapIndex(index) : -1;
	}

	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	public int getSize() {
		return list.size();
	}

	/**
	 * Checks if is empty.
	 *
	 * @return true, if is empty
	 */
	public boolean isEmpty() {
		return list.isEmpty();
	}

	/**
	 * Iterator.
	 *
	 * @return the iterator
	 */
	public Iterator<T> iterator() {
		return new CircularIterator();
	}

	/**
	 * Si llega al final de la lista, volvera al principio 
	 * en vez de dar error por salirse del rango.
	 *
	 * @param index the index
	 * @return the int
	 */
	protected int wrapIndex(int index) {
		if (index >= 0) {
			return index % list.size();
		} else {
			return list.size() + (index % list.size());
		}
	}

	/**
	 * Gets the next index.
	 *
	 * @param currentIndex the current index
	 * @return the next index
	 */
	public int getNextIndex(int currentIndex) {
		return wrapIndex(currentIndex + 1);
	}

	/**
	 * The Class CircularIterator.
	 */
	private class CircularIterator implements Iterator<T> {
		
		/** The current index. */
		private int currentIndex;
		
		/** The iterator index. */
		private int iteratorIndex;

		/**
		 * Instantiates a new circular iterator.
		 */
		public CircularIterator() {
			currentIndex = current;
			iteratorIndex = 0;
		}

		/**
		 * Checks for next.
		 *
		 * @return true, if successful
		 */
		public boolean hasNext() {
			return iteratorIndex < list.size();
		}

		/**
		 * Next.
		 *
		 * @return the t
		 */
		public T next() {
			T element = list.get(currentIndex);
			currentIndex = wrapIndex(currentIndex + 1);
			iteratorIndex++;
			return element;
		}

		/**
		 * Removes the.
		 */
		public void remove() {
			if (iteratorIndex == 0) {
				throw new IllegalStateException("");
			}
			int removalIndex = wrapIndex(currentIndex - 1);
			list.remove(removalIndex);
			currentIndex = wrapIndex(currentIndex - 1);
			iteratorIndex--;
		}
	}

}
