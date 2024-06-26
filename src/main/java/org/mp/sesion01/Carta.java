package org.mp.sesion01;

/**
 * The Class Carta.
 */
public class Carta {

	/** palo. */
	private String palo;
	
	/** numero. */
	private int numero;
	
	/**
	 * Crea una carta
	 *
	 * @param palo el palo de la carta
	 * @param numero el numero de la carta
	 */
	public Carta(String palo, int numero) {
		this.palo = palo;
		this.numero = numero;
	}
	
	/**
	 * Devuelve el palo.
	 *
	 * @return palo de la carta
	 */
	public String getPalo() {
		return palo;
	}

	/**
	 * Devuelve el numero.
	 *
	 * @return numero de la carta
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * Compara una carta con otra
	 *
	 * @param carta Carta que comparar
	 * @return resultado de comparacion
	 */
	public int compareTo(Carta carta) {
		int comparacion = -this.palo.compareTo(carta.palo);
		if(comparacion == 0) {
			return this.numero - carta.numero;
		}
		else {
			return comparacion;
		}
	}
	
	/**
	 * ToString.
	 *
	 * @return ToString
	 */
	public String toString() {
		return "Carta [palo=" + this.palo + ", número=" + this.numero + "]";
	}
	
	/**
	 * Equals.
	 *
	 * @param obj Objeto a comparar
	 * @return true, if successful
	 */
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		
		if(obj == null || getClass() != obj.getClass()) {
			return false;
		}
		
		Carta carta = (Carta) obj;
		return palo.equals(carta.palo) && numero == carta.numero;
	}
}
