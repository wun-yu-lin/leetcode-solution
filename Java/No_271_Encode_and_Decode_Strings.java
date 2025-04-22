import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class No_271_Encode_and_Decode_Strings {

    public static void main(String[] args) {
        // ["neet","code","love","you"]
        runTest(List.of(new String[]{"neet", "code", "love", "you"}));

        runTest(List.of(new String[]{"abc", "123", "addwADW"}));

        //["we","say",":","yes","!@#$%^&*()"]
        runTest(List.of(new String[]{"we", "say", ":", "yes", "!@#$%^&*()"}));

        //[""]
        runTest(List.of(new String[]{""}));
    }

    public static void runTest(List<String> list) {
        Solution s = new Solution();
        System.out.println("input : " + list);
        String encodeStr = s.encode(list);
        System.out.println("encode string: " + encodeStr);
        List<String> decodeList = s.decode(encodeStr);
        System.out.println("decode string: " + decodeList);
    }


    static class Solution {

        public String encode(List<String> strs) {
            if (strs.isEmpty()) {
                return "";
            }
            //UTF-8 characters
            // "abc", "123", "addwADW"
            //output "4#abc3#1237#addwADW
            StringBuilder sb = new StringBuilder();

            for (String str : strs) {
                int size = str.length();
                sb.append(size).append("#").append(str);
            }

            return sb.toString();
        }

        public List<String> decode(String str) {
            if (str.isEmpty()) {
                return Collections.emptyList();
            }
            //UTF-8 characters
            // 3#abc3#1237#addwADW
            //output [ "abc", "123", "addwADW" ]

            char[] chars = str.toCharArray();
            List<String> res = new ArrayList<>();
            int i = 0; //index of #
            int n = 0; //index  size of subString
            while (i < chars.length) {
                char next = chars[i];
                int start;
                int end;
                if (next == '#') {
                    int size = Integer.parseInt(new String(chars, n, i - n));
                    start = i + 1;
                    end = start + size;
                    char[] sub = Arrays.copyOfRange(chars, start, end);
                    res.add(sub.length == 0 ? "" : String.valueOf(sub));
                    //shift index
                    i = end;
                    n = end;
                } else {
                    i++;
                }
            }
            return res;
        }
    }


}
