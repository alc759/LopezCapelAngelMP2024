package org.mp.sesion09.residencias;

import java.io.*;
import java.text.*;
import java.util.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Residencia.
 */
public class Residencia implements Serializable {

	/** nombre. */
	private String nombre;
	
	/** residentes. */
	private ArrayList<Residente> residentes = new ArrayList();
	
	/** habitaciones. */
	private ArrayList<Habitacion> habitaciones = new ArrayList();
	
	/** reservas. */
	private ArrayList<Reserva> reservas = new ArrayList();

	/**
	 * Crea una nueva residencia.
	 *
	 * @param nombre the nombre
	 */
	public Residencia(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Crea una residencia.
	 *
	 * @param nombre the nombre
	 * @param habitaciones the habitaciones
	 */
	public Residencia(String nombre, Habitacion[] habitaciones) {
		this.nombre = nombre;
		for (int i = 0; i < habitaciones.length; i++) {
			if (habitaciones[i] instanceof Habitacion)
				this.habitaciones.add(habitaciones[i]);
		}
	}

	/**
	 * Eliminar habitacion.
	 *
	 * @param habitacion the habitacion
	 */
	public void eliminarHabitacion(Habitacion habitacion) {
		habitaciones.remove(habitacion);
	}

	/**
	 * Ingreso de nuevo residente.
	 *
	 * @param residente the residente
	 * @param habitacion the habitacion
	 * @param fechaInicio the fecha inicio
	 * @param fechaFin the fecha fin
	 */
	public void ingreso(Residente residente, Habitacion habitacion, Date fechaInicio, Date fechaFin) {
		if (!isHabitacionOcupada(habitacion, fechaInicio)) {
			if (fechaOK(fechaInicio, fechaFin) > 0) {
				if (newResidente(residente)) {
					Reserva reserva = new Reserva(residente, habitacion, fechaInicio, fechaFin);
					reservas.add(reserva);
				}
			}
		}
	}

	/**
	 * Comprueba si habitacion ocupada.
	 *
	 * @param habitacion the habitacion
	 * @param fecha the fecha
	 * @return true, if is habitacion ocupada
	 */
	public boolean isHabitacionOcupada(Habitacion habitacion, Date fecha) {
		boolean x = false;
		for (int i = 0; i < reservas.size(); i++) {
			if (habitacion.equals(reservas.get(i).getHabitacion()) && fecha.before(reservas.get(i).getFechaFin())
					&& fecha.after(reservas.get(i).getFechaInicio()))
				x = true;
			else if (habitacion.equals(reservas.get(i).getHabitacion())
					&& (fecha.equals(reservas.get(i).getFechaFin()) || fecha.equals(reservas.get(i).getFechaInicio())))
				x = true;
		}
		return x;
	}

	/**
	 * Comprueba si la fecha es correcta.
	 *
	 * @param fechaInicio the fecha inicio
	 * @param fechaFin the fecha fin
	 * @return the int
	 */
	private int fechaOK(Date fechaInicio, Date fechaFin) {
		if (fechaInicio.before(fechaFin) || fechaInicio.equals(fechaFin))
			return 1;
		else
			return -1;
	}

	/**
	 * New residente.
	 *
	 * @param residente the residente
	 * @return true, if successful
	 */
	private boolean newResidente(Residente residente) {
		boolean nuevo = true;
		for (int i = 0; i < residentes.size(); i++) {
			if (((Residente) residentes.get(i)).equals(residente)) {
				nuevo = false;
			}
		}
		if (nuevo) {
			residentes.add(residente);
			return true;
		}
		return false;
	}

	/**
	 * Insertar habitacion.
	 *
	 * @param habitacion the habitacion
	 */
	public void insertarHabitacion(Habitacion habitacion) {
		for(Habitacion hExistente : habitaciones) {
			if(hExistente.getNumero() == habitacion.getNumero()) {
				return;
			}
		}
		habitaciones.add(habitacion);
	}

	/**
	 * Buscar habitacion.
	 *
	 * @param numero the numero
	 * @return the habitacion
	 */
	public Habitacion buscarHabitacion(String numero) {
		Habitacion habitacion = null;
		for (int i = 0; i < habitaciones.size(); i++) {
			if (habitaciones.get(i).getNumero().equals(numero))
				habitacion = habitaciones.get(i);
		}
		return habitacion;
	}

	/**
	 * Salida de residente.
	 *
	 * @param residente the residente
	 * @param fechaSalida the fecha salida
	 */
	public void salida(Residente residente, Date fechaSalida) {
		for (int i = 0; i < reservas.size(); i++) {
			if (reservas.get(i).getResidente().equals(residente)) {
				reservas.get(i).setFechaFin(fechaSalida);
				for (int j = 0; j < residentes.size(); j++) {
					if (((Residente) residentes.get(j)).equals(residente)) {
						residentes.remove(j);
					}
				}
			}
		}
	}

	/**
	 * Cambiar residente de habitacion.
	 *
	 * @param residente the residente
	 * @param nuevaHabitacion the nueva habitacion
	 * @param fechaInicio the fecha inicio
	 * @param fechaFin the fecha fin
	 */
	public void cambiarHabitacion(Residente residente, Habitacion nuevaHabitacion, Date fechaInicio, Date fechaFin) {
		for (int i = 0; i < reservas.size(); i++) {
			if (reservas.get(i).getResidente().equals(residente)) {
				reservas.get(i).setFechaFin(fechaInicio);
				for (int j = 0; j < residentes.size(); j++) {
					if (((Residente) residentes.get(i)).equals(residente)) {
						residentes.remove(j);
					}
				}
			}
		}
		ingreso(residente, nuevaHabitacion, fechaInicio, fechaFin);
	}

	/**
	 * Listado residentes habitaciones.
	 *
	 * @param fecha the fecha
	 * @return the string
	 */
	public String listadoResidentesHabitaciones(Date fecha) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		StringBuffer buffer = new StringBuffer();
		Reserva[] reservasArray = new Reserva[reservas.size()];
		reservas.toArray(reservasArray);
		ordenacionPorInsercion(reservasArray);

		for (int i = 0; i < reservas.size(); i++) {
			if (reservasArray[i].getFechaFin().equals(fecha) || reservasArray[i].getFechaFin().after(fecha)) {
				buffer.append(reservasArray[i].getHabitacion().getNumero() + ", ");
				buffer.append(reservasArray[i].getResidente().getNombre() + ", ");
				buffer.append(simpleDateFormat.format(reservasArray[i].getFechaInicio()) + ", ");
				buffer.append(simpleDateFormat.format(reservasArray[i].getFechaFin()) + "\n");
			}
		}
		return buffer.toString();
	}

