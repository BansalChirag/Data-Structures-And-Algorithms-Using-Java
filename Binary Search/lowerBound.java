import java.util.Arrays;
import java.util.Scanner;

public class lowerBound {

    /**
     * The function `findLowerBound` returns the index of the first element in a
     * sorted array that is
     * greater than or equal to a given value x.
     * 
     * @param arr The `arr` parameter is an integer array that is sorted in
     *            non-decreasing order.
     * @param x   X is the target value that we want to find the lower bound for in
     *            the given sorted
     *            array. The function `findLowerBound` uses binary search to find
     *            the index of the first element
     *            in the array that is greater than or equal to the target value x.
     * @return The `findLowerBound` method returns the index of the first element in
     *         the array `arr`
     *         that is greater than or equal to the value `x`.
     */
    private static int findLowerBound(int arr[], int x) {
        int start = 0, n = arr.length, end = n - 1, ans = n;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int element = arr[mid];
            if (element < x) {
                start = mid + 1;
            } else if (element >= x) {

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

        System.out.print("Enter the element to find its lower bound : ");
        int ele = sc.nextInt();

        int ans = findLowerBound(arr, ele);

        System.out.println("Lower bound of the elemenet is : " + ans);

        sc.close();
    }
}
