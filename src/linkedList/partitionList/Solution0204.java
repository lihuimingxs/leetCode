package linkedList.partitionList;

import linkedList.entity.ListNode;

/**
 * 面试题 02.04. Partition List LCCI
 *
 * @author : lihuiming
 * @version : 2020/11/22 10:11
 * @modified:
 */
public class Solution0204 {

  public static ListNode partition(ListNode head, int x) {
    ListNode small    = new ListNode();
    ListNode large    = new ListNode();
    ListNode cur      = head;
    ListNode smallCur = small;
    ListNode largeCur = large;
    while (cur != null) {
      if (cur.val < x) {
        smallCur.next = cur;
        smallCur = smallCur.next;
      } else {
        largeCur.next = cur;
        largeCur = largeCur.next;
      }
      cur = cur.next;
    }
    smallCur.next = large.next;
    largeCur.next = null;
    return small.next;
  }

  public static void main(String[] args) {
    int      x    = 3;
    ListNode head = new ListNode(1);
    head.add(4);
    head.add(3);
    head.add(2);
    head.add(5);
    head.add(2);
    System.out.println("******拆表法******");
    System.out.println("原链表：");
    System.out.println(head.toString());
    System.out.println("修改后的链表：");
    System.out.println(partition(head, x).toString());

    head = new ListNode(1);
    head.add(4);
    head.add(3);
    head.add(2);
    head.add(5);
    head.add(2);
    System.out.println("******递归法******");
    System.out.println("原链表：");
    System.out.println(head.toString());
    System.out.println("修改后的链表：");
  }
}
