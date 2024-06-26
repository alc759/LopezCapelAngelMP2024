package org.mp.sesion07.comparator;

// TODO: Auto-generated Javadoc
/**
 * The Class Accion.
 */
public class Accion implements Comparable<Accion> {

	/** nombre. */
	private String nombre;
	
	/** volumen. */
	private long volumen;

	/**
	 * Instancia una nueva accion.
	 *
	 * @param nombre the nombre
	 * @param volumen the volumen
	 */
	public Accion(String nombre, long volumen) {
		super();
		this.nombre = nombre;
		this.volumen = volumen;
	}

	/**
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Sets the nombre.
	 *
	 * @param nombre the new nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Gets the volumen.
	 *
	 * @return the volumen
	 */
	public long getVolumen() {
		return volumen;
	}

	/**
	 * Sets the volumen.
	 *
	 * @param volumen the new volumen
	 */
	public void setVolumen(long volumen) {
		this.volumen = volumen;
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Accion other = (Accion) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (volumen != other.volumen)
			return false;
		return true;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Accion [nombre=" + nombre + ", volumen=" + volumen + "]";
	}

	/**
	 * Compare to.
	 *
	 * @param accion the accion
	 * @return the int
	 */
	@Override
	public int compareTo(Accion accion) {
		if (this == accion) {
			return 0;
		}
		if (this.volumen == accion.getVolumen()) {
			return 0;
		} else {
			if (this.volumen < accion.getVolumen()) {
				return -1;
			} else {
				return 1;
			}
		}
	}

}
