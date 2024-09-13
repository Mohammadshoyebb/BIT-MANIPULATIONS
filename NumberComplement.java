/*
 * 76. Number Complement
Solved
Easy
Topics
Companies
The complement of an integer is the integer you get when you flip all the 0's to 1's and all the 1's to 0's in its binary representation.

For example, The integer 5 is "101" in binary and its complement is "010" which is the integer 2.
Given an integer num, return its complement.

 

Example 1:

Input: num = 5
Output: 2
Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
Example 2:

Input: num = 1
Output: 0
Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
 

Constraints:

1 <= num < 231
 

Note: This question is the same as 1009: https://leetcode.com/problems/complement-of-base-10-integer/


 */

 public class NumberComplement {

    // Approach 1: Using bitwise manipulation
    public int findComplement(int num) {
        if(num==0)return 1;

        int bitmask = num;
        bitmask |= (bitmask >> 1);
        bitmask |= (bitmask >> 2);
        bitmask |= (bitmask >> 4);
        bitmask |= (bitmask >> 8);
        bitmask |= (bitmask >> 16);
        return num ^ bitmask;
    }

    // Approach 2: Using string manipulation
    public int findComplementString(int num) {
        String binary = Integer.toBinaryString(num);
        StringBuilder complementBinary = new StringBuilder();
        for (char c : binary.toCharArray()) {
            complementBinary.append(c == '0' ? '1' : '0');
        }
        return Integer.parseInt(complementBinary.toString(), 2);
    }

    // Approach 3: Using logarithmic operations
    public int findComplementLog(int num) {
        int len = (int)(Math.log(num)/Math.log(2))+1;
        int mask = (1<<len)-1;
        return num ^ mask;
    }

    public static void main(String[] args) {
        NumberComplement nc = new NumberComplement();

        // Test all approaches
        int num = 5;

        // Approach 1
        System.out.println("Approach 1: " + nc.findComplement(num));

        // Approach 2
        System.out.println("Approach 2: " + nc.findComplementString(num));

        // Approach 3
        System.out.println("Approach 3: " + nc.findComplementLog(num));


        num = 0;

        // Approach 1
        System.out.println("Approach 1: " + nc.findComplement(num));

        // Approach 2
        System.out.println("Approach 2: " + nc.findComplementString(num));

        // Approach 3
        System.out.println("Approach 3: " + nc.findComplementLog(num));
    }
}
