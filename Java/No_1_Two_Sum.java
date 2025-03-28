//Given an array of integers nums and an integer target, return indices of the
//two numbers such that they add up to target.
//
// You may assume that each input would have exactly one solution, and you may
//not use the same element twice.
//
// You can return the answer in any order.
//
//
// Example 1:
//
//
//Input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
//
//
// Example 2:
//
//
//Input: nums = [3,2,4], target = 6
//Output: [1,2]
//
//
// Example 3:
//
//
//Input: nums = [3,3], target = 6
//Output: [0,1]
//
//
//
// Constraints:
//
//
// 2 <= nums.length <= 10⁴
// -10⁹ <= nums[i] <= 10⁹
// -10⁹ <= target <= 10⁹
// Only one valid answer exists.
//
//
//
//Follow-up: Can you come up with an algorithm that is less than
//O(n²)
// time complexity?
//
// Related Topics Array Hash Table
// 👍 59068 👎 2111


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class No_1_Two_Sum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int val = target - nums[i];
            if (map.containsKey(val)){
                return new int[]{map.get(val), i};
            }else{
                map.put(nums[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        No_1_Two_Sum solution = new No_1_Two_Sum();
        solution.twoSum(new int[]{2, 7, 11, 15}, 9);
    }

    //2025-03-24
    public static class solution {
        public int[] twoSum(int[] nums, int target) {
            //key: number, value: index of array
            Map<Integer, Integer> numMap = new HashMap<>();
            //prepare map
            //O(n)
            for(int i = 0; i < nums.length; i++){
                numMap.put(nums[i], i);
            }

            int diff;
            //loop in array
            //O(n)
            for(int i = 0; i < nums.length; i++) {
                diff = target - nums[i];
                if (numMap.containsKey(diff) && numMap.get(diff) != i) {
                    return new int[]{i, numMap.get(diff)};
                }
            }
            // No match found
            return null;
        }

        public static void main(String[] args) {
            //nums = [2,7,11,15], target = 9
            solution twoSum = new solution();
            int[] nums = {2, 7, 11, 15};
            int target = 9;
            System.out.println(Arrays.toString(twoSum.twoSum(nums, target)));

        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
