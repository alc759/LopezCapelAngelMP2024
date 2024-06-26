package org.mp.sesion03.arraydinamico;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayDinamicoEnterosTest {

    @Test
    public void testConstructor() {
        ArrayDinamicoEnteros array = new ArrayDinamicoEnteros();
        assertNotNull(array);
        assertEquals(0, array.capacidad());
    }

    @Test
    public void testAgregarYObtenerElemento() {
        ArrayDinamicoEnteros array = new ArrayDinamicoEnteros();
        array.agregar(10);
        array.agregar(20);
        assertEquals(10, array.obtener(0));
        assertEquals(20, array.obtener(1));
    }

    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void testEliminarElemento() {
        ArrayDinamicoEnteros array = new ArrayDinamicoEnteros();
        array.agregar(10);
        array.agregar(20);
        array.eliminar(0);
        assertEquals(20, array.obtener(0));
        assertEquals(1, array.capacidad());
        array.eliminar(2);
    }

    @Test
    public void testEstablecerElemento() {
        ArrayDinamicoEnteros array = new ArrayDinamicoEnteros();
        array.agregar(10);
        array.agregar(20);
        array.establecer(1, 30);
        assertEquals(30, array.obtener(1));
    }

    @Test
    public void testCrecimientoDinamico() {
        ArrayDinamicoEnteros array = new ArrayDinamicoEnteros();
        for (int i = 0; i < 20; i++) {
            array.agregar(i);
        }
        assertEquals(20, array.capacidad());
    }

}
