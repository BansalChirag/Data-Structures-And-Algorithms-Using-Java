import java.util.Scanner;

public class moveZeroesToEnd {
    private static void moveZeroes(int[] arr, int size) {
        int i = 0, j = 0;
        while (i < size && j < size) {
            if (arr[j] != 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j++;
            } else {
                j++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        moveZeroes(arr, n);
        for (int i : arr) {
            System.out.println(i);
        }
        System.out.println();
        sc.close();
    }
}
