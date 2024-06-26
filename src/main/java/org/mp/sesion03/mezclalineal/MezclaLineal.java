package org.mp.sesion03.mezclalineal;

import java.util.Arrays;

/**
 * The Class MezclaLineal.
 */
public class MezclaLineal {

	/**
	 * Mezcla lineal int.
	 *
	 * @param arr1 the arr 1
	 * @param arr2 the arr 2
	 * @return the int[]
	 */
	// Método para mezclar dos arrays de enteros (int)
	public static int[] mezclaLinealInt(int[] arr1, int[] arr2) {
		int[] result = new int[arr1.length + arr2.length];
		int i = 0, j = 0, k = 0;

		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] <= arr2[j]) {
				result[k++] = arr1[i++];
			} else {
				result[k++] = arr2[j++];
			}
		}

		while (i < arr1.length) {
			result[k++] = arr1[i++];
		}

		while (j < arr2.length) {
			result[k++] = arr2[j++];
		}

		return result;
	}

	/**
	 * Mezcla lineal comparables.
	 *
	 * @param <T> the generic type
	 * @param arr1 the arr 1
	 * @param arr2 the arr 2
	 * @return the t[]
	 */
	public static <T extends Comparable<T>> T[] mezclaLinealComparables(T[] arr1, T[] arr2) {
		int totalLength = arr1.length + arr2.length;
		T[] result = Arrays.copyOf(arr1, totalLength);
		int i = arr1.length;
		for (T item : arr2) {
			result[i++] = item;
		}
		Arrays.sort(result);
		return result;
	}

	/**
	 * Mezcla lineal genericos.
	 *
	 * @param <T> the generic type
	 * @param arr1 the arr 1
	 * @param arr2 the arr 2
	 * @return the t[]
	 */
	public static <T extends Comparable<T>> T[] mezclaLinealGenericos(T[] arr1, T[] arr2) {
		int totalLength = arr1.length + arr2.length;
		T[] result = Arrays.copyOf(arr1, totalLength);
		int i = arr1.length;
		for (T item : arr2) {
			result[i++] = item;
		}
		Arrays.sort(result);
		return result;
	}

}
