import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class longestConsecutiveSubsequence {

    /*
     * Given an unsorted array of integers nums, return the length of the longest
     * consecutive elements sequence.
     * 
     * You must write an algorithm that runs in O(n) time.
     * 
     * Example 1:
     * 
     * Input: nums = [100,4,200,1,3,2]
     * Output: 4
     * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4].
     * Therefore its length is 4.
     * Example 2:
     * 
     * Input: nums = [0,3,7,2,5,8,4,6,0,1]
     * Output: 9
     * Example 3:
     * 
     * Input: nums = [1,0,1,2]
     * Output: 3
     * 
     */

    private static int findLongestConsecutiveSubsequence(int[] nums) {
        // 1st solution: Brute-force -> O(n^2)
        // int maxLength = 0;
        // for (int i = 0; i < nums.length; i++) {
        // int currentElement = nums[i];
        // int currentLength = 1;
        // int nextElement = currentElement + 1;
        // while (true) {
        // boolean found = false;

        // // Search for the next consecutive element
        // for (int j = 0; j < nums.length; j++) {
        // if (nums[j] == nextElement) {
        // currentLength++;
        // nextElement++;
        // found = true;
        // break;
        // }
        // }

        // if (!found) {
        // break;
        // }
        // }
        // }
        // System.out.println("Length of the longest consecutive subsequence is: " +
        // maxLength);

        // 2nd solution:
        // Time Complexity: O(NlogN) + O(N), N = size of the given array.
        // Reason: O(NlogN) for sorting the array. To find the longest sequence, we are
        // using a loop that results in O(N).

        // Space Complexity: O(1), as we are not using any extra space to solve this
        // problem.

        // Arrays.sort(nums);
        // int max_length = 0, min_ele = Integer.MIN_VALUE, curr_length = 1;
        // for (int i = 0; i < nums.length; i++) {
        // int currentElement = nums[i];

        // if (currentElement - 1 == min_ele) {
        // min_ele = currentElement;
        // curr_length++;
        // } else if (currentElement > min_ele) {
        // min_ele = currentElement;
        // curr_length = 1;
        // }
        // max_length = Math.max(max_length, curr_length);
        // }

        // return max_length;

        // 3rd solution:
        // Time Complexity : O(N), Space Complexity: O(N)

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int longestStreak = 0;

        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read array input
        System.out.print("Enter elements separated by spaces: ");
        int[] arr = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int max_length = findLongestConsecutiveSubsequence(arr);
        System.out.println("Length of the longest consecutive subsequence is : " + max_length);

        sc.close();
    }
}
