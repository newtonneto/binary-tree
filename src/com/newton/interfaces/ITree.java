package com.newton.interfaces;

import com.newton.resources.Node;

public interface ITree {
    int compareNodes(Object first_key, Object second_key);
    Node findNode(Node root, Object wanted_node);
    void inOrderCrossing(Node node);
    int height(Node node);
    void addNode(Node node);
}
