package org.mp.sesion02.mesas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
 

public class SorteoMesasAppTest {

    private static final String NOMBRE_MUNICIPIO = "Tíjola";
    private static final String NOMBRE_PROVINCIA = "Almería";
    private static final String DATOS_MESAS = "Mesa1:"
            + "López,García,José,1950-01-15,Universidad;Martínez,Ruiz,Ana,1992-04-22,Secundaria;"
            + "Sánchez,Jiménez,Miguel,1980-07-07,Primaria;Fernández,Gómez,María,1973-02-28,Secundaria;"
            + "Lopez,Pérez,Miguel,2002-05-12,Universidad;Soria,Mara,Lucia,1970-08-18,Primaria;"
            + "Rodríguez,Pérez,Carlos,1988-05-12,Universidad;Gutiérrez,Martín,Laura,1999-08-18,Primaria;"
            + "Díaz,Molina,Pedro,1970-11-03,SinEstudios#"
            + "Mesa2:Gómez,Navarro,Sofía,1970-03-10,SinEstudios;Pérez,Álvarez,Luis,1970-06-25,Universidad;"
            + "Ruiz,Serrano,Isabel,1970-09-29,Primaria;Ruiz,Gómez,María,1970-02-28,Secundaria;"
            + "Martínez,Pérez,José,1970-05-12,Universidad;Pérez,Martín,Laura,1970-08-18,Primaria;"
            + "Sanchez,Molina,Pedro,1970-11-03,SinEstudios";

    private static Municipio crearMunicipio() {
        String datosMunicipio = NOMBRE_MUNICIPIO + "," + NOMBRE_PROVINCIA;
        return SorteoMesasApp.parsearDatosMunicipio(datosMunicipio, DATOS_MESAS);
    }

    private static void verificarMiembrosMesa(MesaElectoral mesa, Ciudadano presidenteEsperado,
                                             Ciudadano vocal1Esperado, Ciudadano vocal2Esperado) {
        assertEquals(presidenteEsperado, mesa.getPresidente());
        assertEquals(vocal1Esperado, mesa.getVocal1());
        assertEquals(vocal2Esperado, mesa.getVocal2());
    }

    @Test
    public void testParsearDatosMunicipio() {
        Municipio municipio = crearMunicipio();

        assertEquals(NOMBRE_MUNICIPIO, municipio.getNombreMunicipio());
        assertEquals(NOMBRE_PROVINCIA, municipio.getNombreProvincia());
        assertEquals(2, municipio.getMesasElectorales().length);
    }

 
    
    @Test
    public void testSortearMiembros() {
    	 Municipio municipio = crearMunicipio();
        // Crear una mesa electoral con varios electores
       
		/*
		 * Ciudadano elector1 = new Ciudadano("Apellido1", "Apellido2", "Nombre1",
		 * LocalDate.of(1980, 1, 1), "Universidad"); Ciudadano elector2 = new
		 * Ciudadano("Apellido3", "Apellido4", "Nombre2", LocalDate.of(1990, 2, 2),
		 * "Secundaria"); Ciudadano elector3 = new Ciudadano("Apellido5", "Apellido6",
		 * "Nombre3", LocalDate.of(2000, 3, 3), "Primaria"); Ciudadano elector4 = new
		 * Ciudadano("Apellido7", "Apellido8", "Nombre4", LocalDate.of(1970, 4, 4),
		 * "SinEstudios"); MesaElectoral mesa = new MesaElectoral("Mesa 1",new
		 * Ciudadano[]{elector1, elector2, elector3, elector4});
		 */     
    	MesaElectoral[] mesas =municipio.getMesasElectorales();
    	
    	for (int i = 0; i < mesas.length; i++) {
			MesaElectoral mesa = mesas[i];
			SorteoMesasApp.sortearMiembros(mesa);
			System.out.println(mesa);
		    // Verificaciones
	        assertNotNull(mesa.getPresidente());
	        assertNotNull(mesa.getVocal1());
	        assertNotNull(mesa.getVocal2());
	        
	        // Verificar que no se ha elegido a un elector sin estudios
	        Ciudadano[] ciudadanos =mesa.getElectores();
	        Ciudadano ciudadanoSinEstudios = ciudadanos[ciudadanos.length-1];
	        System.out.println(ciudadanoSinEstudios);
	        assertNotEquals(ciudadanoSinEstudios, mesa.getPresidente());
	        assertNotEquals(ciudadanoSinEstudios, mesa.getVocal1());
	        assertNotEquals(ciudadanoSinEstudios, mesa.getVocal2());

	        // Verificar que no hay miembros repetidos
	        assertNotEquals(mesa.getPresidente(), mesa.getVocal1());
	        assertNotEquals(mesa.getPresidente(), mesa.getVocal2());
	        assertNotEquals(mesa.getVocal1(), mesa.getVocal2());
		}

    }
  
}
