package org.mp.sesion02.mesas;

import java.time.LocalDate;
import java.util.Objects;

/**
 * The Class Ciudadano.
 */
public class Ciudadano {

	/**  apellido 1. */
	private String apellido1;
	
	/**  apellido 2. */
	private String apellido2;
	
	/**  nombre. */
	private String nombre;
	
	/**  fecha nacimiento. */
	private LocalDate fechaNacimiento;
	
	/**  nivel estudios. */
	private String nivelEstudios;
	
	/**  elegido. */
	private boolean elegido;

	/**
	 * Instancia un nuevo ciudadano.
	 *
	 * @param apellido1 the apellido 1
	 * @param apellido2 the apellido 2
	 * @param nombre the nombre
	 * @param fechaNacimiento the fecha nacimiento
	 * @param nivelEstudios the nivel estudios
	 */
	public Ciudadano(String apellido1, String apellido2, String nombre, LocalDate fechaNacimiento,
			String nivelEstudios) {
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.nivelEstudios = nivelEstudios;
		this.setElegido(false);
	}

	/**
	 * Es elegido.
	 *
	 * @return true, if successful
	 */
	public boolean esElegido() {
		return elegido;
	}

	/**
	 * Sets the elegido.
	 *
	 * @param elegido the new elegido
	 */
	public void setElegido(boolean elegido) {
		this.elegido = elegido;
	}

	/**
	 * Gets the apellido 1.
	 *
	 * @return the apellido 1
	 */
	public String getApellido1() {
		return apellido1;
	}

	/**
	 * Sets the apellido 1.
	 *
	 * @param apellido1 the new apellido 1
	 */
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	/**
	 * Gets the apellido 2.
	 *
	 * @return the apellido 2
	 */
	public String getApellido2() {
		return apellido2;
	}

	/**
	 * Sets the apellido 2.
	 *
	 * @param apellido2 the new apellido 2
	 */
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
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
	 * Gets the fecha nacimiento.
	 *
	 * @return the fecha nacimiento
	 */
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * Sets the fecha nacimiento.
	 *
	 * @param fechaNacimiento the new fecha nacimiento
	 */
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * Gets the nivel estudios.
	 *
	 * @return the nivel estudios
	 */
	public String getNivelEstudios() {
		return nivelEstudios;
	}

	/**
	 * Sets the nivel estudios.
	 *
	 * @param nivelEstudios the new nivel estudios
	 */
	public void setNivelEstudios(String nivelEstudios) {
		this.nivelEstudios = nivelEstudios;
	}

	/**
	 * Compara con el objeto especificado
	 *
	 * @param ciudadanoAComparar
	 * @return the int
	 */
	public int compareTo(Ciudadano ciudadanoAComparar) {
		return (this.apellido1 + this.apellido2 + this.nombre)
				.compareTo(ciudadanoAComparar.apellido1 + ciudadanoAComparar.apellido2 + ciudadanoAComparar.nombre);
	}

	/**
	 * Gets the edad.
	 *
	 * @return the edad
	 */
	public int getEdad() {
		return LocalDate.now().getYear() - this.fechaNacimiento.getYear();
	}

	/**
	 * Genera el Hashcode.
	 *
	 * @return the int
	 */
	public int hashCode() {
		return Objects.hash(apellido1, apellido2, fechaNacimiento, nivelEstudios, nombre);
	}

	/**
	 * Equals.
	 *
	 * @param elsapato the elsapato
	 * @return true, if successful
	 */
	public boolean equals(Object elsapato) {
		if (this == elsapato) {
			return true;
		}
		if (elsapato == null) {
			return false;
		}
		if (getClass() != elsapato.getClass()) {
			return false;
		}
		Ciudadano other = (Ciudadano) elsapato;
		return Objects.equals(apellido1, other.apellido1) && Objects.equals(apellido2, other.apellido2)
				&& Objects.equals(fechaNacimiento, other.fechaNacimiento)
				&& Objects.equals(nivelEstudios, other.nivelEstudios) && Objects.equals(nombre, other.nombre);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		return "Ciudadano [apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", nombre=" + nombre
				+ ", fechaNacimiento=" + fechaNacimiento + ",nivelEstudios=" + nivelEstudios + "]";
	}

}
