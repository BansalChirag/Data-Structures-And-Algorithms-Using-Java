import java.util.Arrays;
import java.util.Scanner;

public class twoSumProblem {

    /**
     * Find two numbers in the array that add up to target and return their
     * indices.
     * 
     * @param nums   Array of integers
     * @param target Target sum
     * @return Array containing indices of the two numbers that sum to target
     */

    private static int[] twoSumIndices(int[] nums, int target) {

        IndexValue indexNums[] = new IndexValue[nums.length];

        for (int i = 0; i < indexNums.length; i++) {
            indexNums[i] = new IndexValue(nums[i], i);
        }

        Arrays.sort(indexNums, (a, b) -> Integer.compare(a.value, b.value));

        int left = 0;
        int right = indexNums.length - 1;

        while (left < right) {
            int currSum = indexNums[left].value + indexNums[right].value;
            if (currSum == target) {
                int idx1 = indexNums[left].index;
                int idx2 = indexNums[right].index;

                return new int[] { idx1, idx2 };
            }

            else if (currSum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[] {};
    }

    // Helper class to store value and its original index
    static class IndexValue {
        int value;
        int index;

        public IndexValue(int value, int index) {
            this.value = value;
            this.index = index;
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

        System.out.print("Enter value of k: ");
        int k = sc.nextInt();
        int answer[] = twoSumIndices(arr, k);
        if (answer.length > 0) {
            System.out.print("Element in array whose sum is equal to value of " + k + " are : ");
            for (int i : answer) {
                System.out.print(i + " ");
            }
        } else {
            System.out.println("Sum not found!");
        }
        System.out.println();
        sc.close();
    }
}