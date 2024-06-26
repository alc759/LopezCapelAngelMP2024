package org.mp.sesion09.imagen;

import java.util.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Imagen.
 */
public class Imagen {

	/** formato imagen. */
	private String formatoImagen;
	
	/** tipo imagen. */
	private String tipoImagen;
	
	/** lineas. */
	private int lineas;
	
	/** columnas. */
	private int columnas;
	
	/** bandas. */
	private ArrayList<Banda<?>> bandas;

	/**
	 * Instancia una nueva imagen.
	 *
	 * @param lineas the lineas
	 * @param columnas the columnas
	 * @param formatoImagen the formato imagen
	 * @param tipoImagen the tipo imagen
	 */
	public Imagen(int lineas, int columnas, String formatoImagen, String tipoImagen) {
		this.lineas = lineas;
		this.columnas = columnas;
		this.formatoImagen = formatoImagen;
		this.tipoImagen = tipoImagen;
		this.bandas = new ArrayList<>();
	}

	/**
	 * Gets the datos pixel.
	 *
	 * @param x the x
	 * @param y the y
	 * @return the datos pixel
	 * @throws XYFueraImagenException the XY fuera imagen exception
	 */
	public Number[] getDatosPixel(int x, int y) throws XYFueraImagenException {
		if (x < 0 || x >= lineas || y < 0 || y >= columnas) {
			throw new XYFueraImagenException("Coordenadas fuera de la imagen");
		}
		Number[] datosPixel = new Number[bandas.size()];
		for (int i = 0; i < bandas.size(); i++) {
			datosPixel[i] = bandas.get(i).getDatoXY(x, y);
		}
		return datosPixel;
	}

	/**
	 * Extraer imagen.
	 *
	 * @param x1 the x 1
	 * @param y1 the y 1
	 * @param x2 the x 2
	 * @param y2 the y 2
	 * @return the imagen
	 * @throws XYFueraImagenException the XY fuera imagen exception
	 */
	public Imagen extraerImagen(int x1, int y1, int x2, int y2) throws XYFueraImagenException {
		if (x1 < 0 || y1 < 0 || x2 >= lineas || y2 >= columnas || x1 > x2 || y1 > y2) {
			throw new XYFueraImagenException("Coordenadas fuera de la imagen");
		}
		int nuevasLineas = x2 - x1 + 1;
		int nuevasColumnas = y2 - y1 + 1;
		Imagen nuevaImagen = new Imagen(nuevasLineas, nuevasColumnas, formatoImagen, tipoImagen);
		for (Banda<?> banda : bandas) {
			Number[][] nuevosDatos = new Number[nuevasLineas][nuevasColumnas];
			for (int i = 0; i < nuevasLineas; i++) {
				for (int j = 0; j < nuevasColumnas; j++) {
					nuevosDatos[i][j] = banda.getDatoXY(x1 + i, y1 + j);
				}
			}
			nuevaImagen.anadirBanda(new Banda<Number>(banda.getNombreBanda(), nuevosDatos));
		}
		return nuevaImagen;
	}

	/**
	 * Anadir banda.
	 *
	 * @param banda the banda
	 */
	public void anadirBanda(Banda<?> banda) {
		bandas.add(banda);
	}

	/**
	 * Eliminar banda.
	 *
	 * @param i the i
	 */
	public void eliminarBanda(int i) {
		bandas.remove(i);
	}

	/**
	 * Gets the banda.
	 *
	 * @param i the i
	 * @return the banda
	 */
	public Banda<?> getBanda(int i) {
		return bandas.get(i);
	}

	/**
	 * Gets the bandas.
	 *
	 * @return the bandas
	 */
	public ArrayList<Banda<?>> getBandas() {
		return bandas;
	}

	/**
	 * Gets the numero bandas.
	 *
	 * @return the numero bandas
	 */
	public int getNumeroBandas() {
		return bandas.size();
	}

	/**
	 * Gets the lineas.
	 *
	 * @return the lineas
	 */
	public int getLineas() {
		return lineas;
	}

	/**
	 * Gets the columnas.
	 *
	 * @return the columnas
	 */
	public int getColumnas() {
		return columnas;
	}

	/**
	 * Gets the tipo imagen.
	 *
	 * @return the tipo imagen
	 */
	public String getTipoImagen() {
		return tipoImagen;
	}

	/**
	 * Sets the tipo imagen.
	 *
	 * @param tipoImagen the new tipo imagen
	 */
	public void setTipoImagen(String tipoImagen) {
		this.tipoImagen = tipoImagen;
	}

	/**
	 * Gets the formato imagen.
	 *
	 * @return the formato imagen
	 */
	public String getFormatoImagen() {
		return formatoImagen;
	}

	/**
	 * Sets the formato imagen.
	 *
	 * @param formatoImagen the new formato imagen
	 */
	public void setFormatoImagen(String formatoImagen) {
		this.formatoImagen = formatoImagen;
	}

	/**
	 * Sets the bandas.
	 *
	 * @param bandas the new bandas
	 */
	public void setBandas(ArrayList<Banda<?>> bandas) {
		this.bandas = bandas;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		return "Imagen{" + "formatoImagen='" + formatoImagen + '\'' + ", tipoImagen='" + tipoImagen + '\'' + ", lineas="
				+ lineas + ", columnas=" + columnas + ", bandas=" + bandas + '}';
	}

}
