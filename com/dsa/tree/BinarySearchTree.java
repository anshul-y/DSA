package com.dsa.tree;

import com.dsa.custom_class.TreeNode;

public class BinarySearchTree {

    private TreeNode root;

    /**
     * Creates a binary search tree with the following structure:
     * 
     *    6
     *   / \
     *  4   8
     * / \ / \
     * 2 5 7 9
     * 
     * Each node is represented by a TreeNode object with a value.
     * The root of the tree is assigned to the variable "root".
     * The left and right child nodes are assigned to the respective variables of
     * the parent node.
     * 
     * @return void
     */
    public void createBinarySearchTree() {
        // Create TreeNode objects for each node in the tree
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode forth = new TreeNode(4);
        TreeNode fifth = new TreeNode(5);
        TreeNode sixth = new TreeNode(6);
        TreeNode seventh = new TreeNode(7);
        TreeNode eighth = new TreeNode(8);
        TreeNode ninth = new TreeNode(9);

        // Assign the root node
        root = sixth;

        // Assign the left and right child nodes for each parent node
        sixth.leftNode = forth;
        sixth.rightNode = eighth;
        forth.leftNode = second;
        forth.rightNode = fifth;
        eighth.leftNode = seventh;
        eighth.rightNode = ninth;
    }

    /**
     * Inserts a new node with the given data into the binary search tree.
     * 
     * @param data the data to be inserted
     */
    public void insert(int data) {
        root = insert(root, data);
    }

    /**
     * Inserts a new node with the given data into the binary search tree rooted at
     * the specified node.
     * If the root is null, creates a new tree node with the given data and returns
     * it.
     * If the data is less than the root's data, recursively inserts the data into
     * the left subtree.
     * If the data is greater than or equal to the root's data, recursively inserts
     * the data into the right subtree.
     * Returns the root of the modified tree.
     *
     * @param root The root of the binary search tree.
     * @param data The data to be inserted.
     * @return The root of the modified tree.
     */
    public TreeNode insert(TreeNode root, int data) {
        if (root == null) {
            root = new TreeNode(data);
            return root;
        }

        if (data < root.data) {
            root.leftNode = insert(root.leftNode, data);
        } else {
            root.rightNode = insert(root.rightNode, data);
        }
        return root;
    }

    /**
     * Performs an in-order traversal of a binary tree rooted at the given node.
     */
    public void inOrder() {
        inOrder(root);
        System.out.println();
    }

    /**
     * Performs an in-order traversal of a binary tree rooted at the given node.
     * 
     * Prints the data of each node in the traversal order.
     * 
     * @param root The root node of the binary tree.
     */
    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.leftNode);
        System.out.print(root.data + " ");
        inOrder(root.rightNode);
    }

    /**
     * Searches for a TreeNode with the given data in the binary tree.
     * 
     * @param data The data to search for.
     * @return The TreeNode with the given data, or null if not found.
     */
    public TreeNode search(int data) {
        return search(root, data);
    }

    private TreeNode search(TreeNode root, int data) {
        if (root == null || root.data == data) {
            return root;
        }
        if (data < root.data) {
            return search(root.leftNode, data);
        } else {
            return search(root.rightNode, data);
        }
    }

    /**
     * Checks if the binary tree is valid.
     * 
     * @return true if the binary tree is valid, false otherwise.
     */
    public boolean isValid() {
        return isValid(this.root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * Checks if a binary tree is a valid binary search tree.
     * 
     * @param root The root node of the binary tree.
     * @param min  The minimum value that a node in the tree can have.
     * @param max  The maximum value that a node in the tree can have.
     * @return True if the binary tree is a valid binary search tree, false
     *         otherwise.
     */
    private boolean isValid(TreeNode root, long min, long max) {
        if (root == null)
            return true;

        if (root.data <= min || root.data >= max)
            return false;

        boolean left = isValid(root.leftNode, min, root.data);
        if (left) {
            return isValid(root.rightNode, root.data, max);
        }
        return false;
    }

    /**
     * The main method of the program.
     * Creates a BinarySearchTree object and performs various operations on it.
     */
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        // bst.insert(5);
        // bst.insert(3);
        // bst.insert(7);
        // bst.insert(1);

        // bst.inOrder();

        // if (bst.search(8) != null) {
        // System.out.println("Key Found !!");
        // }

        // bst.createBinarySearchTree();
        // System.out.println(bst.isValid());
    }
}
