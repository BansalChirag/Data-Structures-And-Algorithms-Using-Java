import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class countSubArraysWithXORsumK {
    private static int countSubArrays(int nums[], int k) {
        int n = nums.length, count = 0;

        // 1st solution: Time Complexity: O(N^2)

        // for (int i = 0; i < n; i++) {
        // int xorSum = 0;
        // for (int j = i; j < n; j++) {
        // xorSum ^= nums[j];
        // if (xorSum == k)
        // count++;
        // }

        // }

        // 2nd solution: Using Hashing

        // Time Complexity: O(N)
        // Space Complexity: O(N)

        int xorSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(xorSum, 1); // To handle the case when the subarray starts from index 0

        for (int i = 0; i < n; i++) {

            xorSum ^= nums[i];

            if (map.containsKey(xorSum ^ k)) {
                int val = map.getOrDefault(xorSum ^ k, 0);
                count += val;
            }

            map.put(xorSum, map.getOrDefault(xorSum, 0) + 1);

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

        System.out.print("Enter value of k : ");
        int k = sc.nextInt();

        int total_subArrays = countSubArrays(arr, k);
        System.out.println("Total subarrays with XOR sum equal to " + k + " is: " + total_subArrays);
        sc.close();
    }
}
