public class Fast_Exponentiation {
    public static int fastExp(int a, int n){
        int ans = 1;
        
        while(n>0){
            if((n&1)==1){
                ans *= a;
            }
            a *= a;
            n >>= 1;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(fastExp(3, 5));
        System.out.println(fastExp(5, 5));
        System.out.println(fastExp(7, 12));
        System.out.println(fastExp(6, 7));
    }
}
