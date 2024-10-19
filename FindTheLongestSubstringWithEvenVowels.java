/**
 * 1371. Find the Longest Substring Containing Vowels in Even Counts
 * 
 * Given the string s, return the size of the longest substring containing each vowel 
 * an even number of times. That is, 'a', 'e', 'i', 'o', and 'u' must appear an even 
 * number of times.
 * 
 * Example 1:
 * Input: s = "eleetminicoworoep"
 * Output: 13
 * Explanation: The longest substring is "leetminicowor" which contains two each of 
 * the vowels: e, i, and o, and zero of the vowels: a and u.
 * 
 * Example 2:
 * Input: s = "leetcodeisgreat"
 * Output: 5
 * Explanation: The longest substring is "leetc" which contains two e's.
 * 
 * Example 3:
 * Input: s = "bcbcbc"
 * Output: 6
 * Explanation: In this case, the given string "bcbcbc" is the longest because all 
 * vowels: a, e, i, o, and u appear zero times.
 * 
 * Constraints:
 * 1 <= s.length <= 5 x 10^5
 * s contains only lowercase English letters.
 */
 
 import java.util.HashMap;

public class FindTheLongestSubstringWithEvenVowels {
     /**
      * This method finds the length of the longest substring where all vowels
      * (a, e, i, o, u) appear an even number of times.
      * 
      * Time Complexity: O(n), where n is the length of the input string.
      * Space Complexity: O(32) = O(1) for the bitmask and O(n) for the hash map.
      * 
      * @param s The input string.
      * @return The length of the longest valid substring.
      */
     public int findTheLongestSubstring(String s) {
         // Bitmask to track the parity (even/odd) of vowels: a, e, i, o, u
         int state = 0;
         // Map to store the first occurrence of each bitmask state
         HashMap<Integer, Integer> firstOccurrence = new HashMap<>();
         // Initialize with state 0 occurring at index -1 to handle edge case
         firstOccurrence.put(0, -1);
         
         int maxLength = 0;
 
         // Traverse the string character by character
         for (int i = 0; i < s.length(); i++) {
             char ch = s.charAt(i);
             
             // Toggle the corresponding bit based on the character
             switch (ch) {
                 case 'a': 
                     state ^= (1 << 0); // Toggle bit for 'a'
                     break;
                 case 'e': 
                     state ^= (1 << 1); // Toggle bit for 'e'
                     break;
                 case 'i': 
                     state ^= (1 << 2); // Toggle bit for 'i'
                     break;
                 case 'o': 
                     state ^= (1 << 3); // Toggle bit for 'o'
                     break;
                 case 'u': 
                     state ^= (1 << 4); // Toggle bit for 'u'
                     break;
             }
             
             // If this bitmask state has been seen before
             if (firstOccurrence.containsKey(state)) {
                 // Calculate the length of the substring from the first occurrence
                 maxLength = Math.max(maxLength, i - firstOccurrence.get(state));
             } else {
                 // Otherwise, record the first occurrence of this state
                 firstOccurrence.put(state, i);
             }
         }
         
         return maxLength;
     }
 
     // Main method for testing
     public static void main(String[] args) {
         FindTheLongestSubstringWithEvenVowels solution = new FindTheLongestSubstringWithEvenVowels();
 
         // Test case 1
         String s1 = "eleetminicoworoep";
         System.out.println(solution.findTheLongestSubstring(s1));  // Output: 13
 
         // Test case 2
         String s2 = "leetcodeisgreat";
         System.out.println(solution.findTheLongestSubstring(s2));  // Output: 5
 
         // Test case 3
         String s3 = "bcbcbc";
         System.out.println(solution.findTheLongestSubstring(s3));  // Output: 6
     }
 }

 /*
  
class Solution {
    public int findTheLongestSubstring(String s) {
        int res = 0; int xor = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u'){
                xor ^= c;
            }
            if(map.containsKey(xor)){
                res = Math.max(res, i-map.get(xor));
            }else{
                map.put(xor,i);
            }
            
        }
        return res;
    }
}

  */