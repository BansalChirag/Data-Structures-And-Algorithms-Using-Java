import java.util.Scanner;

public class symettericVoidPattern2 {

    private static void printSymettericVoid2(int n) {

        for (int row = 0; row < n - 1; row++) {
            for (int col = 0; col < row + 1; col++) {
                System.out.print("*");
            }
            for (int space = 0; space < 2 * (n - row - 1); space++) {
                System.out.print(" ");
            }
            for (int col = 0; col < row + 1; col++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < (n) - row; col++) {
                System.out.print("*");
            }
            for (int space = 0; space < 2 * row; space++) {
                System.out.print(" ");
            }
            for (int col = 0; col < (n) - row; col++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();
        printSymettericVoid2(n);
        sc.close();
    }
}
