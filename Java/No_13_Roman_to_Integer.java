import java.util.HashMap;
import java.util.Map;

public class No_13_Roman_to_Integer {
    static class Solution {

        private static final Map<Character, Integer> romanMap = new HashMap<>();
        static {
            romanMap.put('I', 1);
            romanMap.put('V', 5);
            romanMap.put('X', 10);
            romanMap.put('L', 50);
            romanMap.put('C', 100);
            romanMap.put('D', 500);
            romanMap.put('M', 1000);
        }

        public int romanToInt(String s) {
            int sum = 0;
            if (s.isEmpty()) {
                return sum;
            }
            sum += romanMap.get(s.charAt(s.length() - 1));
            for (int i = s.length() - 2; i >= 0; i--) {
                char nextChar = s.charAt(i + 1);
                char currChar = s.charAt(i);
                if (romanMap.get(nextChar) > romanMap.get(currChar)) {
                    sum -= romanMap.get(currChar);
                } else {
                    sum += romanMap.get(currChar);
                }
            }

            return sum;
        }
    }

//
//
//要從羅馬數字的邏輯來理解這段程式碼，我們需要先掌握羅馬數字的基本規則，然後對應程式中的實現。
//
//        ---
//
//        ### 羅馬數字的邏輯與規則
//
//        1. **基本符號與值**：
//        羅馬數字使用以下符號表示數值：
//        - `I = 1`
//        - `V = 5`
//        - `X = 10`
//        - `L = 50`
//        - `C = 100`
//        - `D = 500`
//        - `M = 1000`
//
//        2. **加法與減法**：
//        - **加法規則**：
//        當較小的符號位於較大的符號右側時，加上該符號的值。
//        例如：`VI = 5 + 1 = 6`，`XII = 10 + 1 + 1 = 12`。
//        - **減法規則**：
//        當較小的符號位於較大的符號左側時，減去該符號的值。
//        例如：`IV = 5 - 1 = 4`，`IX = 10 - 1 = 9`。
//
//        3. **處理順序**：
//        羅馬數字是從左到右書寫的，但由於減法規則的存在，解讀時需要考慮相鄰符號的關係。
//
//        ---
//
//        ### 程式邏輯的對應
//
//        程式透過以下方式實現了上述邏輯：
//
//        #### **1. 定義映射表**
//        ```java
//private static final Map<Character, Integer> romanMap = new HashMap<>();
//        ```
//        - 使用一個靜態哈希表（`romanMap`），將每個羅馬數字字符對應到它的整數值，實現符號與數值的快速查找。
//
//        ---
//
//        #### **2. 初始值設置**
//        ```java
//        int sum = 0;
//        sum += romanMap.get(s.charAt(s.length() - 1));
//        ```
//        - 將字串的最後一個字符對應的值直接加到 `sum` 中，因為羅馬數字的最後一個符號總是 **加法**（不存在後續的減法情況）。
//
//        ---
//
//        #### **3. 從右向左處理字串**
//        ```java
//        for (int i = s.length() - 2; i >= 0; i--) {
//        ```
//        - 程式從倒數第二個字符開始向左遍歷，每次檢查當前字符與右側字符的數值大小。
//
//        ---
//
//        #### **4. 加法與減法的判斷**
//        ```java
//        if (romanMap.get(nextChar) > romanMap.get(currChar)) {
//        sum -= romanMap.get(currChar); // 減法
//        } else {
//        sum += romanMap.get(currChar); // 加法
//        }
//        ```
//        - 比較當前字符（`currChar`）與右側字符（`nextChar`）的數值：
//        - 若 `currChar` 的值小於 `nextChar`，表示符合減法規則（例如 `IV`、`IX`），從 `sum` 中減去 `currChar` 的值。
//        - 否則，直接加上 `currChar` 的值，符合加法規則。
//
//        ---
//
//        ### 舉例說明
//
//        #### **輸入：`"MCMXCIV"`**
//
//        1. 初始化：
//        - `sum = 5`，最後一個字符為 `V`，值為 5。
//
//        2. 從右到左逐步處理：
//        - **`I`（1）比`V`（5）小，執行減法：** `sum = 5 - 1 = 4`
//        - **`C`（100）比`I`（1）大，執行加法：** `sum = 4 + 100 = 104`
//        - **`X`（10）比`C`（100）小，執行減法：** `sum = 104 - 10 = 94`
//        - **`M`（1000）比`X`（10）大，執行加法：** `sum = 94 + 1000 = 1094`
//        - **`C`（100）比`M`（1000）小，執行減法：** `sum = 1094 - 100 = 994`
//        - **`M`（1000）比`C`（100）大，執行加法：** `sum = 994 + 1000 = 1994`
//
//        3. 結果：
//        - 返回 `sum = 1994`。
//
//        ---
//
//        ### 解析程式中的細節邏輯
//
//        1. **為什麼從右往左處理？**
//        - 因為羅馬數字的減法規則需要判斷當前符號與後續符號的大小關係，而從右往左可以確保先處理右側符號，方便比較。
//
//        2. **為什麼最後一個符號直接加？**
//        - 因為最後一個符號的值不需要再考慮減法規則，它總是直接累加到總和中。
//
//        3. **如何避免多餘操作？**
//        - 程式設計上直接利用哈希表的查找效率 \(O(1)\)，每次操作只需一次查找與大小比較。
//
//        ---
//
//        ### 另一個例子
//
//        輸入：`"LVIII"`
//        - 過程：
//        - `sum = 0`，初始為 `8`（最後一個字符 `I`）。
//        - 從右到左依次計算：
//        - `I` 比 `I` 相等，加法，`sum = 8 + 1 = 9`
//        - `V` 比 `I` 大，加法，`sum = 9 + 5 = 14`
//        - `L` 比 `V` 大，加法，`sum = 14 + 50 = 58`
//
//        結果：`sum = 58`。
}

