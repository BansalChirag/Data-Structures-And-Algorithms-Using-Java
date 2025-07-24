import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class leadersInAnArray {
    // Input: nums = [1, 2, 5, 3, 1, 2]

    // Output: [5, 3, 2]

    /**
     * Given an array nums of size n, return all the majority element.
     * A Leader is an element that is greater than all of the elements on its right
     * side in the array.     * 
     * 
     * 
     * @param nums Array of integers
     * 
     * @return an ArrayList containing all the leaders present in that given array
     */
    private static ArrayList<Integer> leaders(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = nums.length;
        ans.add(nums[n - 1]);
        int max_ele = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] >= max_ele) {
                max_ele = nums[i];
                ans.add(nums[i]);
            }
        }
        Collections.reverse(ans);
        return ans;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter elements separated by spaces: ");

        int[] arr = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayList<Integer> ans = leaders(arr);

        System.out.println(ans);
        sc.close();
    }
}
