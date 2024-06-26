package org.mp.sesion09.residencias;

import java.io.*;
import java.util.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Residente.
 */
public class Residente implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** dni. */
	private String dni;
	
	/** nombre. */
	private String nombre;
	
	/** sexo. */
	private char sexo;
	
	/** fecha nacimiento. */
	private Date fechaNacimiento;

	/**
	 * Crea un nuevo residente.
	 *
	 * @param nombre the nombre
	 * @param dni the dni
	 * @param sexo the sexo
	 * @param fechaNacimiento the fecha nacimiento
	 */
	public Residente(String nombre, String dni, char sexo, Date fechaNacimiento) {
		this.nombre = nombre;
		this.dni = dni;
		this.sexo = sexo;
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * Gets the edad.
	 *
	 * @param date the date
	 * @return the edad
	 */
	public int getEdad(Date date) {
		Date fechaNacimiento = this.fechaNacimiento;
		long tiempoNacimiento = fechaNacimiento.getTime();
		long tiempoActual = date.getTime();
		long diferencia = tiempoActual - tiempoNacimiento;
		long millisPorAnio = 1000L * 60 * 60 * 24 * 365;
		int edad = (int) (diferencia / millisPorAnio);
		return edad;
	}

	/**
	 * Gets the dni.
	 *
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Sets the dni.
	 *
	 * @param dni the new dni
	 */
	public void setDni(String dni) {
		this.dni = dni;
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
	 * Gets the sexo.
	 *
	 * @return the sexo
	 */
	public char getSexo() {
		return sexo;
	}

	/**
	 * Sets the sexo.
	 *
	 * @param sexo the new sexo
	 */
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	/**
	 * Gets the fecha nacimiento.
	 *
	 * @return the fecha nacimiento
	 */
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * Sets the fecha nacimiento.
	 *
	 * @param fechaNacimiento the new fecha nacimiento
	 */
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	

}
