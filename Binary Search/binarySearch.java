import java.util.Arrays;
import java.util.Scanner;

public class binarySearch {
    private static int performBinarySearch(int arr[], int ele) {
        int start = 0, end = arr.length - 1;
        // Arrays.sort(arr);

        while (start < end) {
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
