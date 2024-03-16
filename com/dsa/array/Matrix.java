package com.dsa.array;

public class Matrix {

    public static void search(int[][] matrix, int rowsNum, int value) {
        int i = 0;
        int j = rowsNum - 1;
        while (i < rowsNum && j >= 0) {

            if (value == matrix[i][j]) {
                System.out.println("Found at: [" + i + "," + j + "]");
                return;
            }
            if (value < matrix[i][j]) {
                j--;
            } else {
                i++;
            }
        }
        System.out.println("Not Found");
    }

    /**
     * Traverses a matrix in a spiral pattern and prints the elements.
     * 
     * @param matrix the matrix to be traversed
     * @param row    the number of rows in the matrix
     * @param col    the number of columns in the matrix
     */
    public static void spiralTraverse(int[][] matrix, int row, int col) {
        int k = 0; // starting row index
        int l = 0; // starting column index
        int i; // loop variable

        while (k < row && l < col) {
            // Traverse the top row from left to right
            for (i = l; i < col; i++) {
                System.out.print(matrix[k][i] + " ");
            }
            k++; // move to the next row

            // Traverse the right column from top to bottom
            for (i = k; i < row; i++) {
                System.out.print(matrix[i][col - 1] + " ");
            }
            col--; // decrease the column count

            // Traverse the bottom row from right to left
            if (k < row) {
                for (i = col - 1; i >= l; i--) {
                    System.out.print(matrix[row - 1][i] + " ");
                }
                row--; // decrease the row count
            }

            // Traverse the left column from bottom to top
            if (l < col) {
                for (i = row - 1; i >= k; i--) {
                    System.out.print(matrix[i][l] + " ");
                }
                l++; // move to the next column
            }
        }
    }

    public static int[][] getSortedMatrix() {
        return new int[][] {
                { 10, 20, 30, 40 },
                { 15, 25, 35, 45 },
                { 27, 29, 37, 48 },
                { 32, 33, 39, 51 }
        };
    }

    public static void main(String[] args) {
        // search(getSortedMatrix(), 4, 37);
        
        int[][] matrix = {
                { 1, 2, 3, 4 },
                { 12, 13, 14, 5 },
                { 11, 16, 15, 6 },
                { 10, 9, 8, 7 }
        };
        spiralTraverse(matrix, 4, 4);
    }
}
