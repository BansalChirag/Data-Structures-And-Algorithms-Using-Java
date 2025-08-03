import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class majorityElement2 {

    /**
     * Given an array nums of size n, return all the majority elements.
     * The majority element is the element that appears more than ⌊n / 3⌋ (floor)
     * times. if
     * no majority element exists return an empty list.
     * 
     * 
     * @param nums Array of integers
     * 
     * @return Integer containing the value of the element which appears more than
     *         N/2 times
     */

    private static List<Integer> findMajorityElement2(int[] nums) {

        // will be solving the question using Boyer-Moore Voting Algorithm (same as
        // majoprity element for [n/2] times)
        // Time Complexity: O(n)
        // Space Complexity: O(1)

        // First check how many majority elements can exist in an array of size n
        // does not matter what is the value of n it will be always be at max 2
        // example : n=20
        // floor of n/3 is 6 so means find elements which have appeare in the array more
        // than 6 times, let's say 7 times , even if you take 2 elements which appear
        // more than 6 times(7 in this case) that would be 14 elements, so you are left
        // with 6 elements only, so you see there can be at max 2 elements which are
        // greater than [n/3] times

        List<Integer> result = new ArrayList<>();

        int count1 = 0, count2 = 0, candidate1 = Integer.MIN_VALUE, candidate2 = Integer.MIN_VALUE; // not taken 0 as
                                                                                                    // for the case of
                                                                                                    // [0,0,0]

        for (int i = 0; i < nums.length; i++) {
            int currEle = nums[i];
            if (count1 == 0 && currEle != candidate2) {
                count1++;
                candidate1 = currEle;
            }

            else if (count2 == 0 && currEle != candidate1) {
                count2++;
                candidate2 = currEle;
            } else if (candidate1 == currEle) {
                count1++;
            } else if (candidate2 == currEle) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;

        for (Integer ele : nums) {
            if (candidate1 == ele)
                count1++;
            if (candidate2 == ele)
                count2++;
        }
        if (count1 > Math.floor(nums.length / 3))
            result.add(candidate1);
        if (count2 > Math.floor(nums.length / 3))
            result.add(candidate2);
        System.out.println("result arr : " + result);
        if (result.size() == 2 && result.get(0) == result.get(1)) {
            result.remove(result.size() - 1);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read array input
        System.out.print("Enter elements separated by spaces: ");
        int[] arr = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        List<Integer> answer = findMajorityElement2(arr);
        System.out.println("Majority elements are: " + answer);

        sc.close();
    }
}
