package com.dsa.graph;

import com.dsa.Answer;

public class NumberOfIslands implements Runnable {

    private final int[][] islands;
    public int numberOfIsland = 0;

    NumberOfIslands(int[][] grid){
        this.islands = grid;
    }

    public static void main(String[] args) {
        int[][] islands = {{1, 1, 0, 0, 1}, {1, 0, 0, 0, 0}, {0, 0, 1, 0, 0}, {1, 0, 0, 0, 1}};
        Answer.print(islands, "Islands");

        NumberOfIslands numOfIslands = new NumberOfIslands(islands);
        numOfIslands.run();

        int nums = numOfIslands.numberOfIsland;
        Answer.print(nums, "Number od islands");
    }

    /**
     * Returns the number of islands found in the grid.
     *
     * @return The number of islands.
     */
    public int getIslands() {
        return this.numberOfIsland;
    }

    /**
     * Runs the algorithm to find the number of islands in the given grid of lands and waters.
     */
    public void run() {
        int m = this.islands.length;
        int n = this.islands[0].length;
        // Initialize a boolean matrix to keep track of visited cells
        boolean[][] visited = new boolean[m][n];
        int numberOfIsland = 0;
        // Iterate through each cell in the grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // If the cell is unvisited and contains land
                if (!visited[i][j] && this.islands[i][j] == 1) {
                    // Run depth-first search to explore the island
                    dfs(this.islands, visited, i, j);
                    // Increment the number of islands found
                    numberOfIsland++;
                }
            }
        }
        // Update the instance variable with the number of islands
        this.numberOfIsland = numberOfIsland;
    }

    /**
     * Depth-first search algorithm to explore an island starting from a given cell.
     *
     * @param islands The grid of lands and waters.
     * @param visited A boolean matrix to track visited cells.
     * @param m       The row index of the current cell.
     * @param n       The column index of the current cell.
     */
    private void dfs(int[][] islands, boolean[][] visited, int m, int n) {
        // Base case: Check if the current cell is out of bounds, already visited, or contains water
        if (m < 0 || n < 0 || m >= islands.length || n >= islands[0].length || visited[m][n] || isWater(m, n))
            return;
        // Mark the current cell as visited
        visited[m][n] = true;
        // Recursively explore neighboring cells (up, down, left, right)
        dfs(islands, visited, m - 1, n); // up
        dfs(islands, visited, m + 1, n); // down
        dfs(islands, visited, m, n - 1); // left
        dfs(islands, visited, m, n + 1); // right
    }

    /**
     * Checks if a cell in the grid contains water.
     *
     * @param m The row index of the cell.
     * @param n The column index of the cell.
     * @return {@code true} if the cell contains water, {@code false} otherwise.
     */
    private boolean isWater(int m, int n) {
        return this.islands[m][n] == 0;
    }
}
