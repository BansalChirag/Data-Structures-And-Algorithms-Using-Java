import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class kadanesAlgo {
    /**
     * Given an array nums of size n, return the maximum subArray sum which exists
     * in the array and also print the array.
     * 
     * @param nums Array of integers
     * 
     * @return Integer containing the value of the element having maximum subArray
     *         sum
     */
    private static int maxSubArray(int[] nums) {

        int sum = 0, max_sum = Integer.MIN_VALUE, start_idx = 0, end_idx = 0;
        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];
            if (sum > max_sum) {
                end_idx = i;
                max_sum = sum;
            }
            if (sum < 0) {
                start_idx = i + 1;
                sum = 0;
            }

        }

        // for printing subArray with maxSum
        // just print the elements of array from start_idx to end_idx
        return max_sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read array input
        System.out.print("Enter elements separated by spaces: ");
        int[] arr = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int answer = maxSubArray(arr);
        System.out.println("Majority elements are: " + answer);

        sc.close();
    }
}
