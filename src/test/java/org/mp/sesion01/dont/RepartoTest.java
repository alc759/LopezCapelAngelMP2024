package org.mp.sesion01.dont;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mp.sesion01.dont.Reparto;
import org.mp.sesion01.dont.Votacion;

// TODO: Auto-generated Javadoc
/**
 * The Class RepartoTest.
 */
public class RepartoTest {

  /**
   * Test reparto mayoria.
   */
  @Test
  public void testRepartoMayoria() {
    Votacion[] votaciones = {
        new Votacion("PP", 130652),
        new Votacion("PSOE", 92221),
        new Votacion("Vox", 67963)
    };
    
    int numDiputados = 6;
    Reparto.repartoMayoria(votaciones, numDiputados);
    
    assertEquals(6, votaciones[votaciones.length-1].getDiputados()); // PP recibe los 6 diputados
  }

  /**
   * Test reparto dont.
   */
  @Test 
  public void testRepartoDont() {
    // Inicializar votaciones
    Votacion[] votaciones = {
        new Votacion("PP", 130652),
        new Votacion("PSOE", 92221), 
        new Votacion("Vox", 67963),
        new Votacion("Sumar", 21246)
    };

    int numDiputados = 6;
    Reparto.repartoDont(votaciones, numDiputados);

    // Verificar distribución final
    assertEquals(3, votaciones[votaciones.length-1].getDiputados()); // PP
    assertEquals(2, votaciones[votaciones.length-3].getDiputados()); // PSOE
    assertEquals(1, votaciones[votaciones.length-2].getDiputados()); // Vox
    assertEquals(0, votaciones[votaciones.length-4].getDiputados()); // Sumar
  }

}