package linkedList.entity;

import java.util.Objects;

/**
 * @author : lihuiming
 * @version : 2020/10/13 14:04
 * @modified:
 */
public class Node {

  public int  val;
  public Node next;
  public Node random;

  public Node(int val) {
    this.val = val;
    this.next = null;
    this.random = null;
  }

  public void add(int nextVar, int randomVar) {
    Node next   = new Node(nextVar);
    Node random = new Node(randomVar);
    //第一个链表节点
    if (this.next == null) {
      this.next = next;
      this.random = random;
    } else {
      Node temp = this.next;
      //寻找链表最后一个节点
      while (temp.next != null) {
        temp = temp.next;
      }
      //将地址值赋值为链表最后一个节点
      temp.next = next;
      temp.random = random;
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
    Node node = (Node) o;
    return val == node.val &&
        Objects.equals(next, node.next) &&
        Objects.equals(random, node.random);
  }

  @Override
  public int hashCode() {
    return Objects.hash(val, next, random);
  }

  @Override
  public String toString() {
    return "Node{" +
        "val=" + val +
        ", next=" + next +
        ", random=" + random +
        '}';
  }
}
