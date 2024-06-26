package org.mp.sesion02.mesas;

/**
 * The Class MesaElectoral.
 */
public class MesaElectoral {

	/**  nombre mesa. */
	private String nombreMesa;
	
	/**  presidente. */
	private Ciudadano presidente;
	
	/**  vocal 1. */
	private Ciudadano vocal1;
	
	/**  vocal 2. */
	private Ciudadano vocal2;
	
	/**  electores. */
	private Ciudadano[] electores;

	/**
	 * Instancia una nueva mesa electoral.
	 *
	 * @param nombreMesa the nombre mesa
	 * @param electores the electores
	 */
	public MesaElectoral(String nombreMesa, Ciudadano[] electores) {
		this.setNombreMesa(nombreMesa);
		this.setElectores(electores);
	}

	/**
	 * Gets the nombre mesa.
	 *
	 * @return the nombre mesa
	 */
	public String getNombreMesa() {
		return nombreMesa;
	}

	/**
	 * Sets the nombre mesa.
	 *
	 * @param nombreMesa the new nombre mesa
	 */
	public void setNombreMesa(String nombreMesa) {
		this.nombreMesa = nombreMesa;
	}

	/**
	 * Gets the presidente.
	 *
	 * @return the presidente
	 */
	public Ciudadano getPresidente() {
		return presidente;
	}

	/**
	 * Sets the presidente.
	 *
	 * @param presidente the new presidente
	 */
	public void setPresidente(Ciudadano presidente) {
		this.presidente = presidente;
	}

	/**
	 * Gets the vocal 1.
	 *
	 * @return the vocal 1
	 */
	public Ciudadano getVocal1() {
		return vocal1;
	}

	/**
	 * Sets the vocal 1.
	 *
	 * @param vocal1 the new vocal 1
	 */
	public void setVocal1(Ciudadano vocal1) {
		this.vocal1 = vocal1;
	}

	/**
	 * Gets the vocal 2.
	 *
	 * @return the vocal 2
	 */
	public Ciudadano getVocal2() {
		return vocal2;
	}

	/**
	 * Sets the vocal 2.
	 *
	 * @param vocal2 the new vocal 2
	 */
	public void setVocal2(Ciudadano vocal2) {
		this.vocal2 = vocal2;
	}

	/**
	 * Gets the electores.
	 *
	 * @return the electores
	 */
	public Ciudadano[] getElectores() {
		return electores;
	}

	/**
	 * Sets the electores.
	 *
	 * @param electores the new electores
	 */
	public void setElectores(Ciudadano[] electores) {
		this.electores = electores;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		return "MesaElectoral{nombreMesa='" + this.nombreMesa +
				"', presidente=" + this.presidente +
				", vocal1=" + this.vocal1 +
				", vocal2=" + this.vocal2 + "}";
		}

}
