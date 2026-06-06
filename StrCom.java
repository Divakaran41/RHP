import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int len = s.length();

        for (int i = 1; i < (1 << len); i++) {
            StringBuilder combi = new StringBuilder();

            for (int j = 0; j < len; j++) {
                if ((i & (1 << j)) != 0) {
                    combi.append(s.charAt(j));
                }
            }

            System.out.println(combi);
        }
    }
}
