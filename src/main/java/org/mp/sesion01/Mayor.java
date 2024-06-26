package org.mp.sesion01;

/**
 * The Class Mayor.
 */
public class Mayor {
	 
	/**
	 * Devuelve el entero mayor de un array.
	 *
	 * @param a Array
	 * @return el entero mayor
	 */
	public static int elEnteroMayor(int[] a) {
	
		int max = Integer.MIN_VALUE;
		for (int indice = 0; indice < a.length -1 ; indice++) {  
			if (a[indice] > max && a[indice] != max) {
				max = a[indice];
				}
			}
		
		if(a.length == 1) {
			max = a[0];
		}
		
		if(a.length == 0) {
			throw new RuntimeException("Array vacio");
		}
		
		return max;
	}
}
