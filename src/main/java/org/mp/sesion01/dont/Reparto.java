package org.mp.sesion01.dont;

import java.util.Arrays;

/**
 * The Class Reparto.
 */
public class Reparto {
	
	/**
	 * Reparto mayoria.
	 *
	 * @param votaciones Array de votaciones
	 * @param numDiputados numero de diputados
	 */
	public static void repartoMayoria(Votacion[] votaciones, int numDiputados) {
		
		Arrays.sort(votaciones);
		Votacion votacion = votaciones[votaciones.length -1];
		votacion.setDiputados(numDiputados);
		
	}
	
	/**
	 * Reparto dont.
	 *
	 * @param votaciones Array de votaciones
	 * @param numDiputados numero de diputados
	 */
	public static void repartoDont(Votacion[] votaciones, int numDiputados) {
			
			for(int i = 0; i < numDiputados; i++) {
				ordenarcionInsercion(votaciones);
				
				Votacion ultimaVotacion = votaciones[votaciones.length - 1];
				ultimaVotacion.setDiputados(ultimaVotacion.getDiputados() + 1);
				
				ultimaVotacion.setVotosEnReparto(ultimaVotacion.getVotosObtenidos() / (ultimaVotacion.getDiputados() + 1));
			}
			
		}
	
	/**
	 * Ordenarcion insercion.
	 *
	 * @param votaciones the votaciones
	 */
	public static void ordenarcionInsercion(Votacion[] votaciones) {
		
		for(int i = 0; i < votaciones.length; i++) {
			Votacion votacionActual = votaciones[i];
			int j = i - 1;
			
			while(j >= 0 && votaciones[j].compareTo(votacionActual) > 0) {
				
				votaciones[j + 1] = votaciones[j];
				j--;
			
			}
			
			votaciones[j + 1] = votacionActual;
		}
		
	}
	
}
