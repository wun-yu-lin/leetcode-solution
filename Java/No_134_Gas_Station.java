public class No_134_Gas_Station {
    class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int n = gas.length;
            int totalGas = 0;
            int totalGasCost = 0;
            int currGas = 0;
            int start = 0;
            for (int i = 0; i < n; i++) {
                totalGas += gas[i];
                totalGasCost += cost[i];

                currGas = currGas - cost[i] + gas[i];
                // 負數表示 gas 庫存不足
                if (currGas < 0) {
                    start = i + 1;
                    currGas = 0;
                }
            }

            if (totalGasCost > totalGas) {
                return -1;
            } else {
                return start;
            }
        }
    }
//
//
//### 🚀 **LeetCode 134: Gas Station**
//
//        #### 📚 **題目描述**
//        在一個圓形的加油站路線上，有 `n` 個加油站。
//        - 每個加油站有一定量的汽油，存放在陣列 `gas` 中。
//        - 從第 `i` 個加油站前往第 `i+1` 個加油站需要消耗一定的汽油，存放在陣列 `cost` 中。
//
//        **你可以從任意加油站開始，繞行一圈回到起點。**
//        - 如果可以完成，返回出發的加油站的索引（0-based）。
//        - 如果無法完成，返回 `-1`。
//
//        **條件**：
//        - 如果總加油量 (`sum(gas)`) 小於總消耗量 (`sum(cost)`)，則不可能完成一圈。
//
//        ---
//
//        ### 💡 **解題思路**
//
//        1. **總油量判斷**
//        - 如果 `sum(gas) < sum(cost)`，無法完成繞行，直接返回 `-1`。
//
//        2. **局部油量判斷**
//        - 使用變量 `currGas` 計算當前油量。如果在某個加油站時，油量變成負數，說明從這個加油站開始無法到達下一個加油站。
//        - 當 `currGas < 0` 時，將起點設為下一個加油站，並將 `currGas` 重置為 `0`。
//
//        3. **最終結果**
//        - 如果遍歷完所有加油站後，總加油量 ≥ 總消耗量，則起始站點是有效的。
//
//        ---
//
//        ### 🛠️ **代碼解釋**
//
//        ```java
//class Solution {
//    public int canCompleteCircuit(int[] gas, int[] cost) {
//        int n = gas.length;
//        int totalGas = 0;      // 總加油量
//        int totalGasCost = 0;  // 總消耗量
//        int currGas = 0;       // 當前油量
//        int start = 0;         // 起始加油站索引
//
//        for (int i = 0; i < n; i++) {
//            totalGas += gas[i];        // 累計加油量
//            totalGasCost += cost[i];   // 累計消耗量
//            currGas = currGas - cost[i] + gas[i]; // 當前油量變化
//
//            // 如果當前油量變為負數，無法繼續前進
//            if (currGas < 0) {
//                start = i + 1; // 將起點設為下一個加油站
//                currGas = 0;   // 重置當前油量
//            }
//        }
//
//        // 總油量不足，無法完成一圈
//        if (totalGas < totalGasCost) {
//            return -1;
//        } else {
//            return start;
//        }
//    }
//}
//```
//
//        ---
//
//        ### 📊 **步驟示範**
//
//        **範例：**
//        - `gas = [1, 2, 3, 4, 5]`
//        - `cost = [3, 4, 5, 1, 2]`
//
//        | 站點 | gas | cost | currGas | start |
//        |------|-----|------|---------|-------|
//        | 0    | 1   | 3    | -2      | 1     |
//        | 1    | 2   | 4    | -2      | 2     |
//        | 2    | 3   | 5    | -2      | 3     |
//        | 3    | 4   | 1    | 3       | 3     |
//        | 4    | 5   | 2    | 6       | 3     |
//
//        - **總加油量：** `1+2+3+4+5 = 15`
//        - **總消耗量：** `3+4+5+1+2 = 15`
//
//        總油量 ≥ 總消耗量，從 `3` 出發可以完成一圈。
//
//        **結果：** `3`
//
//        ---
//
//        ### 🧠 **時間與空間複雜度**
//        - **時間複雜度：** \( O(n) \) — 單次遍歷 `gas` 和 `cost` 陣列。
//        - **空間複雜度：** \( O(1) \) — 只使用了常數空間。
//
//        ---
//
//        ### ✅ **關鍵點總結**
//        1. 總加油量 ≥ 總消耗量，才有可能完成一圈。
//        2. 當前油量小於零時，起點移動到下一個加油站。
//        3. 遍歷結束後返回有效起點。
}

