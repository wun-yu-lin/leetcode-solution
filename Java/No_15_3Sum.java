import java.util.*;
import java.util.logging.Logger;

public class No_15_3Sum {

    private static final Logger log = Logger.getLogger(No_15_3Sum.class.getName());

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
//        Example 1:
//        Input: nums = [-1,0,1,2,-1,-4]
//        Output: [[-1,-1,2],[-1,0,1]]
//        Explanation:
//        nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
//        nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
//        nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
//        The distinct triplets are [-1,0,1] and [-1,-1,2].
//        Notice that the order of the output and the order of the triplets does not matter.
        log.info(String.valueOf(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4})));


//        Example 2:
//        Input: nums = [0,1,1]
//        Output: []
//        Explanation: The only possible triplet does not sum up to 0.
        log.info(String.valueOf(solution.threeSum(new int[]{0,1,1})));


//        Example 3:
//
//        Input: nums = [0,0,0]
//        Output: [[0,0,0]]
//        Explanation: The only possible triplet sums up to 0.
        log.info(String.valueOf(solution.threeSum(new int[]{0, 0,0})));

        //[1,2,-2,-1]
        log.info(String.valueOf(solution.threeSum(new int[]{1,2,-2,-1})));

        //[2,-3,0,-2,-5,-5,-4,1,2,-2,2,0,2,-4,5,5,-10]
        log.info(String.valueOf(solution.threeSum(new int[]{2,-3,0,-2,-5,-5,-4,1,2,-2,2,0,2,-4,5,5,-10})));


    }

    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            if (nums == null || nums.length < 3) {
                return Collections.emptyList();
            }
            //sort nums
            Arrays.sort(nums);

            List<List<Integer>> res = new ArrayList<>();
            //skip duplicate triplets.
            Set<String> set = new HashSet<>();

            // Skip duplicate check to prevent timeout
            Set<Integer> numSet = new HashSet<>();

            //int[i] = a, b + c need = -a
            for (int i = 0; i < nums.length; i++) {
                int target = -nums[i];
                int rp =  nums.length - 1;
                int lp = 0;
                if (numSet.contains(nums[i])) {
                    continue;
                } else {
                    numSet.add(nums[i]);
                }
                while (lp < rp) {
                    if (lp == i) {
                        lp++;
                        continue;
                    }

                    if (rp == i) {
                        rp--;
                        continue;
                    }
                    int temp = nums[lp] + nums[rp];
                    if (temp == target) {
                        List<Integer> subRes = Arrays.asList(nums[i], nums[lp], nums[rp]);
                        String key = getMappingKey(subRes);
                        if (!set.contains(key)) {
                            res.add(subRes);
                            set.add(key);
                        }
                        //by pass duplicate
                        while (lp < rp && nums[lp] == nums[lp + 1]) lp++;
                        while (rp < rp && nums[rp] == nums[rp - 1]) rp--;
                        rp--;
                        lp++;
                    } else if (temp > target) {
                        rp--;
                    } else {
                        lp++;
                    }

                }
            }
            return res;
        }

        private String getMappingKey(List<Integer> nums) {
            return nums.stream().sorted().toList().toString();
        }
    }


    static class Solution2 {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);

            for (int i = 0; i < nums.length - 2; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) continue; // Skip duplicates
                if (nums[i] > 0) continue;
                int lp = i + 1;
                int rp = nums.length - 1;
                int target = -nums[i];

                while (lp < rp) {
                    int sum = nums[lp] + nums[rp];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[lp], nums[rp]));

                        // Skip duplicates
                        while (lp < rp && nums[lp] == nums[lp + 1]) lp++;
                        while (lp < rp && nums[rp] == nums[rp - 1]) rp--;

                        lp++;
                        rp--;
                    } else if (sum < target) {
                        lp++;
                    } else {
                        rp--;
                    }
                }
            }

            return res;
        }
    }

}
