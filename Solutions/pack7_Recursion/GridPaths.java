package Solutions.pack7_Recursion;

public class GridPaths {

    public static int numberOfPaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] arr = new int[m][n];
        arr[0][0] = 1;

        for (int i = 1; i < m; i++) {
            if (grid[i][0] == 0) {
                arr[i][0] = arr[i - 1][0];
            }
        }

        for (int j = 1; j < n; j++) {
            if (grid[0][j] == 0) {
                arr[0][j] = arr[0][j - 1];
            }
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] == 0) {
                    arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
                }
            }
        }
        return arr[m - 1][n - 1];
    }
}
