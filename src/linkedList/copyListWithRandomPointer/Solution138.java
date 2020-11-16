package linkedList.copyListWithRandomPointer;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import linkedList.entity.Node;

/**
 * @author : lihuiming
 * @version : 2020/10/13 14:07
 * @modified:
 */
public class Solution138 {

  public static Node copyRandomList1(Node head) {
    if (head == null) {
      return null;
    }
    // map方法：时间复杂度O(n)，空间复杂度O(n)
    // 使用hash表存储旧结点和新结点的映射
    Map<Node, Node> map  = new HashMap<>(8);
    Node            node = head;
    while (node != null) {
      if (!map.containsKey(node)) {
        Node copyNode = new Node(node.val);
        map.put(node, copyNode);
      }
      if (node.random != null) {
        Node random = node.random;
        if (!map.containsKey(random)) {
          Node copyRandom = new Node(random.val);
          map.put(random, copyRandom);
        }
        map.get(node).random = map.get(random);
      }
      node = node.next;
    }
    node = head;
    while (node != null) {
      Node next = node.next;
      map.get(node).next = map.get(next);
      node = node.next;
    }
    return map.get(head);
  }

  public static Node copyRandomList2(Node head) {
    if (head == null) {
      return null;
    }
    // map方法：时间复杂度O(n)，空间复杂度O(n)
    Map<Node, Node> map = new HashMap<>(8);
    // copy各个节点
    Node node = head;
    while (node != null) {
      Node copyNode = new Node(node.val);
      map.put(node, copyNode);
      node = node.next;
    }
    // copy映射关系
    node = head;
    while (node != null) {
      map.get(node).next = map.get(node.next);
      map.get(node).random = map.get(node.random);
      node = node.next;
    }
    return map.get(head);
  }

  public static Node copyRandomList3(Node head) {
    if (head == null) {
      return null;
    }
    // 拼接链表法：时间复杂度O(n)，空间复杂度O(1)
    Node node = head;
    // 组装新链表 1 -> 1' -> 2 -> 2' -> 3 -> 3'
    // 组装过程中无法设置random指针，因为random指向的节点可能还未创建
    while (node != null) {
      Node copyNode = new Node(node.val);
      copyNode.next = node.next;
      node.next = copyNode;
      node = copyNode.next;
    }
    // 设置random指针
    node = head;
    while (node != null && node.next != null) {
      node.next.random = node.random == null ? null : node.random.next;
      node = node.next.next;
    }
    // 分离克隆链表
    // node: 1 -> 1' -> 2 -> 2' -> 3 -> 3'
    // head: 1 -> 2 -> 3
    // cloneNode: 1' -> 2' -> 3'
    Node move      = head.next;
    Node cloneNode = head.next;
    while (head != null && head.next != null) {
      head.next = head.next.next;
      head = head.next;
      if (move != null && move.next != null) {
        move.next = move.next.next;
        move = move.next;
      }
    }
    return cloneNode;
  }

  public static Node copyRandomList4(Node head) {
    if (head == null) {
      return null;
    }
    // 拼接链表法：时间复杂度O(n)，空间复杂度O(1)
    Node node = head;
    // 组装新链表 1 -> 1' -> 2 -> 2' -> 3 -> 3'
    // 组装过程中无法设置random指针，因为random指向的节点可能还未创建
    while (node != null) {
      Node copyNode = new Node(node.val);
      copyNode.next = node.next;
      node.next = copyNode;
      node = copyNode.next;
    }
    // 设置random指针
    node = head;
    while (node != null && node.next != null) {
      node.next.random = node.random == null ? null : node.random.next;
      node = node.next.next;
    }
    // 分离克隆链表
    // node: 1 -> 1' -> 2 -> 2' -> 3 -> 3'
    // cloneNode: 1' -> 2' -> 3'
    node = head;
    Node cloneNode = head.next;
    while (node.next != null) {
      Node temp = node.next;
      node.next = node.next.next;
      node = temp;
    }
    return cloneNode;
  }

  public static void main(String[] args) {
    int    n      = 3;
    Node   head   = new Node(1);
    Random random = new Random();
    for (int i = 2; i <= n; i++) {
      // TODO 需要设置random
//      head.add(i, Math.random(1));
    }
    System.out.println("原链表：");
    System.out.println(head.toString());
    System.out.println("修改后的链表：");
    System.out.println(copyRandomList1(head).toString());
  }
}
