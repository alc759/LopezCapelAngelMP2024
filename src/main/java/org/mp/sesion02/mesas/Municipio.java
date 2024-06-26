package org.mp.sesion02.mesas;

import java.util.Arrays;

/**
 * The Class Municipio.
 */
public class Municipio {

	/**  nombre municipio. */
	private String nombreMunicipio;
	
	/**  nombre provincia. */
	private String nombreProvincia;
	
	/**  mesas electorales. */
	private MesaElectoral[] mesasElectorales;

	/**
	 * Instancia un nuevo municipio.
	 *
	 * @param nombreMunicipio the nombre municipio
	 * @param nombreProvincia the nombre provincia
	 */
	public Municipio(String nombreMunicipio, String nombreProvincia) {
		this.setNombreMunicipio(nombreMunicipio);
		this.setNombreProvincia(nombreProvincia);
	}

	/**
	 * Gets the nombre municipio.
	 *
	 * @return the nombre municipio
	 */
	public String getNombreMunicipio() {
		return nombreMunicipio;
	}

	/**
	 * Sets the nombre municipio.
	 *
	 * @param nombreMunicipio the new nombre municipio
	 */
	public void setNombreMunicipio(String nombreMunicipio) {
		this.nombreMunicipio = nombreMunicipio;
	}

	/**
	 * Gets the nombre provincia.
	 *
	 * @return the nombre provincia
	 */
	public String getNombreProvincia() {
		return nombreProvincia;
	}

	/**
	 * Sets the nombre provincia.
	 *
	 * @param nombreProvincia the new nombre provincia
	 */
	public void setNombreProvincia(String nombreProvincia) {
		this.nombreProvincia = nombreProvincia;
	}

	/**
	 * Gets the mesas electorales.
	 *
	 * @return the mesas electorales
	 */
	public MesaElectoral[] getMesasElectorales() {
		return mesasElectorales;
	}

	/**
	 * Sets the mesas electorales.
	 *
	 * @param mesasElectorales the new mesas electorales
	 */
	public void setMesasElectorales(MesaElectoral[] mesasElectorales) {
		this.mesasElectorales = mesasElectorales;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Municipio{nombreMunicipio='" + nombreMunicipio +
				"'nombreProvincia='" + nombreProvincia +
				"', mesasElectorales=" + Arrays.toString(mesasElectorales) + "}";
	}
	
	

}