	/**
	 * Ordenacion por insercion.
	 *
	 * @param arrayR the array R
	 */
	private void ordenacionPorInsercion(Reserva[] arrayR) {
		for (int i = 1; i < reservas.size(); i++) {
			int j = i;
			Reserva tmp = arrayR[i];
			while (j > 0 && tmp.getResidente().getNombre()
					.compareToIgnoreCase(arrayR[j - 1].getResidente().getNombre()) < 0) {
				arrayR[j] = arrayR[j - 1];
				j--;
			}
			arrayR[j] = tmp;
		}
	}

	/**
	 * Listado habitaciones libres.
	 *
	 * @param fecha the fecha
	 * @return the string
	 */
	public String listadoHabitacionesLibres(Date fecha) {
		String cadena = "";
		for (int i = 0; i < reservas.size(); i++) {
			if (!((fechaOK(reservas.get(i).getFechaInicio(), fecha) <= 0)
					& (fechaOK(reservas.get(i).getFechaFin(), fecha) >= 0))) {
				cadena = cadena + reservas.get(i).getHabitacion().getNumero() + " ";
			}
		}
		return cadena;
	}

	/**
	 * Listado edad media por sexo.
	 *
	 * @param date the date
	 * @return the string
	 */
	public String listadoEdadMediaPorSexo(Date date) {
		double sumaH = 0;
		int numH = 0;
		double sumaM = 0;
		int numM = 0;
		for (Reserva r : reservas) {
			if (r.getResidente().getSexo() == 'V') {
				sumaH += r.getResidente().getEdad(date);
				numH++;
			} else {
				sumaM += r.getResidente().getEdad(date);
				numM++;
			}
		}
		String s = "";
		if (numH == 0) {
			s += "0.0 ";
		} else {
			s += (sumaH / numH) + " ";
		}
		if (numM == 0) {
			s += "0.0 ";
		} else {
			s += (sumaM / numM) + " ";
		}
		return s;
	}

	/**
	 * Gets the habitaciones.
	 *
	 * @return the habitaciones
	 */
	public Habitacion[] getHabitaciones() {
		Habitacion[] habitacions = new Habitacion[habitaciones.size()];
		habitaciones.toArray(habitacions);
		return habitacions;
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
	 * Gets the reservas.
	 *
	 * @return the reservas
	 */
	public Reserva[] getReservas() {
		Reserva[] arrayR = new Reserva[reservas.size()];
		reservas.toArray(arrayR);
		return arrayR;
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
	 * Sets the reservas.
	 *
	 * @param reservas the new reservas
	 */
	public void setReservas(Reserva[] reservas) {
		this.reservas.clear();
		for (int i = 0; i < reservas.length; i++) {
			if (reservas[i] != null) {
				this.reservas.add(reservas[i]);
			}
		}
	}

	/**
	 * Sets the residentes.
	 *
	 * @param residentes the new residentes
	 */
	public void setResidentes(Residente[] residentes) {
		this.residentes.clear();
		for (int i = 0; i < residentes.length; i++) {
			if (residentes[i] != null) {
				this.residentes.add(residentes[i]);
			}
		}
	}

	/**
	 * Gets the n habitaciones.
	 *
	 * @return the n habitaciones
	 */
	public int getNHabitaciones() {
		return habitaciones.size();
	}

	/**
	 * Gets the n reservas.
	 *
	 * @return the n reservas
	 */
	public int getNReservas() {
		return reservas.size();
	}

	/**
	 * Gets the n residentes.
	 *
	 * @return the n residentes
	 */
	public int getNResidentes() {
		return residentes.size();
	}

}
