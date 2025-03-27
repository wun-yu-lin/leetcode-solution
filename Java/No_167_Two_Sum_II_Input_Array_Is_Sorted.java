import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class No_167_Two_Sum_II_Input_Array_Is_Sorted {
    //O(n)
    static class Solution {
        public int[] twoSum(int[] numbers, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            int n = numbers.length;
            for (int i = 0; i < n; i++) {
                int index = i+1;
                map.put(numbers[i], index);
            }

            for (int i = 0; i < n; i++) {
                int index = i+1;
                int val = target - numbers[i];
                if (map.containsKey(val)){
                    return new int[]{index, map.get(val)};
                }
            }
            return null;
        }
    }

    // O(1) ~ O(n)
    static class Solution2 {
        public int[] twoSum(int[] numbers, int target) {
            int sp = 0;
            int ep = numbers.length - 1;

            while (sp < ep) {
                int sum = numbers[sp] + numbers[ep];
                if (sum == target) {
                    return new int[]{++sp, ++ep};
                }
                if (sum < target) {
                    sp++;
                }
                if (sum > target) {
                    ep--;
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {
//            Example 1:
//
//            Input: numbers = [2,7,11,15], target = 9
//            Output: [1,2]
//            Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
        Solution2 solution = new Solution2();
        System.out.println(Arrays.toString(solution.twoSum(new int[]{2, 7, 11, 15}, 9)));

//            Example 2:
//
//            Input: numbers = [2,3,4], target = 6
//            Output: [1,3]
//            Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
        System.out.println(Arrays.toString(solution.twoSum(new int[]{2, 3, 4}, 6)));
//            Example 3:
//
//            Input: numbers = [-1,0], target = -1
//            Output: [1,2]
//            Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
        System.out.println(Arrays.toString(solution.twoSum(new int[]{-1,0}, -1)));
    }

}
