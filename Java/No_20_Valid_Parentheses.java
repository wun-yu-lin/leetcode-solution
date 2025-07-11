import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.logging.Logger;

public class No_20_Valid_Parentheses {
    private final static Logger logger = Logger.getLogger(No_20_Valid_Parentheses.class.getName());

    public static void main(String[] args) {
        Solution solution = new Solution();
//        Example 1:
//        Input: s = "()"
//        Output: true
        logger.info("Example 1:" + solution.isValid("()"));
//
//        Example 2:
//        Input: s = "()[]{}"
//        Output: true
        logger.info("Example 2:" + solution.isValid("()[]{}"));

//        Example 3:
//        Input: s = "(]"
//        Output: false
        logger.info("Example 3:" + solution.isValid("(]"));

//        Example 4:
//        Input: s = "([])"
//        Output: true
        logger.info("Example 4:" + solution.isValid("([])"));


    }
    static class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            Map<Character, Character> pair = new HashMap<>();
            pair.put('{', '}');
            pair.put('[', ']');
            pair.put('(', ')');
            char[] chars = s.toCharArray();

            for (char c : chars) {
                if (pair.containsKey(c)) {
                    stack.push(c);
                    continue;
                }
                //not match
                if (stack.isEmpty()) {
                    return false;
                }
                Character temp = stack.pop();
                Character target = pair.get(temp);
                // not match
                if (!target.equals(c)) {
                    return false;
                }

            }
            return stack.isEmpty();
        }
    }
}
