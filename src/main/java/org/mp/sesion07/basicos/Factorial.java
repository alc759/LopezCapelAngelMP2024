package org.mp.sesion07.basicos;

// TODO: Auto-generated Javadoc
/**
 * The Class Factorial.
 */
public class Factorial {

	/**
	 * Factorial rec.
	 *
	 * @param i the i
	 * @return the int
	 */
	public static int factorialRec(int i) {
		if (i == 0 || i == 1) {
			return 1;
		} else {
			return i * factorialRec(i - 1);
		}
	}

	/**
	 * Factorial iter.
	 *
	 * @param i the i
	 * @return the integer
	 */
	public static Integer factorialIter(int i) {
		int factorial = 1;
		for (int j = 1; j <= i; j++) {
			factorial *= j;
		}
		return factorial;
	}

}
