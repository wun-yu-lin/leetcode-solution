# LeetCode Solutions

- This repository contains solutions to LeetCode problems.

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


| Problem # | Problem | C++ | Java |
| :--- | :--- | :--- | :--- |
| 1 | [Two Sum](https://leetcode.com/problems/two-sum/description/) | - | [v](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Java/No_1_Two_Sum.java) |
| 6 | [Zigzag Conversion](https://leetcode.com/problems/zigzag-conversion/description/?envType=study-plan-v2&envId=top-interview-150) | - | [v](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Java/No_6_Zigzag_Conversion.java) |
| 13 | [Roman to Integer](https://leetcode.com/problems/roman-to-integer/?envType=study-plan-v2&envId=top-interview-150) | - | [v](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Java/No_13_Roman_to_Integer.java) |
| 14 | [Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix/description/?envType=study-plan-v2&envId=top-interview-150) | - | [v](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Java/No_14_Longest_Common_Prefix.java) |
| 26 | [Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150) | - | [v](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Java/No_26_Remove_Duplicates_from_Sorted_Array.java) |
| 27 | [Remove Element](https://leetcode.com/problems/remove-element/description/?envType=study-plan-v2&envId=top-interview-150) | - | [v](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Java/No_27_Remove_Element.java) |
| 28 | [Find the Index of the First Occurrence in a String](https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/) | - | [v](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Java/No_28_Find_the_Index_of_the_First_Occurrence_in_a_String.java) |
| 49 | [Group Anagrams](https://leetcode.com/problems/group-anagrams/description/) | - | [v](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Java/No_49_Group_Anagrams.java) |
| 58 | [Length of Last Word](https://leetcode.com/problems/length-of-last-word/description/?envType=study-plan-v2&envId=top-interview-150) | - | [v](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Java/No_58_Length_of_Last_Word.java) |
| 88 | [Merge Sorted Array](https://leetcode.com/problems/merge-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150) | - | [v](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Java/No_88_Merge_Sorted_Array.java) |
| 125 | [Valid Palindrome](https://leetcode.com/problems/valid-palindrome/description/?envType=study-plan-v2&envId=top-interview-150) | - | [v](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Java/No_125_Valid_Palindrome.java) |
| 134 | [Gas Station](https://leetcode.com/problems/gas-station/description/?envType=study-plan-v2&envId=top-interview-150) | - | [v](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Java/No_134_Gas_Station.java) |
| 151 | [Reverse Words in a String](https://leetcode.com/problems/reverse-words-in-a-string/description/?envType=study-plan-v2&envId=top-interview-150) | - | [v](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Java/No_151_Reverse_Words_in_a_String.java) |
| 167 | [Two Sum II - Input Array Is Sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/?envType=study-plan-v2&envId=top-interview-150) | - | [v](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Java/No_167_Two_Sum_II_Input_Array_Is_Sorted.java) |
| 217 | [Contains Duplicate](https://leetcode.com/problems/contains-duplicate/description/) | - | [v](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Java/No_217_Contains_Duplicate.java) |
| 238 | [Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=top-interview-150) | - | [v](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Java/No_238_Product_of_Array_Except_Self.java) |
| 242 | [Valid Anagram](https://leetcode.com/problems/valid-anagram/description/) | - | [v](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Java/No_242_Valid_Anagram.java) |
| 380 | [Insert Delete GetRandom O(1)](https://leetcode.com/problems/insert-delete-getrandom-o1/description/?envType=study-plan-v2&envId=top-interview-150) | - | [v](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Java/No_380_Insert_Delete_GetRandom_O1.java) |
| 392 | [Is Subsequence](https://leetcode.com/problems/is-subsequence/description/?envType=study-plan-v2&envId=top-interview-150) | - | [v](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Java/No_392_Is_Subsequence.java) |
| 1768 | [Merge Strings Alternately](https://leetcode.com/problems/merge-strings-alternately/description/?envType=study-plan-v2&envId=leetcode-75) | - | [v](https://github.com/wun-yu-lin/leetcode-solution/blob/main/Java/No_1768_Merge_Strings_Alternately.java) |

