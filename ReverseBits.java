/*
 * 190. Reverse Bits
Solved
Easy
Topics
Companies
Reverse bits of a given 32 bits unsigned integer.

Note:

Note that in some languages, such as Java, there is no unsigned integer type. In this case, both input and output will be given as a signed integer type. They should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 2 above, the input represents the signed integer -3 and the output represents the signed integer -1073741825.
 

Example 1:

Input: n = 00000010100101000001111010011100
Output:    964176192 (00111001011110000010100101000000)
Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.
Example 2:

Input: n = 11111111111111111111111111111101
Output:   3221225471 (10111111111111111111111111111111)
Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293, so return 3221225471 which its binary representation is 10111111111111111111111111111111.
 

Constraints:

The input must be a binary string of length 32
 

Follow up: If this function is called many times, how would you optimize it?
 */


public class ReverseBits {
    // Reverse bits function
    public int reverseBits(int n) {
        int result = 0;
        // Iterate through each bit of the input integer
        for (int i = 0; i < 32; i++) {
            // Extract the LSB (least significant bit) of the input integer
            int bit = n & 1;
            // Set the corresponding bit in the result by left-shifting and ORing
            result = (result << 1) | bit;
            // Right-shift the input integer to move to the next bit
            n >>= 1;
        }
        return result;
    }

    // Main method for testing
    public static void main(String[] args) {
        ReverseBits solution = new ReverseBits();
        // Test cases
        int n1 = 43261596;
        int n2 = -3;
        System.out.println("Input: " + n1 + ", Output: " + solution.reverseBits(n1)); // Output: 964176192
        System.out.println("Input: " + n2 + ", Output: " + solution.reverseBits(n2)); // Output: -1073741825
    }
}

//======================================================================================================================
// public class Solution {
//     // you need treat n as an unsigned value
//     public int reverseBits(int n) {
//         int newN = 0;
//         for(int i = 0; i < Integer.SIZE; i++) {
//             newN = newN << 1;
//             if((n & 1) > 0) {
//                 newN = newN ^ 1;
//             }
//             n = n >> 1;
//         }
//         return newN;
//     } 
// }