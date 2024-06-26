package org.mp.sesion07.ordenacion;

import java.util.Arrays;

// TODO: Auto-generated Javadoc
/**
 * The Class Ordenacion.
 */
public class Ordenacion {

	/**
	 * Ordenacion por insercion.
	 *
	 * @param array the array
	 */
	public static void ordenacionPorInsercion(Comparable[] array) {
		int n = array.length;
		for (int i = 1; i < n; ++i) {
			Comparable key = array[i];
			int j = i - 1;
			while (j >= 0 && array[j].compareTo(key) > 0) {
				array[j + 1] = array[j];
				j = j - 1;
			}
			array[j + 1] = key;
		}
	}

	/**
	 * Merge sort.
	 *
	 * @param array the array
	 */
	public static void mergeSort(Comparable[] array) {
		if (array.length > 1) {
			int mid = array.length / 2;
			Comparable[] leftArray = Arrays.copyOfRange(array, 0, mid);
			Comparable[] rightArray = Arrays.copyOfRange(array, mid, array.length);
			mergeSort(leftArray);
			mergeSort(rightArray);

			int i = 0, j = 0, k = 0;

			while (i < leftArray.length && j < rightArray.length) {
				if (leftArray[i].compareTo(rightArray[j]) <= 0) {
					array[k] = leftArray[i];
					i++;
				} else {
					array[k] = rightArray[j];
					j++;
				}
				k++;
			}

			while (i < leftArray.length) {
				array[k] = leftArray[i];
				i++;
				k++;
			}

			while (j < rightArray.length) {
				array[k] = rightArray[j];
				j++;
				k++;
			}
		}
	}

	/**
	 * Sort.
	 *
	 * @param array the array
	 */
	public static void sort(Comparable[] array) {
		Arrays.sort(array);
	}

}
