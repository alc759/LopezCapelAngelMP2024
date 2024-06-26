package org.mp.sesion01.dont;

/**
 * The Class EleccionesApp.
 */
public class EleccionesApp {
	
	/**
	 * Parsear partidos votos.
	 *
	 * @param cadenaPartidosVotos cadena partidos votos
	 * @return the votacion[]
	 */
	public static Votacion[] parsearPartidosVotos(String cadenaPartidosVotos) {
		
		String[] parejas = cadenaPartidosVotos.split(" ");
		
		Votacion[] votaciones = new Votacion[parejas.length];
		
		for(int i = 0; i < parejas.length; i++) {
			String[] pareja = parejas[i].split(",");
			String nombrePartido = pareja[0];
			int votacionesAux = Integer.parseInt(pareja[1]);
			
			votaciones[i] = new Votacion(nombrePartido, votacionesAux);
		}
		
		return votaciones;
		
	}
	
	/**
	 * Parsear datos elecciones.
	 *
	 * @param datosElecciones datos elecciones
	 * @return the provincia
	 */
	public static Provincia parsearDatosElecciones(String datosElecciones) {
		
		String[] datos = datosElecciones.split(",");
		String nombreProvincia = datos[0];
		int numDiputados = Integer.parseInt(datos[1]);
		
		return new Provincia(nombreProvincia, numDiputados);
		
	}
	
	/**
	 * Mostrar resultados.
	 */
	public static void mostrarResultados() {
		return;
	}

}
