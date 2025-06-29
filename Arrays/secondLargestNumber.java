import java.util.Scanner;

public class secondLargestNumber {

    private static int findSecondLargetNumber(int arr[], int size) {

        // first approach will be to sort the array and the element at second last index
        // will be the answer but it willl work only if there are no duplicates
        // and the time complexity will be O(NlogN) due to sorting of array

        // 2nd approch : first finding the highest element using first traversal and
        // then finding the 2nd element using 2nd traversal
        // Time Complexity : O(N)

        // int highest = Integer.MIN_VALUE;
        // int second_highest = Integer.MIN_VALUE;
        // if (size == 0 || size == 1)
        // return -1;

        // for (int i = 0; i < size; i++) {
        // if (highest < arr[i]) {
        // highest = arr[i];
        // }

        // }

        // for (int i = 0; i < size; i++) {
        // if (second_highest < arr[i] && arr[i] < highest) {
        // second_highest = arr[i];
        // }
        // }
        // if (second_highest == Integer.MIN_VALUE)
        // return -1;
        // return second_highest;

        // Best Solution:finding the second_highest in one traversal
        // Time complexity : O(N)

        int highest = Integer.MIN_VALUE;
        int second_highest = Integer.MIN_VALUE;

        if (size == 0 || size == 1)
            return -1;

        for (int i = 0; i < size; i++) {
            if (arr[i] > highest) {
                second_highest = highest;
                highest = arr[i];
            } else if (arr[i] > second_highest && arr[i] != highest) {
                second_highest = arr[i];
            }
        }
        if (second_highest == Integer.MIN_VALUE)
            return -1;

        return second_highest;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int answer = findSecondLargetNumber(arr, n);
        System.out.println("answer : " + answer);
        sc.close();
    }
}
