import java.util.Scanner;

public class findSingleElement {
    private static int findSingleNumber(int[] nums) {
        int singleNumber = 0;

        // using xor operation all elements which are present twice will cancel each
        // other out
        // and the single element will remain

        for (int num : nums) {
            singleNumber ^= num;
        }

        return singleNumber;
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

        int answer = findSingleNumber(arr);
        System.out.println("answer : " + answer);
        sc.close();
    }
}
