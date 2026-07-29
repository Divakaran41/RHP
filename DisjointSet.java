import java.util.*; 
class DisjointSet{
    public static int find(int[] ldr,int node){
        if(ldr[node]!=node){
            ldr[node]=find(ldr,ldr[node]);
        }
        return ldr[node];

    }

    public static void join(int[] ldr,int a,int b){
        int lt=find(ldr,a);
        int rt=find(ldr,b);
        ldr[lt]=rt;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[] ldr=new int[n+1];
        for(int i=1;i<=n;i++){
            ldr[i]=i;
        }
        for(int i=1;i<=m;i++){
            int a,b;
            a=sc.nextInt();
            b=sc.nextInt();
            join(ldr,a,b);
        }
        Set<Integer> st=new TreeSet<>();
        for(int i=1;i<=n;i++){
            st.add(find(ldr,i));
        }
        for(int i=1;i<=n;i++){
            System.out.print(ldr[i]+" ");
        }
        System.out.println(st);
        System.out.println(st.size());

    }
}