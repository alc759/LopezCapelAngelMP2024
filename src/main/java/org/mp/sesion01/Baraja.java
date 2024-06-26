package org.mp.sesion01;

// TODO: Auto-generated Javadoc
/**
 * Clase Baraja.
 */
public class Baraja {

	/** Nombre baraja. */
	private String nombreBaraja;
	
	/** Array con las cartas. */
	private Carta[] cartas;
	
	/**
	 * Crea una baraja
	 *
	 * @param nombreBaraja El nombre de la baraja
	 * @param cartas El array con cartas
	 */
	public Baraja(String nombreBaraja, Carta[] cartas) {
		this.nombreBaraja = nombreBaraja;
		this.cartas = cartas;
	}

	/**
	 * Devuelve nombre baraja.
	 *
	 * @return the nombre baraja
	 */
	public String getNombreBaraja() {
		return nombreBaraja;
	}

	/**
	 * Devuelve array cartas.
	 *
	 * @return the cartas
	 */
	public Carta[] getCartas() {
		return cartas;
	}
	
	/**
	 * Insercion.
	 *
	 * @param Array de cartas
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
	 * @param carta carta a buscar
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
