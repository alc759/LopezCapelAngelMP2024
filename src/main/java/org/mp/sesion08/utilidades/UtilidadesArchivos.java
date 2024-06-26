package org.mp.sesion08.utilidades;

import java.io.IOException;
import java.io.*;
import java.util.*;
import java.util.List;
import java.util.regex.*;
import java.util.stream.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

// TODO: Auto-generated Javadoc
/**
 * The Class UtilidadesArchivos.
 */
public class UtilidadesArchivos {

	/**
	 * Crear archivo.
	 *
	 * @param ruta the ruta
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void crearArchivo(String ruta) throws IOException {
		Path path = Paths.get(ruta);
		if (!Files.exists(path)) {
			Files.createFile(path);
		}
	}

	/**
	 * Verificar existencia archivo.
	 *
	 * @param ruta the ruta
	 * @return true, if successful
	 */
	public static boolean verificarExistenciaArchivo(String ruta) {
		Path path = Paths.get(ruta);
		return Files.exists(path);
	}

	/**
	 * Eliminar archivo.
	 *
	 * @param ruta the ruta
	 * @return true, if successful
	 */
	public static boolean eliminarArchivo(String ruta) {
		Path path = Paths.get(ruta);
		try {
			return Files.deleteIfExists(path);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Obtener nombre archivo.
	 *
	 * @param rutaCompleta the ruta completa
	 * @return the string
	 */
	public static String obtenerNombreArchivo(String rutaCompleta) {
		Path path = Paths.get(rutaCompleta);
		return path.getFileName().toString();
	}

	/**
	 * Obtener ruta padre.
	 *
	 * @param rutaCompleta the ruta completa
	 * @return the string
	 */
	public static String obtenerRutaPadre(String rutaCompleta) {
		Path path = Paths.get(rutaCompleta);
		return path.getParent().toString();
	}

	/**
	 * Copiar archivo.
	 *
	 * @param rutaOrigen the ruta origen
	 * @param rutaDestino the ruta destino
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void copiarArchivo(String rutaOrigen, String rutaDestino) throws IOException {
		Path origenPath = Paths.get(rutaOrigen);
		Path destinoPath = Paths.get(rutaDestino);
		Files.copy(origenPath, destinoPath, StandardCopyOption.REPLACE_EXISTING);
	}

	/**
	 * Copiar directorio recursivamente.
	 *
	 * @param rutaOrigen the ruta origen
	 * @param rutaDestino the ruta destino
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void copiarDirectorioRecursivamente(String rutaOrigen, String rutaDestino) throws IOException {
		Path origenPath = Paths.get(rutaOrigen);
		Path destinoPath = Paths.get(rutaDestino);
		Files.createDirectories(destinoPath);
		try (Stream<Path> paths = Files.walk(origenPath)) {
			paths.forEach(source -> {
				try {
					Path destino = destinoPath.resolve(origenPath.relativize(source));
					if (Files.isDirectory(source)) {
						Files.createDirectories(destino);
					} else {
						Files.copy(source, destino, StandardCopyOption.REPLACE_EXISTING);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		}
	}

	/**
	 * Obtener tamanio archivo.
	 *
	 * @param ruta the ruta
	 * @return the long
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static long obtenerTamanioArchivo(String ruta) throws IOException {
		Path path = Paths.get(ruta);
		return Files.size(path);
	}

	/**
	 * Verificar si es directorio.
	 *
	 * @param rutaDirectorio the ruta directorio
	 * @return true, if successful
	 */
	public static boolean verificarSiEsDirectorio(String rutaDirectorio) {
		Path path = Paths.get(rutaDirectorio);
		return Files.isDirectory(path);
	}

	/**
	 * Obtener ruta actual.
	 *
	 * @return the path
	 */
	public static Path obtenerRutaActual() {
		return Paths.get("").toAbsolutePath();
	}

	/**
	 * Obtener ruta raiz.
	 *
	 * @return the path
	 */
	public static Path obtenerRutaRaiz() {
		Path rutaRaiz = FileSystems.getDefault().getRootDirectories().iterator().next();
		if (System.getProperty("os.name").toLowerCase().contains("windows")) {
			return Paths.get(rutaRaiz.toString().substring(0, 3));
		} else {
			return rutaRaiz;
		}
	}

	/**
	 * Obtener ruta relativa.
	 *
	 * @param rutaBase the ruta base
	 * @param rutaEspecifica the ruta especifica
	 * @return the path
	 */
	public static Path obtenerRutaRelativa(Path rutaBase, Path rutaEspecifica) {
		return rutaBase.relativize(rutaEspecifica);
	}

	/**
	 * Obtener string ruta.
	 *
	 * @param ruta the ruta
	 * @return the string
	 */
	public static String obtenerStringRuta(Path ruta) {
		return ruta.toString();
	}

	/**
	 * Comparar rutas.
	 *
	 * @param ruta1 the ruta 1
	 * @param ruta2 the ruta 2
	 * @return true, if successful
	 */
	public static boolean compararRutas(Path ruta1, Path ruta2) {
		return ruta1.equals(ruta2);
	}

	/**
	 * Comparar rutas.
	 *
	 * @param ruta1 the ruta 1
	 * @param ruta2 the ruta 2
	 * @param ruta3 the ruta 3
	 * @return true, if successful
	 */
	public static boolean compararRutas(Path ruta1, Path ruta2, Path ruta3) {
		return ruta1.equals(ruta2) && ruta1.equals(ruta3);
	}

	/**
	 * Copiar archivos con filtro.
	 *
	 * @param rutaOrigen the ruta origen
	 * @param rutaDestino the ruta destino
	 * @param string the string
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void copiarArchivosConFiltro(String rutaOrigen, String rutaDestino, String string)
			throws IOException {
		Path origenPath = Paths.get(rutaOrigen);
		Path destinoPath = Paths.get(rutaDestino);
		if (!Files.exists(destinoPath)) {
			Files.createDirectories(destinoPath);
		}
		Pattern pattern = Pattern.compile(string);
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(origenPath)) {
			for (Path entry : stream) {
				if (pattern.matcher(entry.getFileName().toString()).matches()) {
					Files.copy(entry, destinoPath.resolve(entry.getFileName()), StandardCopyOption.REPLACE_EXISTING);
				}
			}
		}
	}

	/**
	 * Listar archivos en directorio.
	 *
	 * @param rutaDirectorio the ruta directorio
	 * @return the list
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static List<File> listarArchivosEnDirectorio(String rutaDirectorio) throws IOException {
		Path directorioPath = Paths.get(rutaDirectorio);
		try (Stream<Path> paths = Files.list(directorioPath)) {
			return paths.filter(Files::isRegularFile).map(Path::toFile).collect(Collectors.toList());
		}
	}

	/**
	 * Recorrer directorio recursivamente.
	 *
	 * @param rutaDirectorio the ruta directorio
	 * @param visitor the visitor
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void recorrerDirectorioRecursivamente(String rutaDirectorio, FileVisitor<Path> visitor)
			throws IOException {
		Path directorio = Paths.get(rutaDirectorio);
		Queue<Path> queue = new LinkedList<>();
		queue.offer(directorio);
		while (!queue.isEmpty()) {
			Path current = queue.poll();
			if (Files.isDirectory(current)) {
				Iterator<Path> iterator = Files.list(current).iterator();
				while (iterator.hasNext()) {
					Path path = iterator.next();
					queue.offer(path);
				}
			}
			visitor.visitFile(current, Files.readAttributes(current, BasicFileAttributes.class));
		}
	}

}
