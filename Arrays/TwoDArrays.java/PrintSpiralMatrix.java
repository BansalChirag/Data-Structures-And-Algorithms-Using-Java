import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrintSpiralMatrix {
    private static boolean isSizeEqual(List<Integer> list, int n) {
        return list.size() == n;
    }

    private static void printSpiral(int[][] matrix) {

        int rows = matrix.length, cols = matrix[0].length;
        List<Integer> spiralOrder = new ArrayList<>();
        int startRow = 0, endRow = rows - 1, startCol = 0, endCol = cols - 1;
        while (startRow <= endRow && startCol <= endCol) {

            if (isSizeEqual(spiralOrder, rows * cols))
                return;

            // START COL -> END COL , VARIABLE-> COL, FIX-> ROW
            for (int i = startCol; i <= endCol; i++) {
                spiralOrder.add(matrix[startRow][i]);

            }

            startRow++;

            // START ROW -> END ROW , VARIABLE-> ROW, FIX-> COL
            for (int i = startRow; i <= endRow && !isSizeEqual(spiralOrder, rows * cols); i++) {
                spiralOrder.add(matrix[i][endCol]);

            }

            endCol--;

            // END COL -> START COL , VARIABLE-> COL, FIX-> ROW
            for (int i = endCol; i >= startCol && !isSizeEqual(spiralOrder, rows * cols); i--) {
                spiralOrder.add(matrix[endRow][i]);

            }
            endRow--;

            // END ROW -> START ROW , VARIABLE-> ROW, FIX-> COL

            for (int i = endRow; i >= startRow && !isSizeEqual(spiralOrder, rows * cols); i--) {
                spiralOrder.add(matrix[i][startCol]);

            }
            startCol++;
        }

        System.out.println("answer : " + spiralOrder);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input size for the primary matrix
        System.out.print("Enter number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = scanner.nextInt();

        int[][] primaryMatrix = new int[rows][cols];
        System.out.println("Enter elements for the primary matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                primaryMatrix[i][j] = scanner.nextInt();
            }
        }

        printSpiral(primaryMatrix);
        ;

        // // Input size for the secondary matrix
        // System.out.print("Enter number of rows for the secondary matrix: ");
        // int secRows = scanner.nextInt();
        // System.out.print("Enter number of columns for the secondary matrix: ");
        // int secCols = scanner.nextInt();

        // int[][] secondaryMatrix = new int[secRows][secCols];
        // System.out.println("Enter elements for the secondary matrix:");
        // for (int i = 0; i < secRows; i++) {
        // for (int j = 0; j < secCols; j++) {
        // secondaryMatrix[i][j] = scanner.nextInt();
        // }
        // }

        // // Optional: rotate and print
        // if (secRows == secCols) {
        // rotateMatrix(secondaryMatrix);
        // System.out.println("Secondary matrix after 90-degree rotation:");
        // // printMatrix(secondaryMatrix);
        // } else {
        // System.out.println("Cannot rotate non-square matrix.");
        // }

        scanner.close();
    }
}
