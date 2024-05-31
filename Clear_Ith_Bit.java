public class Clear_Ith_Bit {
    public static int clearIthBit(int n,int i){
        int bitMask = ~(1<<i);
        return (bitMask & n);
    }
    public static void main(String[] args) {
        int ans = clearIthBit(10,2);
        int ans2 = clearIthBit(13,5);
        System.out.println(ans);
        System.out.println(ans2);

        System.out.println(clearIthBit(13,3));
    }  
}
