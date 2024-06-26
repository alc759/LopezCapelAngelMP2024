package org.mp.sesion09.residencias.dao;

import java.io.*;

import org.mp.sesion09.residencias.Habitacion;
import org.mp.sesion09.residencias.Reserva;
import org.mp.sesion09.residencias.Residencia;
import org.mp.sesion09.residencias.Residente;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.*;

// TODO: Auto-generated Javadoc
/**
 * The Class ResidenciaXML.
 */
public class ResidenciaXML extends ResidenciaDAOFactory implements DataAccessObject {

	/** The xstream. */
	private XStream xstream;

	/**
	 * Instancia residencia XML.
	 *
	 * @param nombreArchivo the nombre archivo
	 */
	public ResidenciaXML(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
		xstream = new XStream(new DomDriver("UTF-8"));
		xstream.alias("residencia", Residencia.class);
		xstream.alias("residente", Residente.class);
		xstream.alias("habitacion", Habitacion.class);
		xstream.alias("reserva", Reserva.class);
		xstream.allowTypesByWildcard(new String[] { "org.mp.sesion09.residencias.**" });
	}

	/**
	 * Escribir.
	 *
	 * @param object the object
	 */
	public void escribir(Object object) {
		File f = new File(nombreArchivo);
		try {
			FileOutputStream fos = new FileOutputStream(f);
			xstream.toXML(object, fos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Leer.
	 *
	 * @return the object
	 */
	public Object leer() {
		File f = new File(nombreArchivo);
		try {
			FileInputStream fis = new FileInputStream(f);
			return xstream.fromXML(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

}
