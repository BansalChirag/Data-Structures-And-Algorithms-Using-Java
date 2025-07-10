import java.util.Scanner;

public class hollowPattern {

    private static void printHollow(int n) {
        for (int row = 0; row < n; row++) {

            for (int col = 0; col < n; col++) {
                if(row==0 || row==n-1 || col==0 || col==n-1 ) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
                
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();
        printHollow(n);
        sc.close();
    }
}
