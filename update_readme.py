import os
import re

BASE_DIR = os.getcwd()

LANGUAGE_FOLDERS = {
    "C++": "C++",
    "Java": "Java"
}

NOTES_FOLDER = "Notes"
README_FILE = "README.md"

GITHUB_BASE_URL = "https://github.com/wun-yu-lin/leetcode-solution/blob/main"  # 替換為你的 GitHub Repo URL


def get_all_files(folder):
    """取得指定資料夾內的所有檔案清單"""
    folder_path = os.path.join(BASE_DIR, folder)
    return os.listdir(folder_path) if os.path.exists(folder_path) else []


def extract_note_info(note_file):
    """
    從 Note 文件提取題目編號、名稱和 URL。
    """
    with open(note_file, "r", encoding="utf-8") as file:
        content = file.read()
    match = re.search(r"# \[(\d+)\. (.+?)\]\((https?://leetcode\.com/problems/.+?)\)", content)
    return match.groups() if match else (None, None, None)


def parse_notes():
    """
    解析 Notes 資料夾，提取題目資訊。
    """
    notes_data = {}
    for note in get_all_files(NOTES_FOLDER):
        if not note.endswith(".md"):
            continue
        note_file = os.path.join(BASE_DIR, NOTES_FOLDER, note)
        problem_id, title, url = extract_note_info(note_file)
        if problem_id:
            notes_data[int(problem_id)] = {"title": title, "url": url, "languages": {}}
    return notes_data


def find_solutions_by_language(language, problems):
    """
    根據語言資料夾，將解答連結添加到對應題目。
    """
    folder = LANGUAGE_FOLDERS.get(language)
    for file_name in get_all_files(folder):
        match = re.match(r"No_(\d+)_.*?\.(cpp|java)$", file_name, re.IGNORECASE)
        if match:
            problem_id = int(match.group(1))
            if problem_id in problems:
                problems[problem_id]["languages"][language] = f"{folder}/{file_name}"


def build_table(problems):
    """
    生成 README 表格內容。
    """
    headers = ["Problem #", "Problem"] + list(LANGUAGE_FOLDERS.keys())
    rows = [headers, [":---"] * len(headers)]

    for problem_id in sorted(problems.keys()):
        problem = problems[problem_id]
        row = [str(problem_id), f"[{problem['title']}]({problem['url']})"]
        for lang in LANGUAGE_FOLDERS.keys():
            if lang in problem["languages"]:
                file_path = problem["languages"][lang]
                row.append(f"[v]({GITHUB_BASE_URL}/{file_path})")  # 僅顯示 v
            else:
                row.append("-")
        rows.append(row)

    return "\n".join("| " + " | ".join(row) + " |" for row in rows)


def update_readme(problems):
    """
    更新 README.md 文件內容。
    """
    table = build_table(problems)
    content = f"# LeetCode Solutions\n\nThis repository contains solutions to LeetCode problems.\n\n{table}\n"
    content = f"""# LeetCode Solutions

- This repository contains solutions to LeetCode problems.
- LeetCode statistics \n
    <img src="https://leetcard.jacoblin.cool/wylinze?theme=dark&font=Sarpanch&ext=activity" alt="wylinze-leetcode" />

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
git diff --cached --quiet || {{
    echo "README.md has been updated and staged."
}}

echo "Success!"
# Exit hook normally
exit 0
```
\n\n
# LeetCode Solutions Summary
\n\n{table}\n
"""
    with open(README_FILE, "w", encoding="utf-8") as file:
        file.write(content)


def main():
    # 整合所有資料
    problems = parse_notes()
    for language in LANGUAGE_FOLDERS.keys():
        find_solutions_by_language(language, problems)

    # 更新 README
    update_readme(problems)


if __name__ == "__main__":
    main()



# 以下為 commit hook
#!/bin/bash
# 在提交前執行 README 更新腳本
# echo "Updating README.md..."
# python3 generate_readme.py
#
# # 將 README.md 加入提交中
# if [[ -n $(git status README.md --porcelain) ]]; then
#     echo "Staging updated README.md..."
#     git add README.md
# fi
#
# # 確保檔案狀態同步
# echo "Validating staged changes..."
# git diff --cached --quiet || {
#     echo "README.md has been updated and staged."
# }
#
# echo "Success!"
# # 正常結束 hook
# exit 0

## 修改 file 使用權限 在 terminal 執行
# chmod +x .git/hooks/pre-commit

