import java.util.Scanner;

public class NumberOfIslands {

    static int row;
    static int col;

    static void dfs(char arr[][], int i, int j) {

        if (i < 0 || j < 0 || i >= row || j >= col || arr[i][j] == '0')
            return;

        arr[i][j] = '0';

        dfs(arr, i, j + 1); // Right
        dfs(arr, i, j - 1); // Left
        dfs(arr, i + 1, j); // Down
        dfs(arr, i - 1, j); // Up
    }

    public static int numIslands(char[][] grid) {

        row = grid.length;
        col = grid[0].length;

        int count = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int r = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int c = sc.nextInt();

        char[][] grid = new char[r][c];

        System.out.println("Enter the grid (0 or 1):");

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                grid[i][j] = sc.next().charAt(0);
            }
        }

        int islands = numIslands(grid);

        System.out.println("Number of Islands = " + islands);

        sc.close();
    }
}