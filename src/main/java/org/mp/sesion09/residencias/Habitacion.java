package org.mp.sesion09.residencias;

import java.io.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Habitacion.
 */
public class Habitacion implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** numero. */
	private String numero;

	/**
	 * Instancia una nueva habitacion.
	 *
	 * @param numero the numero
	 */
	public Habitacion(String numero) {
		this.numero = numero;
	}

	/**
	 * Gets the numero.
	 *
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * Sets the numero.
	 *
	 * @param numero the new numero
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

}
