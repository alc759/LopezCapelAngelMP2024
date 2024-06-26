package org.mp.sesion09.imagen;

// TODO: Auto-generated Javadoc
/**
 * The Class Banda.
 *
 * @param <T> the generic type
 */
public class Banda<T extends Number> {

	/** nombre banda. */
	private String nombreBanda;
	
	/** datos. */
	private T[][] datos;

	/**
	 * Instancia una nueva banda.
	 *
	 * @param nombre the nombre
	 * @param x the x
	 * @param y the y
	 */
	public Banda(String nombre, int x, int y) {
		this.nombreBanda = nombre;
		this.datos = (T[][]) new Number[x][y];
	}

	/**
	 * Instancia una nueva banda.
	 *
	 * @param nombreBanda the nombre banda
	 * @param datos the datos
	 */
	public Banda(String nombreBanda, T[][] datos) {
		this.nombreBanda = nombreBanda;
		this.datos = datos;
	}

	/**
	 * Gets the nombre banda.
	 *
	 * @return the nombre banda
	 */
	public String getNombreBanda() {
		return nombreBanda;
	}

	/**
	 * Sets the nombre banda.
	 *
	 * @param nombreBanda the new nombre banda
	 */
	public void setNombreBanda(String nombreBanda) {
		this.nombreBanda = nombreBanda;
	}

	/**
	 * Gets the datos.
	 *
	 * @return the datos
	 */
	public T[][] getDatos() {
		return datos;
	}

	/**
	 * Sets the datos.
	 *
	 * @param datos the new datos
	 */
	public void setDatos(T[][] datos) {
		this.datos = datos;
	}

	/**
	 * Gets the dato XY.
	 *
	 * @param x the x
	 * @param y the y
	 * @return the dato XY
	 */
	public T getDatoXY(int x, int y) {
		return datos[x][y];
	}

	/**
	 * Sets the dato XY.
	 *
	 * @param dato the dato
	 * @param x the x
	 * @param y the y
	 */
	public void setDatoXY(T dato, int x, int y) {
		datos[x][y] = dato;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		return "Banda{" + "nombreBanda='" + nombreBanda + '\'' + ", datos=" + datos + '}';
	}

}
