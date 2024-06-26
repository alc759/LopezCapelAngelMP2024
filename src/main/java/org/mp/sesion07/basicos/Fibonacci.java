package org.mp.sesion07.basicos;

// TODO: Auto-generated Javadoc
/**
 * The Class Fibonacci.
 */
public class Fibonacci {

	/**
	 * Fibonacci recursivo.
	 *
	 * @param i the i
	 * @return the int
	 */
	public static int fibonacciRec(int i) {
		if (i <= 1) {
			return i;
		} else {
			return fibonacciIter(i - 1) + fibonacciIter(i - 2);
		}
	}

	/**
	 * Fibonacci iterativo.
	 *
	 * @param i the i
	 * @return the int
	 */
	public static int fibonacciIter(int i) {
		if (i <= 1) {
			return i;
		} else {
			int fibAnterior = 0;
			int fibActual = 1;
			for (int j = 2; j <= i; j++) {
				int tt = fibActual;
				fibActual = fibActual + fibAnterior;
				fibAnterior = tt;
			}
			return fibActual;
		}
	}

}
