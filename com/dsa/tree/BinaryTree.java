package com.dsa.tree;

import com.dsa.Answer;
import com.dsa.custom_class.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

    TreeNode root;

    public TreeNode getRoot() {
        return this.root;
    }

    public TreeNode createBinaryTree() {
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode forth = new TreeNode(4);
        TreeNode fifth = new TreeNode(5);
        root = first;
        first.leftNode = second;
        first.rightNode = third;
        second.leftNode = forth;
        second.rightNode = fifth;
        return root;
    }

    public TreeNode buildTree(int... values) {
        if (values == null || values.length == 0) {
            return null;
        }

        TreeNode[] nodes = new TreeNode[values.length];
        // Create TreeNode objects for each value
        for (int i = 0; i < values.length; i++) {
            nodes[i] = new TreeNode(values[i]);
        }

        // Connect the nodes to form the tree structure
        for (int i = 0; i < values.length; i++) {
            int leftIndex = 2 * i + 1;
            int rightIndex = 2 * i + 2;
            if (leftIndex < values.length) {
                nodes[i].leftNode = nodes[leftIndex];
            }
            if (rightIndex < values.length) {
                nodes[i].rightNode = nodes[rightIndex];
            }
        }
        root = nodes[0];
        // Return the root node of the tree
        return nodes[0];
    }

    public void printTree() {
        printTree(this.root, 0);
    }
    private void printTree(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        // Print indentation corresponding to the level
        for (int i = 0; i < level; i++) {
            System.out.print("   ");
        }
        // Print the value of the node
        System.out.println("↳"+node.data);
        // Recursively print left and right subtrees with increased level
        printTree(node.leftNode, level + 1);
        printTree(node.rightNode, level + 1);
    }

    public void printStack(Stack<TreeNode> stack) {
        TreeNode[] nodes = new TreeNode[stack.size()];
        nodes = stack.toArray(nodes);
        System.out.println();
        System.out.println("| |");
        for (int i = nodes.length - 1; i >= 0; i--) {
            TreeNode node = nodes[i];
            System.out.println("|" + node.data + "|");
        }
        System.out.println("|-|");
    }

    public void preOrderRecursiveTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrderRecursiveTraverse(root.leftNode);
        preOrderRecursiveTraverse(root.rightNode);
    }

    public void preOrderIterativeTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        System.out.println();
        System.out.print("PreOrder Traverse: ");
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            System.out.print(temp.data + " ");
            if (temp.rightNode != null) {
                stack.push(temp.rightNode);
            }

            if (temp.leftNode != null) {
                stack.push(temp.leftNode);
            }
        }
    }

    public void inOrderRecursiveTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderRecursiveTraverse(root.leftNode);
        System.out.print(root.data + " ");
        inOrderRecursiveTraverse(root.rightNode);
    }

    public void inOrderIterativeTraverse(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        System.out.println();
        System.out.print("InOrder Traverse: ");
        TreeNode temp = root;
        while (!stack.isEmpty() || temp != null) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.leftNode;
            } else {
                temp = stack.pop();
                System.out.print(temp.data + " ");
                temp = temp.rightNode;
            }
            // printStack(stack);
        }
    }

    public void postOrderRecursiveTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderRecursiveTraverse(root.leftNode);
        postOrderRecursiveTraverse(root.rightNode);
        System.out.print(root.data + " ");
    }

    public void postOrderIterativeTraverse(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        System.out.println();
        System.out.print("PostOrder Traverse: ");
        TreeNode current = root;
        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.leftNode;
            } else {
                TreeNode temp = stack.peek().rightNode;
                if (temp == null) {
                    temp = stack.pop();
                    System.out.print(temp.data + " ");
                    while (!stack.isEmpty() && temp == stack.peek().rightNode) {
                        temp = stack.pop();
                        System.out.print(temp.data + " ");
                    }
                } else {
                    current = temp;
                }
            }
        }
    }

    public void levelOrderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println();
        System.out.print("Level-Order Traverse: ");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.print(temp.data + " ");
            if (temp.leftNode != null)
                queue.offer(temp.leftNode);
            if (temp.rightNode != null)
                queue.offer(temp.rightNode);
        }
        System.out.println();
    }

    public int findMax(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int max = root.data;
        int left = findMax(root.leftNode);
        int right = findMax(root.rightNode);

        if (max < left) {
            max = left;
        }
        if (max < right) {
            max = right;
        }

        return max;
    }

    public boolean isSymmetricBFS(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root.leftNode);
        stack.push(root.rightNode);
        while (!stack.isEmpty()) {
            TreeNode n1 = stack.pop();
            TreeNode n2 = stack.pop();
            if (n1 == null && n2 == null) {
                continue;
            }
            if (n1 == null || n2 == null || n1.data != n2.data) {
                return false;
            }
            stack.push(n1.leftNode);
            stack.push(n2.rightNode);
            stack.push(n1.rightNode);
            stack.push(n2.leftNode);
        }
        return true;
    }

    public void isSymmetricDFS(TreeNode root) {

    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode binaryTreeRoot = binaryTree.createBinaryTree();
//        binaryTree.buildTree(1, 2, 3, 4, 5);
        binaryTree.printTree();
        // 1
        // / \
        // 2 3
        // / \
        // 4 5

        // binaryTree.preOrderRecursiveTraverse(binaryTree.getRoot());
        binaryTree.preOrderIterativeTraverse(binaryTree.getRoot());

        // binaryTree.inOrderRecursiveTraverse(binaryTree.getRoot());
        binaryTree.inOrderIterativeTraverse(binaryTree.getRoot());

        // binaryTree.postOrderRecursiveTraverse(binaryTree.getRoot());
        binaryTree.postOrderIterativeTraverse(binaryTree.getRoot());

        binaryTree.levelOrderTraverse(binaryTree.getRoot());

        int max = binaryTree.findMax(binaryTree.getRoot());
        Answer.print(max, "Maximum number in Binary Tree");

        BinaryTree symmetricTree = new BinaryTree();
        symmetricTree.buildTree(1,2,2,3,0,0,3);
        symmetricTree.printTree();
        boolean isSymmetric = binaryTree.isSymmetricBFS(symmetricTree.getRoot());
        Answer.print(isSymmetric, "Binary Tree is symmetric");
    }

}
