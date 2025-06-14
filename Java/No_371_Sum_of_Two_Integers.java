public class No_371_Sum_of_Two_Integers {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.getSum(5,3));


    }

    static class Solution {
        public int getSum(int a, int b) {
            int loop = 0;
            while (b != 0) { //end when not 進位
                loop++;
                System.out.println("-------loop" + loop +" ---");
                System.out.printf("a : %4s (%d)%n", Integer.toBinaryString(a), a);
                System.out.printf("b : %4s (%d)%n", Integer.toBinaryString(b), b);
                int carry = a & b; //AND 找出進位
                System.out.printf("carry a & b: %4s (%d)%n", Integer.toBinaryString(carry), carry);

                a = a ^ b; // XOR 做加法但不包含進位
                System.out.printf("a ^ b: %4s (%d)%n", Integer.toBinaryString(a), a);

                b = carry << 1;
                System.out.printf("b = carry <<1:  %4s (%d)%n", Integer.toBinaryString(b), b);

                System.out.println("----------------------");

            }
            return a;
        }
    }


    static class Solution2 {
        public int getSum(int a, int b) {
            while (b != 0) { //end when not 進位
                int carry = a & b; //AND 找出進位
                a = a ^ b; // XOR 做加法但不包含進位
                b = carry << 1;
            }
            return a;
        }
    }






}
