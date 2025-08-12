import java.util.Arrays;
import java.util.Scanner;

public class binarySearch {
    /**
     * The function `performBinarySearch` implements a binary search algorithm to
     * find the index of a
     * given element in a sorted array.
     * 
     * @param arr The `arr` parameter is an array of integers that you want to
     *            perform a binary search
     *            on. The elements in the array should be sorted in ascending order
     *            for the binary search
     *            algorithm to work correctly.
     * @param ele The `ele` parameter in the `performBinarySearch` method represents
     *            the element that
     *            you are searching for within the given array `arr`. The method
     *            uses binary search to find the
     *            index of this element in the array. If the element is found, the
     *            method returns the index of the
     *            element in the
     * @return The method `performBinarySearch` returns the index of the element
     *         `ele` in the sorted
     *         array `arr` if it is found, otherwise it returns -1.
     */
    private static int performBinarySearch(int arr[], int ele) {
        int start = 0, end = arr.length - 1;
        // Arrays.sort(arr);

        while (start <= end) {
            int mid = start + (end - start) / 2;

            int element = arr[mid];

            if (ele == element) {
                return mid;
            } else if (ele > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }
        return -1;
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

        int ans = performBinarySearch(arr, ele);
        if (ans == -1) {
            System.out.println("Element does not exist");
        } else {
            System.out.println("Element exist at : " + ans);
        }
        sc.close();

    }
}
