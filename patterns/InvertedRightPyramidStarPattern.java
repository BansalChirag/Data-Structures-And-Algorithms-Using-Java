import java.util.Scanner;

public class InvertedRightPyramidStarPattern {

    void invertedRightPyramid(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = n - i; j > 0; j--) {
                System.out.print('*');
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();
        new InvertedRightPyramidStarPattern().invertedRightPyramid(n);
        sc.close();
    }
}
