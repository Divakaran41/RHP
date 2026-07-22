import java.io.*;
import java.util.*;

public class karenwithcoffee {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int MAX = 200000;

        int[] diff = new int[MAX + 2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            diff[l]++;
            diff[r + 1]--;
        }

        int[] prefix = new int[MAX + 1];

        int count = 0;
        for (int i = 1; i <= MAX; i++) {
            count += diff[i];

            if (count >= k) {
                prefix[i] = prefix[i - 1] + 1;
            } else {
                prefix[i] = prefix[i - 1];
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int ans = prefix[b] - prefix[a - 1];
            sb.append(ans).append('\n');
        }

        System.out.print(sb);
    }
}