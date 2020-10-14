package linkedList.copyListWithRandomPointer;

import java.util.Objects;

/**
 * @author : lihuiming
 * @version : 2020/10/13 14:04
 * @modified:
 */
public class Node {

  int  val;
  Node next;
  Node random;

  public Node(int val) {
    this.val = val;
    this.next = null;
    this.random = null;
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
}
