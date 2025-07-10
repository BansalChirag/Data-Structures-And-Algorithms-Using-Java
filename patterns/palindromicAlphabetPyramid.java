import java.util.Scanner;

// Input Format: N = 3
// Result: 
//   A  
//  ABA 
// ABCBA

public class palindromicAlphabetPyramid {
    private static void printAlhaHill(int n) {
        for (int row = 0; row < n; row++) {

            // if you are getting confused by imagining the characters, just imagine them in
            // the number form
            // Input Format: N = 3
            // Result:
            // 1
            // 121
            // 12321

            // here is the solution for the above

            // for (int space = 0; space < n-row; space++) {
            // System.out.print(" ");
            // }

            // for (int col = 0; col < row+1; col++) {
            // System.out.print(col + 1);
            // }
            // for (int col = row; col > 0; col--) {
            // System.out.print(col);
            // }
            // System.out.println();

            // now try to convert it to char

            for (int space = 0; space < n - row; space++) {
                System.out.print(" ");
            }

            for (int col = 0; col < row + 1; col++) {
                System.out.print((char) ('A' + col));
            }
            for (int col = row; col > 0; col--) {
                System.out.print((char) ('A' + col - 1));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();
        printAlhaHill(n);
        sc.close();
    }
}
