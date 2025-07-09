import java.util.Scanner;

public class NumberCrown {

    public static void numberCrown(int n) {

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < row + 1; col++) {
                System.out.print(col + 1);
            }
            for (int space = 0; space < 2 * (n - row - 1); space++) {
                System.out.print(' ');
            }

            for (int col = row; col >= 0; col--) {
                System.out.print(col + 1);
            }
            System.out.println();

        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();
        numberCrown(n);
        sc.close();
    }
}
