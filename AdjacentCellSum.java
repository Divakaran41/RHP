import java.util.*;
public class AdjacentCellSum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a,b;
        a=sc.nextInt();
        b=sc.nextInt();
        int arr[][]=new int[a][b];
        for(int i=0;i<a;i++){
            for(int j=0;j<b;j++)arr[i][j]=sc.nextInt();
        }
        int i,j;
        i=sc.nextInt();
        j=sc.nextInt();
        int sum=0;
        int adj[][]={{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,-1}, {1,-1}, {-1,1}};
        for(int lol=0;lol<8;lol++){
            int r=adj[lol][0]+i;
            int c=adj[lol][1]+j;
            if(r>=0 && r<a && c>=0 && c<b)sum+=arr[r][c];
        }
        System.out.println(sum);
    }
}