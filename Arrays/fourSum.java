import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class fourSum {

    /**
     * Given an integer array arr, return all the unique quads [arr[a], arr[b],
     * arr[c]] + arr[d]] thats sums up to a target value.
     * 
     * 
     * @param arr Array of integers
     * 
     * @return an arrayList of list of Integers containing all the quad whose sum
     *         is equal to given target sum
     * 
     * 
     *         Input: arr = [4,3,3,4,4,2,1,2,1,1], target = 9
     *         Output: [[1,1,3,4],[1,2,2,4],[1,2,3,3]]
     */

    private static void findFourSum(int[] arr, int target, List<ArrayList<Integer>> result) {
        int n = arr.length;

        // Sort the array
        java.util.Arrays.sort(arr);

        // 1st solution using brute force:
        // Time Complexity: O(n^4)
        // Space Complexity: O(1) as we are storing the triplets in a result arraylist
        // which is required by the interviewer to store and display the result yuo can
        // print it also if no return is provided
        // for (int i = 0; i < n; i++) {
        // for (int j = i + 1; j < n; j++) {
        // for (int k = j + 1; k < n; k++) {
        // for (int l = k + 1; l < n; l++) {
        // int sum = arr[i] + arr[j] + arr[k] + arr[l];
        // if (sum == target) {
        // List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k], arr[l]);
        // Collections.sort(temp);

        // if (!result.contains(temp)) {
        // ArrayList<Integer> quad = new ArrayList<>(temp);
        // result.add(quad);
        // }
        // }
        // }
        // }
        // }
        // }

        // 2nd Solution: Using two pointers

        for (int i = 0; i < n - 2; i++) {
            // Skip duplicates
            if (i > 0 && arr[i] == arr[i - 1])
                continue;
            for (int j = i + 1; j < n - 1; j++) {

                if (j > i + 1 && arr[j] == arr[j - 1])
                    continue;
                int left = j + 1;
                int right = n - 1;
                while (left < right) {
                    long sum = (long) arr[i] + arr[j] + arr[left] + arr[right];

                    if (sum == target) {
                        ArrayList<Integer> triplet = new ArrayList<>();
                        triplet.add(arr[i]);
                        triplet.add(arr[left]);
                        triplet.add(arr[right]);
                        triplet.add(arr[j]);
                        Collections.sort(triplet);
                        if (!result.contains(triplet))
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

        List<ArrayList<Integer>> result = new ArrayList<>();

        // Call countSubArrays with arr and k
        findFourSum(arr, k, result);

        System.out.println("answer : " + result);
        sc.close();
    }
}
