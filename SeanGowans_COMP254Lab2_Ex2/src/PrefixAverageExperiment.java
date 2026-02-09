import java.util.Random;

public class PrefixAverageExperiment {

    /** Generate an array of size n with random doubles. */
    private static double[] randomArray(int n) {
        Random r = new Random(42);          // fixed seed for repeatability
        double[] x = new double[n];
        for (int i = 0; i < n; i++)
            x[i] = r.nextDouble();
        return x;
    }

    /**
     * Tests prefixAverage1 and prefixAverage2, doubling n each trial.
     * Optional command line args:
     *   args[0] = trials
     *   args[1] = start n
     */
    public static void main(String[] args) {
        int n = 500;       // starting value (reasonable for O(n^2))
        int trials = 10;    // number of doublings

        try {
            if (args.length > 0)
                trials = Integer.parseInt(args[0]);
            if (args.length > 1)
                n = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) { }

        int start = n;

        // Run the quicker one first (like StringExperiment)
        System.out.println("Testing prefixAverage2...");
        for (int t = 0; t < trials; t++) {
            double[] x = randomArray(n);

            long startTime = System.currentTimeMillis();
            double[] temp = PrefixAverage.prefixAverage2(x);
            long endTime = System.currentTimeMillis();

            long elapsed = endTime - startTime;
            System.out.println(String.format("n: %9d took %12d milliseconds", n, elapsed));

            n *= 2;
        }

        System.out.println("Testing prefixAverage1...");
        n = start;  // restore

        for (int t = 0; t < trials; t++) {
            double[] x = randomArray(n);

            long startTime = System.currentTimeMillis();
            double[] temp = PrefixAverage.prefixAverage1(x);
            long endTime = System.currentTimeMillis();

            long elapsed = endTime - startTime;
            System.out.println(String.format("n: %9d took %12d milliseconds", n, elapsed));

            n *= 2;
        }
    }
}
