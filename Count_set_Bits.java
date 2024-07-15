/**
 * The Count_set_Bits class calculates the number of set bits (bits with value 1) in an integer.
 */
public class Count_set_Bits {  
    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            // Check if the least significant bit is set
            if ((n & 1) != 0) {
                count++;
            }
            // Right shift the integer by one position
            n = n >> 1;
        }
        return count;
    }
    public static void main(String[] args) {
        int n = 16;
        System.out.println("Number of set bits in " + n + ": " + countSetBits(n));  // Output: 1
    }
}
