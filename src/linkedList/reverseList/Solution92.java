package linkedList.reverseList;

/**
 * 92.Reverse Linked List II
 *
 * @author : lihuiming
 * @version : 2020/10/12 20:33
 * @modified:
 */
class Solution92 {

  public ListNode reverseListBetween(ListNode head, int m, int n) {
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
}
