package linkedList.entity;

import java.util.Objects;

/**
 * 链表实体类
 *
 * @author : lihuiming
 * @version : 2020/10/12 20:33
 * @modified:
 */
public class ListNode {

  public int      val;
  public ListNode next;

  public ListNode(int x) {
    this.val = x;
  }

  public void add(int var) {
    ListNode node = new ListNode(var);
    //第一个链表节点
    if (this.next == null) {
      this.next = node;
    } else {
      ListNode temp = this.next;
      //寻找链表最后一个节点
      while (temp.next != null) {
        temp = temp.next;
      }
      //将地址值赋值为链表最后一个节点
      temp.next = node;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListNode listNode = (ListNode) o;
    return val == listNode.val &&
        Objects.equals(next, listNode.next);
  }

  @Override
  public int hashCode() {
    return Objects.hash(val, next);
  }

  @Override
  public String toString() {
    return "ListNode{" +
        "val=" + val +
        ", next=" + next +
        '}';
  }
}
