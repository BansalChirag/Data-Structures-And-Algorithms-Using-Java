import java.util.Scanner;

public class RotateArray {

    private static void reverseArray(int arr[], int start, int end) {
        while (start < end) {

            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    private static void rotateArrayByK(int arr[], int size, int k) {

        // rotate the array by k positions

        // solution is to reverse the first k elements and then reverse the rest of the
        // array
        // and then reverse the whole array

        // edge cases
        // if the array is empty or k is 0 or k is a multiple of size, no rotation is
        // needed
        if (size == 0 || k == 0 || k % size == 0) {
            return;
        }

        k = k % size; // handle cases where k is greater than size
        reverseArray(arr, 0, size - 1); // reverse the whole array
        reverseArray(arr, 0, k - 1); // reverse first k elements

        reverseArray(arr, k, size - 1); // reverse the rest of the array

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter the value of K: ");
        int k = sc.nextInt();
        rotateArrayByK(arr, n, k);
        for (int i : arr) {
            System.out.print(i + " ");
        }

        System.out.println();
        sc.close();
    }
}
