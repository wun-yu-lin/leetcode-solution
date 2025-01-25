class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }

        int currentRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(currentRow).append(c);
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }
            currentRow += goingDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}

class Solution2 {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() == 1) {
            return s;
        }
        int resRowCount = Math.min(s.length(), numRows);
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < resRowCount; i++) {
            rows.add(new StringBuilder());
        }
        int xIdx = 0;
        int yIdx = 0;
        for (int i = 0; i < s.length(); i++) {
            if (xIdx == 0 || (xIdx % (resRowCount - 1)) == 0) {
                rows.get(yIdx).append(s.charAt(i));
                if (yIdx == resRowCount - 1) {
                    yIdx = resRowCount - 2;
                    xIdx++;
                } else {
                    yIdx++;
                }
            } else {
                for (int j = 0; j < resRowCount; j++) {
                    if (j == yIdx) {
                        rows.get(j).append(s.charAt(i));
                        xIdx++;
                    }
                }
                if (yIdx != 0) {
                    yIdx--;
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) {
            res.append(row);
        }
        return res.toString();
    }
}

