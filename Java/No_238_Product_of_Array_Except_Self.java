public class No_238_Product_of_Array_Except_Self {
    class Solution {
        /**
         * <pre>
         * prefix = nums[0] × nums[1] × ... × nums[i-1]
         * suffix = nums[i+1] × nums[i+2] × ... × nums[n-1]
         *
         * input [a,b,c,d]
         * output [bcd, acd, abd, abc]
         *
         * prefix [1, a, ab, abc]
         * suffix [bcd, cd, d, 1]
         *
         * for loop i = 1 to prefix.len -1
         *  res[i] = prefix[i] x suffix[i]
         *
         * </pre>
         *
         *
         *
         */
        public int[] productExceptSelf(int[] nums) {

            int n = nums.length;
            int[] res = new int[n];
            res[0] = 1;

            // 前綴積
            for (int i = 1; i < n; i++) {
                res[i] = res[i - 1] * nums[i - 1];
            }

            int rigth = 1;
            // 後綴積
            for (int i = n - 1; i >= 0; i--) {
                res[i] *= rigth;
                rigth *= nums[i];
            }

            return res;
        }
    }

//
//
//        ### **功能概述**
//        - 給定一個整數數組 `nums`，返回一個新數組 `res`。
//        - `res[i]` 的值為陣列中除了 `nums[i]` 本身之外，其他所有元素的乘積。
//        - **限制**：要求 **時間複雜度為 O(n)** 且 **不使用除法運算**。
//
//        - **目標**：計算 **前綴積 (prefix product)**，並將其儲存在 `res` 中。
//        - **初始化**：
//        - `res[0] = 1`：對於數組最左邊的元素，前面沒有其他元素，因此前綴積為 1。
//        - **計算邏輯**：
//        - 對於每個 `i`，`res[i]` 等於前一個位置的前綴積 `res[i-1]` 乘以前一個元素 `nums[i-1]`。
//        - **例子**：
//        - `nums = [1, 2, 3, 4]`，執行後：
//        - `res = [1, 1, 2, 6]`。
//        - 這表示每個 `i` 的左側所有元素的乘積。
//
//        ---
//
//        #### 2. **後綴積計算與結果更新**
//        ```java
//        int rigth = 1;
//
//        for (int i = n - 1; i >= 0; i--) {
//        res[i] *= rigth;
//        rigth *= nums[i];
//        }
//        ```
//
//        - **目標**：在原本存有 **前綴積** 的 `res` 上，乘上 **後綴積 (suffix product)**。
//        - **初始化**：
//        - `rigth = 1`：最右邊的元素後面沒有其他元素，所以後綴積初始為 1。
//        - **計算邏輯**：
//        - 從右往左遍歷陣列：
//        - `res[i] *= rigth`：將前綴積與當前的後綴積相乘，得到 `res[i]`。
//        - `rigth *= nums[i]`：更新後綴積，將當前元素 `nums[i]` 乘進去。
//        - **例子**：
//        - `nums = [1, 2, 3, 4]`，`res` 初始為 `[1, 1, 2, 6]`。
//        - 從右到左遍歷：
//        - `i = 3`：`res[3] = 6 × 1 = 6`，`rigth = 1 × 4 = 4`。
//        - `i = 2`：`res[2] = 2 × 4 = 8`，`rigth = 4 × 3 = 12`。
//        - `i = 1`：`res[1] = 1 × 12 = 12`，`rigth = 12 × 2 = 24`。
//        - `i = 0`：`res[0] = 1 × 24 = 24`，`rigth = 24 × 1 = 24`。
//        - 最終結果：`res = [24, 12, 8, 6]`。
//
//        ---
//
//        ### **完整邏輯**
//        1. **前綴積 (Prefix)**：從左到右計算每個元素左側所有數字的乘積。
//        2. **後綴積 (Suffix)**：從右到左計算每個元素右側所有數字的乘積，並將其乘上前綴積。
//        3. 結果儲存在 `res` 中。
//
//        ---
//
//        ### **時間與空間複雜度**
//        1. **時間複雜度**：O(n)
//        - 前綴積和後綴積各需要一次遍歷。
//        2. **空間複雜度**：O(1)（忽略輸出數組 `res` 的空間）。
//
//        ---
//
//        ### **變數拼寫錯誤**
//        程式碼中有個小錯誤：
//        ```java
//        int rigth = 1;
//        ```
//        `rigth` 應該是 `right`。
//
//        ---
//
//        ### **修正後程式碼**
}


