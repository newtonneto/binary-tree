package com.newton.interfaces;

import com.newton.resources.Node;

public interface ITree {
    Integer compareNodes(Object first_key, Object second_key);
    Node findNode(Node root, Object wanted_node);
    void inOrderCrossing(Node node);
    Integer height(Node node);
    void addNode(Node root, Node node);
    void print(Node node, Integer spaces);
}
