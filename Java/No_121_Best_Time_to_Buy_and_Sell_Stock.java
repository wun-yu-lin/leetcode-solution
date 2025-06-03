import java.util.logging.Logger;

public class No_121_Best_Time_to_Buy_and_Sell_Stock {
    private static final Logger log = Logger.getLogger(No_121_Best_Time_to_Buy_and_Sell_Stock.class.getName());
    public static void main(String[] args) {
        Solution solution = new Solution();
//        Example 1:
//
//        Input: prices = [7,1,5,3,6,4]
//        Output: 5
//        Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
//        Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
        log.info(String.valueOf(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4})));

//        Example 2:
//
//        Input: prices = [7,6,4,3,1]
//        Output: 0
//        Explanation: In this case, no transactions are done and the max profit = 0.
        log.info(String.valueOf(solution.maxProfit(new int[]{7, 6, 4, 3, 1})));


    }


    static class Solution {
        public int maxProfit(int[] prices) {
            int benefit = 0;
            int minInt = Integer.MAX_VALUE;
            for (int i = 0; i < prices.length; i++) {
                int curr = prices[i] - minInt;
                benefit = Math.max(curr, benefit);
                minInt = Math.min(prices[i], minInt);
            }
            return benefit;
        }
    }


}
