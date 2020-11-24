package dynamicProgramming;

/**
 * 70. Climbing Stairs
 *
 * @author : lihuiming
 * @version : 2020/11/25 01:15
 * @modified:
 */
public class Solution70 {

  public int climbStairs(int n) {
    if (n <= 2) {
      return n;
    }
    int pre1 = 1;
    int pre2 = 2;
    for (int i = 2; i < n; i++) {
      int cur = pre1 + pre2;
      pre1 = pre2;
      pre2 = cur;
    }
    return pre2;
  }
}
