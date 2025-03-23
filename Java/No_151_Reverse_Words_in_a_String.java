public class No_151_Reverse_Words_in_a_String {
    class Solution {
        public String reverseWords(String s) {
            String[] strs = s.split(" ");
            int index = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = strs.length -1; i >=0; i--) {
                String currStr = strs[i];
                //emptyString 跳過
                if (currStr == null || currStr.isEmpty()) {
                    continue;
                }
                //開頭
                if (index != 0) {
                    sb.append(" ");
                }
                index++;
                sb.append(currStr);
            }
            return sb.toString();
        }
    }
}

