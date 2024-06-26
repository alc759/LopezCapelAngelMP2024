package org.mp.sesion09.imagen;

import java.io.*;
import java.util.*;

// TODO: Auto-generated Javadoc
/**
 * The Class ImagenDAO.
 */
public class ImagenDAO {

	/**
	 * Escribir archivo.
	 *
	 * @param nombreArchivo the nombre archivo
	 * @param imagen the imagen
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void escribirArchivo(String nombreArchivo, Imagen imagen) throws IOException {

		File file = new File(nombreArchivo);
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);
		String nombre = file.getName();
		int indice = nombre.indexOf(".");
		nombre = nombre.substring(0, indice);
		pw.println(nombre + ".dat");
		pw.println(imagen.getFormatoImagen());
		pw.println(imagen.getTipoImagen());
		int nBandas = imagen.getNumeroBandas();
		pw.println(nBandas);

		List<String> nombresBandas = new ArrayList<>();
		for (Banda<?> banda : imagen.getBandas()) {
			nombresBandas.add(banda.getNombreBanda());
		}

		String bandasEnLinea = "[" + String.join(";", nombresBandas) + "]";
		pw.println(bandasEnLinea);
		pw.println(imagen.getLineas());
		pw.println(imagen.getColumnas());
		pw.close();
		String nombreNuevo = file.getParent();
		nombreNuevo = nombreNuevo + File.separator + nombre + ".dat";
		if (imagen.getFormatoImagen().equals("BSQ")) {
			escribirBSQ(nombreNuevo, imagen);
		}

	}

	/**
	 * Escribir BSQ.
	 *
	 * @param nombreArchivo the nombre archivo
	 * @param imagen the imagen
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private static void escribirBSQ(String nombreArchivo, Imagen imagen) throws IOException {

		Banda<Number> b = null;
		String tipoImagen = imagen.getTipoImagen();
		try {
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(new File(nombreArchivo)));
			for (int i = 0; i < imagen.getNumeroBandas(); i++) {
				b = (Banda<Number>) imagen.getBanda(i);
				for (int j = 0; j < imagen.getLineas(); j++) {
					for (int k = 0; k < imagen.getColumnas(); k++) {
						if (tipoImagen.equals("Integer"))
							dos.writeInt((Integer) b.getDatoXY(j, k));
						else
							dos.writeDouble((Double) b.getDatoXY(j, k));
					}
				}
			}
			dos.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * Leer archivo.
	 *
	 * @param nombreArchivo the nombre archivo
	 * @return the imagen
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static Imagen leerArchivo(String nombreArchivo) throws IOException {

		File file = new File(nombreArchivo);
		Imagen imagen = null;
		try {
			Scanner sc = new Scanner(file);
			String archivoDatos = sc.nextLine();
			String tipoImagen = sc.nextLine();
			String formatoImagen = sc.nextLine();
			sc.nextLine();

			String[] arrayBandas = sc.nextLine().replace("[", "").replace("]", "").split(";");

			int lineas = Integer.parseInt(sc.nextLine());
			int columnas = Integer.parseInt(sc.nextLine());

			sc.close();

			imagen = new Imagen(lineas, columnas, formatoImagen, tipoImagen);
			imagen = leerBSQ(file.getParent() + File.separator + archivoDatos, imagen, arrayBandas, tipoImagen);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return imagen;

	}

	/**
	 * Leer BSQ.
	 *
	 * @param nombreArchivo the nombre archivo
	 * @param imagen the imagen
	 * @param nBandas the n bandas
	 * @param tipoImagen the tipo imagen
	 * @return the imagen
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private static Imagen leerBSQ(String nombreArchivo, Imagen imagen, String[] nBandas, String tipoImagen)
			throws IOException {

		File file = new File(nombreArchivo);
		FileInputStream fis = new FileInputStream(file);
		DataInputStream dis = new DataInputStream(fis);

		for (int k = 0; k < nBandas.length; k++) {
			Banda<Number> b = new Banda<>(nBandas[k], imagen.getColumnas(), imagen.getLineas());
			for (int i = 0; i < imagen.getLineas(); i++) {
				for (int j = 0; j < imagen.getColumnas(); j++) {
					if (imagen.getTipoImagen().equals("Double")) {
						b.setDatoXY(dis.readDouble(), j, i);
					} else {
						b.setDatoXY(dis.readInt(), j, i);
					}
				}
			}
			imagen.anadirBanda(b);
		}
		dis.close();
		fis.close();

		return imagen;

	}

}
