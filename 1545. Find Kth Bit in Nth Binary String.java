/**
 * 1545. Find Kth Bit in Nth Binary String
 * 
 * Given two positive integers n and k, the binary string Sn is formed as follows:
 * 
 * S1 = "0"
 * Si = Si - 1 + "1" + reverse(invert(Si - 1)) for i > 1
 * 
 * Where + denotes the concatenation operation, reverse(x) returns the reversed string x, 
 * and invert(x) inverts all the bits in x (0 changes to 1 and 1 changes to 0).
 * 
 * For example, the first four strings in the above sequence are:
 * S1 = "0"
 * S2 = "011"
 * S3 = "0111001"
 * S4 = "011100110110001"
 * 
 * Return the kth bit in Sn. It is guaranteed that k is valid for the given n.
 * 
 * Example 1:
 * Input: n = 3, k = 1
 * Output: "0"
 * Explanation: S3 is "0111001". The 1st bit is "0".
 * 
 * Example 2:
 * Input: n = 4, k = 11
 * Output: "1"
 * Explanation: S4 is "011100110110001". The 11th bit is "1".
 * 
 * Constraints:
 * 1 <= n <= 20
 * 1 <= k <= 2^n - 1
 */

public class FindKthBitInNthBinaryString {

    /**
     * This method finds the k-th bit in the binary string S_n.
     * 
     * @param n The index of the binary string S_n.
     * @param k The position of the bit to find (1-based index).
     * @return The k-th bit in S_n.
     */
    public char findKthBit(int n, int k) {
        // Base case: When n = 1, the binary string is "0"
        if (n == 1) return '0';
        
        // Find the length of the current string Sn, which is 2^n - 1
        int length = (1 << n) - 1;
        
        // Find the middle position
        int mid = length / 2 + 1;
        
        // If k is the middle position, return '1'
        if (k == mid) return '1';
        
        // If k is in the first half, find the bit in Sn-1
        if (k < mid) return findKthBit(n - 1, k);
        
        // If k is in the second half, find the bit in Sn-1 and invert it
        return findKthBit(n - 1, length - k + 1) == '0' ? '1' : '0';
    }

    public static void main(String[] args) {
        FindKthBitInNthBinaryString solution = new FindKthBitInNthBinaryString();
        
        // Test case 1
        int n1 = 3;
        int k1 = 1;
        System.out.println(solution.findKthBit(n1, k1));  // Output: '0'

        // Test case 2
        int n2 = 4;
        int k2 = 11;
        System.out.println(solution.findKthBit(n2, k2));  // Output: '1'
    }
}
