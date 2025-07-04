import java.util.Scanner;

public class removeDuplicatesFromArray {
    private static int removeDuplicates(int arr[], int size) {
        int i = 0, j = 1;
        while (i < size && j < size) {
            if (arr[i] != arr[j]) {
                arr[i + 1] = arr[j];
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int answer = removeDuplicates(arr, n);
        System.out.println("answer : " + answer);
        sc.close();
    }
}
