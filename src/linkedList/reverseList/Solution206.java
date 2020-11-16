package linkedList.reverseList;

import linkedList.entity.ListNode;

/**
 * 206.Reverse Linked List
 *
 * @author : lihuiming
 * @version : 2020/10/12 20:33
 * @modified:
 */
class Solution206 {

  public static ListNode iteration(ListNode head) {
    if (head == null) {
      return null;
    }
    // 迭代法
    ListNode prev    = head;
    ListNode current = head.next;
    prev.next = null;
    while (current != null) {
      ListNode next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    return prev;
  }

  public static ListNode recursion(ListNode head) {
    // 递归法
    return reverse(null, head);
  }

  public static ListNode reverse(ListNode prev, ListNode current) {
    if (current == null) {
      return prev;
    }
    ListNode next = current.next;
    current.next = prev;
    return reverse(current, next);
  }

  public static void main(String[] args) {
    int      n    = 5;
    ListNode head = new ListNode(1);
    for (int i = 2; i <= n; i++) {
      head.add(i);
    }
    System.out.println("******迭代法******");
    System.out.println("原链表：");
    System.out.println(head.toString());
    System.out.println("修改后的链表：");
    System.out.println(iteration(head).toString());

    for (int i = 2; i <= n; i++) {
      head.add(i);
    }
    System.out.println("******递归法******");
    System.out.println("原链表：");
    System.out.println(head.toString());
    System.out.println("修改后的链表：");
    System.out.println(recursion(head).toString());
  }
}
