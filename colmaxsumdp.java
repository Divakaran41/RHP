import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int arr[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int dp[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            dp[i][0] = arr[i][0];
        }

        for (int j = 1; j < m; j++) {
            int max1 = Integer.MIN_VALUE;
            int max2 = Integer.MIN_VALUE;
            int row = -1;

            for (int i = 0; i < n; i++) {
                if (dp[i][j - 1] > max1) {
                    max2 = max1;
                    max1 = dp[i][j - 1];
                    row = i;
                } else if (dp[i][j - 1] > max2) {
                    max2 = dp[i][j - 1];
                }
            }

            for (int i = 0; i < n; i++) {
                if (i == row) {
                    dp[i][j] = arr[i][j] + max2;
                } else {
                    dp[i][j] = arr[i][j] + max1;
                }
            }
        }

        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i][m - 1]);
        }

        System.out.println(ans);
    }
}
