import java.util.logging.Logger;

public class No_11_Container_With_Most_Water {
    private static final Logger log = Logger.getLogger(No_11_Container_With_Most_Water.class.getName());

    public static void main(String[] args) {
        Solution solution = new Solution();
//        Input: height = [1,8,6,2,5,4,8,3,7]
//        Output: 49
//        Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
        log.info(String.valueOf(solution.maxArea(new int[] {1,8,6,2,5,4,8,3,7})));


//        Example 2:
//
//        Input: height = [1,1]
//        Output: 1
        log.info(String.valueOf(solution.maxArea(new int[] {1,1})));

        //[1,2,4,3]
        // 4
        log.info(String.valueOf(solution.maxArea(new int[] {1,2,4,3})));

        //[1,2,3,1000,9]
        //9
        log.info(String.valueOf(solution.maxArea(new int[] {1,2,3,1000,9})));

        //[1,8,6,2,5,4,8,25,7]
        //49
        log.info(String.valueOf(solution.maxArea(new int[] {1,8,6,2,5,4,8,25,7})));


    }



    static class Solution {
        public int maxArea(int[] height) {
            if (height.length == 0) return 0;
            if (height.length == 1) return height[0];
            int maxArea = Integer.MIN_VALUE;
            int lp = 0;
            int rp = height.length - 1;

            while (lp < rp) {
                int minHeight = Math.min(height[lp], height[rp]);
                int area = minHeight * (rp - lp);
                if (area > maxArea) {
                    maxArea = area;
                }
                //shift pointer
                if (height[lp] < height[rp]) {
                    lp++;
                } else {
                    rp--;
                }
            }

            return maxArea;

        }
    }
}
