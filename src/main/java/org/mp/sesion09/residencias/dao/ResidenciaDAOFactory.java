package org.mp.sesion09.residencias.dao;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating ResidenciaDAO objects.
 */
public class ResidenciaDAOFactory {

	/** nombre archivo. */
	protected String nombreArchivo;

	/**
	 * Crea nueva ResidenciaDAO.
	 *
	 * @param nombreArchivo the nombre archivo
	 * @param tipo the tipo
	 * @return the data access object
	 */
	public static DataAccessObject createResidenciaDAOFactory(String nombreArchivo, String tipo) {
		DataAccessObject dao = null;
		if (tipo.equals("ser")) {
			dao = new ResidenciaSER(nombreArchivo);
		}
		if (tipo.equals("xml")) {
			dao = new ResidenciaXML(nombreArchivo);
		}
		if (tipo.equals("json")) {
			dao = new ResidenciaJSON(nombreArchivo);
		}
		return dao;

	}
}
