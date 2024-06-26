package org.mp.sesion09.residencias.dao;

import java.io.*;

import org.mp.sesion09.residencias.Residencia;

// TODO: Auto-generated Javadoc
/**
 * The Class ResidenciaSER.
 */
public class ResidenciaSER extends ResidenciaDAOFactory implements DataAccessObject {

	/**
	 * Instancia residencia SER.
	 *
	 * @param nombreArchivo the nombre archivo
	 */
	public ResidenciaSER(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	/**
	 * Escribir.
	 *
	 * @param object the object
	 */
	public void escribir(Object object) {
		File file = new File(nombreArchivo);
		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(object);
			oos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
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

		File file = new File(nombreArchivo);
		try {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Residencia residencia = (Residencia) ois.readObject();
			ois.close();
			fis.close();
			return residencia;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;

	}

}
