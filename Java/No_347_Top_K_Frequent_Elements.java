import java.util.*;

public class No_347_Top_K_Frequent_Elements {
    static class Solution {
        public static class DataObj {
            int num;
            int count;

            public DataObj(int num, int count) {
                this.num = num;
                this.count = count;
            }
        }

        public int[] topKFrequent(int[] nums, int k) {
            //MAX HEAP
            PriorityQueue<DataObj> pq = new PriorityQueue<>((a, b) -> b.count - a.count);
            //key: nums, DataObj
            Map<Integer, DataObj> map = new HashMap<>();

            //prepare map
            for (int num : nums) {
                if (!map.containsKey(num)) {
                    map.put(num, new DataObj(num, 1));
                } else {
                    DataObj d = map.get(num);
                    d.count++;
                }
            }
            //prepare pq
            pq.addAll(map.values());

            //get first k element
            int[] res = new int[k];
            for (int i = 0; i < k; i++) {
                if (pq.isEmpty()) {
                    break;
                }
                DataObj d = pq.poll();
                res[i] = d.num;
            }
            return res;
        }

    }
    static class Solution2 {

        public int[] topKFrequent(int[] nums, int k) {
            //MAX HEAP, MAP<Key:num, value:count>
            PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
            //key: nums, value: count of each num
            Map<Integer, Integer> map = new HashMap<>();

            //prepare map
            for (int num : nums) {
                if (!map.containsKey(num)) {
                    map.put(num,1);
                } else {
                    map.put(num, map.get(num) + 1);
                }
            }
            //prepare pq
            pq.addAll(map.entrySet());

            //get first k element
            int[] res = new int[k];
            for (int i = 0; i < k; i++) {
                if (pq.isEmpty()) {
                    break;
                }
                Map.Entry<Integer, Integer> m = pq.poll();
                res[i] = m.getKey();
            }
            return res;
        }

    }


    public static void main(String[] args) {
        Solution2 solution = new Solution2();
//        Example 1:
//
//        Input: nums = [1,1,1,2,2,3], k = 2
//        Output: [1,2]
        System.out.println(Arrays.toString(solution.topKFrequent(new int[]{1, 2}, 2)));


//        Example 2:
//
//        Input: nums = [1], k = 1
//        Output: [1]
        System.out.println(Arrays.toString(solution.topKFrequent(new int[]{1}, 1)));

    }

}
