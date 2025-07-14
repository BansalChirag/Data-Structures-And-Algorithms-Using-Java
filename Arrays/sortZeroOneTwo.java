import java.util.Scanner;

public class sortZeroOneTwo {

    /**
     * Sorts an array consisting only of 0s, 1s, and 2s in ascending order.
     * 
     * @param arr Array of integers containing only 0s, 1s, and 2s
     */

    private static void sort012(int arr[]) {

        // 1st solution will be to sort the array using any sorting algo (quick
        // sort,merge sort, selection sort,insertion sort,bubble sort)

        // Time Complexity: O(N*logN)

        // Space Complexity: O(1)

        // 2nd Solution : maintaining the count of variables

        // int count_0 = 0, count_1 = 0, count_2 = 0;
        // for (int i : arr) {
        // if (i == 0)
        // count_0++;
        // else if (i == 1)
        // count_1++;
        // else
        // count_2++;
        // }

        // for (int i = 0; i < arr.length; i++) {
        // if (count_0 > 0) {
        // arr[i] = 0;
        // count_0--;
        // }

        // else if (count_1 > 0) {
        // arr[i] = 1;
        // count_1--;
        // } else {
        // arr[i] = 2;
        // count_2--;
        // }

        // }

        // Time Complexity: O(N) + O(N), where N = size of the array. First O(N) for
        // counting the number of 0’s, 1’s, 2’s, and second O(N) for placing them
        // correctly in the original array.

        // Space Complexity: O(1) as we are not using any extra space.

        // 3rd Solution: DNF sort
        int start = 0, end = arr.length - 1, mid = 0;
        while (start < end) {
            if (arr[mid] == 1) {
                start++;
                mid++;
                end--;
            } else if (arr[mid] == 0) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                mid++;
                end--;

            } else {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.print("Enter elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        sort012(arr);
        for (int i : arr) {
            System.out.print(i);
        }
        System.out.println();
        sc.close();
    }
}
