package org.mp.sesion03.matriz;

/**
 * The Class MatrizDouble.
 */
public class MatrizDouble extends MatrizGenerica<Double> {

	/**
	 * Instancia una nueva matriz double.
	 *
	 * @param i the i
	 * @param j the j
	 */
	public MatrizDouble(int i, int j) {
		super(i, j);
	}

	/**
	 * Crear matriz.
	 *
	 * @param filas the filas
	 * @param columnas the columnas
	 * @return the matriz generica
	 */
	protected MatrizGenerica<Double> crearMatriz(int filas, int columnas) {
		return new MatrizDouble(filas, columnas);
	}

	/**
	 * Sumar elementos.
	 *
	 * @param a the a
	 * @param b the b
	 * @return the double
	 */
	protected Double sumarElementos(Double a, Double b) {
		return a + b;
	}

	/**
	 * Multiplicar elementos.
	 *
	 * @param a the a
	 * @param b the b
	 * @return the double
	 */
	protected Double multiplicarElementos(Double a, Double b) {
		try {
			return a * b;
		}
		catch(IllegalArgumentException e) {
		}
		return -1.0;
	}

	/**
	 * Cero elemento.
	 *
	 * @return the double
	 */
	protected Double ceroElemento() {
		return 0.0;
	}

}
