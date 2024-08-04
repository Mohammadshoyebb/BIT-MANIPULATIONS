/*
 * 201. Bitwise AND of Numbers Range
 * Difficulty: Medium
 * 
 * Given two integers left and right that represent the range [left, right], return the bitwise AND of all numbers in this range, inclusive.
 * 
 * Example 1:
 * Input: left = 5, right = 7
 * Output: 4
 * 
 * Example 2:
 * Input: left = 0, right = 0
 * Output: 0
 * 
 * Example 3:
 * Input: left = 1, right = 2147483647
 * Output: 0
 * 
 * Constraints:
 * 0 <= left <= right <= 2^31 - 1
 * 
 * Approach 1:
 * - Continuously reduce the range [left, right] by setting the right value to the result of bitwise AND between right and (right-1) until left is no longer less than right.
 * - Return the bitwise AND of left and right.
 */

 public class BitwiseAndOfNumbersRange {

    // Approach 1
    public int rangeBitwiseAndApproach1(int left, int right) {
        // While left is less than right, keep reducing right by performing bitwise AND of right and (right-1)
        while (left < right) {
            // This effectively removes the rightmost set bit from right
            right = right & (right - 1);
        }
        // When left equals right, we have the common prefix of all numbers in the range
        return left & right;
    }

    /*
     * Explanation:
     * - The bitwise AND operation between right and (right - 1) removes the rightmost set bit from right.
     * - By continuously performing this operation, we effectively zero out the differing bits between left and right, leaving only the common prefix.
     * - This common prefix is the bitwise AND result of all numbers in the range.
     */

    // Approach 2
    public int rangeBitwiseAndApproach2(int left, int right) {
        int shifts = 0;
        // Shift left and right to the right until they are the same
        while (left < right) {
            // Right-shifting left and right to eliminate the differing bits
            left = left >> 1;
            right = right >> 1;
            shifts++;
        }
        // Shift back the common prefix to its original position
        return right << shifts; // or return left << shifts; since left == right now
    }

    /*
     * Explanation:
     * - The right-shift operation eliminates the differing bits between left and right.
     * - By shifting both left and right until they are equal, we isolate the common prefix.
     * - Shifting back the common prefix to its original position gives the bitwise AND result of all numbers in the range.
     */

    public static void main(String[] args) {
        BitwiseAndOfNumbersRange solution = new BitwiseAndOfNumbersRange();

        // Test approach 1
        System.out.println("Approach 1:");
        System.out.println("Input: left = 5, right = 7 | Output: " + solution.rangeBitwiseAndApproach1(5, 7)); // Output: 4
        System.out.println("Input: left = 0, right = 0 | Output: " + solution.rangeBitwiseAndApproach1(0, 0)); // Output: 0
        System.out.println("Input: left = 1, right = 2147483647 | Output: " + solution.rangeBitwiseAndApproach1(1, 2147483647)); // Output: 0

        // Test approach 2
        System.out.println("Approach 2:");
        System.out.println("Input: left = 5, right = 7 | Output: " + solution.rangeBitwiseAndApproach2(5, 7)); // Output: 4
        System.out.println("Input: left = 0, right = 0 | Output: " + solution.rangeBitwiseAndApproach2(0, 0)); // Output: 0
        System.out.println("Input: left = 1, right = 2147483647 | Output: " + solution.rangeBitwiseAndApproach2(1, 2147483647)); // Output: 0
    }
}
