import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class No_392_Is_Subsequence {
    class Solution {
        public boolean isSubsequence(String s, String t) {
            if (s.isEmpty()) {
                return true;
            }

            Queue<Character> queue = new ArrayDeque<>();
            for (int i = 0; i < s.length(); i++) {
                queue.offer(s.charAt(i));
            }

            Character tempChar = queue.poll(); // first;
            for (int i = 0; i < t.length(); i++) {
                if (tempChar != null && tempChar.equals(t.charAt(i))) {
                    if (queue.isEmpty()) {
                        return true;
                    }
                    tempChar = queue.poll();
                }
            }
            return false;
        }
    }


    class Solution2 {
        public boolean isSubsequence(String s, String t) {
            if (s.isEmpty()) {
                return true;
            }
            Deque<Character> deque = new ArrayDeque<>();
            for (var c : s.toCharArray()) {
                deque.addLast(c);
            }

            Character tempChar = deque.poll(); // first;
            for (int i = 0; i < t.length(); i++) {
                if (tempChar != null && tempChar.equals(t.charAt(i))) {
                    if (deque.isEmpty()) {
                        return true;
                    }
                    tempChar = deque.poll();
                }
            }
            return false;
        }
    }
}

