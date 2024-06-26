package org.mp.sesion02.mesas;

import java.time.LocalDate;
import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * The Class SorteoMesasApp.
 */
public class SorteoMesasApp {

	/**
	 * Parsear datos municipio.
	 *
	 * @param datosMunicipio  datos municipio
	 * @param datosMesas  datos mesas
	 * @return the municipio
	 */
	public static Municipio parsearDatosMunicipio(String datosMunicipio, String datosMesas) {
		String[] descMunicipio = datosMunicipio.split(",");
		Municipio municipio = new Municipio(descMunicipio[0], descMunicipio[1]);
		//
		String[] datos = datosMesas.split("#");
		MesaElectoral[] mesas = new MesaElectoral[datos.length];
		for (int i = 0; i < datos.length; i++) {
			MesaElectoral mesa;
			String[] datosMesa = datos[i].split(":");
			Ciudadano[] arrayCiudadanos;
			for (int j = 0; j < datosMesa.length; j++) {
				String[] datosCiudadanos = datosMesa[1].split(";");
				arrayCiudadanos = new Ciudadano[datosCiudadanos.length];
				for (int k = 0; k < datosCiudadanos.length; k++) {
					String[] datosIndividuo = datosCiudadanos[k].split(",");
					Ciudadano ciudadano = new Ciudadano(datosIndividuo[0], datosIndividuo[1], datosIndividuo[2],
							LocalDate.parse(datosIndividuo[3]), datosIndividuo[4]);
					arrayCiudadanos[k] = ciudadano;
				}
				mesa = new MesaElectoral(datosMesa[0], arrayCiudadanos);
				mesas[i] = mesa;
			}
		}
		municipio.setMesasElectorales(mesas);
		return municipio;
	}

	/**
	 * Sortear miembros.
	 *
	 * @param mesa the mesa
	 */
	public static void sortearMiembros(MesaElectoral mesa) {
		Ciudadano[] electores = mesa.getElectores();
		Ciudadano[] miembrosMesa = new Ciudadano[3];
		int cont = 0;
		int i = 0;
		while (cont < 3) {
			Random random = new Random();
			int numAleatorio = random.nextInt(electores.length - 1);
			if (electores[numAleatorio].getEdad() < 60 && electores[numAleatorio].esElegido() == false) {
				miembrosMesa[i] = electores[numAleatorio];
				electores[numAleatorio].setElegido(true);
				cont++;
				i++;
			}
		}
		mesa.setPresidente(miembrosMesa[0]);
		mesa.setVocal1(miembrosMesa[1]);
		mesa.setVocal2(miembrosMesa[2]);
	}

	/**
	 * Mostrar resultados.
	 *
	 * @param municipio the municipio
	 */
	public static void mostrarResultados(Municipio municipio) {
		municipio.toString();
	}

}
