import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=0;
        String str;
        str=sc.next();
        for(char i: str.toCharArray()){
            a=a|(1<<(i-'a'));
        }
        if(a==(1<<26)-1)System.out.println("yes");
        else System.out.println("No");
        
    }
}
