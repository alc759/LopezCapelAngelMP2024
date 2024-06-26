package org.mp.sesion07.comparator;

import java.util.Comparator;

// TODO: Auto-generated Javadoc
/**
 * The Class NumeroPaloComparator.
 */
public class NumeroPaloComparator implements Comparator<Carta> {

	/**
	 * Compara dos cartas por el palo que tengan.
	 *
	 * @param carta1 the carta 1
	 * @param carta2 the carta 2
	 * @return the int
	 */
	public int compare(Carta carta1, Carta carta2) {
		int comparacionNumero = Integer.compare(carta1.getNumero(), carta2.getNumero());
		if (comparacionNumero == 0) {
			String[] ordenPalo = { "O", "C", "E", "B" };
			int indicePaloCarta1 = getIndex(carta1.getPalo(), ordenPalo);
			int indicePaloCarta2 = getIndex(carta2.getPalo(), ordenPalo);
			return Integer.compare(indicePaloCarta1, indicePaloCarta2);
		}

		return comparacionNumero;
	}

	/**
	 * Gets the index.
	 *
	 * @param palo the palo
	 * @param ordenPalo the orden palo
	 * @return the index
	 */
	private int getIndex(String palo, String[] ordenPalo) {
		for (int i = 0; i < ordenPalo.length; i++) {
			if (palo.equals(ordenPalo[i])) {
				return i;
			}
		}
		return ordenPalo.length;
	}

}
