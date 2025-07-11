import java.util.Scanner;

public class reversedNletterTriangle {
    void nLetterTriangle(int n) {
        for (int row = 0; row < n; row++) {

            for (char ch = 'A'; ch < ('A' + n - row); ch++) {
                System.out.print(ch);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();
        new reversedNletterTriangle().nLetterTriangle(n);
        sc.close();
    }
}
