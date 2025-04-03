
public class No_1768_Merge_Strings_Alternately {
    static class Solution {
        public String mergeAlternately(String word1, String word2) {
            int p1 = 0, p2 = 0;
            StringBuilder sb = new StringBuilder();
            while (p1 < word1.length() || p2 < word2.length()) {
                if (p1 < word1.length()) {
                    sb.append(word1.charAt(p1++));
                }
                if (p2 < word2.length()) {
                    sb.append(word2.charAt(p2++));
                }
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        Example 1:
//
//        Input: word1 = "abc", word2 = "pqr"
//        Output: "apbqcr"
//        Explanation: The merged string will be merged as so:
//        word1:  a   b   c
//        word2:    p   q   r
//        merged: a p b q c r
        System.out.println(solution.mergeAlternately("abc", "pqr"));
//        Example 2:
//
//        Input: word1 = "ab", word2 = "pqrs"
//        Output: "apbqrs"
//        Explanation: Notice that as word2 is longer, "rs" is appended to the end.
//                word1:  a   b
//        word2:    p   q   r   s
//        merged: a p b q   r   s
        System.out.println(solution.mergeAlternately("ab", "pqrs"));
//        Example 3:
//
//        Input: word1 = "abcd", word2 = "pq"
//        Output: "apbqcd"
//        Explanation: Notice that as word1 is longer, "cd" is appended to the end.
//                word1:  a   b   c   d
//        word2:    p   q
//        merged: a p b q c   d
        System.out.println(solution.mergeAlternately("abcd", "pq"));
    }
}
