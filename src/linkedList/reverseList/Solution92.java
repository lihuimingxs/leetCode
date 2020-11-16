package linkedList.reverseList;

import linkedList.entity.ListNode;

/**
 * 92.Reverse Linked List II
 *
 * @author : lihuiming
 * @version : 2020/10/12 20:33
 * @modified:
 */
class Solution92 {

  public static ListNode reverseList(ListNode head, int m, int n) {
    if (head == null || m >= n) {
      return head;
    }
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    head = dummy;
    for (int i = 1; i < m; i++) {
      head = head.next;
    }
    ListNode prevM = head;
    ListNode mNode = head.next;
    ListNode nNode = mNode;
    ListNode postN = nNode.next;
    for (int i = m; i < n; i++) {
      ListNode next = postN.next;
      postN.next = nNode;
      nNode = postN;
      postN = next;
    }
    prevM.next = nNode;
    mNode.next = postN;
    return dummy.next;
  }

  public static void main(String[] args) {
    int      m    = 1;
    int      n    = 5;
    ListNode head = new ListNode(1);
    for (int i = 2; i <= n; i++) {
      head.add(i);
    }
    System.out.println("原链表：");
    System.out.println(head.toString());
    System.out.println("修改后的链表：");
    System.out.println(reverseList(head, m, n).toString());
  }
}
