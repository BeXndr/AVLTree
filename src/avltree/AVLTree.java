/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avltree;

/**
 *
 * @author Bernardo
 */
public class AVLTree<T extends Comparable<T>> {

        private Node<T> root;

        public AVLTree() {
            this.root = null;
        }

        public void insert(T data) {
            this.root = insert(this.root, data);
        }

        private Node<T> insert(Node<T> node, T data) {
            if (node == null) {
                return new Node<>(data);
            }

            if (data.compareTo(node.data) < 0) {
                node.left = insert(node.left, data);
            } else if (data.compareTo(node.data) > 0) {
                node.right = insert(node.right, data);
            }

            int balanceFactor = getBalanceFactor(node);

            if (balanceFactor > 1 && data.compareTo(node.left.data) < 0) {
                return rightRotate(node);
            }

            if (balanceFactor < -1 && data.compareTo(node.right.data) > 0) {
                return leftRotate(node);
            }

            if (balanceFactor > 1 && data.compareTo(node.left.data) > 0) {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }

            if (balanceFactor < -1 && data.compareTo(node.right.data) < 0) {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }

            return node;
        }

        private Node<T> rightRotate(Node<T> node) {
            Node<T> left = node.left;
            Node<T> rightOfLeft = left.right;

            left.right = node;
            node.left = rightOfLeft;

            node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
            left.height = Math.max(getHeight(left.left), getHeight(left.right)) + 1;

            return left;
        }

        private Node<T> leftRotate(Node<T> node) {
            Node<T> right = node.right;
            Node<T> leftOfRight = right.left;

            right.left = node;
            node.right = leftOfRight;

            node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
            right.height = Math.max(getHeight(right.left), getHeight(right.right)) + 1;

            return right;
        }

        private int getHeight(Node<T> node) {
            if (node == null) {
                return 0;
            }

            return node.height;
        }

        private int getBalanceFactor(Node<T> node) {
            if (node == null) {
                return 0;
            }

            return getHeight(node.left) - getHeight(node.right);
        }

        public void list() {
            list(root);
        }

        private void list(Node<T> node) {
            if (node != null) {
                list(node.left);
                System.out.println(node.data);
                list(node.right);
            }
        }

        private class Node<T extends Comparable<T>> {

            private T data;
            private Node<T> left;
            private Node<T> right;
            private int height;

            public Node(T data) {
                this.data = data;
                this.left = null;
                this.right = null;
                this.height = 1;
            }
        }
    }