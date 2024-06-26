package org.mp.sesion03.matriz;

import java.util.Arrays;

/**
 * The Class MatrizGenerica.
 *
 * @param <T> the generic type
 */
public abstract class MatrizGenerica<T extends Number> {

	/**  filas. */
	private int filas;
	
	/**  columnas. */
	private int columnas;
	
	/**  matriz. */
	private T[][] matriz;

	/**
	 * Instancia una nueva matriz generica.
	 *
	 * @param filas the filas
	 * @param columnas the columnas
	 */
	public MatrizGenerica(int filas, int columnas) {
		this.filas = filas;
		this.columnas = columnas;
		matriz = (T[][]) new Number[filas][columnas];
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				sb.append(matriz[i][j]).append(" ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	/**
	 * Establece el valor indicado en la posicion elegida
	 *
	 * @param fila the fila
	 * @param columna the columna
	 * @param valor the valor
	 */
	public void setValor(int fila, int columna, T valor) {
		matriz[fila][columna] = valor;
	}

	/**
	 * Gets the matriz.
	 *
	 * @return the matriz
	 */
	public T[][] getMatriz() {
		return matriz.clone();
	}

	/**
	 * Sumar.
	 *
	 * @param otraMatriz the otra matriz
	 * @return the matriz generica
	 */
	public MatrizGenerica<T> sumar(MatrizGenerica<T> otraMatriz) {
		if (this.matriz.length != otraMatriz.matriz.length || this.matriz[0].length != otraMatriz.matriz.length) {
			throw new IllegalArgumentException();
		}
		MatrizGenerica<T> resultado = crearMatriz(filas, columnas);
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				resultado.matriz[i][j] = sumarElementos(matriz[i][j], otraMatriz.matriz[i][j]);
			}
		}
		return resultado;
	}

	/**
	 * Multiplicar.
	 *
	 * @param otraMatriz the otra matriz
	 * @return the matriz generica
	 */
	public MatrizGenerica<T> multiplicar(MatrizGenerica<T> otraMatriz) {
		
		if (otraMatriz.filas != this.columnas)
			throw new IllegalArgumentException();
		
		for(int i = 0; i < otraMatriz.filas; i++) {
			for(int j = 0; j < otraMatriz.columnas; j++) {
				if(otraMatriz.matriz[i][j] == null) {
					throw new IllegalArgumentException();
				}
			}
		}
		
		MatrizGenerica<T> result = this.crearMatriz(this.filas, otraMatriz.columnas);
		for (int i = 0; i < this.filas; i++) {
			for (int j = 0; j < otraMatriz.columnas; j++) {
				for (int k = 0; k < this.columnas; k++) {
					result.matriz[i][j] = this.sumarElementos(
							result.matriz[i][j] == null ? this.ceroElemento() : result.matriz[i][j],
							this.multiplicarElementos(this.matriz[i][k], otraMatriz.matriz[k][j]));
				}
			}
		}
		return result;
	}

	/**
	 * Transponer.
	 *
	 * @return the matriz generica
	 */
	public MatrizGenerica<T> transponer() {
		MatrizGenerica<T> result = this.crearMatriz(this.columnas, this.filas);
		for (int i = 0; i < this.filas; i++) {
			for (int j = 0; j < this.columnas; j++) {
				result.setValor(j, i, matriz[i][j]);
			}
		}
		return result;
	}

	/**
	 * Crear matriz.
	 *
	 * @param i the i
	 * @param j the j
	 * @return the matriz generica
	 */
	protected abstract MatrizGenerica<T> crearMatriz(int i, int j);

	/**
	 * Sumar elementos.
	 *
	 * @param a the a
	 * @param b the b
	 * @return the t
	 */
	protected abstract T sumarElementos(T a, T b);

	/**
	 * Multiplicar elementos.
	 *
	 * @param a the a
	 * @param b the b
	 * @return the t
	 */
	protected abstract T multiplicarElementos(T a, T b);

	/**
	 * Cero elemento.
	 *
	 * @return the t
	 */
	protected abstract T ceroElemento();

}
