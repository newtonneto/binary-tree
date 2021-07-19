package com.newton.resources;

import com.newton.interfaces.ITree;

public class Tree implements ITree {
    private Node root;

    public Tree(Node root) {
        this.root = root;
    }

    @Override
    public int compareNodes(Object first_key, Object second_key) {
        Integer first_value = Integer.parseInt(first_key.toString());
        Integer second_value = Integer.parseInt(second_key.toString());

        System.out.println("First value: " + first_value + " Second value: " + second_value);

        if (first_value < second_value) {
            //Retorna -1 caso o wanted_node seja menor que o root atual
            return -1;
        } else if (first_value > second_value) {
            //Retorna 1 caso o wanted_node seja maior que o root atual
            return 1;
        };

        //Retorna 0 caso o wanted_node seja igual ao root atual
        return 0;
    }

    @Override
    public Node findNode(Node root, Object wanted_node) {
        Node search_result = null;
        Integer compare_result = this.compareNodes(wanted_node, root.getKey());

        //Se a key buscada for menor que o valor do root atual, busque no filho esquerdo
        if (compare_result == -1 && search_result == null) {
            Node left_child = root.getLeftChild();

            //Se o root atual possuir um filho esquerdo, buscar o wanted_node nele
            if (left_child != null) {
                search_result = findNode(left_child, wanted_node);
            }

            //Se não tiver quer dizer que o wanted_node não existe nessa árvore
            return search_result;
        }
        //Se a key buscada for maior que o valor do root atual, busque no filho direito
        else if (compare_result == 1 && search_result == null) {
            Node right_child = root.getRightChild();

            //Se o root atual possuir um filho direito, buscar o wanted_node nele
            if (right_child != null) {
                search_result = findNode(right_child, wanted_node);
            }

            //Se não tiver quer dizer que o wanted_node não existe nessa árvore
            return search_result;
        }
        //Se as keys forem igual o wanted_node é o root atual
        else if (compare_result == 0) {
            return  search_result = root;
        }

        //Caso todas as condicionais falhem, o wanted_node n existe na árvore
        return null;
    }

    @Override
    public void inOrderCrossing(Node node) {
        //Se o node não for externo, visite o filho esquerdo
        if (node.isInternal()) {
            inOrderCrossing(node.getLeftChild());
        }

        //Visite o proprio node
        System.out.println(node);

        //Se o node não for externo, visite o node direito
        if (node.isInternal()) {
            inOrderCrossing(node.getRightChild());
        }
    }
}
