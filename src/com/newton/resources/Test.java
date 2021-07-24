package com.newton.resources;

import com.newton.interfaces.ITest;

public class Test implements ITest {
    Tree tree;
    Node root = new Node("10");

    public Test() {
        this.tree = new Tree(root);
    }

    public void executeTestOne() {
        Node eight = new Node("8");
        Node eleven = new Node("11");

        this.root.setLeftChild(eight);
        this.root.setRightChild(eleven);

        Node five = new Node("5");

        eight.setLeftChild(five);

        Node wanted_node;

        wanted_node = this.tree.findNode(this.root, "5");

        System.out.println("Wanted Node: " + wanted_node);

        Node viteeum = new Node(21);
        Node viteedois = new Node(22);
        five.setRightChild(viteeum);
        five.setLeftChild(viteedois);

        Node trintaeum = new Node(31);

        viteedois.setRightChild(trintaeum);

        System.out.println("Tree Height: " + tree.height(root));

        tree.inOrderCrossing(root);
    }
}
