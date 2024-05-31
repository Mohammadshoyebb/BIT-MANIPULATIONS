
/*
861. Score After Flipping Matrix
Solved
Medium
Topics
Companies
You are given an m x n binary matrix grid.

A move consists of choosing any row or column and toggling each value in that row or column (i.e., changing all 0's to 1's, and all 1's to 0's).

Every row of the matrix is interpreted as a binary number, and the score of the matrix is the sum of these numbers.

Return the highest possible score after making any number of moves (including zero moves).

 

Example 1:


Input: grid = [[0,0,1,1],[1,0,1,0],[1,1,0,0]]
Output: 39
Explanation: 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
Example 2:

Input: grid = [[0]]
Output: 1
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 20
grid[i][j] is either 0 or 1.

*/


// ====================================================================SOLUTION=============================================================================================
public class ScoreAfterFlippingMatrix {
    public int matrixScore(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Step 1: Ensure each row starts with a 1 by flipping rows if necessary
        for (int i = 0; i < rows; i++) {
            if (grid[i][0] == 0) {
                flipRow(grid, i);
            }
        }

        // Step 2: Ensure each column has more 1s than 0s by flipping columns if necessary
        for (int j = 1; j < cols; j++) {
            int countOnes = 0;
            for (int i = 0; i < rows; i++) {
                countOnes += grid[i][j];
            }
            // Flip the column if it has fewer 1s than 0s
            if (countOnes < (rows + 1) / 2) {
                flipColumn(grid, j);
            }
        }

        // Step 3: Calculate the score
        int score = 0;
        for (int i = 0; i < rows; i++) {
            int rowScore = 0;
            for (int j = 0; j < cols; j++) {
                rowScore = (rowScore << 1) + grid[i][j];
            }
            score += rowScore;
        }

        return score;
    }

    private void flipRow(int[][] grid, int row) {
        for (int j = 0; j < grid[0].length; j++) {
            grid[row][j] ^= 1; // Toggle the value
        }
    }

    private void flipColumn(int[][] grid, int col) {
        for (int i = 0; i < grid.length; i++) {
            grid[i][col] ^= 1; // Toggle the value
        }
    }

    public static void main(String[] args) {
        ScoreAfterFlippingMatrix solution = new ScoreAfterFlippingMatrix();
        
        int[][] grid1 = {
            {0, 0, 1, 1},
            {1, 0, 1, 0},
            {1, 1, 0, 0}
        };
        System.out.println("Output for example 1: " + solution.matrixScore(grid1)); // Output: 39

        int[][] grid2 = {{0}};
        System.out.println("Output for example 2: " + solution.matrixScore(grid2)); // Output: 1
    }
}