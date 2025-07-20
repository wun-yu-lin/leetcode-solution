import java.util.logging.Logger;

public class No_33_Search_in_Rotated_Sorted_Array {
    private static final Logger logger = Logger.getLogger(No_33_Search_in_Rotated_Sorted_Array.class.getName());

    public static void main(String[] args) {
        Solution solution = new Solution();
//        Example 1:
//        Input: nums = [4,5,6,7,0,1,2], target = 0
//        Output: 4
        logger.info(String.valueOf(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0)));

//        Example 2:
//        Input: nums = [4,5,6,7,0,1,2], target = 3
//        Output: -1
        logger.info(String.valueOf(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3)));


//        Example 3:
//        Input: nums = [1], target = 0
//        Output: -1
        logger.info(String.valueOf(solution.search(new int[]{1}, 0)));


    }

    static class Solution {
        public int search(int[] nums, int target) {
            int lp = 0;
            int rp = nums.length - 1;
            int minIndex = -1;
            //find index of min value in array
            while (lp < rp) {
                int mp = (rp - lp) / 2 + lp;
                if (nums[mp] > nums[rp]) {
                    lp = mp + 1;
                } else {
                    rp = mp;
                }
            }
            minIndex = lp;

            int left = 0;
            int right = nums.length - 1;
            int medium = 0;
            int offset = nums.length - minIndex;
            int realMid;
            while (left <= right) {
                medium = (right - left) / 2 + left;
                realMid = (medium - offset) < 0 ? medium - offset + nums.length : medium - offset;

                if (nums[realMid] == target) {
                    return realMid;
                } else if (nums[realMid] < target) {
                    left = medium + 1;
                } else {
                    right = medium - 1;
                }
            }
            return -1;
        }
    }


}
