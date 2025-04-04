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
    //iteration solution
    static class Solution2 {
        public int reverse(int x) {
            final int MIN = -2147483648; // -2^31
            final int MAX = 2147483647;  // 2^31 - 1

            int result = 0;
            int curentInt = x;
            while (curentInt != 0) {
                //last number
                int digit = curentInt % 10;
                curentInt /= 10; // remove last number
                if (result > MAX / 10 || (result == MAX / 10 && digit > MAX % 10))
                    return 0;
                if (result < MIN / 10 || (result == MIN / 10 && digit < MIN % 10))
                    return 0;
                result = (result * 10) + digit;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();

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
