import os
from collections import defaultdict

def scan_solutions(base_dir, languages):
    """
    掃描指定目錄，收集每個題目的解答檔案資訊。
    :param base_dir: 專案根目錄
    :param languages: 語言與資料夾的對應字典
    :return: 題目與解答檔案的對應字典
    """
    solutions = defaultdict(dict)
    for lang, folder in languages.items():
        folder_path = os.path.join(base_dir, folder)
        if not os.path.exists(folder_path):
            continue

        for file_name in os.listdir(folder_path):
            if not file_name.endswith((".cpp", ".java")):
                continue

            problem_name = file_name.split(".")[0]  # 提取題目名稱
            solutions[problem_name][lang] = os.path.join(folder, file_name)
    return solutions


def generate_table(solutions, languages):
    """
    生成 README 表格內容。
    :param solutions: 題目與解答檔案的對應字典
    :param languages: 語言列表
    :return: 表格的字串
    """
    header = "| Problem | " + " | ".join(languages) + " |\n"
    divider = "|---------|" + "|".join([":---:" for _ in languages]) + "|\n"
    rows = []

    for problem in sorted(solutions.keys()):
        row = [problem]
        for lang in languages:
            if lang in solutions[problem]:
                row.append(f"[✔]({solutions[problem][lang]})")
            else:
                row.append("-")
        rows.append("| " + " | ".join(row) + " |")

    return header + divider + "\n".join(rows) + "\n"


def write_readme(content):
    """
    將生成的內容寫入 README.md。
    :param content: 生成的 README 內容
    """
    with open("README.md", "w") as readme_file:
        readme_file.write(content)


def main():
    base_dir = os.getcwd()
    languages = {
        "C++": "C++",
        "Java": "Java",
    }

    # 掃描解答檔案
    solutions = scan_solutions(base_dir, languages)

    # 生成表格內容
    table = generate_table(solutions, list(languages.keys()))

    # README 標頭與表格結合
    readme_content = "# LeetCode Solutions\n\n"
    readme_content += "This repository contains solutions to LeetCode problems.\n\n"
    readme_content += table

    # 寫入 README
    write_readme(readme_content)


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
