import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class countSubArraysSumEqualsK {
    private static int countSubArrays(int nums[], int k) {

        int n = nums.length, sum = 0, count = 0;

        // HashMap<Integer, Integer> mpp = new HashMap<>();
        // int sum = 0, count = 0;
        // for (int i : nums) {
        // sum += i;
        // if(mpp.containsKey(mpp))
        // }

        // 1st solution: Time complexity: O(n)
        // int count = 0;
        // for (int i = 0; i < n; i++) {
        // sum = 0;
        // for (int j = i; j < n; j++) {
        // sum += nums[j];
        // if (sum == k)
        // count++;
        // }
        // }
        // return count;

        // 2nd solution: it only works for arrays having non-negative integers and k
        // value > 0
        // as it is failing the testcase for nums = [1] and k = 0
        // so this solution is rejected

        // int i = 0, j = 0;

        // while (j < n) {
        // sum += nums[j];
        // if (sum == k) {
        // count++;
        // sum -= nums[i];
        // i++;
        // }

        // else if (sum > k) {
        // sum -= nums[i];
        // i++;
        // if (sum == k) {
        // count++;
        // }
        // }
        // j++;

        // }

        // return count;

        // 3rd solution or 2nd Solution:
        // Time Complexity: O(n)
        // space complexity: O(n)

        HashMap<Integer, Integer> mpp = new HashMap<>();

        mpp.put(sum, 1);

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            int rem = sum - k;

            if (mpp.containsKey(rem)) {
                int val = mpp.getOrDefault(rem, 0);
                count += val;
            }

            mpp.put(sum, mpp.getOrDefault(sum, 0) + 1);

        }
        return count;

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

        // Call countSubArrays with arr and k
        int count = countSubArrays(arr, k);

        System.out.println("Number of subarrays: " + count);
        sc.close();
    }

}
