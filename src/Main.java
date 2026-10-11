import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] sizes = {100, 1000, 10000};
        Random rand = new Random();
        System.out.printf("%-12s | %-8s | %-15s | %-15s | %-15s%n", "Structure", "Size", "Insert (ms)", "Search (ms)", "Delete (ms)");
        System.out.println("----------------------------------------------------------------------------------");
        for (int size : sizes) {
            int[] data = new int[size];
            for (int i = 0; i < size; i++) {
                data[i] = rand.nextInt(1000000);
            }
            BST bst = new BST();
            long start = System.nanoTime();
            for (int x : data) bst.insert(x);
            double bstInsert = (System.nanoTime() - start) / 1e6;
            start = System.nanoTime();
            for (int x : data) bst.search(x);
            double bstSearch = (System.nanoTime() - start) / 1e6;
            start = System.nanoTime();
            for (int i = 0; i < size / 10; i++) bst.delete(data[i]);
            double bstDelete = (System.nanoTime() - start) / 1e6;
            System.out.printf("%-12s | %-8d | %-15.4f | %-15.4f | %-15.4f%n", "BST", size, bstInsert, bstSearch, bstDelete);
            HashTable ht = new HashTable(Math.max(100, size));
            start = System.nanoTime();
            for (int x : data) ht.insert(x);
            double htInsert = (System.nanoTime() - start) / 1e6;
            start = System.nanoTime();
            for (int x : data) ht.search(x);
            double htSearch = (System.nanoTime() - start) / 1e6;
            start = System.nanoTime();
            for (int i = 0; i < size / 10; i++) ht.delete(data[i]);
            double htDelete = (System.nanoTime() - start) / 1e6;
            System.out.printf("%-12s | %-8d | %-15.4f | %-15.4f | %-15.4f%n", "Hash Table", size, htInsert, htSearch, htDelete);
            System.out.println("----------------------------------------------------------------------------------");
        }
    }
}
