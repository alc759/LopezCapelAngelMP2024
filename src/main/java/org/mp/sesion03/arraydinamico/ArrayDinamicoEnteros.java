package org.mp.sesion03.arraydinamico;
import java.util.Arrays;

// TODO: Auto-generated Javadoc
/**
 * Representa una lista de valores enteros que puede crecer y disminuir.
 */
public class ArrayDinamicoEnteros {
    
    /** The elementos. */
    private int[] elementos;  
    
    /** The num elementos. */
    private int numElementos;

    
    /**
     * Instantiates a new array dinamico enteros.
     */
    public ArrayDinamicoEnteros() {
		super();
		elementos = new int[10];
		numElementos=0;
	}
    
	/**
	 * Devuelve el elemento en un índice dado en el array. 
	 * Lanza ArrayIndexOutOfBoundsException si el índice no es válido.
	 *
	 * @param indice the indice
	 * @return the int
	 */
    public int obtener(int indice) {
        if (indice < 0 || indice >= numElementos)
            throw new ArrayIndexOutOfBoundsException("Indice no válido, " + indice);
        return elementos[indice];
    }
    
    /**
     * Establece el valor del elemento del array en un índice dado. 
     * Lanza ArrayIndexOutOfBoundsException si el índice no es válido.
     *
     * @param indice the indice
     * @param elemento the elemento
     */
    public void establecer(int indice, int elemento) {
        if (indice < 0 || indice >= numElementos)
            throw new ArrayIndexOutOfBoundsException("Indice no válido, " + indice);
        elementos[indice] = elemento;
    }
    
    /**
     * Devuelve la cantidad de elementos actualmente en el array.
     *
     * @return the int
     */
    public int capacidad() {
        return numElementos;
    }
    
    /**
     * Agrega un nuevo elemento al final del array. El tamaño aumenta en uno.
     *
     * @param elemento the elemento
     */
    public void agregar(int elemento) {
    	
    	if (numElementos == elementos.length) {
    	    int[] nuevosElementos = new int[2 * elementos.length];
    	    for (int i = 0; i < elementos.length; i++) {
    	        nuevosElementos[i] = elementos[i];
    	    }
    	    elementos = nuevosElementos;
    	}       
        elementos[numElementos] = elemento;
        numElementos++;
    }
    
    /**
     * Elimina el elemento en un índice dado en el array. El tamaño del array
     * disminuye en uno. Los elementos siguientes al elemento eliminado se mueven
     * una posición hacia abajo en el array.
     * Lanza ArrayIndexOutOfBoundsException si el índice no es válido.
     *
     * @param indice the indice
     */
    public void eliminar(int indice) {
        if (indice < 0 || indice >= numElementos)
            throw new ArrayIndexOutOfBoundsException("Indice no válido, " + indice);
        for (int j = indice + 1; j < numElementos; j++)
            elementos[j - 1] = elementos[j];
        numElementos--;
    }
    
}
