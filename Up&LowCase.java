import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=0,b=0;
        String str;
        str=sc.next();
        for(char i: str.toCharArray()){
            if(i>='a' && i<='z')a=a|(1<<(i-'a'));
            else b=b|(1<<(i-'A'));
        }
        if(a==(1<<26)-1 && b==(1<<26)-1)System.out.println("yes");
        else System.out.println("No");
        
    }
}
