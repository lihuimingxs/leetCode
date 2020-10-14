package linkedList.reverseList;

/**
 * 206.Reverse Linked List
 *
 * @author : lihuiming
 * @version : 2020/10/12 20:33
 * @modified:
 */
class Solution206 {

  public ListNode reverseList1(ListNode head) {
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

  public ListNode reverseList2(ListNode head) {
    // 递归法
    return reverse(null, head);
  }

  public ListNode reverse(ListNode prev, ListNode current) {
    if (current == null) {
      return prev;
    }
    ListNode next = current.next;
    current.next = prev;
    return reverse(current, next);
  }
}
