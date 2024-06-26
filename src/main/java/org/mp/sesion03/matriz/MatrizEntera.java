package org.mp.sesion03.matriz;

/**
 * The Class MatrizEntera.
 */
public class MatrizEntera extends MatrizGenerica<Integer> {

	/**
	 * Instancia una nueva matriz entera.
	 *
	 * @param filas the filas
	 * @param columnas the columnas
	 */
	public MatrizEntera(int filas, int columnas) {
		super(filas, columnas);
	}

	/**
	 * Crear matriz.
	 *
	 * @param filas the filas
	 * @param columnas the columnas
	 * @return the matriz generica
	 */
	protected MatrizGenerica<Integer> crearMatriz(int filas, int columnas) {
		return new MatrizEntera(filas, columnas);
	}

	/**
	 * Sumar elementos.
	 *
	 * @param a the a
	 * @param b the b
	 * @return the integer
	 */
	protected Integer sumarElementos(Integer a, Integer b) {
		return a + b;
	}

	/**
	 * Multiplicar elementos.
	 *
	 * @param a the a
	 * @param b the b
	 * @return the integer
	 */
	protected Integer multiplicarElementos(Integer a, Integer b) {
		return a * b;
	}

	/**
	 * Cero elemento.
	 *
	 * @return the integer
	 */
	protected Integer ceroElemento() {
		return 0;
	}

}
