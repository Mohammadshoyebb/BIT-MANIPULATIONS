/**
 * 1310. XOR Queries of a Subarray
 * 
 * Problem:
 * You are given an array arr of positive integers. You are also given the array queries 
 * where queries[i] = [lefti, righti].
 * 
 * For each query i, compute the XOR of elements from lefti to righti (i.e., 
 * arr[lefti] XOR arr[lefti + 1] XOR ... XOR arr[righti]).
 * 
 * Return an array answer where answer[i] is the XOR result for the ith query.
 * 
 * Example 1:
 * Input: arr = [1, 3, 4, 8], queries = [[0, 1], [1, 2], [0, 3], [3, 3]]
 * Output: [2, 7, 14, 8]
 * Explanation:
 * - XOR from index 0 to 1: 1 XOR 3 = 2
 * - XOR from index 1 to 2: 3 XOR 4 = 7
 * - XOR from index 0 to 3: 1 XOR 3 XOR 4 XOR 8 = 14
 * - XOR from index 3 to 3: 8
 * 
 * Example 2:
 * Input: arr = [4, 8, 2, 10], queries = [[2, 3], [1, 3], [0, 0], [0, 3]]
 * Output: [8, 0, 4, 4]
 * 
 * Constraints:
 * - 1 <= arr.length, queries.length <= 3 * 10^4
 * - 1 <= arr[i] <= 10^9
 * - queries[i].length == 2
 * - 0 <= lefti <= righti < arr.length
 */
public class XORQueriesofaSubarray {

    /**
     * Brute force approach to solve the XOR Queries.
     * 
     * For each query, we calculate the XOR of the elements from `left` to `right` index.
     * 
     * Time complexity: O(n * m), where n is the length of the array `arr`, and m is the number of queries.
     * - For each query, we iterate through the subarray from left to right, performing XOR operations.
     * 
     * This approach can become slow if the array and query lengths are large, but it is simple to implement.
     * 
     
     */
    public int[] xorQueriesBruteForce(int[] arr, int[][] queries) {
        // Result array to store the answer for each query
        int[] res = new int[queries.length];
        int count = 0;

        // Process each query individually
        for (int[] query : queries) {
            int left = query[0];  // Left index of the query
            int right = query[1]; // Right index of the query
            int xorValue = 0;     // Variable to store XOR result for the current query

            // XOR all elements from index `left` to `right`
            for (int i = left; i <= right; i++) {
                xorValue ^= arr[i]; // XOR the current element with the running result
            }

            // Store the XOR result in the result array
            res[count++] = xorValue;
        }

        return res;
    }

    /**
     * Efficient approach using prefix XOR to solve the XOR Queries.
     * 
     * We precompute a cumulative XOR array (`cumXor`), where `cumXor[i]` stores the XOR of all elements from `arr[0]` to `arr[i]`.
     * This allows us to answer each query in constant time.
     * 
     * For a query [left, right]:
     * - If `left == 0`: The XOR of the subarray from `left` to `right` is simply `cumXor[right]`.
     * - Otherwise: The XOR of the subarray can be computed as `cumXor[right] ^ cumXor[left - 1]`.
     * 
     * Time complexity: O(n + m), where n is the length of the array `arr`, and m is the number of queries.
     * - Building the prefix XOR array takes O(n).
     * - Answering each query takes O(1), so processing m queries takes O(m).
     * 
     
     */
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        
        // Step 1: Build the cumulative XOR (prefix XOR) array
        int[] cumXor = new int[n];
        cumXor[0] = arr[0];  // The first element's XOR is itself

        // Compute the cumulative XOR for each element in the array
        for (int i = 1; i < n; i++) {
            cumXor[i] = cumXor[i - 1] ^ arr[i];  // XOR with the previous cumulative value
        }

        // Step 2: Process each query using the cumulative XOR array
        int[] res = new int[queries.length];  // Result array to store the XOR results for each query
        int count = 0;  // To keep track of result array index

        for (int[] query : queries) {
            int left = query[0];  // Left index of the query
            int right = query[1]; // Right index of the query

            // If the left index is 0, the XOR result is just the cumulative XOR up to `right`
            if (left == 0) {
                res[count++] = cumXor[right];
            } else {
                // Otherwise, XOR the cumulative values to get the XOR of the subarray
                res[count++] = cumXor[right] ^ cumXor[left - 1];
            }
        }

        return res;
    }

    /**
     * Main method to demonstrate both approaches.
     * Uncomment the approach you want to test.
     */
    public static void main(String[] args) {
        XORQueriesofaSubarray solution = new XORQueriesofaSubarraya.java
        ();
        
        // Test case: Example input from the problem description
        int[] arr = {1, 3, 4, 8};
        int[][] queries = {{0, 1}, {1, 2}, {0, 3}, {3, 3}};
        
        // Test brute force approach
        System.out.println("Brute Force Results:");
        int[] resultBruteForce = solution.xorQueriesBruteForce(arr, queries);
        for (int res : resultBruteForce) {
            System.out.print(res + " ");  // Expected output: [2, 7, 14, 8]
        }
        System.out.println();

        // Test efficient approach
        System.out.println("Efficient Approach Results:");
        int[] resultEfficient = solution.xorQueries(arr, queries);
        for (int res : resultEfficient) {
            System.out.print(res + " ");  // Expected output: [2, 7, 14, 8]
        }
    }
}

