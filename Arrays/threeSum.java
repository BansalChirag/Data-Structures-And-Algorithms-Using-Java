import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class threeSum {

    /**
     * Given an integer array nums, return all the triplets [nums[i], nums[j],
     * nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] +
     * nums[k] == 0.
     * 
     * 
     * @param nums Array of integers
     * 
     * @return an arrayList of list of Integers containing all the tiplets whose sum
     *         is equal to given target sum or 0
     * 
     * 
     *         Input: nums = [-1,0,1,2,-1,-4]
     *         Output: [[-1,-1,2],[-1,0,1]]
     *         Explanation:
     *         nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
     *         nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
     *         nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
     *         The distinct triplets are [-1,0,1] and [-1,-1,2].
     *         Notice that the order of the output and the order of the triplets
     *         does not
     *         matter.
     */

    private static void findThreeSum(int[] arr, int target, ArrayList<ArrayList<Integer>> result) {
        int n = arr.length;

        // Sort the array
        java.util.Arrays.sort(arr);

        // 1st solution using brute force:
        // Time Complexity: O(n^3)
        // Space Complexity: O(1) as we are storing the triplets in a result arraylist
        // which is required by the interviewer to store and display the result yuo can
        // print it also if no return is provided

        // for (int i = 0; i < n - 2; i++) {
        // for (int j = i + 1; j < n - 1; j++) {
        // for (int k = j + 1; k < n; k++) {
        // ArrayList<Integer> triplet = new ArrayList<>();
        // if (arr[i] + arr[j] + arr[k] == target) {
        // triplet.add(arr[i]);
        // triplet.add(arr[j]);
        // triplet.add(arr[k]);
        // }
        // if (triplet.size() > 0 && !result.contains(triplet))
        // result.add(triplet);
        // }
        // }
        // }

        // 2nd Solution: Using two pointers

        for (int i = 0; i < n - 2; i++) {
            // Skip duplicates
            if (i > 0 && arr[i] == arr[i - 1])
                continue;

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                if (sum == target) {
                    ArrayList<Integer> triplet = new ArrayList<>();
                    triplet.add(arr[i]);
                    triplet.add(arr[left]);
                    triplet.add(arr[right]);
                    result.add(triplet);
                    left++;
                    right--;

                    // Skip duplicates
                    while (left < right && arr[left] == arr[left - 1])
                        left++;
                    while (left < right && arr[right] == arr[right + 1])
                        right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read array input
        System.out.print("Enter elements separated by spaces: ");
        int[] arr = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // Read the value of k
        System.out.print("Enter value of k: ");
        int k = sc.nextInt();

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        // Call countSubArrays with arr and k
        findThreeSum(arr, k, result);

        System.out.println("answer : " + result);
        sc.close();
    }
}