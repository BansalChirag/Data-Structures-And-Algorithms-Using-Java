import java.util.Scanner;

public class SetMatrixZero {

    // Given an m x n integer matrix matrix, if an element is 0, set its entire row
    // and column to 0's.

    private static int[][] cloneMatrix(int[][] matrix) {
        int[][] cloned = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            System.arraycopy(matrix[i], 0, cloned[i], 0, matrix[0].length);
        }
        return cloned;
    }

    private static void makeColZero(int matrix[][], int col) {
        final int MARKER = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][col] != 0)
                matrix[i][col] = MARKER;
        }
    }

    private static void makeRowZero(int matrix[][], int row) {
        final int MARKER = Integer.MIN_VALUE;
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[row][i] != 0)
                matrix[row][i] = MARKER;
        }
    }

    private static void setZeroes(int[][] matrix) {

        int n = matrix.length, m = matrix[0].length;

        // Clone the original matrix for reuse
        int[][] original = cloneMatrix(matrix);

        // solution1: Time Complexity: O(n^3) (near about)-> O(n*m)*(n+m) + O(n*m)
        // solution only works if the matrix is a binary matrix

        System.out.println(
                "-----------------------------------------------------Solution 1 begins:-----------------------------------------------------");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    makeRowZero(matrix, i);
                    makeColZero(matrix, j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }

        printMatrix(matrix);
        System.out.println(
                "-----------------------------------------------------Solution 1 ends:-----------------------------------------------------");

        System.out.println(
                "-----------------------------------------------------Reinitializing the array to User Input: -----------------------------------------------------");

        // Reset matrix to original for Solution 2
        matrix = cloneMatrix(original);

        System.out.println(
                "-----------------------------------------------------Solution 2 begins: -----------------------------------------------------");

        // Time Complexity : O(2*(n*m)) Space Complexity: O(n) + O(m)
        int rows[] = new int[n];
        int cols[] = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (rows[i] == 1 || cols[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }

        printMatrix(matrix);
        System.out.println(
                "-----------------------------------------------------Solution 2 ends: -----------------------------------------------------");

        System.out.println(
                "-----------------------------------------------------Reinitializing the array to User Input: -----------------------------------------------------");

        matrix = cloneMatrix(original);

        System.out.println(
                "-----------------------------------------------------Solution 3 begins: -----------------------------------------------------");

        // Time Complexity : O(2*(n*m)) Space Complexity: O(1)
        int col0 = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    if (j != 0)
                        matrix[i][0] = 0;
                    else
                        col0 = 0;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] != 0)
                    if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                        matrix[i][j] = 0;
                    }
            }
        }

        if (matrix[0][0] == 0) {
            for (int j = 0; j < m; j++)
                matrix[0][j] = 0;
        }

        if (col0 == 0) {
            for (int i = 0; i < n; i++)
                matrix[i][0] = 0;
        }

        printMatrix(matrix);
        System.out.println(
                "-----------------------------------------------------Solution 3 ends: -----------------------------------------------------");
    }

    // method to print the matrix
    private static void printMatrix(int[][] matrix) {
        System.out.println(
                "-----------------------------------------------------Printing Matrix: -----------------------------------------------------");
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
        setZeroes(matrix);

        scanner.close();

    }
}
