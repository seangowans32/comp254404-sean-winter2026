import java.util.Random;

public class TestHashMap {
    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000};
        double[] loadFactors = {0.5, 0.7, 0.9};

        for(double loadFactor : loadFactors) {
            System.out.println("========================================");
            System.out.println("Testing ChainHashMap with load factor = " + loadFactor);
            System.out.println("========================================");

            for(int size : sizes) {
                runTest(size, loadFactor);
            }

            System.out.println();
        }
    }

    public static void runTest(int size, double loadFactor) {
        ChainHashMap<Integer, Integer> map = new ChainHashMap<>(17, loadFactor);
        Random rand = new Random(42);

        int[] keys = new int[size];
        for(int i = 0; i < size; i++) {
            keys[i] = rand.nextInt(1000000);
        }

        long startPut = System.nanoTime();

        for(int i = 0; i < size; i++) {
            map.put(keys[i], i);
        }

        long endPut = System.nanoTime();
        long startGet = System.nanoTime();

        for(int i = 0; i < size; i++) {
            map.get(keys[i]);
        }

        long endGet = System.nanoTime();

        System.out.println("Number of entries: " + size);
        System.out.println("Insertion time: " + ((endPut - startPut) / 1_000_000.0) + " ms");
        System.out.println("Search time: " + ((endGet - startGet) / 1_000_000.0) + " ms");
        System.out.println("----------------------------------------");
    }
}