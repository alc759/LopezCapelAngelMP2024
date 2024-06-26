package org.mp.sesion03.matriz;

import java.util.Arrays;

/**
 * The Class MatrizEnteros.
 */
// Clase MatrizEnteros
public class MatrizEnteros {
    
    /**  matriz. */
    private int[][] matriz;

    /**
     * Instancia una nueva matriz enteros.
     *
     * @param filas the filas
     * @param columnas the columnas
     */
    public MatrizEnteros(int filas, int columnas) {
        matriz = new int[filas][columnas];
    }

    /**
     * Realiza una suma con otra matriz.
     *
     * @param otraMatriz the otra matriz
     * @return the matriz enteros
     */
    public MatrizEnteros sumar(MatrizEnteros otraMatriz) {
        if (this.matriz.length != otraMatriz.matriz.length || this.matriz[0].length != otraMatriz.matriz[0].length) {
            throw new IllegalArgumentException("Las matrices deben tener el mismo tamaño para poder sumarlas.");
        }

        int filas = this.matriz.length;
        int columnas = this.matriz[0].length;
        MatrizEnteros resultado = new MatrizEnteros(filas, columnas);

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado.matriz[i][j] = this.matriz[i][j] + otraMatriz.matriz[i][j];
            }
        }

        return resultado;
    }

    /**
     * Realiza una multiplicacion con otra matriz.
     *
     * @param otraMatriz the otra matriz
     * @return the matriz enteros
     */
    public MatrizEnteros multiplicar(MatrizEnteros otraMatriz) {
        if (this.matriz[0].length != otraMatriz.matriz.length) {
            throw new IllegalArgumentException("El número de columnas de la primera matriz debe ser igual al número de filas de la segunda matriz para poder multiplicarlas.");
        }

        int filasA = this.matriz.length;
        int columnasA = this.matriz[0].length;
        int columnasB = otraMatriz.matriz[0].length;

        MatrizEnteros resultado = new MatrizEnteros(filasA, columnasB);

        for (int i = 0; i < filasA; i++) {
            for (int j = 0; j < columnasB; j++) {
                for (int k = 0; k < columnasA; k++) {
                    resultado.matriz[i][j] += this.matriz[i][k] * otraMatriz.matriz[k][j];
                }
            }
        }

        return resultado;
    }

    /**
     * Transpone la matriz.
     *
     * @return the matriz enteros
     */
    public MatrizEnteros transponer() {
        int filas = this.matriz.length;
        int columnas = this.matriz[0].length;
        MatrizEnteros resultado = new MatrizEnteros(columnas, filas);

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado.matriz[j][i] = this.matriz[i][j];
            }
        }

        return resultado;
    }

    /**
     * Sets the valor.
     *
     * @param fila the fila
     * @param columna the columna
     * @param valor the valor
     */
    public void setValor(int fila, int columna, int valor) {
        matriz[fila][columna] = valor;
    }
    
    /**
     * Gets the matriz.
     *
     * @return the matriz
     */
    public int[][] getMatriz() {
        return matriz.clone();
    }
    
    
    
    /**
     * To string.
     *
     * @return the string
     */
    @Override
	public String toString() {
    	String salida = "";
    	for (int[] fila : this.matriz) {
            for (int elemento : fila) {
               salida = salida + elemento + "\t";
            }
            salida = salida + "\n";
        }
    	return salida;
	}

	/**
	 * Imprimir.
	 */
	public void imprimir() {
        for (int[] fila : this.matriz) {
            for (int elemento : fila) {
                System.out.print(elemento + " ");
            }
            System.out.println();
        }
    }
}