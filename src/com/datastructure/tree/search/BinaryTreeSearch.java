package com.datastructure.tree.search;

/**
 * @author Hacah
 * @date 2021/1/2 21:04
 * 实现二叉树的前、中、后序查找。
 */
public class BinaryTreeSearch {

    public static void main(String[] args) {

        /*
        * 编写前序查找，中序查找和后序查找的方法。
        * 并分别使用三种查找方式，查找 no = 1 的节点
        * 并分析各种查找方式，分别比较了多少次
        * */
        BinaryTree binaryTree = new BinaryTree(1, "张三");
        binaryTree.addLeftChild(2, "李四").addLeftChild(3, "小唐");
        binaryTree.addRightChild(4, "大千");

        // 前序遍历
        BinaryTree.Node node = binaryTree.preSearch(1);
        System.out.println(node);
        // 中序遍历
        BinaryTree.Node node1 = binaryTree.midSearch(1);
        System.out.println(node1);
        // 后序遍历
        BinaryTree.Node node2 = binaryTree.postSearch(1);
        System.out.println(node2);
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
     * 前序查找
     * @param no
     * @return
     */
    public Node preSearch(int no) {
        return root.preSearch(no);
    }

    /**
     * 中序查找
     * @param no
     * @return
     */
    public Node midSearch(int no) {
        return root.midSearch(no);
    }

    /**
     * 后序查找
     * @param no
     * @return
     */
    public Node postSearch(int no) {
        return root.postSearch(no);
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
         * 前序查找
         *
         * @param no 查找的数
         * @return
         */
        public Node preSearch(int no) {
            // 用于查询的统计判断次数
            System.out.println("一次判断");
            // 从这个节点找
            // 是否这个节点是要找的节点
            if (this.no == no) {
                return this;
            }
            // 从左节点找
            // 是否这个节点的左子树存在要找的节点
            if (leftChild != null) {
                // 临时的变量接收
                Node node = leftChild.preSearch(no);
                // 如果不等于空就找到了数据
                if (node != null) {
                    return node;
                }
            }
            // 从右节点找
            // 是否这个节点的右子树存在要找的节点
            if (rightChild != null) {
                // 临时的变量接收
                Node node = rightChild.preSearch(no);
                // 如果不等于空就找到了数据
                if (node != null) {
                    return node;
                }
            }
            // 都没找到
            return null;
        }

        /**
         * 中序查找
         *
         * @param no 查找的数
         * @return
         */
        public Node midSearch(int no) {
            // 从左节点找
            // 是否这个节点的左子树存在要找的节点
            if (leftChild != null) {
                // 临时的变量接收
                Node node = leftChild.midSearch(no);
                // 如果不等于空就找到了数据
                if (node != null) {
                    return node;
                }
            }
            System.out.println("一次判断");
            // 从这个节点找
            // 是否这个节点是要找的节点
            if (this.no == no) {
                return this;
            }

            // 从右节点找
            // 是否这个节点的右子树存在要找的节点
            if (rightChild != null) {
                // 临时的变量接收
                Node node = rightChild.midSearch(no);
                // 如果不等于空就找到了数据
                if (node != null) {
                    return node;
                }
            }
            // 都没找到
            return null;
        }

        /**
         * 后序查找
         *
         * @param no 查找的数
         * @return
         */
        public Node postSearch(int no) {

            // 从左节点找
            // 是否这个节点的左子树存在要找的节点
            if (leftChild != null) {
                // 临时的变量接收
                Node node = leftChild.postSearch(no);
                // 如果不等于空就找到了数据
                if (node != null) {
                    return node;
                }
            }

            // 从右节点找
            // 是否这个节点的右子树存在要找的节点
            if (rightChild != null) {
                // 临时的变量接收
                Node node = rightChild.postSearch(no);
                // 如果不等于空就找到了数据
                if (node != null) {
                    return node;
                }
            }

            System.out.println("一次判断");
            // 从这个节点找
            // 是否这个节点是要找的节点
            if (this.no == no) {
                return this;
            }


            // 都没找到
            return null;
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

