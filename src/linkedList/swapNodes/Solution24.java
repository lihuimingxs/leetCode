package linkedList.swapNodes;

import linkedList.entity.ListNode;

/**
 * @author : lihuiming
 * @version : 2020/11/16 20:50
 * @modified:
 */
public class Solution24 {
  public static ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode newHead = head.next;
    head.next = swapPairs(newHead.next);
    newHead.next = head;
    return newHead;
  }

  public static void main(String[] args) {
    int      n    = 5;
    ListNode head = new ListNode(1);
    for (int i = 2; i <= n; i++) {
      head.add(i);
    }
    System.out.println("原链表：");
    System.out.println(head.toString());
    System.out.println("修改后的链表：");
    System.out.println(swapPairs(head).toString());
  }
}
