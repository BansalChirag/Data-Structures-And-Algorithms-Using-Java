import java.util.Arrays;
import java.util.Scanner;

public class majorityElement {

    /**
     * Given an array nums of size n, return the majority element.
     * The majority element is the element that appears more than ⌊n / 2⌋ times. You
     * may assume that the majority element always exists in the array.
     * 
     * 
     * @param nums Array of integers
     * 
     * @return Integer containing the value of the element which appears more than
     *         N/2 times
     */

    // 1st solution: counting each occurence of an element using linear search
    // and then comparing whether the size is more than N/2 or not

    // Space complexity is O(1) and Time complexity is O(n^2) [O(n) for first loop
    // and O(n) for second loop]

    // private static int countOccurences(int[] nums, int ele) {
    // int count = 0;
    // for (int n : nums) {
    // if (n == ele) {
    // count++;
    // }
    // }
    // return count;
    // }

    // private static int findMajorityElement(int[] nums) {
    // int size = nums.length;
    // for (int i = 0; i < size; i++) {

    // int cnt = countOccurences(nums, nums[1]);
    // System.out.println("cnt : " + cnt);
    // if (cnt > Math.ceil(size / 2)) {
    // return nums[1];

    // }
    // }
    // return -1;
    // }

    // 2nd Solution: using hashing
    // Time complexity: O(n) + O(n) + O(k) -> O(n+k) where k is the maximum value
    // present in the array
    // Space complexity: O(k)

    // private static int findMajorityElement(int nums[]) {
    // int max = Integer.MIN_VALUE, size = nums.length;
    // for (int num : nums) {
    // if (num > max) {
    // max = num;
    // }
    // }

    // // Create a frequency array of size max + 1
    // int[] frequency = new int[max + 1];

    // // Count occurrences of each element
    // for (int num : nums) {
    // frequency[num]++;
    // }

    // for (int i = 0; i < frequency.length; i++) {
    // if (frequency[i] > size / 2) {
    // return i; // Return the majority element
    // }
    // }

    // return -1;
    // }

    // 3rd Solution : Optimal Approach:

    private static int findMajorityElement(int nums[]) {
        // int max = Integer.MIN_VALUE, size = nums.length;
        // for (int num : nums) {
        // if (num > max) {
        // max = num;
        // }
        // }

        // // Create a frequency array of size max + 1
        // int[] frequency = new int[max + 1];

        // // Count occurrences of each element
        // for (int num : nums) {
        // frequency[num]++;
        // }

        // for (int i = 0; i < frequency.length; i++) {
        // if (frequency[i] > size / 2) {
        // return i; // Return the majority element
        // }
        // }

        // return -1;

        int count = 0, ele = 0, size = nums.length;

        for (int i = 0; i < size; i++) {
            int currEle = nums[i];
            if (count == 0) {
                count = 1;
                ele = nums[i];
            } else if (ele == currEle) {
                count++;
            } else if (ele != currEle) {
                count--;
            }
        }
        System.out.print("count : " + count);
        if (count > Math.ceil(size / 2))
            return count;
        return -1;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // System.out.print("Enter the size of the array: ");
        // int n = sc.nextInt();
        // int arr[] = new int[n];

        // first way of taking input
        // System.out.print("Enter elements of the array: ");
        // for (int i = 0; i < n; i++) {
        // arr[i] = sc.nextInt();
        // }

        // for seond way
        // sc.nextLine(); // ✅ Consume leftover newline

        // System.out.print("Enter " + n + " elements separated by spaces: ");
        // String[] input = sc.nextLine().split(" ");

        // for (int i = 0; i < n; i++) {
        // arr[i] = Integer.parseInt(input[i]);
        // }

        // 3rd way of taking input:
        System.out.print("Enter elements separated by spaces: ");
        // sc.nextLine(); // ✅ Consume leftover newline
        int[] arr = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int answer = findMajorityElement(arr);
        if (answer != -1) {
            System.out.println("Majority element is: " + answer);
        } else {
            System.out.println("No majority element found!");
        }
        System.out.println();
        sc.close();
    }
}
