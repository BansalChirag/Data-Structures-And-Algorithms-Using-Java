import java.util.Scanner;

public class RotateMatrix {

    // You are given an n x n 2D matrix representing an image, rotate the image by
    // 90 degrees (clockwise).

    // You have to rotate the image in-place, which means you have to modify the
    // input 2D matrix directly. DO NOT allocate another 2D matrix and do the
    // rotation

    // two types of rotation are there :
    // 1. In place Rotation (Uses Transpose + Reverse)
    // ✅ Efficient in memory
    // ❌ Only works for square matrices

    // Steps:

    // Transpose the matrix (swap rows and columns)

    // Reverse rows (for clockwise) or columns (for anticlockwise)

    // 2.New matrix construction

    // Works for any rectangular matrix
    // ❌ Uses additional memory

    // Steps:

    // Build a new matrix from scratch by placing elements directly into their
    // rotated positions.

    // normal function to rotate the matrix 90 degree clockwise (in-place rotation)

    private static void rotateMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        transposeMatrix(matrix);
        for (int i = 0; i < rows; i++) {
            for (int j = cols - 1; j >= cols / 2; j--) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][cols - j - 1];
                matrix[i][cols - j - 1] = temp;

            }
        }
    }

    // new matrix construction method to rotate the matrix without transpose
    // required
    private static void rotateMatrix(int[][] matrix, int angle, String direction) {

        angle = angle % 360;

        // no need to rotate the matrix if the angle is 0 (for case 0 and 360)as the
        // output will be same
        // even if you rotate it

        if (angle == 0)
            return;

        // Convert anticlockwise to equivalent clockwise rotation
        if (direction.equalsIgnoreCase("anticlockwise")) {
            angle = (360 - angle) % 360;
        }

        int times = angle / 90;

        for (int i = 0; i < times; i++) {
            matrix = rotate90Clockwise(matrix);
        }
        printMatrix(matrix);

    }

    private static int[][] rotate90Clockwise(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] rotated = new int[m][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rotated[j][n - 1 - i] = matrix[i][j];
            }
        }

        return rotated;
    }

    // method to transpose the matrix
    private static void transposeMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    // method to print the matrix
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input size for the primary matrix
        System.out.print("Enter number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = scanner.nextInt();

        int[][] matrix = new int[rows][cols];
        System.out.println("Enter elements for the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        System.out.print("Enter rotation angle (90, 180, 270): ");
        int angle = scanner.nextInt();

        System.out.print("Enter direction (C for clockwise / AC for anticlockwise): ");
        String directionInput = scanner.next();
        directionInput = directionInput.trim().toUpperCase();

        String direction;
        if (directionInput.equals("C")) {
            direction = "clockwise";
        } else if (directionInput.equals("AC")) {
            direction = "anticlockwise";
        } else {
            System.out.println("Invalid direction input. Defaulting to clockwise.");
            direction = "clockwise";
        }
        // String direction = scanner.next();

        rotateMatrix(matrix, angle, direction);

        // printMatrix(matrix);

        scanner.close();
    }
}
