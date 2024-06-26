package org.mp.sesion07.comparator;

// TODO: Auto-generated Javadoc
/**
 * The Class Carta.
 */
public class Carta implements Comparable<Carta> {

	/** palo. */
	private String palo;

	/** numero. */
	private int numero;

	/**
	 * Instancia carta.
	 *
	 * @param palo the palo
	 * @param numero the numero
	 */
	public Carta(String palo, int numero) {
		this.palo = palo;
		this.numero = numero;
	}

	/**
	 * Gets the palo.
	 *
	 * @return the palo
	 */
	public String getPalo() {
		return palo;
	}

	/**
	 * Gets the numero.
	 *
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * Compare to.
	 *
	 * @param carta the carta
	 * @return the int
	 */
	public int compareTo(Carta carta) {
		int comparacion = Integer.compare(this.numero, carta.numero);
		if (comparacion == 0) {
			String[] ordenPalo = { "O", "C", "E", "B" };
			int indicePaloCarta1 = getIndex(this.palo, ordenPalo);
			int indicePaloCarta2 = getIndex(carta.palo, ordenPalo);
			return Integer.compare(indicePaloCarta1, indicePaloCarta2);
		}
		return comparacion;
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

	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		return "Carta [palo=" + this.palo + ", número=" + this.numero + "]";
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		Carta carta = (Carta) obj;
		return palo.equals(carta.palo) && numero == carta.numero;
	}
}
