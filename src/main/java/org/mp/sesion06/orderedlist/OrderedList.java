package org.mp.sesion06.orderedlist;

import java.util.LinkedList;
import java.util.List;

/**
 * The Class OrderedList.
 *
 * @param <T> the generic type
 */
public class OrderedList<T extends Comparable<T>> {

	/** The list. */
	private List<T> list;

	/**
	 * Instancia una ordered list.
	 */
	public OrderedList() {
		this.list = new LinkedList<>();
	}

	/**
	 * Instancia una ordered list.
	 *
	 * @param list the list
	 */
	public OrderedList(List<? extends T> list) {
		this.list = new LinkedList<>(list);
	}

	/**
	 * Adds the element.
	 *
	 * @param element the element
	 */
	public void addElement(T element) {
		int index = 0;
		while (index < list.size() && list.get(index).compareTo(element) < 0) {
			index++;
		}
		list.add(index, element);
	}

	/**
	 * Removes the element.
	 *
	 * @param element the element
	 * @return true, if successful
	 */
	public boolean removeElement(T element) {
		return list.remove(element);
	}

	/**
	 * Gets the element at specified index.
	 *
	 * @param index the index
	 * @return the element
	 */
	public T getElement(int index) {
		if (isEmpty() || index < 0 || index >= getSize()) {
			return null;
		}
		return list.get(index);
	}

	/**
	 * Gets the index.
	 *
	 * @param element the element
	 * @return the index
	 */
	public int getIndex(T element) {
		return list.indexOf(element);
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

}
