import java.util.LinkedList;

public class HashTable {
    private final LinkedList<Integer>[] table;
    private final int capacity;

    @SuppressWarnings("unchecked")
    public HashTable(int capacity) {
        this.capacity = capacity;
        this.table = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(int key) {
        return Math.abs(key) % capacity;
    }

    public void insert(int key) {
        int idx = hash(key);
        if (!table[idx].contains(key)) {
            table[idx].add(key);
        }
    }

    public boolean search(int key) {
        int idx = hash(key);
        return table[idx].contains(key);
    }

    public void delete(int key) {
        int idx = hash(key);
        table[idx].remove((Integer) key);
    }
}
