
// import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class reArrangeElementsBySign {
    private static int[] rearrangeArray(int[] nums) {

        // You are given a 0-indexed integer array nums of even length consisting of an
        // equal number of positive and negative integers.

        // You should return the array of nums such that the the array follows the given
        // conditions:

        // Every consecutive pair of integers have opposite signs.
        // For all integers with the same sign, the order in which they were present in
        // nums is preserved.
        // The rearranged array begins with a positive integer.
        // Return the modified array after rearranging the elements to satisfy the
        // aforementioned conditions.

        int n = nums.length;

        // 1st solution: Time Complexity: O(n) Space Complexity: O(n)
        // ArrayList<Integer> pos = new ArrayList<>();
        // ArrayList<Integer> neg = new ArrayList<>();
        int ans[] = new int[n];
        // for (int k = 0; k < n; k++) {
        // if (nums[k] < 0) {
        // neg.add(nums[k]);
        // } else if (nums[k] >= 0) {
        // pos.add(nums[k]);
        // }

        // }
        // int n1 = pos.size(), n2 = neg.size();

        // int k = 0, i = 0, j = 0;

        // while (i < n1 && j < n2) {

        // if (k % 2 != 0) {
        // ans[k] = neg.get(j);
        // j++;
        // } else {
        // ans[k] = pos.get(i);
        // i++;
        // }

        // k++;
        // }

        // while (i < n1) {
        // ans[k] = pos.get(i);
        // i++;
        // k++;
        // }

        // while (j < n2) {
        // ans[k] = neg.get(j);
        // j++;
        // k++;
        // }

        // 2nd Solution: Time Complexity: O(n), Space complexity: O(1)
        int negIdx = 1, posIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                ans[negIdx] = nums[i];
                negIdx += 2;
            } else {
                ans[posIdx] = nums[i];
                posIdx += 2;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter elements separated by spaces: ");

        int[] arr = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int ans[] = rearrangeArray(arr);
        for (int i : ans) {
            System.out.print(i + " ");
        }
        System.out.println();
        sc.close();
    }
}
