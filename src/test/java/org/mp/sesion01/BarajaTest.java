package org.mp.sesion01;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

// TODO: Auto-generated Javadoc
/**
 * The Class BarajaTest.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BarajaTest {

	/**
	 * Test constructor.
	 */
	@Test
	@Order(1)
	public void testConstructor() {
		Carta[] cartas = new Carta[40];
		// Inicializar array de cartas

		Baraja baraja = new Baraja("Española", cartas);

		assertEquals("Española", baraja.getNombreBaraja());
		assertArrayEquals(cartas, baraja.getCartas());
	}

	/**
	 * Test ordenar insercion en baraja.
	 */
	@Test
	@Order(2)
	public void testOrdenarInsercionEnBaraja() {
		Carta carta1 = new Carta("Oros", 5);
		Carta carta2 = new Carta("Copas", 8);
		Carta carta3 = new Carta("Espadas", 5);

		Carta[] cartas = { carta1, carta2, carta3 };
		Baraja baraja = new Baraja("Baraja de Prueba", cartas);

		baraja.insercion(baraja.getCartas());

		Carta[] cartasOrdenadas = baraja.getCartas();
		for (int i = 0; i < cartasOrdenadas.length - 1; i++) {
			assertTrue(cartasOrdenadas[i].compareTo(cartasOrdenadas[i + 1]) <= 0);
		}
	}

	/**
	 * Test ordenar insercion en baraja 40.
	 */
	@Test
	@Order(3)
	public void testOrdenarInsercionEnBaraja40() {

		Carta[] cartas = new Carta[40];
		String[] palos = { "Oros", "Copas", "Espadas", "Bastos" };
		Carta carta;

		int j = 0;
		for (int k = 0; k < palos.length; k++) {
			for (int i = 1; i < 8; i++) {
				carta = new Carta(palos[k], i);
				cartas[j] = carta;
				j++;
			}
			for (int i = 10; i < 13; i++) {
				carta = new Carta(palos[k], i);
				cartas[j] = carta;
				j++;
			}
		}
		Baraja baraja = new Baraja("Española", cartas);
		barajar(cartas);
		baraja.insercion(baraja.getCartas());

		Carta[] cartasOrdenadas = baraja.getCartas();
		for (int i = 0; i < cartasOrdenadas.length - 1; i++) {
			assertTrue(cartasOrdenadas[i].compareTo(cartasOrdenadas[i + 1]) <= 0);
		}
	}

	/**
	 * Test buscar carta en baraja.
	 */
	@Test
	@Order(4)
	public void testBuscarCartaEnBaraja() {
		Carta carta1 = new Carta("Oros", 5);
		Carta carta2 = new Carta("Copas", 8);
		Carta carta3 = new Carta("Espadas", 5);

		Carta[] cartas = { carta1, carta2, carta3 };
		Baraja baraja = new Baraja("Baraja de Prueba", cartas);

		assertEquals(carta1, baraja.buscarCarta(new Carta("Oros", 5)));
		assertEquals(carta2, baraja.buscarCarta(new Carta("Copas", 8)));
		assertEquals(carta3, baraja.buscarCarta(new Carta("Espadas", 5)));
		assertEquals(null, baraja.buscarCarta(new Carta("Bastos", 10)));
	}

	/**
	 * Test buscar carta en baraja 40.
	 */
	@Test
	@Order(5)
	public void testBuscarCartaEnBaraja40() {
		Carta[] cartas = new Carta[40];
		String[] palos = { "Oros", "Copas", "Espadas", "Bastos" };
		Carta carta;

		int j = 0;
		for (int k = 0; k < palos.length; k++) {
			for (int i = 1; i < 8; i++) {
				carta = new Carta(palos[k], i);
				cartas[j] = carta;
				j++;
			}
			for (int i = 10; i < 13; i++) {
				carta = new Carta(palos[k], i);
				cartas[j] = carta;
				j++;
			}
		}
		Baraja baraja = new Baraja("Española", cartas);
		carta = new Carta("Copas", 7);

		assertEquals(carta, baraja.buscarCarta(new Carta("Copas", 7)));

		assertEquals(null, baraja.buscarCarta(new Carta("Bastos", 8)));
	}

	/**
	 * Barajar.
	 *
	 * @param cartas the cartas
	 */
	private void barajar(Carta[] cartas) {

		Random rand = new Random();
		for (int i = 0; i < 160; i++) {
			int x = rand.nextInt(40);
			int y = rand.nextInt(40);

			Carta swap = cartas[x];
			cartas[x] = cartas[y];
			cartas[y] = swap;
		}
	}

}