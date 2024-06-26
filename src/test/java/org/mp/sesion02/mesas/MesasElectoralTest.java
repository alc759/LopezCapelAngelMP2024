package org.mp.sesion02.mesas;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class MesasElectoralTest {

	@Test
	public void testConstructor() {
	    String nombreMesa = "Mesa 1";
	    Ciudadano[] electores = new Ciudadano[]{
	        new Ciudadano("López", "García", "José", LocalDate.of(1980, 1, 1), "Universidad"),
	        new Ciudadano("Martínez", "Pérez", "Ana", LocalDate.of(1990, 2, 2), "Secundaria"),
	        new Ciudadano("Pérez", "Gómez", "María", LocalDate.of(2000, 3, 3), "Primaria")
	    };

	    MesaElectoral mesa = new MesaElectoral(nombreMesa, electores);

	    assertEquals(nombreMesa, mesa.getNombreMesa());
	    assertEquals(electores.length, mesa.getElectores().length);
	    for (int i = 0; i < electores.length; i++) {
	        assertEquals(electores[i], mesa.getElectores()[i]);
	    }
	    assertNull(mesa.getPresidente());
	    assertNull(mesa.getVocal1());
	    assertNull(mesa.getVocal2());
	}
	
	
	@Test
	public void testToString() {
	    String nombreMesa = "Mesa 1";
	    Ciudadano presidente = new Ciudadano("López", "García", "José", LocalDate.of(1980, 1, 1), "Universidad");
	    Ciudadano vocal1 = new Ciudadano("Martínez", "Pérez", "Ana", LocalDate.of(1990, 2, 2), "Secundaria");
	    Ciudadano vocal2 = new Ciudadano("Pérez", "Gómez", "María", LocalDate.of(2000, 3, 3), "Primaria");
	    Ciudadano[] electores = new Ciudadano[]{presidente, vocal1, vocal2};

	    MesaElectoral mesa = new MesaElectoral(nombreMesa, electores);
	    mesa.setPresidente(presidente);
	    mesa.setVocal1(vocal1);
	    mesa.setVocal2(vocal2);

	    String expectedString = String.format(
	            "MesaElectoral{nombreMesa='%s', presidente=%s, vocal1=%s, vocal2=%s}",
	            nombreMesa,  presidente, vocal1, vocal2);
	    
	    assertEquals(expectedString, mesa.toString());
	}



}
