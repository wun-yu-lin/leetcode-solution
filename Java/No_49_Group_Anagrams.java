import java.util.*;

public class No_49_Group_Anagrams {
    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> mapping = new HashMap<>();

            for (String str : strs) {
                String key = getMappingKey(str);
                if (!mapping.containsKey(key)) {
                    List<String> list = new ArrayList<>();
                    list.add(str);
                    mapping.put(key, list);
                } else {
                    mapping.get(key).add(str);
                }
            }
            
            return new ArrayList<>(mapping.values());
        }

        private static String getMappingKey (String str) {
            char[] chars = str.toCharArray();
            int[] count = new int[26];
            char bias = 'a';
            for (char c : chars) {
                count[c - bias]++;
            }
            return Arrays.toString(count);
        }

        public static void main(String[] args) {
            Solution solution = new Solution();
//            Example 1:
//
//            Input: strs = ["eat","tea","tan","ate","nat","bat"]
//
//            Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
//
//            Explanation
            System.out.println(solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
//
//            There is no string in strs that can be rearranged to form "bat".
//                    The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
//                    The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
//                    Example 2:
//
//            Input: strs = [""]
//
//            Output: [[""]]
            System.out.println(solution.groupAnagrams(new String[]{""}));
//
//            Example 3:
//
//            Input: strs = ["a"]
//
//            Output: [["a"]]
            System.out.println(solution.groupAnagrams(new String[]{"a"}));
        }
    }


}
