# LeetCode Solutions

- This repository contains solutions to LeetCode problems.
- LeetCode statistics 

    <img src="https://leetcard.jacoblin.cool/wylinze?theme=dark&font=Sarpanch&ext=activity" alt="wylinze-leetcode" width = 300px />

- Usage Instructions

- To use this repository, follow these steps:

  1. Fork this repository.
  2. In `update_readme.py`, change `GITHUB_BASE_URL` to your own repository's URL.
  3. Install Python 3 in your environment, e.g., Python 3.10.12.
  4. Use [Clip LeetCode](https://chromewebstore.google.com/detail/clip-leetcode/cnghimckckgcmhbdokjielmhkmnagdcp?pli=1) to copy the problem statement into `Notes/filename.md`.
  5. Start solving problems in the corresponding folder, e.g., `Java`, `C++`.
  6. Name your files according to the format `No_123_Solution_name`.
  7. Add the following pre-commit hook in `./.git/hooks/pre-commit`:

```bash
#!/bin/bash

# Run README update script before committing
echo "Updating README.md..."
python3 update_readme.py

# Add README.md to the commit if modified
if [[ -n $(git status README.md --porcelain) ]]; then
    echo "Staging updated README.md..."
    git add README.md
fi

# Ensure file status is synchronized
echo "Validating staged changes..."
git diff --cached --quiet || {
    echo "README.md has been updated and staged."
}

echo "Success!"
# Exit hook normally
exit 0
```



# LeetCode Solutions Summary


| Problem # | Problem | Notes | C++ | Java |
| :--- | :--- | :--- | :--- | :--- |
| 1 | [Two Sum](https://leetcode.com/problems/two-sum/description/) | [md](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Notes/No_1_Two_Sum.md) | - | [java](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Java/No_1_Two_Sum.java) |
| 3 | [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/description/) | [md](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Notes/No_3_Longest_Substring_Without_Repeating_Characters.md) | - | [java](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Java/No_3_Longest_Substring_Without_Repeating_Characters.java) |
| 5 | [Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/description/) | [md](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Notes/No_5_Longest_Palindromic_Substring.md) | - | [java](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Java/No_5_Longest_Palindromic_Substring.java) |
| 6 | [Zigzag Conversion](https://leetcode.com/problems/zigzag-conversion/description/?envType=study-plan-v2&envId=top-interview-150) | [md](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Notes/No_6_Zigzag_Conversion.md) | - | [java](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Java/No_6_Zigzag_Conversion.java) |
| 7 | [Reverse Integer](https://leetcode.com/problems/reverse-integer/description/) | [md](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Notes/No_7_Reverse_Integer.md) | - | [java](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Java/No_7_Reverse_Integer.java) |
| 11 | [Container With Most Water](https://leetcode.com/problems/container-with-most-water/description/) | [md](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Notes/No_11_Container_With_Most_Water.md) | - | [java](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Java/No_11_Container_With_Most_Water.java) |
| 13 | [Roman to Integer](https://leetcode.com/problems/roman-to-integer/?envType=study-plan-v2&envId=top-interview-150) | [md](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Notes/No_13_Roman_to_Integer.md) | - | [java](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Java/No_13_Roman_to_Integer.java) |
| 14 | [Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix/description/?envType=study-plan-v2&envId=top-interview-150) | [md](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Notes/No_14_Longest_Common_Prefix.md) | - | [java](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Java/No_14_Longest_Common_Prefix.java) |
| 15 | [3Sum](https://leetcode.com/problems/3sum/description/) | [md](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Notes/No_15_3Sum.md) | - | [java](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Java/No_15_3Sum.java) |
| 20 | [Valid Parentheses](https://leetcode.com/problems/valid-parentheses/description/) | [md](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Notes/No_20_Valid_Parentheses.md) | - | [java](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Java/No_20_Valid_Parentheses.java) |
| 21 | [Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/description/) | [md](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Notes/No_21_Merge_Two_Sorted_Lists.md) | - | [java](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Java/No_21_Merge_Two_Sorted_Lists.java) |
| 26 | [Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150) | [md](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Notes/No_26_Remove_Duplicates_from_Sorted_Array.md) | - | [java](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Java/No_26_Remove_Duplicates_from_Sorted_Array.java) |
| 27 | [Remove Element](https://leetcode.com/problems/remove-element/description/?envType=study-plan-v2&envId=top-interview-150) | [md](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Notes/No_27_Remove_Element.md) | - | [java](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Java/No_27_Remove_Element.java) |
| 28 | [Find the Index of the First Occurrence in a String](https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/) | [md](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Notes/No_28_Find_the_Index_of_the_First_Occurrence_in_a_String.md) | - | [java](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Java/No_28_Find_the_Index_of_the_First_Occurrence_in_a_String.java) |
| 33 | [Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/description/) | [md](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Notes/No_33_Search_in_Rotated_Sorted_Array.md) | - | [java](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Java/No_33_Search_in_Rotated_Sorted_Array.java) |
| 49 | [Group Anagrams](https://leetcode.com/problems/group-anagrams/description/) | [md](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Notes/No_49_Group_Anagrams.md) | - | [java](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Java/No_49_Group_Anagrams.java) |
| 58 | [Length of Last Word](https://leetcode.com/problems/length-of-last-word/description/?envType=study-plan-v2&envId=top-interview-150) | [md](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Notes/No_58_Length_of_Last_Word.md) | - | [java](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Java/No_58_Length_of_Last_Word.java) |
| 76 | [Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/description/) | [md](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Notes/No_76_Minimum_Window_Substring.md) | - | [java](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Java/No_76_Minimum_Window_Substring.java) |
| 88 | [Merge Sorted Array](https://leetcode.com/problems/merge-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150) | [md](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Notes/No_88_Merge_Sorted_Array.md) | - | [java](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Java/No_88_Merge_Sorted_Array.java) |
| 121 | [Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/) | [md](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Notes/No_121_Best_Time_to_Buy_and_Sell_Stock.md) | - | [java](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Java/No_121_Best_Time_to_Buy_and_Sell_Stock.java) |
| 125 | [Valid Palindrome](https://leetcode.com/problems/valid-palindrome/description/?envType=study-plan-v2&envId=top-interview-150) | [md](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Notes/No_125_Valid_Palindrome.md) | - | [java](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Java/No_125_Valid_Palindrome.java) |
| 128 | [Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence/description/) | [md](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Notes/No_128_Longest_Consecutive_Sequence.md) | - | [java](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Java/No_128_Longest_Consecutive_Sequence.java) |
| 134 | [Gas Station](https://leetcode.com/problems/gas-station/description/?envType=study-plan-v2&envId=top-interview-150) | [md](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Notes/No_134_Gas_Station.md) | - | [java](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Java/No_134_Gas_Station.java) |
| 151 | [Reverse Words in a String](https://leetcode.com/problems/reverse-words-in-a-string/description/?envType=study-plan-v2&envId=top-interview-150) | [md](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Notes/No_151_Reverse_Words_in_a_String.md) | - | [java](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Java/No_151_Reverse_Words_in_a_String.java) |
| 153 | [Find Minimum in Rotated Sorted Array](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/) | [md](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Notes/No_153_Find_Minimum_in_Rotated_Sorted_Array.md) | - | [java](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Java/No_153_Find_Minimum_in_Rotated_Sorted_Array.java) |
| 167 | [Two Sum II - Input Array Is Sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/?envType=study-plan-v2&envId=top-interview-150) | [md](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Notes/No_167_Two_Sum_II_Input_Array_Is_Sorted.md) | - | [java](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Java/No_167_Two_Sum_II_Input_Array_Is_Sorted.java) |
| 206 | [Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/description/) | [md](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Notes/No_206_Reverse_Linked_List.md) | - | [java](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Java/No_206_Reverse_Linked_List.java) |
| 217 | [Contains Duplicate](https://leetcode.com/problems/contains-duplicate/description/) | [md](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Notes/No_217_Contains_Duplicate.md) | - | [java](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Java/No_217_Contains_Duplicate.java) |
| 238 | [Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=top-interview-150) | [md](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Notes/No_238_Product_of_Array_Except_Self.md) | - | [java](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Java/No_238_Product_of_Array_Except_Self.java) |
| 242 | [Valid Anagram](https://leetcode.com/problems/valid-anagram/description/) | [md](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Notes/No_242_Valid_Anagram.md) | - | [java](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Java/No_242_Valid_Anagram.java) |
| 271 | [Encode and Decode Strings](https://leetcode.com/problems/encode-and-decode-strings/) | [md](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Notes/No_271_Encode_and_Decode_Strings.md) | - | [java](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Java/No_271_Encode_and_Decode_Strings.java) |
| 347 | [Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/description/) | [md](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Notes/No_347_Top_K_Frequent_Elements.md) | - | [java](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Java/No_347_Top_K_Frequent_Elements.java) |
| 371 | [Sum of Two Integers](https://leetcode.com/problems/sum-of-two-integers/) | [md](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Notes/No_371_Sum_of_Two_Integers.md) | - | [java](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Java/No_371_Sum_of_Two_Integers.java) |
| 380 | [Insert Delete GetRandom O(1)](https://leetcode.com/problems/insert-delete-getrandom-o1/description/?envType=study-plan-v2&envId=top-interview-150) | [md](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Notes/No_380_Insert_Delete_GetRandom_O1.md) | - | [java](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Java/No_380_Insert_Delete_GetRandom_O1.java) |
| 392 | [Is Subsequence](https://leetcode.com/problems/is-subsequence/description/?envType=study-plan-v2&envId=top-interview-150) | [md](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Notes/No_392_Is_Subsequence.md) | - | [java](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Java/No_392_Is_Subsequence.java) |
| 424 | [Longest Repeating Character Replacement](https://leetcode.com/problems/longest-repeating-character-replacement/description/) | [md](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Notes/No_424_Longest_Repeating_Character_Replacement.md) | - | [java](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Java/No_424_Longest_Repeating_Character_Replacement.java) |
| 1768 | [Merge Strings Alternately](https://leetcode.com/problems/merge-strings-alternately/description/?envType=study-plan-v2&envId=leetcode-75) | [md](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Notes/No_1768_Merge_Strings_Alternately.md) | - | [java](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Java/No_1768_Merge_Strings_Alternately.java) |

