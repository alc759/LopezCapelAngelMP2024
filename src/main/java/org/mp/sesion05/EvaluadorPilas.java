package org.mp.sesion05;

import java.util.Random;

import org.mp.sesion05.pilas.ArrayStack;
import org.mp.sesion05.pilas.LinkedListStack;
import org.mp.sesion05.pilas.NodeStack;
import org.mp.sesion05.pilas.Stack;

/**
 * The Class EvaluadorPilas.
 */
public class EvaluadorPilas {

	/** tamano de las pilas. */
	private static final int[] pilas = { 10000, 20000, 30000, 40000, 50000 };
	
	/** numero de ops. */
	private static final int ops = 100;

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		System.out.println("Comienza el evaluador\n\n");

		System.out.println("ArrayStack:");

		imprimirCabecera();
		for (int tamanio : pilas) {
			double[] tiemposPromedioPilas = realizarOperaciones(new ArrayStack<>(), tamanio);
			imprimirResultados(tamanio, tiemposPromedioPilas);
		}

		System.out.println("\nLinkedListStack:");

		imprimirCabecera();
		for (int tamanio : pilas) {
			double[] tiemposPromedioPilas = realizarOperaciones(new LinkedListStack<>(), tamanio);
			imprimirResultados(tamanio, tiemposPromedioPilas);
		}

		System.out.println("\nNodeLinkStack:");

		for (int tamanio : pilas) {
			double[] tiemposPromedioPilas = realizarOperaciones(new NodeStack<>(), tamanio);
			imprimirResultados(tamanio, tiemposPromedioPilas);
		}
	}

	/**
	 * Imprimir cabecera.
	 */
	private static void imprimirCabecera() {
		System.out.println("Tamaño de operaciones\t\tTiempo Push (ns)\t\tTiempo Pop (ns)");
	}

	/**
	 * Realizar operaciones.
	 *
	 * @param <E> the element type
	 * @param pila the pila
	 * @param tamanio the tamanio
	 * @return the double[]
	 */
	private static <E> double[] realizarOperaciones(Stack<E> pila, int tamanio) {
		long[] tiempos = new long[2];
		Random random = new Random();
		for (int i = 0; i < ops; i++) {
			tiempos[0] += pushOperacion(pila, random);
			tiempos[1] += popOperacion(pila);
		}
		double[] tiemposDouble = new double[2];
		tiemposDouble[0] = (double) tiempos[0] / ops;
		tiemposDouble[1] = (double) tiempos[1] / ops;
		return tiemposDouble;
	}

	/**
	 * Push operacion.
	 *
	 * @param <E> the element type
	 * @param pila the pila
	 * @param random the random
	 * @return the double
	 */
	private static <E> double pushOperacion(Stack<E> pila, Random random) {
		long tiempoInicio = System.nanoTime();
		if (pila instanceof ArrayStack) {
			((ArrayStack<Integer>) pila).push(random.nextInt());
		} else if (pila instanceof LinkedListStack) {
			((LinkedListStack<Double>) pila).push(random.nextDouble());
		} else if (pila instanceof NodeStack) {
			((NodeStack<String>) pila).push(Integer.toString(random.nextInt()));
		}
		return (double) (System.nanoTime() - tiempoInicio);
	}

	/**
	 * Pop operacion.
	 *
	 * @param pila the pila
	 * @return the double
	 */
	private static double popOperacion(Stack<?> pila) {
		double tiempoInicio = System.nanoTime();
		pila.pop();
		return System.nanoTime() - tiempoInicio;
	}

	/**
	 * Imprimir resultados.
	 *
	 * @param tamanio the tamanio
	 * @param tiemposPromedioPilas the tiempos promedio pilas
	 */
	private static void imprimirResultados(int tamanio, double[] tiemposPromedioPilas) {
		System.out.printf("%-22d\t\t%,15.0f\t\t%,15.0f%n", tamanio, tiemposPromedioPilas[0], tiemposPromedioPilas[1]);
	}

}
