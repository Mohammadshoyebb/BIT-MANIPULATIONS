public class FindUniqueNumber {
    public int findUnique(int[] nums) {
        int unique = 0;
        for (int num : nums) {
            unique ^= num;
        }
        return unique;
    }

    public static void main(String[] args) {
        FindUniqueNumber solution = new FindUniqueNumber();
        int[] nums1 = {2, 3, 2};
        int[] nums2 = {4, 1, 2, 1, 2};
        int[] nums3 = {1};
        
        System.out.println(solution.findUnique(nums1)); // Output: 3
        System.out.println(solution.findUnique(nums2)); // Output: 4
        System.out.println(solution.findUnique(nums3)); // Output: 1
    }
}
