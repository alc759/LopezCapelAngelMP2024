package org.mp.sesion09.residencias;

import java.io.*;
import java.util.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Reserva.
 */
public class Reserva implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The numero reserva. */
	private int numeroReserva;
	
	/** The residente. */
	private Residente residente;
	
	/** The habitacion. */
	private Habitacion habitacion;
	
	/** The fecha inicio. */
	private Date fechaInicio;
	
	/** The fecha fin. */
	private Date fechaFin;
	
	/** The ultimo numero. */
	private static int ultimoNumero = 0;

	/**
	 * Instancia nueva reserva.
	 *
	 * @param residente the residente
	 * @param habitacion the habitacion
	 * @param fechaInicio the fecha inicio
	 * @param fechaFin the fecha fin
	 */
	public Reserva(Residente residente, Habitacion habitacion, Date fechaInicio, Date fechaFin) {
		this.numeroReserva = ++ultimoNumero;
		this.residente = residente;
		this.habitacion = habitacion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}

	/**
	 * Gets the numero reserva.
	 *
	 * @return the numero reserva
	 */
	public int getNumeroReserva() {
		return numeroReserva;
	}

	/**
	 * Sets the numero reserva.
	 *
	 * @param numeroReserva the new numero reserva
	 */
	public void setNumeroReserva(int numeroReserva) {
		this.numeroReserva = numeroReserva;
	}

	/**
	 * Gets the residente.
	 *
	 * @return the residente
	 */
	public Residente getResidente() {
		return residente;
	}

	/**
	 * Sets the residente.
	 *
	 * @param residente the new residente
	 */
	public void setResidente(Residente residente) {
		this.residente = residente;
	}

	/**
	 * Gets the habitacion.
	 *
	 * @return the habitacion
	 */
	public Habitacion getHabitacion() {
		return habitacion;
	}

	/**
	 * Sets the habitacion.
	 *
	 * @param habitacion the new habitacion
	 */
	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	/**
	 * Gets the fecha inicio.
	 *
	 * @return the fecha inicio
	 */
	public Date getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * Sets the fecha inicio.
	 *
	 * @param fechaInicio the new fecha inicio
	 */
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * Gets the fecha fin.
	 *
	 * @return the fecha fin
	 */
	public Date getFechaFin() {
		return fechaFin;
	}

	/**
	 * Sets the fecha fin.
	 *
	 * @param fechaFin the new fecha fin
	 */
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * Gets the ultimo numero.
	 *
	 * @return the ultimo numero
	 */
	public static int getUltimoNumero() {
		return ultimoNumero;
	}

	/**
	 * Comprueba si la reserva esta activa.
	 *
	 * @return true, if is activa
	 */
	public boolean isActiva() {
		Date now = new Date();
		return now.before(fechaFin);
	}

	/**
	 * Checks if is activa.
	 *
	 * @param fechaActual the fecha actual
	 * @return true, if is activa
	 */
	public boolean isActiva(Date fechaActual) {
		return fechaActual.compareTo(fechaInicio) >= 0 && fechaActual.compareTo(fechaFin) <= 0;
	}

}
