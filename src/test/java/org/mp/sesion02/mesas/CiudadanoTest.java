package org.mp.sesion02.mesas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class CiudadanoTest {
	
	@Test
	public void testConstructor() {
	    String apellido1 = "Pérez";
	    String apellido2 = "Gómez";
	    String nombre = "María";
	    LocalDate fechaNacimiento = LocalDate.of(2000, 3, 3);
	    String nivelEstudios = "Primaria";

	    Ciudadano ciudadano = new Ciudadano(apellido1, apellido2, nombre, fechaNacimiento, nivelEstudios);

	    assertEquals(apellido1, ciudadano.getApellido1());
	    assertEquals(apellido2, ciudadano.getApellido2());
	    assertEquals(nombre, ciudadano.getNombre());
	    assertEquals(fechaNacimiento, ciudadano.getFechaNacimiento());
	    assertEquals(nivelEstudios, ciudadano.getNivelEstudios());
	}


    @Test
    public void testCompareTo() {
        Ciudadano ciudadano1 = new Ciudadano("López", "García", "José", LocalDate.of(1980, 1, 1), "Universidad");
        Ciudadano ciudadano2 = new Ciudadano("Martínez", "Pérez", "Ana", LocalDate.of(1990, 2, 2), "Secundaria");

        int resultado = ciudadano1.compareTo(ciudadano2);

        assertTrue(resultado < 0);
    }

    @Test
    public void testGetEdad() {
        Ciudadano ciudadano = new Ciudadano("Pérez", "Gómez", "María", LocalDate.of(2000, 3, 3), "Primaria");

        int edad = ciudadano.getEdad();

        assertEquals(24, edad);
    }

}
