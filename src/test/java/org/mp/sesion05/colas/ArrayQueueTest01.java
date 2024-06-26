package org.mp.sesion05.colas;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ArrayQueueTest01 {

    @Test
    public void testEnqueueDequeue() {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 20; i++) {
            queue.enqueue(i);
        }
        for (int i = 0; i < 20; i++) {
            assertEquals(Integer.valueOf(i), queue.dequeue());
        }
    }

    /**
     * Prueba que la capacidad del arreglo se duplique correctamente cuando se llena la cola.
     */    
    @Test
    public void testDuplicarCapacidad() {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 20; i++) {
            queue.enqueue(i);
        }
        assertEquals(20, queue.getSize());
        assertEquals(20, queue.arrayQueue.length);
    }

    @Test
    public void testInterEnqueueDequeueInterCalados() {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            assertEquals(Integer.valueOf(i), queue.dequeue());
        }
    }

    /**
     * Prueba que la cola maneje correctamente la circularidad al llegar al final del arreglo.
     */    
    @Test
    public void testCircularidad() {
        // Creamos una cola con capacidad inicial de 10 elementos
    	ArrayQueue<Integer> queue = new ArrayQueue<>();

        // Encolamos 10 elementos
        for (int i = 0; i < 10; i++) {
        	queue.enqueue(i);
        }

        // Desencolamos 5 elementos
        for (int i = 0; i < 5; i++) {
        	queue.dequeue();
        }

        // Encolamos 5 nuevos elementos
        for (int i = 10; i < 15; i++) {
        	queue.enqueue(i);
        }

        // Verificamos que el tamaño del arreglo interno sea 10
        assertEquals(10, queue.arrayQueue.length);

        // Encolamos 1 elemento más
        queue.enqueue(16);

        // Verificamos que el tamaño del arreglo interno sea 20
        assertEquals(20, queue.arrayQueue.length);
    }
}
