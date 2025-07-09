import java.util.Scanner;

public class nLetterTraingle {
    void nLetterTriangle(int n) {
        for (int row = 0; row < n; row++) {

            // This loop prints characters in each row.

            // It starts from 'A'.

            // And it runs until 'A' + row.

            // For example, if row = 2, the loop runs from 'A' to 'C' (i.e., A, B, C).
            for (char ch = 'A'; ch <= 'A' + row; ch++) {
                System.out.print(ch);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();
        new nLetterTraingle().nLetterTriangle(n);
        sc.close();
    }
}
