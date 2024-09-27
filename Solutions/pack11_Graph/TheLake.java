package Solutions.pack11_Graph;


public class TheLake {

    public int findTotalMaxDepth(int[][] grid) {
        int maxDepth = 0;

        int rows = grid.length;
        int cols = grid[0].length;

        // Track visited cells
        boolean[][] visited = new boolean[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] != 0 && !visited[row][col]) {
                    int depth = exploreLake(grid, visited, row, col);
                    maxDepth = Math.max(maxDepth, depth);
                }
            }
        }
        return maxDepth;
    }

    // DFS to explore all
    private int exploreLake(int[][] grid, boolean[][] visited, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return 0;
        }

        if (grid[row][col] == 0 || visited[row][col]) {
            return 0;
        }

        visited[row][col] = true;

        int totalDepth = grid[row][col];

        totalDepth += exploreLake(grid, visited, row + 1, col);  // Down
        totalDepth += exploreLake(grid, visited, row - 1, col);  // Up
        totalDepth += exploreLake(grid, visited, row, col + 1);  // Right
        totalDepth += exploreLake(grid, visited, row, col - 1);  // Left

        return totalDepth;
    }
}
