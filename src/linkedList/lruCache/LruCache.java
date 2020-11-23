package linkedList.lruCache;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : lihuiming
 * @version : 2020/11/24 01:12
 * @modified:
 */
public class LruCache {

  public class CacheNode {

    private CacheNode prev;
    private CacheNode next;
    private int       key;
    private int       value;

    public CacheNode(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  private final int                     capacity;
  private       Map<Integer, CacheNode> cacheNodeMap = new HashMap<>();
  private       CacheNode               head         = new CacheNode(-1, -1);
  private       CacheNode               tail              = new CacheNode(-1, -1);

  public LruCache(int capacity) {
    this.capacity = capacity;
    head.next = tail;
    tail.prev = head;
  }

  public int get(int key) {
    if (!cacheNodeMap.containsKey(key)) {
      return -1;
    }
    CacheNode current = cacheNodeMap.get(key);
    current.prev.next = current.next;
    current.next.prev = current.prev;
    moveToTail(current);
    return current.value;
  }

  public void put(int key, int value) {
    if (get(key) != -1) {
      cacheNodeMap.get(key).value = value;
      return;
    }
    if (cacheNodeMap.size() == this.capacity) {
      cacheNodeMap.remove(head.next.key);
      head.next = head.next.next;
      head.next.prev = head;
    }
    CacheNode current = new CacheNode(key, value);
    cacheNodeMap.put(key, current);
    moveToTail(current);
  }

  private void moveToTail(CacheNode cacheNode) {
    cacheNode.prev = tail.prev;
    tail.prev = cacheNode;
    cacheNode.prev.next = cacheNode;
    cacheNode.next = tail;
  }

  public static void main(String[] args) {
    LruCache lruCache = new LruCache(2);
    // [1]
    lruCache.put(1, 1);
    // [1, 2]
    lruCache.put(2, 2);
    // [2, 1] 输出：1
    System.out.println(lruCache.get(1));
    // [1, 3]
    lruCache.put(3, 3);
    // [1, 3] 输出：-1
    System.out.println(lruCache.get(2));
    // [3, 4]
    lruCache.put(4, 4);
    // [3, 4] 输出：-1
    System.out.println(lruCache.get(1));
    // [4, 3] 输出：3
    System.out.println(lruCache.get(3));
    // [3, 4] 输出：4
    System.out.println(lruCache.get(4));
  }
}
