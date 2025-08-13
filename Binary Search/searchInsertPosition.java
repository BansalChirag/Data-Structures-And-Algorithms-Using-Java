import java.util.Arrays;
import java.util.Scanner;

public class searchInsertPosition {

    /**
     * @return The method `searchInsert` is expected to return an integer value
     *         which represents the
     *         index where the `target` should be inserted in the given sorted array
     *         `arr` and if the target element is already present just return the
     *         index
     *         where it is present.
     */

    private static int searchInsert(int[] arr, int target) {
        return lowerBound.findLowerBound(arr, target);

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

        int ans = searchInsert(arr, ele);
        if (arr[ans] == ele && ans != arr.length) {

            System.out.println("Element already present at index : " + ans);
        } else {
            System.out.println("Element should be inserted at index : " + ans);
        }

        sc.close();
    }
}
