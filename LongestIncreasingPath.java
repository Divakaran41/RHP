import java.util.Scanner;

public class LongestIncreasingPath {

    static int row;
    static int col;

    static int[][] dir = {
        {0, -1},  // Left
        {0, 1},   // Right
        {1, 0},   // Down
        {-1, 0}   // Up
    };

    static int dfs(int[][] arr, int i, int j, int[][] dp) {

        if (dp[i][j] != 0)
            return dp[i][j];

        int max = 0;

        for (int k = 0; k < 4; k++) {

            int nr = i + dir[k][0];
            int nc = j + dir[k][1];

            if (nr >= 0 && nc >= 0 && nr < row && nc < col
                    && arr[nr][nc] > arr[i][j]) {

                max = Math.max(max, dfs(arr, nr, nc, dp));
            }
        }

        dp[i][j] = 1 + max;
        return dp[i][j];
    }

    static int longestIncreasingPath(int[][] matrix) {

        row = matrix.length;
        col = matrix[0].length;

        int[][] dp = new int[row][col];
        int ans = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ans = Math.max(ans, dfs(matrix, i, j, dp));
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int r = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int c = sc.nextInt();

        int[][] matrix = new int[r][c];

        System.out.println("Enter matrix elements:");

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int result = longestIncreasingPath(matrix);

        System.out.println("Longest Increasing Path Length = " + result);

        sc.close();
    }
}