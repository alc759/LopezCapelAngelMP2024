package org.mp.sesion07.comparator;

// TODO: Auto-generated Javadoc
/**
 * The Class Baraja.
 */
public class Baraja {

	/** nombre baraja. */
	private String nombreBaraja;
	
	/** cartas. */
	private Carta[] cartas;
	
	/**
	 * Instancia baraja.
	 *
	 * @param nombreBaraja the nombre baraja
	 * @param cartas the cartas
	 */
	public Baraja(String nombreBaraja, Carta[] cartas) {
		this.nombreBaraja = nombreBaraja;
		this.cartas = cartas;
	}

	/**
	 * Gets the nombre baraja.
	 *
	 * @return the nombre baraja
	 */
	public String getNombreBaraja() {
		return nombreBaraja;
	}

	/**
	 * Gets the cartas.
	 *
	 * @return the cartas
	 */
	public Carta[] getCartas() {
		return cartas;
	}
	
	/**
	 * Insercion.
	 *
	 * @param cartas the cartas
	 */
	public void insercion(Carta[] cartas) {
		for(int i = 0; i < cartas.length; i++) {
			Carta carta = cartas[i];
			int j = i - 1;
			
			while(j >= 0 && cartas[j].compareTo(carta) > 0) {
				cartas[j + 1] = cartas[j];
				j--;
			}
			
			cartas[j + 1] = carta;
		}
	}
	
	/**
	 * Buscar carta.
	 *
	 * @param carta the carta
	 * @return the object
	 */
	public Object buscarCarta(Carta carta) {
		for(Carta cartaAux : cartas) {
			if(cartaAux.compareTo(carta) == 0) {
				return cartaAux;
			}
		}
		return null;
	}
}
