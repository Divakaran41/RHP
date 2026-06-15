import java.util.*;
public class LSwithEqual0s&1s{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int sum=0;
        int max=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='0')sum-=1;
            else sum+=1;
            if(map.containsKey(sum)) max=Math.max(max,i-map.get(sum));
            else map.put(sum,i);
        }
        System.out.println(max);
    }
}