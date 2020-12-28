package com.datastructure.tree;

/**
 * @author Hacah
 * @date 2021/1/2 21:04
 * @Description 实现二叉树的前、中、后序遍历。
 */
public class BinaryTreeDemo {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(1, "张三");
        binaryTree.addLeftChild(2, "李四").addLeftChild(3, "小唐");
        binaryTree.addRightChild(4, "大千");

        // 前序遍历
        binaryTree.preOrder();
        System.out.println();
        // 中序遍历
        binaryTree.midOrder();
        System.out.println();
        // 后序遍历
        binaryTree.posOrder();
    }


}

/**
 * 二叉树的类
 */
class BinaryTree {

    /** 根节点 */
    private Node root;

    public BinaryTree(int no, String name) {
        root = new Node(no, name);
    }

    /**
     * 前序遍历方法
     */
    public void preOrder() {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("root为空");
        }
    }

    public void midOrder() {
        if (root != null) {
            root.midOrder();
        } else {
            System.out.println("root为空");
        }
    }

    public void posOrder() {
        if (root != null) {
            root.postOrder();
        } else {
            System.out.println("root为空");
        }
    }

    /**
     * 添加左节点
     *
     * @return
     */
    public Node addLeftChild(int no, String name) {
        return root.addLeftChild(no, name);
    }

    /**
     * 添加右节点
     *
     * @return
     */
    public Node addRightChild(int no, String name) {
        return root.addRightChild(no, name);
    }


    /**
     * 二叉树的节点
     */
    static class Node {

        private int no;
        private String name;
        private Node leftChild;
        private Node rightChild;

        public Node(int no, String name) {
            this.no = no;
            this.name = name;
        }

        /**
         * 前序遍历
         */
        public void preOrder() {
            System.out.println(this);
            if (this.leftChild != null) {
                leftChild.preOrder();
            }
            if (rightChild != null) {
                rightChild.preOrder();
            }
        }

        /**
         * 中序遍历
         */
        public void midOrder() {
            if (this.leftChild != null) {
                leftChild.midOrder();
            }
            System.out.println(this);
            if (this.rightChild != null) {
                rightChild.midOrder();
            }
        }

        /**
         * 后序遍历
         */
        public void postOrder() {
            if (this.leftChild != null) {
                leftChild.postOrder();
            }
            if (rightChild != null) {
                rightChild.postOrder();
            }
            System.out.println(this);
        }

        /**
         * 添加左节点
         *
         * @return
         */
        public Node addLeftChild(int no, String name) {
            Node node = new Node(no, name);
            this.leftChild = node;
            return node;
        }

        /**
         * 添加右节点
         *
         * @return
         */
        public Node addRightChild(int no, String name) {
            Node node = new Node(no, name);
            rightChild = node;
            return node;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    '}';
        }

    }

}

