public class Get_Ith_Bit {
    public static int getIthBit(int n,int i){
        int bitMask = 1<<i;
        if((n & bitMask)==0){
            return 0;
        }
        return 1;
    }
    public static void main(String[] args) {
        int ans = getIthBit(10,2);
        int ans2 = getIthBit(13,0);
        System.out.println(ans);
        System.out.println(ans2);
    }
}
