import java.util.Scanner;
import java.io.File;

public class FileSearch {
    public static void find(File root, String filename) {

        if (root.getName().equals(filename)) {
            System.out.println("Found:\t" + root);
        }

        if (root.isDirectory()) {
            String[] children = root.list();
            if (children != null) {
                for (String childname : children) {
                    File child = new File(root, childname);
                    find(child, filename);   // recursive call
                }
            }
        }
    }

    public static void main(String[] args) {
        // Just For The Demo
        // /Users/sean/Documents
        // file1.txt

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the starting location: ");
        String start = sc.nextLine();

        System.out.print("Enter filename to search for: ");
        String filename = sc.nextLine();

        File root = new File(start);

        if (!root.exists()) {
            System.out.println("Path does not exist.");
        } else {
            find(root, filename);
        }

        sc.close();
    }
}