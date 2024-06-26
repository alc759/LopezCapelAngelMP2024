package org.mp.sesion01.dont;

import java.util.Objects;

/**
 * The Class Votacion.
 */
public class Votacion implements Comparable{
	
	/** partido. */
	private String partido;
	
	/** votos obtenidos. */
	private int votosObtenidos;
	
	/** votos en reparto. */
	private int votosEnReparto;
	
	/** diputados. */
	private int diputados;
	
	/**
	 * Instancia una nueva votacion.
	 *
	 * @param partido nombre partido
	 * @param votosObtenidos numero de votos obtenidos
	 */
	public Votacion(String partido, int votosObtenidos) {
		this.partido = partido;
		this.diputados = 0;
		this.votosObtenidos = votosObtenidos;
		this.votosEnReparto = this.getVotosObtenidos();
	}

	/**
	 * Gets the partido.
	 *
	 * @return the partido
	 */
	public String getPartido() {
		return partido;
	}

	/**
	 * Sets the partido.
	 *
	 * @param partido the new partido
	 */
	public void setPartido(String partido) {
		this.partido = partido;
	}

	/**
	 * Gets the votos obtenidos.
	 *
	 * @return the votos obtenidos
	 */
	public int getVotosObtenidos() {
		return votosObtenidos;
	}

	/**
	 * Sets the votos obtenidos.
	 *
	 * @param votosObtenidos the new votos obtenidos
	 */
	public void setVotosObtenidos(int votosObtenidos) {
		this.votosObtenidos = votosObtenidos;
	}

	/**
	 * Gets the votos en reparto.
	 *
	 * @return the votos en reparto
	 */
	public int getVotosEnReparto() {
		return votosEnReparto;
	}

	/**
	 * Sets the votos en reparto.
	 *
	 * @param votosEnReparto the new votos en reparto
	 */
	public void setVotosEnReparto(int votosEnReparto) {
		this.votosEnReparto = votosEnReparto;
	}

	/**
	 * Gets the diputados.
	 *
	 * @return the diputados
	 */
	public int getDiputados() {
		return diputados;
	}

	/**
	 * Sets the diputados.
	 *
	 * @param diputados the new diputados
	 */
	public void setDiputados(int diputados) {
		this.diputados = diputados;
	}
	
	/**
	 * Compara con el objeto especificado.
	 *
	 * @param o the objeto a comparar
	 * @return the int
	 */
	public int compareTo(Object o) {
		Votacion votacion = (Votacion) o;
		
		if(this.getVotosEnReparto() > votacion.getVotosEnReparto()) {
			return 1;
		}
		else if(this.getVotosEnReparto() < votacion.getVotosEnReparto()) {
			return -1;
		}
		else {
			return 0;
		}
	}
	
	/**
	 * Equals.
	 *
	 * @param o the o
	 * @return true, if successful
	 */
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		if(o == null || getClass() != o.getClass()) {
			return false;
		}
		Votacion votacion = (Votacion) o;
		return this.votosObtenidos == votacion.votosObtenidos
		&& this.votosEnReparto == votacion.votosEnReparto
		&& this.diputados == votacion.diputados
		&& Objects.equals(partido, votacion.partido);
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		return "Votacion [partido = " + this.partido +
				", votosObtenidos = " + this.votosObtenidos +
				", votosEnReparto = " + this.votosEnReparto +
				", diputados = " + this.diputados + "]";
	}
	
}
