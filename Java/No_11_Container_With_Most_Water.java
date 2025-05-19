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
        log.info(String.valueOf(solution.maxArea(new int[] {1,2,4,3})));

        //[1,2,3,1000,9]
        log.info(String.valueOf(solution.maxArea(new int[] {1,2,3,1000,9})));

        //[1,8,6,2,5,4,8,25,7]
        log.info(String.valueOf(solution.maxArea(new int[] {1,8,6,2,5,4,8,25,7})));


    }



    static class Solution {
        public int maxArea(int[] height) {
            if (height.length == 0) return 0;
            if (height.length == 1) return height[0];
            if (height.length == 2) return Math.min(height[0], height[1]);
            int currArea;

            //find left max area
            int leftMaxArea = Integer.MIN_VALUE;
            int leftMaxIdx = 0;

            for (int i = 0; i < height.length - 1; i++) {
                currArea = height[i] * (height.length - i);
                if (leftMaxArea < currArea) {
                    leftMaxArea = currArea;
                    leftMaxIdx = i;
                }
            }

            //find right max area
            int rightMaxArea = Integer.MIN_VALUE;
            int rightMaxIdx = 0;
            for (int i = height.length - 1; i >=0 ; i--) {
                if (i == leftMaxIdx) {continue;}
                currArea = height[i] * (i+1) ;
                if (rightMaxArea < currArea) {
                    rightMaxArea = currArea;
                    rightMaxIdx = i;
                }
            }

            //calculate max area
            int minHeight = Math.min(height[leftMaxIdx], height[rightMaxIdx]);
            int diff = rightMaxIdx - leftMaxIdx;
            if (diff == 0) {
                diff = 1;
            }
            return minHeight * diff;
        }
    }
}
