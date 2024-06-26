package org.mp.sesion07.ordenacion;
import java.util.Arrays;
import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * The Class OrdenacionApp.
 */
public class OrdenacionApp {
    
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        Integer[] intArray = generateRandomArray(10, -100, 100);
        System.out.println("Array de enteros desordenado: " + Arrays.toString(intArray));

        Ordenacion.ordenacionPorInsercion(intArray);
        System.out.println("Array de enteros ordenado por inserción: " + Arrays.toString(intArray));

        Ordenacion.mergeSort(intArray);
        System.out.println("Array de enteros ordenado por Merge Sort: " + Arrays.toString(intArray));

        Ordenacion.sort(intArray);
        System.out.println("Array de enteros ordenado con Arrays.sort: " + Arrays.toString(intArray));

        String[] stringArray = generateRandomStringArray(10, 5);
        System.out.println("\nArray de cadenas desordenado: " + Arrays.toString(stringArray));

        Ordenacion.ordenacionPorInsercion(stringArray);
        System.out.println("Array de cadenas ordenado por inserción: " + Arrays.toString(stringArray));

        Ordenacion.mergeSort(stringArray);
        System.out.println("Array de cadenas ordenado por Merge Sort: " + Arrays.toString(stringArray));

        Ordenacion.sort(stringArray);
        System.out.println("Array de cadenas ordenado con Arrays.sort: " + Arrays.toString(stringArray));

        CustomObject[] customArray = generateRandomCustomObjectArray(10, -100, 100);
        System.out.println("\nArray de objetos personalizados desordenado: " + Arrays.toString(customArray));

        Ordenacion.ordenacionPorInsercion(customArray);
        System.out.println("Array de objetos personalizados ordenado por inserción: " + Arrays.toString(customArray));

        Ordenacion.mergeSort(customArray);
        System.out.println("Array de objetos personalizados ordenado por Merge Sort: " + Arrays.toString(customArray));

        Ordenacion.sort(customArray);
        System.out.println("Array de objetos personalizados ordenado con Arrays.sort: " + Arrays.toString(customArray));
    }

    /**
     * Generate random array.
     *
     * @param size the size
     * @param min the min
     * @param max the max
     * @return the integer[]
     */
    private static Integer[] generateRandomArray(int size, int min, int max) {
        Integer[] array = new Integer[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(max - min + 1) + min;
        }
        return array;
    }

    /**
     * Generate random string array.
     *
     * @param size the size
     * @param maxLength the max length
     * @return the string[]
     */
    private static String[] generateRandomStringArray(int size, int maxLength) {
        String[] array = new String[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            int length = random.nextInt(maxLength) + 1;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < length; j++) {
                sb.append((char) (random.nextInt(26) + 'a'));
            }
            array[i] = sb.toString();
        }
        return array;
    }

    /**
     * Generate random custom object array.
     *
     * @param size the size
     * @param min the min
     * @param max the max
     * @return the custom object[]
     */
    private static CustomObject[] generateRandomCustomObjectArray(int size, int min, int max) {
        CustomObject[] array = new CustomObject[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = new CustomObject(random.nextInt(max - min + 1) + min);
        }
        return array;
    }

    /**
     * The Class CustomObject.
     */
    private static class CustomObject implements Comparable<CustomObject> {
        
        /** The value. */
        private int value;

        /**
         * Instantiates a new custom object.
         *
         * @param value the value
         */
        public CustomObject(int value) {
            this.value = value;
        }

        /**
         * Compare to.
         *
         * @param o the o
         * @return the int
         */
        @Override
        public int compareTo(CustomObject o) {
            return Integer.compare(this.value, o.value);
        }

        /**
         * To string.
         *
         * @return the string
         */
        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }
}