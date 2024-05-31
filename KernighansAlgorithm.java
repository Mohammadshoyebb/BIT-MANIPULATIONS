public class KernighansAlgorithm {
    public static void main(String[] args) {
        // Test cases
        int n1 = 10;
        System.out.println("Number of set bits in " + n1 + ": " + countSetBits(n1)); // Output: 2
        
        int n2 = 7;
        System.out.println("Number of set bits in " + n2 + ": " + countSetBits(n2)); // Output: 3
        
        int n3 = 100;
        System.out.println("Number of set bits in " + n3 + ": " + countSetBits(n3)); // Output: 3
    }
    
    // Kernighan's Algorithm Implementation to count set bits in an integer
    public static int countSetBits(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1); // Clear the rightmost set bit
            count++;
        }
        return count;
    }
}
