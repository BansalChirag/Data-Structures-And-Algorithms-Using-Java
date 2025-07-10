import java.util.Scanner;

public class reverseAlphabetTriangle {
    private static void printAlphaTriangle(int n) {

        // Input Format: N = 5
        // Result:
        // ABCDE
        // ABCD
        // ABC
        // AB
        // A

        // converting this into number format will make it easy

        for (int row = n; row > 0; row--) {
            for (int col = 0; col < n - row + 1; col++) {
                System.out.print((char) (row + col + 'A' - 1));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();
        printAlphaTriangle(n);
        sc.close();
    }
}
