import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n,m;
        n=sc.nextInt();
        m=sc.nextInt();
        int arr[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        int dp[][]=new int[n][m];
        for(int i=0;i<m;i++){
            dp[0][i]=arr[0][i];
        }
        for(int i=1;i<n;i++){
            int max1=Integer.MIN_VALUE;
            int max2=Integer.MIN_VALUE;
            int col=-1;
            for(int j=0;j<m;j++){
                if(dp[i-1][j]>max1){
                    max2=max1;
                    max1=dp[i-1][j];
                    col=j;
                }else if(max2<dp[i-1][j]){
                    max2=dp[i-1][j];
                }
            }
            for(int j=0;j<m;j++){
                if(col==j){
                    dp[i][j]=arr[i][j]+max2;
                }else dp[i][j]=arr[i][j]+max1;
            }
        }
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans=Math.max(ans,dp[i][j]);
            }
        }
        System.out.println(ans);
    }
}
