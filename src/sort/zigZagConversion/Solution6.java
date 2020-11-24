package sort.zigZagConversion;

import java.util.ArrayList;
import java.util.List;

/**
 * 6. ZigZag Conversion
 *
 * @author : lihuiming
 * @version : 2020/11/24 13:19
 * @modified:
 */
public class Solution6 {

  public String convert(String s, int numRows) {
    if (numRows == 1) {
      return s;
    }

    // 创建行对象
    List<StringBuffer> rows = new ArrayList<>();
    for (int i = 0; i < numRows; i++) {
      rows.add(new StringBuffer());
    }
    // 按行添加字符
    int     curRow    = 0;
    boolean goingDown = false;
    for (char c : s.toCharArray()) {
      rows.get(curRow).append(c);
      if (curRow == 0 || curRow == numRows) {
        goingDown = !goingDown;
      }
      curRow += goingDown ? 1 : -1;
    }
    // 按行拼接
    StringBuilder sb = new StringBuilder();
    for (StringBuffer row : rows) {
      sb.append(row);
    }
    return sb.toString();
  }
}
