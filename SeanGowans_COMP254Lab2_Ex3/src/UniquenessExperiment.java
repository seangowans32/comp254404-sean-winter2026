import java.util.Random;

public class UniquenessExperiment {

    // Time limit: 1 minute (60,000 milliseconds)
    private static final long TIME_LIMIT_MS = 60000;

    /** Generate an array of size n with random integers. */
    private static int[] randomArray(int n) {
        Random r = new Random(42);      // fixed seed for repeatability
        int[] data = new int[n];
        for (int i = 0; i < n; i++)
            data[i] = r.nextInt();
        return data;
    }

    /** Time how long unique1 takes for input size n. */
    private static long timeUnique1(int n) {
        int[] data = randomArray(n);

        long startTime = System.currentTimeMillis();
        Uniqueness.unique1(data);
        long endTime = System.currentTimeMillis();

        return endTime - startTime;
    }

    /** Time how long unique2 takes for input size n. */
    private static long timeUnique2(int n) {
        int[] data = randomArray(n);

        long startTime = System.currentTimeMillis();
        Uniqueness.unique2(data);
        long endTime = System.currentTimeMillis();

        return endTime - startTime;
    }

    /**
     * Binary-search-style method to find the largest n
     * that runs in under 1 minute.
     */
    private static int findMaxN(boolean testUnique1) {
        int low = 1000;
        int high = testUnique1 ? 10_000_000 : 10_000_000;
        int best = low;

        while (low <= high) {
            int mid = (low + high) / 2;

            long time = testUnique1 ? timeUnique1(mid) : timeUnique2(mid);

            System.out.println("n = " + mid + " took " + time + " ms");

            if (time <= TIME_LIMIT_MS) {
                best = mid;        // valid candidate
                low = mid + 1;     // try larger n
            } else {
                high = mid - 1;    // too slow, try smaller n
            }
        }
        return best;
    }

    public static void main(String[] args) {
        System.out.println("Finding maximum n for unique1...");
        int maxN1 = findMaxN(true);
        System.out.println("Max n for unique1 (<= 1 minute): " + maxN1);

        System.out.println("\nFinding maximum n for unique2...");
        int maxN2 = findMaxN(false);
        System.out.println("Max n for unique2 (<= 1 minute): " + maxN2);
    }
}