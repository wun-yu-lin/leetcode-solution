import java.util.HashSet;
import java.util.Set;

public class No_217_Contains_Duplicate {

    static class Solution {
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                // Return true if a duplicate is found
                if (set.contains(num)) {
                    return true;
                }
                set.add(num);
            }
            // All numbers are distinct
            return false;
        }


        public static void main(String[] args) {
            Solution solution = new Solution();
//            Example 1:
//
//            Input: nums = [1,2,3,1]
//
//            Output: true
            System.out.println(solution.containsDuplicate(new int[]{1, 2, 3, 1}));
//
//            Explanation:
//
//            The element 1 occurs at the indices 0 and 3.
//
//            Example 2:
//
//            Input: nums = [1,2,3,4]
//
//            Output: false

            System.out.println(solution.containsDuplicate(new int[]{1, 2, 3, 4}));
//
//            Explanation:
//
//            All elements are distinct.
//
//            Example 3:
//
//            Input: nums = [1,1,1,3,3,4,3,2,4,2]
//
//            Output: true
            System.out.println(solution.containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
        }
    }

}
