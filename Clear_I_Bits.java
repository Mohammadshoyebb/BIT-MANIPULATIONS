/*
 * A = 1111, i = 2;
 * output: 1100;
 * 
 * 
 * 
 * A = 001101011101, i=4;
 * output: 001101010000;
 */
public class Clear_I_Bits {
    public static int clearIBits(int n,int i){
        int bitMask = (~0) << i;
        // OR

        // int bitMask = (-1) << i;

        // both methods works same because ((~0) = (-1));

        return n & bitMask;
    }
    public static void main(String[] args) {
        System.out.println(clearIBits(12, 3));
        System.out.println(clearIBits(16, 2));
        System.out.println(clearIBits(14, 1));
        System.out.println(clearIBits(20, 3));
    }  
}
