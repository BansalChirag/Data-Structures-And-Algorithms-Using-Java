import java.util.HashMap;
import java.util.Scanner;

public class largestSubarrayWithSumK {
    private static int longestSubarrayWithSumK(int[] arr, int k) {
        // int maxLength = 0;
        // int currentSum = 0;
        // int start = 0;

        // for (int end = 0; end < arr.length; end++) {
        // currentSum += arr[end];

        // while (currentSum > k && start <= end) {
        // currentSum -= arr[start];
        // start++;
        // }

        // if (currentSum == k) {
        // maxLength = Math.max(maxLength, end - start + 1);
        // }
        // }

        // return maxLength;

        // 1st solution using brute force
        // Time Complexity: O(n^2)
        // int n = arr.length, length = 0;
        // for (int i = 0; i < n; i++) {
        // int sum = 0;
        // for (int j = i; j < n; j++) {
        // sum += arr[j];
        // int len = j - i + 1;
        // if (sum == k && len > length) {
        // length = len;
        // }
        // }
        // }

        // 3rd solution using SLIDING WINDOW (it works only for positives if question
        // has given that array will have positives and zeroes only then it is the
        // optimal
        // approach)
        // Time Complexity: O(n)
        // space complexity: O(1)
        // int i = 0, j = 0, sum = 0, n = arr.length, length = 0;
        // while (i < n && j < n) {
        // sum += arr[j];
        // if (sum == k) {
        // length = Math.max(length, j - i + 1);
        // sum -= arr[i];
        // j++;
        // i++;
        // } else if (sum > k) {
        // sum -= arr[i];
        // i++;
        // } else {
        // j++;
        // }

        // }

        // return length;

        // solution 3: optimial solution in case there are negatives in an array
        // otherwise the 2nd solution is the most optimal one

        // Time Complexity: O(N) or O(N*logN) depending on which map data structure we
        // are using, where N = size of the array.
        // Reason: For example, if we are using an unordered_map data structure in C++
        // the time complexity will be O(N)(though in the worst case, unordered_map
        // takes O(N) to find an element and the time complexity becomes O(N2)) but if
        // we are using a map data structure, the time complexity will be O(N*logN). The
        // least complexity will be O(N) as we are using a loop to traverse the array.

        // Space Complexity: O(N) as a map data structure is used

        HashMap<Integer, Integer> mpp = new HashMap<>();
        int sum = 0, maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }

            int rem = sum - k;

            if (mpp.containsKey(rem)) {
                int len = i - mpp.get(rem);
                maxLen = Math.max(maxLen, len);
            }

            if (!mpp.containsKey(sum)) {
                mpp.put(sum, i);
            }
        }
        return maxLen;
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
        int answer = longestSubarrayWithSumK(arr, k);
        System.out.println("answer : " + answer);
        sc.close();
    }
}
