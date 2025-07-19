import java.util.logging.Logger;

public class No_153_Find_Minimum_in_Rotated_Sorted_Array {

    private static final Logger logger = Logger.getLogger(No_153_Find_Minimum_in_Rotated_Sorted_Array.class.getName());

    public static void main(String[] args) {
        Solution solution = new Solution();
//        Example 1:
//
//        Input: nums = [3,4,5,1,2]
//        Output: 1
//        Explanation: The original array was [1,2,3,4,5] rotated 3 times.
        logger.info(String.valueOf(solution.findMin(new int[]{3, 4, 5, 1, 2})));

//         Example 2:
//        Input: nums = [4,5,6,7,0,1,2]
//        Output: 0
//        Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
        logger.info(String.valueOf(solution.findMin(new int[]{4, 5, 6, 7, 0, 1, 2})));


//        Example 3:
//        Input: nums = [11,13,15,17]
//        Output: 11
//        Explanation: The original array was [11,13,15,17] and it was rotated 4 times.
        logger.info(String.valueOf(solution.findMin(new int[]{11, 13, 15, 17})));


    }

    static class Solution {
        public int findMin(int[] nums) {
            int lp = 0;
            int rp = nums.length - 1;
            while (lp < rp) {
                int mid = (lp + rp) / 2;
                if (nums[mid] > nums[rp]) {
                    lp = mid + 1;
                } else {
                    rp = mid - 1;
                }
            }

            return nums[lp];

        }
    }
}
