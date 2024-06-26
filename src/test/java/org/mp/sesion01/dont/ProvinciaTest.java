package org.mp.sesion01.dont;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mp.sesion01.dont.Provincia;

// TODO: Auto-generated Javadoc
/**
 * The Class ProvinciaTest.
 */
public class ProvinciaTest {

  /**
   * Test to string.
   */
  @Test
  public void testToString() {
    Provincia p = new Provincia("Almería", 6);
    String expected = "Provincia [nombre=Almería, numDiputados=6]";
    assertEquals(expected, p.toString());
  }

  /**
   * Test equals.
   */
  @Test
  public void testEquals() {
    Provincia p1 = new Provincia("Almería", 6);
    Provincia p2 = new Provincia("Almería", 6);
    assertTrue(p1.equals(p2));
    
    Provincia p3 = new Provincia("Granada", 8);
    assertFalse(p1.equals(p3));
  }

}

