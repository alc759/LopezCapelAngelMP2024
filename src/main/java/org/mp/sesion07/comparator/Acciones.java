package org.mp.sesion07.comparator;

import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class Acciones.
 */
public class Acciones {

	/** acciones. */
	private List<Accion> acciones;
	
	/**
	 * Instancia acciones.
	 */
	public Acciones() {
		super();
		acciones = new ArrayList<Accion>();
	}
	
	/**
	 * Anade una accion.
	 *
	 * @param accion the accion
	 */
	public void add(Accion accion) {
		acciones.add(accion);
	}

	/**
	 * Gets the acciones.
	 *
	 * @return the acciones
	 */
	public List<Accion> getAcciones() {

		return acciones;
	}
	
}
