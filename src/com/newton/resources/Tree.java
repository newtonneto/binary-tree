package com.newton.resources;

import com.newton.interfaces.ITree;

public class Tree implements ITree {
    private Node root;
    private Integer node_quantity;

    public Tree(Node root) {
        this.node_quantity = 0;
        this.root = root;
    }

    @Override
    public Integer compareNodes(Object first_key, Object second_key) {
        Integer first_value = Integer.parseInt(first_key.toString());
        Integer second_value = Integer.parseInt(second_key.toString());
        Integer result;

        if (first_value > second_value) {
            result = -1;
        } else if (first_value < second_value) {
            result = 1;
        } else {
            result = 0;
        }

        return result;
    }

    @Override
    public Node findNode(Node root, Object wanted_node) {
        Integer comparation = compareNodes(root.getKey(), wanted_node);
        Node finded_node = null;

        //Buscar no node esquerdo
        if (comparation == -1 && finded_node == null) {
            //Se o lado esquerdo do root atual for nulo, retorne o root pois o novo node será inserido nele
            if (root.getLeftChild() == null) {
                return root;
            }
            //Se não for, continue a busca
            else {
                finded_node = findNode(root.getLeftChild(), wanted_node);
            }
        }
        //Buscar no node direito
        else if (comparation == 1 && finded_node == null) {
            //Se o lado direito do root atual for nulo, retorne o root pois o novo node será inserido nele
            if (root.getRightChild() == null) {
                return root;
            }
            //Se não for, continue a busca
            else {
                finded_node = findNode(root.getRightChild(), wanted_node);
            }
        }
        //Se o resultado da comparação for 0, o node buscado existe na árvore
        else {
            return root;
        }

        return finded_node;
    }

    @Override
    public void inOrderCrossing(Node node) {
        //Se o node não for externo, visite o filho esquerdo
        if (node.isInternal() && node.getLeftChild() != null) {
            inOrderCrossing(node.getLeftChild());
        }

        //Visite o proprio node
        System.out.println("Node: " + node.toString() + " height: " + height(node));

        //Se o node não for externo, visite o node direito
        if (node.isInternal() && node.getRightChild() != null) {
            inOrderCrossing(node.getRightChild());
        }
    }

    @Override
    public Integer height(Node node) {
        if (node != null) {
            return Math.max(height(node.getLeftChild()), height(node.getRightChild())) + 1;
        } else {
            return 0;
        }
    }

    @Override
    public void addNode(Node root, Node node) {
        //Verifica se o node já existe na árvore, se não existir recebe o node pai do novo node
        Node parent_node = findNode(this.root, node.getKey());

        if (parent_node.getKey() == node.getKey()) {
            System.out.println("O node passado já existe na árvore");
        } else {
            //Verifica se o novo node é maior ou menor que o seu pai
            Integer comparation = this.compareNodes(parent_node.getKey(), node.getKey());
            node.setParent(parent_node);
            this.node_quantity = this.node_quantity + 1;

            //Será filho esquerdo
            if (comparation == -1) {
                parent_node.setLeftChild(node);
            }
            //Será filho direito
            else if (comparation == 1) {
                parent_node.setRightChild(node);
            }
        }
    }

    @Override
    public void print(Node node, Integer spaces) {
        spaces = spaces + 10;

        if (node.isInternal() && node.getLeftChild() != null) {
            print(node.getLeftChild(), spaces);
        }

        System.out.print("\n");
        for (int index = 10; index < spaces; index++) {
            System.out.print(" ");
        }
        System.out.print(node.getKey() + "\n");

        if (node.isInternal() && node.getRightChild() != null) {
            print(node.getRightChild(), spaces);
        }
    }
}
