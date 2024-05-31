public class Set_Ith_Bit {
    public static int setIthBit(int n,int i){
        int bitMask = 1<<i;
        return (bitMask | n);
    }
    public static void main(String[] args) {
        int ans = setIthBit(10,2);
        int ans2 = setIthBit(13,0);
        System.out.println(ans);
        System.out.println(ans2);
    }  
}
