import java.util.Arrays;
import java.util.Scanner;

public class upperBound {

    /**
     * The function `findUpperBound` returns the index of the first element in a
     * sorted array that is
     * greater than a given value x.
     * 
     * @param arr The `arr` parameter is an array of integers that is sorted in
     *            non-decreasing order.
     * @param x   It seems like you were about to provide the value of parameter x
     *            for the
     *            `findUpperBound` method. Please go ahead and provide the value of
     *            x so that I can assist you
     *            further with the code.
     * @return The `findUpperBound` method returns the index of the last occurrence
     *         of an element less
     *         than or equal to the given value `x` in the input array `arr`.
     */

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
