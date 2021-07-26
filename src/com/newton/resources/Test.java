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

        tree.inOrderCrossing(root);

        System.out.println("");
        //tree.printNode(root, 0);

        Node node_14 = new Node(14);
        tree.addNode(root, node_14);

        tree.printNode(root, 0);
    }
}
