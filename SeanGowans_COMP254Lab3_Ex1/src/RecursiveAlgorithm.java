import java.util.Scanner;

public class RecursiveAlgorithm {
    public static int product(int m, int n) {
        if (m == 0) {
            return 0;
        } else {
            return product(m - 1, n) + n;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter positive integer m: ");
        int m = sc.nextInt();

        System.out.print("Enter positive integer n: ");
        int n = sc.nextInt();

        System.out.println(m + " * " + n + " = " + product(m, n));

        sc.close();
    }
}