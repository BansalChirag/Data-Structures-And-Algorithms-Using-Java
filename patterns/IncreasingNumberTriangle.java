import java.util.Scanner;

public class IncreasingNumberTriangle {

    public static void nNumberTriangle(int rows) {
        int number = 1;
        for (int row = 1; row <= rows; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(number + " ");
                number++;
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();
        nNumberTriangle(n);
        sc.close();
    }
}
