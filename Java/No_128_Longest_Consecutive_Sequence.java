import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;

public class No_128_Longest_Consecutive_Sequence {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
//        Example 1:
//
//        Input: nums = [100,4,200,1,3,2]
//        Output: 4
        System.out.println(solution.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));

//        Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
//        Example 2:
//
//        Input: nums = [0,3,7,2,5,8,4,6,0,1]
//        Output: 9
        System.out.println(solution.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));

//        Example 3:
//
//        Input: nums = [1,0,1,2]
//        Output: 3
        System.out.println(solution.longestConsecutive(new int[]{1,0,1,2}));
    }
    static class Solution {
        public int longestConsecutive(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            Set<Integer> set = new TreeSet<>();
            //prepare tree set
            for (int num : nums) {
                set.add(num);
            }
            AtomicInteger maxLen = new AtomicInteger(1);
            AtomicInteger curLen = new AtomicInteger(1);
            AtomicInteger preInt = new AtomicInteger(Integer.MAX_VALUE);

            //for loop set
            set.forEach(key -> {
                if (key == preInt.get()+1) {
                    curLen.getAndIncrement();
                } else {
                    curLen.set(1);
                }
                if (maxLen.get() < curLen.get()) {
                    maxLen.set(curLen.get());
                }
                preInt.set(key);
            });
            return maxLen.get();
        }
    }

    static class Solution2 {
        public int longestConsecutive(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            Set<Integer> set = new HashSet<>();
            //prepare set
            for (int num : nums) {
                set.add(num);
            }

            int maxLen = 1;
            for (int num : set) {

                if (set.contains(num-1)) {
                    continue;
                }

                int cur = num;
                int len = 0;
                while (set.contains(cur)) {
                    cur++;
                    len++;
                }

                if (len > maxLen) {
                    maxLen = len;
                }

            }

            return maxLen;
        }
    }

}
