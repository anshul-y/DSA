package com.dsa.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.dsa.Answer;
import com.dsa.custom_class.TreeNode;

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
        System.out.println();
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
        TreeNode current = root;
        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.leftNode;
            } else {
                TreeNode temp = stack.peek().rightNode;
                if (temp == null) {
                    temp = stack.pop();
                    System.out.print(temp.data+" ");
                    while (!stack.isEmpty() && temp == stack.peek().rightNode) {
                        temp = stack.pop();
                        System.out.print(temp.data+" ");
                    }
                } else {
                    current = temp;
                }
            }
        }
        System.out.println();
    }

    public void levelOrderTraverse(TreeNode root) {
        if(root==null){
            return;
        }
        System.out.println();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.print(temp.data+" ");
            if(temp.leftNode!=null)
                queue.offer(temp.leftNode);
            if(temp.rightNode!=null)
                queue.offer(temp.rightNode);
        }
        System.out.println();
    }

    public int findMax(TreeNode root) {
        if(root==null){
            return Integer.MIN_VALUE;
        }

        int max = root.data;
        int left = findMax(root.leftNode);
        int right = findMax(root.rightNode);

        if(max<left){
            max = left;
        }
        if(max<right){
            max = right;
        }

        return max;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.createBinaryTree();
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
    }

}
