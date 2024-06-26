package org.mp.sesion08.estadistica;

import java.util.Arrays;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.mp.sesion08.conjuntodatos.ConjuntoDatos;

// TODO: Auto-generated Javadoc
/**
 * The Class Estadistica.
 */
public class Estadistica {

	/** Conjunto de Datos. */
	private ConjuntoDatos cd;

	/**
	 * Instancia una nueva Estadistica.
	 *
	 * @param cd the cd
	 */
	public Estadistica(ConjuntoDatos cd) {
		this.cd = cd;
	}

	/**
	 * Convertir A double.
	 *
	 * @param datosString the datos string
	 * @return the double[]
	 */
	private double[] convertirADouble(String[] datosString) {
		return Arrays.stream(datosString).mapToDouble(s -> {
			try {
				return Double.parseDouble(s);
			} catch (NumberFormatException e) {
				return Double.NaN;
			}
		}).toArray();
	}

	/**
	 * Gets the descriptive statistics.
	 *
	 * @param columna the columna
	 * @return the descriptive statistics
	 */
	private DescriptiveStatistics getDescriptiveStatistics(String columna) {
		String[] datosColumna = cd.getColumna(columna);
		double[] valores = convertirADouble(datosColumna);
		DescriptiveStatistics stats = new DescriptiveStatistics();
		Arrays.stream(valores).forEach(stats::addValue);
		return stats;
	}

	/**
	 * Media.
	 *
	 * @param columna the columna
	 * @return the double
	 */
	public double media(String columna) {
		DescriptiveStatistics stats = getDescriptiveStatistics(columna);
		if (stats.getN() == 0) {
			return Double.NaN;
		}
		return stats.getMean();
	}

	/**
	 * Max.
	 *
	 * @param columna the columna
	 * @return the double
	 */
	public double max(String columna) {
		DescriptiveStatistics stats = getDescriptiveStatistics(columna);
		if (stats.getN() == 0) {
			return Double.NaN;
		}
		return stats.getMax();
	}

	/**
	 * Min.
	 *
	 * @param columna the columna
	 * @return the double
	 */
	public double min(String columna) {
		DescriptiveStatistics stats = getDescriptiveStatistics(columna);
		if (stats.getN() == 0) {
			return Double.NaN;
		}
		return stats.getMin();
	}

	/**
	 * Suma.
	 *
	 * @param columna the columna
	 * @return the double
	 */
	public double suma(String columna) {
		DescriptiveStatistics stats = getDescriptiveStatistics(columna);
		if (stats.getN() == 0) {
			return Double.NaN;
		}
		return stats.getSum();
	}

	/**
	 * Mediana.
	 *
	 * @param columna the columna
	 * @return the double
	 */
	public double mediana(String columna) {
		DescriptiveStatistics stats = getDescriptiveStatistics(columna);
		if (stats.getN() == 0) {
			return Double.NaN;
		}
		return stats.getPercentile(50);
	}

	/**
	 * Varianza.
	 *
	 * @param columna the columna
	 * @return the double
	 */
	public double varianza(String columna) {
		DescriptiveStatistics stats = getDescriptiveStatistics(columna);
		if (stats.getN() == 0) {
			return Double.NaN;
		}
		return stats.getVariance();
	}

	/**
	 * Desviacion estandar.
	 *
	 * @param columna the columna
	 * @return the double
	 */
	public double desviacionEstandar(String columna) {
		DescriptiveStatistics stats = getDescriptiveStatistics(columna);
		if (stats.getN() == 0) {
			return Double.NaN;
		}
		return stats.getStandardDeviation();
	}

}
