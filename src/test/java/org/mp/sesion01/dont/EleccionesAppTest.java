package org.mp.sesion01.dont;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mp.sesion01.dont.EleccionesApp;
import org.mp.sesion01.dont.Provincia;
import org.mp.sesion01.dont.Votacion;

// TODO: Auto-generated Javadoc
/**
 * The Class EleccionesAppTest.
 */
public class EleccionesAppTest {
	
  /**
   * Test parsear datos elecciones.
   */
  @Test
  public void testParsearDatosElecciones() {
    String datos = "Almería,6";
    Provincia expected = new Provincia("Almería", 6);
    
    Provincia result = EleccionesApp.parsearDatosElecciones(datos);
    assertEquals(expected, result);
  }

  /**
   * Test parsear partidos votos.
   */
  @Test
  public void testParsearPartidosVotos() {
    String datos = "PP,130652 PSOE,92221 Vox,67963 Sumar,21246";
    Votacion[] expected = {
        new Votacion("PP", 130652),
        new Votacion("PSOE", 92221),
        new Votacion("Vox", 67963),
        new Votacion("Sumar", 21246)
    };
    
    Votacion[] result = EleccionesApp.parsearPartidosVotos(datos);
    System.out.println(expected);
    System.out.println(result);
    for (int i = 0; i < expected.length; i++) {
		assertEquals(expected[i], result[i]);
	}
  }
}

