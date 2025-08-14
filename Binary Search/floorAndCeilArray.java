import java.util.Arrays;
import java.util.Scanner;

public class floorAndCeilArray {

    private static void findFloor(int arr[], int x) {

        int start = 0, n = arr.length, end = n - 1, ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int ele = arr[mid];
            if (ele == x) {
                ans = mid;
                break;
            } else if (ele > x) {
                end = mid - 1;

            } else {
                ans = mid;
                start = mid + 1;
            }
        }

        System.out.println("Floor of the element " + x + " is : " + arr[ans]);

    }

    private static void findCeil(int arr[], int x) {
        int ans = lowerBound.findLowerBound(arr, x);
        System.out.println("Ceil of the element " + x + " is : " + arr[ans]);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read array input
        System.out.print("Enter elements separated by spaces: ");
        int[] arr = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print("Enter the element  : ");
        int ele = sc.nextInt();

        findFloor(arr, ele);

        findCeil(arr, ele);

        sc.close();
    }
}
