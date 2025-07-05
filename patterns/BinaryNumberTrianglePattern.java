import java.util.Scanner;

public class BinaryNumberTrianglePattern {
    public static void nBinaryTriangle(int n) {
        for (int rows = 0; rows < n; rows++) {

            for (int col = 0; col < rows + 1; col++) {
                System.out.print((rows + col) % 2 == 0 ? 1 + " " : 0 + " ");
            }

            System.out.println();
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();
        nBinaryTriangle(n);
        sc.close();
    }
}
