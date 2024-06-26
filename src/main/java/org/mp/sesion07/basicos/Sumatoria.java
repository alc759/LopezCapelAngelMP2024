package org.mp.sesion07.basicos;

// TODO: Auto-generated Javadoc
/**
 * The Class Sumatoria.
 */
public class Sumatoria {

	/**
	 * Suma recursiva.
	 *
	 * @param i the i
	 * @return the int
	 */
	public static int sumaRec(int i) {
		if (i <= 0) {
			return 0;
		}

		return i + sumaRec(i - 1);
	}

	/**
	 * Suma iterativa.
	 *
	 * @param i the i
	 * @return the int
	 */
	public static int sumaIter(int i) {
		int suma = 0;
		for (int j = 1; j <= i; j++) {
			suma = suma + j;
		}

		return suma;
	}

	/**
	 * Suma gaus.
	 *
	 * @param i the i
	 * @return the int
	 */
	public static int sumaGaus(int i) {
		return (i * (i + 1)) / 2;
	}

}
