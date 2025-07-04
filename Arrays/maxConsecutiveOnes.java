import java.util.Scanner;

public class maxConsecutiveOnes {

    private int findMaxConsecutiveOnes(int[] nums) {
        int i = 0, j = 0, n = nums.length, count = 0;
        while (i < n && j < n) {
            if (nums[j] == 0) {
                j++;
                i = j;
            } else {
                if (count < j - i + 1) {
                    count = j - i + 1;
                }
                j++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int answer = new maxConsecutiveOnes().findMaxConsecutiveOnes(arr);
        System.out.println("answer : " + answer);
        sc.close();

    }
}
