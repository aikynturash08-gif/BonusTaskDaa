public class BST {
    static class Node {
        int key;
        Node left, right;

        Node(int key) {
            this.key = key;
        }
    }

    private Node root;

    public void insert(int key) {
        root = insertRecursive(root, key);
    }

    private Node insertRecursive(Node curr, int key) {
        if (curr == null) {
            return new Node(key);
        }
        if (key < curr.key) {
            curr.left = insertRecursive(curr.left, key);
        } else if (key > curr.key) {
            curr.right = insertRecursive(curr.right, key);
        }
        return curr;
    }

    public boolean search(int key) {
        return searchRecursive(root, key);
    }

    private boolean searchRecursive(Node curr, int key) {
        if (curr == null) {
            return false;
        }
        if (curr.key == key) {
            return true;
        }
        return key < curr.key ? searchRecursive(curr.left, key) : searchRecursive(curr.right, key);
    }

    public void delete(int key) {
        root = deleteRecursive(root, key);
    }

    private Node deleteRecursive(Node curr, int key) {
        if (curr == null) {
            return null;
        }
        if (key < curr.key) {
            curr.left = deleteRecursive(curr.left, key);
        } else if (key > curr.key) {
            curr.right = deleteRecursive(curr.right, key);
        } else {
            if (curr.left == null) return curr.right;
            if (curr.right == null) return curr.left;

            Node minNode = findMin(curr.right);
            curr.key = minNode.key;
            curr.right = deleteRecursive(curr.right, minNode.key);
        }
        return curr;
    }

    private Node findMin(Node curr) {
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }
}
