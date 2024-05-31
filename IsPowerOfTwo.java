/**
 * The IsPowerOfTwo class determines whether a given integer is a power of two.
 */
public class IsPowerOfTwo {
    
    /**
     * Checks if the given integer is a power of two.
     * 
     * @param n The integer to be checked.
     * @return true if the integer is a power of two, false otherwise.
     */
    public static boolean powerOfTwo(int n) {
        // If n & (n-1) is 0, then it is a power of two
        return (n & (n - 1)) == 0;
    }
    
    /**
     * Main method to test the powerOfTwo function with sample inputs.
     * 
     * @param args Command line arguments (unused).
     */
    public static void main(String[] args) {
        System.out.println(powerOfTwo(8));   // Output: true
        System.out.println(powerOfTwo(7));   // Output: false
        System.out.println(powerOfTwo(16));  // Output: true
    }
}

