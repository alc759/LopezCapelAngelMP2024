package org.mp.sesion01;
import static org.junit.Assert.*;


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

// TODO: Auto-generated Javadoc
/**
 * The Class CartaTest.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CartaTest {

  /**
   * Test constructor.
   */
  @Test
  @Order(1) 
  public void testConstructor() {
    Carta carta = new Carta("Oros", 5);
    assertEquals("Oros", carta.getPalo());
    assertEquals(5, carta.getNumero());
  }

  /**
   * Test to string.
   */
  @Test
  @Order(2)
  public void testToString() {
    Carta carta = new Carta("Oros", 5);
    
    String expected = "Carta [palo=Oros, número=5]";
    String actual = carta.toString();
    
    assertEquals(expected, actual);
  }
  
  /**
   * Test compare to.
   */
  @Test
  @Order(3)
  public void testCompareTo() {
    Carta carta1 = new Carta("Oros", 5);
    Carta carta2 = new Carta("Copas", 7);
    Carta carta3 = new Carta("Oros", 3);
    
    assertTrue(carta1.compareTo(carta2) < 0); 
    assertTrue(carta2.compareTo(carta1) > 0);
    assertTrue(carta1.compareTo(carta3) > 0);
  }

}

