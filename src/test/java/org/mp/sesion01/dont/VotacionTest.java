package org.mp.sesion01.dont;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mp.sesion01.dont.Votacion;

// TODO: Auto-generated Javadoc
/**
 * The Class VotacionTest.
 */
public class VotacionTest {

  /**
   * Test to string.
   */
  @Test
  public void testToString() {
    Votacion v = new Votacion("PP", 130652);
    String expected = "Votacion [partido = PP, votosObtenidos = 130652, votosEnReparto = 130652, diputados = 0]";
    assertEquals(expected, v.toString());
  }

  /**
   * Test compare to.
   */
  @Test
  public void testCompareTo() {
    Votacion v1 = new Votacion("PP", 130652);
    Votacion v2 = new Votacion("PSOE", 92221);
    assertTrue(v1.compareTo(v2) > 0);
    
    Votacion v3 = new Votacion("PSOE", 92221);
    assertEquals(0, v2.compareTo(v3)); 
  }

}

