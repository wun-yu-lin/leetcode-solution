public class No_7_Reverse_Integer {
    //Brute Force
    static class Solution {
        public int reverse(int x) {
            boolean isNegative = x < 0;
            long absLong = isNegative ? Math.abs((long)x): x;

            String longStr = String.valueOf(absLong);
            StringBuilder sb = new StringBuilder();
            for (int i = longStr.length() -1 ; i >= 0  ; i--) {
                sb.append(longStr.charAt(i));
            }
            long res = Long.parseLong(sb.toString());
            if (res >= Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
                return 0;
            }
            return (int) (isNegative ? res * -1 : res);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

//
//        Example 1:
//
//        Input: x = 1234
//
//        Output: 4321
        System.out.println(solution.reverse(1234));

//        Example 2:
//
//        Input: x = -1234
//
//        Output: -4321
        System.out.println(solution.reverse(-1234));
//        Example 3:
//
//        Input: x = 1234236467
//
//        Output: 0
        System.out.println(solution.reverse(1234236467));

        System.out.println(solution.reverse(-2147483648));


    }


}
