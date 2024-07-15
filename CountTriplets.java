/*
1442. Count Triplets That Can Form Two Arrays of Equal XOR
Solved
Medium
Topics
Companies
Hint
Given an array of integers arr.

We want to select three indices i, j and k where (0 <= i < j <= k < arr.length).

Let's define a and b as follows:

a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
Note that ^ denotes the bitwise-xor operation.

Return the number of triplets (i, j and k) Where a == b.

Example 1:
Input: arr = [2, 3, 1, 6, 7]
Output: 4
Explanation: The triplets are (0, 1, 2), (0, 2, 2), (2, 3, 4) and (2, 4, 4)

Example 2:
Input: arr = [1, 1, 1, 1, 1]
Output: 10

Constraints:
1 <= arr.length <= 300
1 <= arr[i] <= 10^8
*/

public class CountTriplets {
    // First method: Using nested loops with XOR
    public int countTriplets(int[] nums) {
        int count = 0;
        // Iterate over each starting index
        for (int i = 0; i < nums.length; i++) {
            int xor = 0;
            // Compute XOR for subarray starting at index i
            for (int j = i; j < nums.length; j++) {
                xor ^= nums[j];
                // If XOR is zero, count valid (i, j, k) triplets
                if (xor == 0) {
                    count += (j - i);
                }
            }
        }
        return count;
    }

    // Second method: Using prefix XOR array
    public int countTripletsPrefixXOR(int[] arr) {
        int n = arr.length;
        int[] prefixXOR = new int[n + 1];
        // Initialize prefix XOR array
        prefixXOR[1] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixXOR[i + 1] = prefixXOR[i] ^ arr[i];
        }
        int tripletSum = 0;
        // Iterate over all pairs (i, j) to count valid triplets
        for (int i = 0; i < prefixXOR.length; i++) {
            for (int j = i + 1; j < prefixXOR.length; j++) {
                if (prefixXOR[i] == prefixXOR[j]) {
                    tripletSum += j - i - 1;
                }
            }
        }
        return tripletSum;
    }

    public static void main(String[] args) {
        CountTriplets solution = new CountTriplets();
        int[] arr1 = {2, 3, 1, 6, 7};
        int[] arr2 = {1, 1, 1, 1, 1};

        // Using first method
        System.out.println(solution.countTriplets(arr1)); // Output: 4
        System.out.println(solution.countTriplets(arr2)); // Output: 10
        
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        // Using second method
        System.out.println(solution.countTripletsPrefixXOR(arr1)); // Output: 4
        System.out.println(solution.countTripletsPrefixXOR(arr2)); // Output: 10
    }
}

/*
Dry run for the first method: countTriplets

Example array: [2, 3, 1, 6, 7]

Initial values:
count = 0

1. Loop i = 0:
   - xor = 0
   - j = 0: xor = 2, no triplet
   - j = 1: xor = 1, no triplet
   - j = 2: xor = 0, count += (2 - 0) -> count = 2
   - j = 3: xor = 6, no triplet
   - j = 4: xor = 1, no triplet

2. Loop i = 1:
   - xor = 0
   - j = 1: xor = 3, no triplet
   - j = 2: xor = 2, no triplet
   - j = 3: xor = 4, no triplet
   - j = 4: xor = 3, no triplet

3. Loop i = 2:
   - xor = 0
   - j = 2: xor = 1, no triplet
   - j = 3: xor = 7, no triplet
   - j = 4: xor = 0, count += (4 - 2) -> count = 4

4. Loop i = 3:
   - xor = 0
   - j = 3: xor = 6, no triplet
   - j = 4: xor = 1, no triplet

5. Loop i = 4:
   - xor = 0
   - j = 4: xor = 7, no triplet

Total count = 4


Dry run for the second method: countTripletsPrefixXOR

Example array: [2, 3, 1, 6, 7]

Initial values:
prefixXOR = [0, 2, 1, 0, 6, 1]
tripletSum = 0

1. Loop i = 0:
   - j = 1: no match
   - j = 2: no match
   - j = 3: match (prefixXOR[0] == prefixXOR[3]), tripletSum += (3 - 0 - 1) -> tripletSum = 2
   - j = 4: no match
   - j = 5: no match

2. Loop i = 1:
   - j = 2: no match
   - j = 3: no match
   - j = 4: no match
   - j = 5: no match

3. Loop i = 2:
   - j = 3: no match
   - j = 4: no match
   - j = 5: match (prefixXOR[2] == prefixXOR[5]), tripletSum += (5 - 2 - 1) -> tripletSum = 4

4. Loop i = 3:
   - j = 4: no match
   - j = 5: no match

5. Loop i = 4:
   - j = 5: no match

Total tripletSum = 4
*/
