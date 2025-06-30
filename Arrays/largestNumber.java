import java.util.Scanner;

class largestNumber {
    private static int findLargetNumber(int arr[], int size) {
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < size; i++) {
            if (ans < arr[i])
                ans = arr[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int answer = findLargetNumber(arr, n);
        System.out.println("answer : " + answer);
        sc.close();
    }
}