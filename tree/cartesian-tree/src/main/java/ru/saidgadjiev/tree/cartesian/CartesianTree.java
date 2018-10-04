package ru.saidgadjiev.tree.cartesian;

/**
 * Created by said on 27.09.2018.
 */
public class CartesianTree {

    private Node root;

    public void add(int key) {
        if (root == null) {
            root = new Node(key);
        } else {
            if (key < root.key) {
                addNode(key, root, root.left);
            } else {
                addNode(key, root, root.right);
            }
        }
    }

    private void addNode(int key, Node root, Node node) {
        if (node == null) {
            if (key < root.key) {
                root.left = new Node(key);
            } else {
                root.right = new Node(key);
            }
        } else if (key < node.key) {
            addNode(key, node, node.left);
        } else {
            addNode(key, node, node.right);
        }
    }

    public boolean contains(int key) {
        return contains(key, root);
    }

    private boolean contains(int key, Node node) {
        if (node == null) {
            return false;
        }
        if (node.key == key) {
            return true;
        }
        if (key < node.key) {
            return contains(key, node.left);
        } else {
            return contains(key, node.right);
        }
    }

    public CartesianTree copy() {
        CartesianTree cartesianTree = new CartesianTree();

        cartesianTree.root = new Node(root.key);
        copy(cartesianTree.root, root.left);
        copy(cartesianTree.root, root.right);

        return cartesianTree;
    }

    private void copy(Node root, Node node) {
        if (node != null) {
            Node rootNode;

            if (node.key < root.key) {
                root.left = rootNode = new Node(node.key);
            } else {
                root.right = rootNode = new Node(node.key);
            }
            copy(rootNode, node.left);
            copy(rootNode, node.right);
        }
    }

    public static void main(String[] args) {
        CartesianTree cartesianTree = new CartesianTree();

        cartesianTree.add(5);
        cartesianTree.add(3);
        cartesianTree.add(4);
        cartesianTree.add(6);
        cartesianTree.add(2);
        cartesianTree.add(1);

        CartesianTree copy = cartesianTree.copy();

        System.out.println(copy.contains(1));
    }

    private static class Node {

        int key;

        Node left;

        Node right;

        Node(int key) {
            this.key = key;
        }
    }
}
