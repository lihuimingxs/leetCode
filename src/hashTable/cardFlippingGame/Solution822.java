package hashTable.cardFlippingGame;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 翻转卡牌游戏
 *
 * @author : lihuiming
 * @version : 2020/11/22 10:11
 * @modified:
 */
public class Solution822 {

  public static int flipGame(int[] fronts, int[] backs) {

    HashSet<Integer> set = new HashSet<>();
    // 找出相同元素
    for (int i = 0; i < fronts.length; i++) {
      if (fronts[i] == backs[i]) {
        set.add(fronts[i]);
      }
    }

    int answer = Integer.MAX_VALUE;
    // 在可能的元素中取最小值
    for (int front : fronts) {
      if (!set.contains(front)) {
        answer = Math.min(answer, front);
      }
    }
    // 在可能的元素中取最小值
    for (int back : backs) {
      if (!set.contains(back)) {
        answer = Math.min(answer, back);
      }
    }
    return answer == Integer.MAX_VALUE ? 0 : answer;
  }

  public static void main(String[] args) {
    int[] fronts = new int[]{1, 2, 4, 4, 7};
    int[] backs  = new int[]{1, 3, 4, 1, 3};
    System.out.println("******翻转卡牌游戏******");
    System.out.println("fronts：");
    System.out.println(Arrays.toString(fronts));
    System.out.println("backs：");
    System.out.println(Arrays.toString(backs));
    System.out.println("输出结果：");
    System.out.println(flipGame(fronts, backs));
  }
}
