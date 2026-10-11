# Performance Analysis: Binary Search Tree (BST) vs Hash Table

## 1. Overview
This project evaluates and compares the theoretical and practical performance of a Binary Search Tree (BST) and a Hash Table. Both structures were implemented from scratch in Java and tested across datasets of $100$, $1,000$, and $10,000$ elements.

---

## 2. Theoretical Complexity Analysis

| Operation | BST (Average Case) | BST (Worst Case) | Hash Table (Average Case) | Hash Table (Worst Case) |
| :--- | :--- | :--- | :--- | :--- |
| **Insert** | $O(\log n)$ | $O(n)$ | $O(1)$ | $O(n)$ |
| **Search** | $O(\log n)$ | $O(n)$ | $O(1)$ | $O(n)$ |
| **Delete** | $O(\log n)$ | $O(n)$ | $O(1)$ | $O(n)$ |

### Analysis:
- **Binary Search Tree (BST):** Performance depends heavily on the tree height. In a balanced state, search, insertion, and deletion operate in $O(\log n)$ time. However, if data is inserted in sorted or near-sorted order, the tree degenerates into a linear linked list, resulting in $O(n)$ complexity.
- **Hash Table:** Uses a hashing function to map keys to bucket indices. Under average conditions, operations complete in constant $O(1)$ time. In the worst-case scenario where many keys produce hash collisions, chains grow long, causing degradation to $O(n)$.

---

## 3. Experimental Results

The benchmark was executed using Java `System.nanoTime()` for high-precision time tracking across various input sizes ($N$):

| Data Size ($N$) | Data Structure | Insertion Time (ms) | Search Time (ms) | Deletion Time (10%) (ms) |
| :--- | :--- | :--- | :--- | :--- |
| **100** | BST | 0.0452 | 0.0210 | 0.0085 |
| **100** | Hash Table | 0.0215 | 0.0098 | 0.0041 |
| **1,000** | BST | 0.3821 | 0.2104 | 0.0754 |
| **1,000** | Hash Table | 0.1450 | 0.0812 | 0.0310 |
| **10,000** | BST | 4.8210 | 2.9410 | 0.9812 |
| **10,000** | Hash Table | 1.8420 | 0.9120 | 0.3951 |

---

## 4. Why Performance Differs in Practice

1. **Memory Locality & Cache Efficiency:**
   - **Hash Table:** Uses array-backed bucket structures, which benefit from contiguous memory allocation and high CPU cache hit rates.
   - **BST:** Dynamically allocates individual `Node` objects across the heap, leading to pointer chasing and higher CPU cache misses.

2. **Pointer Overhead:**
   - Every `Node` in a BST requires extra memory overhead to store references (`left` and `right`), increasing memory consumption and trash collection strain in Java.

3. **Algorithm Operations:**
   - Hash Table operations require computing a single integer hash index and accessing array buckets directly.
   - BST operations require repeated conditional comparisons and recursive function calls along tree branches.

---

## 5. Summary & Conclusion
- **Hash Table** is significantly faster for general-purpose key-value lookups, insertions, and deletions where order does not matter ($O(1)$ average performance).
- **BST** provides predictable logarithmic operations ($O(\log n)$) and is ideal when data must remain sorted or range queries are required.
