import java.util.Scanner;

public class repeatedAlphabetTriangle {
    public static void alphaRamp(int n) {
        for (int row = 0; row < n; row++) {

            for (int col = 0; col < row + 1; col++) {
                System.out.print((char) ('A' + row));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();
        alphaRamp(n);
        sc.close();
    }
}
