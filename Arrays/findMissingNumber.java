import java.util.Scanner;

public class findMissingNumber {
    private static int missingNumber(int[] nums, int N) {

        // 1st solution

        // time complexity : O(N^2)
        // for (int i = 1; i <= N; i++) {
        // int flag = 0;
        // for (int j = 0; j < N; j++) {
        // if (nums[j] == i) {
        // flag = 1;
        // break;
        // }
        // }
        // if (flag == 0)
        // return i;
        // }

        // return -1;

        // 2nd solution

        // time complexity : O(2*N)
        // space complexity
        // for (int i = 1; i <= N; i++) {
        // int flag = 0;
        // for (int j = 0; j < N; j++) {
        // if (nums[j] == i) {
        // flag = 1;
        // break;
        // }
        // }
        // if (flag == 0)
        // return i;
        // }

        // return -1;

        // 2nd solution using hashing

        // int[] hash = new int[N + 1];
        // for (int i = 0; i < nums.length; i++) {
        // hash[nums[i]]++;
        // }
        // for (int i = 0; i < hash.length; i++) {
        // if (hash[i] == 0)
        // return i;
        // }

        // 3rd solution
        // int sum = 0;
        // for (int i = 0; i < nums.length; i++) {
        // sum += nums[i];
        // }
        // int expectedSum = (N * (N + 1)) / 2;

        // return expectedSum - sum;

        // 4th solution using XOR

        int xor1 = 0, xor2 = 0;
        for (int i = 0; i < nums.length; i++) {
            xor1 = xor1 ^ (i + 1);
            xor2 = xor2 ^ nums[i];
        }

        return xor1 ^ xor2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int answer = missingNumber(arr, n);
        System.out.println("answer : " + answer);
        sc.close();
    }
}
