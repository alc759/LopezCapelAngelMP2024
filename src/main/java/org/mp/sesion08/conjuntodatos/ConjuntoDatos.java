package org.mp.sesion08.conjuntodatos;

import java.util.*;
import java.io.*;

// TODO: Auto-generated Javadoc
/**
 * The Class ConjuntoDatos.
 */
public class ConjuntoDatos {

	/** archivo texto. */
	private File archivoTexto;
	
	/** separador. */
	private String separador;
	
	/** locale. */
	private Locale locale;
	
	/** cabecera. */
	private ArrayList<String> cabecera;
	
	/** numero lineas. */
	private int numeroLineas;
	
	/** numero columnas. */
	private int numeroColumnas;
	
	/** datos string. */
	private String[][] datosString;

	/**
	 * Instancia nuevo conjunto datos.
	 *
	 * @param archivoTexto the archivo texto
	 * @param separador the separador
	 * @param locale the locale
	 */
	public ConjuntoDatos(File archivoTexto, String separador, Locale locale) {
		this.archivoTexto = archivoTexto;
		this.separador = separador;
		this.locale = locale;
		this.cabecera = cabecera(archivoTexto);
		this.numeroLineas = numLineas(archivoTexto);
		this.numeroColumnas = cabecera.size();
		this.datosString = leerDatos(archivoTexto, numeroLineas, numeroColumnas);
	}

	/**
	 * Devuelve la cabecera.
	 *
	 * @param archivoTexto the archivo texto
	 * @return the array list
	 */
	private ArrayList<String> cabecera(File archivoTexto) {
		ArrayList<String> cabecera = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(archivoTexto))) {
			String linea = br.readLine();
			if (linea != null) {
				cabecera.addAll(Arrays.asList(linea.split(separador)));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cabecera;
	}

	/**
	 * Devuelve el num lineas.
	 *
	 * @param archivoTexto the archivo texto
	 * @return the int
	 */
	private int numLineas(File archivoTexto) {
		int lineas = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(archivoTexto))) {
			while (br.readLine() != null) {
				lineas++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lineas - 1;
	}

	/**
	 * Leer datos.
	 *
	 * @param archivoTexto the archivo texto
	 * @param filas the filas
	 * @param columnas the columnas
	 * @return the string[][]
	 */
	private String[][] leerDatos(File archivoTexto, int filas, int columnas) {
		String[][] datos = new String[filas][columnas];
		try (BufferedReader br = new BufferedReader(new FileReader(archivoTexto))) {
			br.readLine();
			String linea;
			int fila = 0;
			while ((linea = br.readLine()) != null && fila < filas) {
				String[] partes = linea.split(separador);
				for (int i = 0; i < Math.min(partes.length, columnas); i++) {
					datos[fila][i] = partes[i];
				}
				fila++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return datos;
	}

	/**
	 * Gets the columna.
	 *
	 * @param columna the columna
	 * @return the columna
	 */
	public String[] getColumna(int columna) {
		if (columna < 0 || columna >= numeroColumnas) {
			throw new IllegalArgumentException("Indice de columna fuera de rango");
		}
		String[] valores = new String[numeroLineas];
		for (int i = 0; i < numeroLineas; i++) {
			valores[i] = datosString[i][columna];
		}
		return valores;
	}

	/**
	 * Gets the columna.
	 *
	 * @param columna the columna
	 * @return the columna
	 */
	public String[] getColumna(String columna) {
		int indice = cabecera.indexOf(columna);
		if (indice != -1) {
			return getColumna(indice);
		} else {
			throw new IllegalArgumentException("Nombre de columna no encontrado");
		}
	}

	/**
	 * Gets the cabecera.
	 *
	 * @return the cabecera
	 */
	public ArrayList<String> getCabecera() {
		return cabecera;
	}

	/**
	 * Gets the separador.
	 *
	 * @return the separador
	 */
	public String getSeparador() {
		return separador;
	}

	/**
	 * Gets the locale.
	 *
	 * @return the locale
	 */
	public Locale getLocale() {
		return locale;
	}

	/**
	 * Gets the numero lineas.
	 *
	 * @return the numero lineas
	 */
	public int getNumeroLineas() {
		return numeroLineas;
	}

	/**
	 * Gets the numero columnas.
	 *
	 * @return the numero columnas
	 */
	public int getNumeroColumnas() {
		return numeroColumnas;
	}

	/**
	 * Gets the datos string.
	 *
	 * @return the datos string
	 */
	public String[][] getDatosString() {
		return datosString;
	}

	/**
	 * Gets the archivo texto.
	 *
	 * @return the archivo texto
	 */
	public File getArchivoTexto() {
		return archivoTexto;
	}

	/**
	 * Exportar.
	 *
	 * @param cabeceraAB the cabecera AB
	 * @param archivoTexto the archivo texto
	 * @param separador the separador
	 */
	public void exportar(String[] cabeceraAB, String archivoTexto, String separador) {
		try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(archivoTexto)))) {
			pw.println(String.join(separador, cabeceraAB));
			for (int i = 0; i < numeroLineas; i++) {
				ArrayList<String> linea = new ArrayList<>();
				for (String cabeceraNombre : cabeceraAB) {
					int indice = cabecera.indexOf(cabeceraNombre);
					if (indice != -1) {
						linea.add(datosString[i][indice]);
					}
				}
				pw.println(String.join(separador, linea));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Conjunto datos.
	 *
	 * @param cabecera the cabecera
	 * @param archivoTexto the archivo texto
	 * @param separador the separador
	 * @param locale the locale
	 * @return the conjunto datos
	 */
	public ConjuntoDatos conjuntoDatos(String[] cabecera, String archivoTexto, String separador, Locale locale) {
		return new ConjuntoDatos(new File(archivoTexto), separador, locale);
	}

}
