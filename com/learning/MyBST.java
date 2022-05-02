package com.glearning;

// Find a pair with a given sum in Binary Search Tree

import java.util.HashSet;

public class MyBST {

    class Node {
        int data;
        Node left, right;
    }

    Node NewNode(int data)
    {
        Node NewNode = new Node();
        NewNode.data = data;
        NewNode.left = null;
        NewNode.right = null;
        return NewNode;
    }

    Node insert(Node root, int key)
    {
        if (root == null)
            return NewNode(key);
        if (key < root.data)
            root.left = insert(root.left, key);
        else
            root.right = insert(root.right, key);
        return root;
    }

    boolean findpairdetails(Node root, int sum, HashSet<Integer> set)
    {
        if (root == null)
            return false;

        if (findpairdetails(root.left, sum, set))
            return true;

        if (set.contains(sum - root.data)) {
            System.out.println("Pair is ("
                    + (sum - root.data) + ", "
                    + root.data + ")");
            return true;
        }
        else
            set.add(root.data);

        return findpairdetails(root.right, sum, set);
    }

    void findPair(Node root, int sum)
    {
        HashSet<Integer> set = new HashSet<Integer>();
        if (!findpairdetails(root, sum, set))
            System.out.println("Nodes are not found");
    }

    public static void main(String[] args)
    {
        MyBST findpairbst = new MyBST();

        Node root = null;
        root = findpairbst.insert(root, 40);
        root = findpairbst.insert(root, 20);
        root = findpairbst.insert(root, 60);
        root = findpairbst.insert(root, 10);
        root = findpairbst.insert(root, 30);
        root = findpairbst.insert(root, 50);
        root = findpairbst.insert(root, 70);

        int sum = 130;

        findpairbst.findPair(root, sum);
    }

}
