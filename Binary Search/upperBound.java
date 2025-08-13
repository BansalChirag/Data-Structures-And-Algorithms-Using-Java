import java.util.Arrays;
import java.util.Scanner;

public class upperBound {

    // finding smallest element which is greater than x
    private static int findUpperBound(int arr[], int x) {
        int start = 0, n = arr.length, end = n - 1, ans = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int element = arr[mid];
            if (element <= x) {

                start = mid + 1;
            } else {
                ans = mid;
                end = mid - 1;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read array input
        System.out.print("Enter elements separated by spaces: ");
        int[] arr = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print("Enter the element you need to find : ");
        int ele = sc.nextInt();

        int ans = findUpperBound(arr, ele);
        if (ans == -1) {
            System.out.println("Element does not exist");
        } else {
            System.out.println("Element exist at : " + ans);
        }
        sc.close();
    }
}
