package org.mp.sesion07.busqueda;
import java.util.Arrays;
import java.util.Random;

/**
 * The Class Busqueda.
 *
 * @param <T> the generic type
 */
public class Busqueda<T extends Comparable<T>> {
    
    /** num elementos. */
    private int numElementos;
    
    /** datos. */
    private T[] datos;
    
    /** num buscado. */
    private T numBuscado;

    /**
     * instancia una nueva busqueda.
     *
     * @param numElementos the num elementos
     */
    public Busqueda(int numElementos) {
        this.numElementos = numElementos;
        datos = (T[]) new Comparable[numElementos];
        generarDatosAleatorios();
    }

    /**
     * Generar datos aleatorios.
     */
    private void generarDatosAleatorios() {
        Random random = new Random();
        for (int i = 0; i < numElementos; i++) {
            datos[i] = (T) Integer.valueOf(random.nextInt(100)); // Genera números aleatorios entre 0 y 99
        }
        Arrays.sort(datos);
        numBuscado = datos[random.nextInt(numElementos)]; // Escoge un elemento aleatorio del arreglo para buscar
    }

    /**
     * Gets the num elementos.
     *
     * @return the num elementos
     */
    public int getNumElementos() {
        return numElementos;
    }

    /**
     * Gets the datos.
     *
     * @return the datos
     */
    public T[] getDatos() {
        return datos;
    }

    /**
     * Sets the datos.
     *
     * @param datosModelo the new datos
     */
    public void setDatos(T[] datosModelo) {
        this.datos = datosModelo;
    }

    /**
     * Gets the num buscado.
     *
     * @return the num buscado
     */
    public T getNumBuscado() {
        return numBuscado;
    }

    /**
     * Sets the num buscado.
     *
     * @param buscar the new num buscado
     */
    public void setNumBuscado(T buscar) {
        numBuscado = buscar;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "Problema búsqueda con " + numElementos + " elementos\n" +
               "Elemento buscado: " + numBuscado + "\n" +
               Arrays.toString(datos);
    }
}