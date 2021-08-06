package com.newton.resources;

import com.newton.interfaces.ITest;

public class Test implements ITest {
    Tree tree;
    Node root = new Node("10");

    public Test() {
        this.tree = new Tree(root);
    }

    public void executeTestOne() {
        Node node_5 = new Node(5);
        Node node_15 = new Node(15);
        tree.addNode(root, node_5);
        tree.addNode(root, node_15);

        Node node_8 = new Node(8);
        Node node_18 = new Node(18);
        tree.addNode(root, node_8);
        tree.addNode(root, node_18);


        Node node_13 = new Node(13);
        tree.addNode(root, node_13);

        System.out.println("");

        Node node_2 = new Node(2);
        Node node_3 = new Node(3);
        Node node_4 = new Node(4);
        Node node_7 = new Node(7);
        Node node_9 = new Node(9);
        Node node_12 = new Node(12);
        Node node_14 = new Node(14);
        Node node_17 = new Node(17);
        Node node_19 = new Node(19);
        tree.addNode(root, node_3);
        tree.addNode(root, node_2);
        tree.addNode(root, node_4);
        tree.addNode(root, node_7);
        tree.addNode(root, node_9);
        tree.addNode(root, node_12);
        tree.addNode(root, node_14);
        tree.addNode(root, node_17);
        tree.addNode(root, node_19);

        tree.print(root, 0);

        tree.inOrderCrossing(root);
    }
}
