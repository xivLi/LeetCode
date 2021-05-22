import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
    }
}

class LRUCache {
    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int capacity;
    private int size;
    private DLinkedNode head, tail;

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {

        }

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        DLinkedNode node = cache.get(key);
        move2Head(node);
        return node.value;

    }

    public void put(int key, int value) {
        if (!cache.containsKey(key)) {
            DLinkedNode node = new DLinkedNode(key, value);
            cache.put(key, node);
            add2Head(node);
            ++size;
            if (size > capacity) {
                DLinkedNode tail = removeTail();
                cache.remove(tail.key);
                --size;
            }
        } else {
            DLinkedNode node = cache.get(key);
            node.value = value;
            move2Head(node);
        }
    }

    private LRUCache.DLinkedNode removeTail() {
        tail = tail.prev;
        tail.next = null;
        return tail;
    }

    private void add2Head(LRUCache.DLinkedNode node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void move2Head(LRUCache.DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;

        add2Head(node);
    }
}
/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */