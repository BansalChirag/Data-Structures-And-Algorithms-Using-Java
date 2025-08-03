import java.util.Arrays;
import java.util.Scanner;

public class nextPermutation {

    // Problem Statement: Given an array Arr[] of integers, rearrange the numbers of
    // the given array into the lexicographically next greater permutation of
    // numbers.

    // If such an arrangement is not possible, it must rearrange to the lowest
    // possible order (i.e., sorted in ascending order).

    // Examples
    // Example 1 :

    // Input format: Arr[] = {1,3,2}
    // Output: Arr[] = {2,1,3}
    // Explanation: All permutations of {1,2,3} are {{1,2,3} , {1,3,2}, {2,13} ,
    // {2,3,1} , {3,1,2} , {3,2,1}}. So, the next permutation just after {1,3,2} is
    // {2,1,3}.
    // Example 2:

    // Input format: Arr[] = {3,2,1}
    // Output: Arr[] = {1,2,3}
    // Explanation: As we see all permutations of {1,2,3}, we find {3,2,1} at the
    // last position. So, we have to return the topmost permutation.

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    private static void findNextPermutation(int nums[]) {
        // 1st solution: Step 1: Find all possible permutations of elements present and
        // store them.

        // Step 2: Search input from all possible permutations.

        // Step 3: Print the next permutation present right after it.

        // 2nd solution:

        int n = nums.length;
        int idx = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                idx = i;
                break;
            }
        }
        if (idx == -1) {
            // If no such index found, it means the array is in descending order
            // Reverse the entire array to get the smallest permutation
            reverse(nums, 0, n - 1);

            return;
        }

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] > nums[idx]) {
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;
                break;
            }
        }
        // revrse the remaining elements after idx
        int left = idx + 1, right = n - 1;
        reverse(nums, left, right);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read array input
        System.out.print("Enter elements separated by spaces: ");
        int[] arr = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        findNextPermutation(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }

        System.out.println();

        sc.close();
    }
}
