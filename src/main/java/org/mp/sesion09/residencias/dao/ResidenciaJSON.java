package org.mp.sesion09.residencias.dao;

import java.io.*;

import org.mp.sesion09.residencias.Residencia;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class ResidenciaJSON.
 */
public class ResidenciaJSON extends ResidenciaDAOFactory implements DataAccessObject {

	/** gson. */
	private Gson gson = null;

	/**
	 * Instancia residencia JSON.
	 *
	 * @param nombreArchivo the nombre archivo
	 */
	public ResidenciaJSON(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
		this.gson = new GsonBuilder().setPrettyPrinting().create();
	}

	/**
	 * Escribir.
	 *
	 * @param object the object
	 */
	public void escribir(Object object) {
		File f = new File(nombreArchivo);
		try {
			FileWriter fw = new FileWriter(f);
			gson.toJson(object, fw);
			fw.close();
		} catch (IOException e) {
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
		try (FileReader fr = new FileReader(f)) {
			return gson.fromJson(fr, Residencia.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
