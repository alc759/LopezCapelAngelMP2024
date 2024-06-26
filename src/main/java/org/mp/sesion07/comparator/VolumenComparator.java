package org.mp.sesion07.comparator;

import java.util.Comparator;

// TODO: Auto-generated Javadoc
/**
 * The Class VolumenComparator.
 */
public class VolumenComparator implements Comparator<Accion> {

	/**
	 * Compara dos acciones segun el valor de sus volumenes.
	 *
	 * @param accion1 the accion 1
	 * @param accion2 the accion 2
	 * @return the int
	 */
	public int compare(Accion accion1, Accion accion2) {
		if (accion1 == accion2) {
			return 0;
		}
		if (accion1.getVolumen() == accion2.getVolumen()) {
			return 0;
		} else {
			if (accion1.getVolumen() < accion2.getVolumen()) {
				return -1;
			} else {
				return 1;
			}
		}
	}

}
