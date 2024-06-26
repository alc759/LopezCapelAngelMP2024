package org.mp.sesion01.dont;

/**
 * The Class Provincia.
 */
public class Provincia {
	
	/** Nombre provincia */
	private String nombre;
	
	/** Numero de diputados */
	private int numDiputados;
	
	/**
	 * Crea una provincia.
	 *
	 * @param nombre nombre de provincia
	 * @param numDiputados num diputados
	 */
	public Provincia(String nombre, int numDiputados) {
		this.nombre = nombre;
		this.numDiputados = numDiputados;
	}

	/**
	 * Devuelve el nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre.
	 *
	 * @param nombre the new nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Devuelve num diputados.
	 *
	 * @return the num diputados
	 */
	public int getNumDiputados() {
		return numDiputados;
	}

	/**
	 * Establece num diputados.
	 *
	 * @param numDiputados the new num diputados
	 */
	public void setNumDiputados(int numDiputados) {
		this.numDiputados = numDiputados;
	}
	
	/**
	 * Equals.
	 *
	 * @param o Objeto a comparar
	 * @return true, if successful
	 */
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		if(o == null || getClass() != o.getClass()) {
			return false;
		}
		
		Provincia provinciaAux = (Provincia) o;
		return nombre.equals(provinciaAux.nombre) && this.numDiputados == provinciaAux.numDiputados;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		return "Provincia [nombre=" + this.nombre + ", numDiputados=" + this.numDiputados + "]";
	}
}
