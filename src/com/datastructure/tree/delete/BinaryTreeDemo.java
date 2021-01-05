package com.datastructure.tree.delete;

/**
 * @author Hacah
 * @date 2021/1/2 21:04
 * <p>
 * 树的节点删除
 * 要求：
 * 如果删除的节点是叶子节点，则删除该节点
 * 如果删除的节点是非叶子节点，则删除该子树
 */
public class BinaryTreeDemo {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(1, "张三");
        binaryTree.addLeftChild(2, "李四").addLeftChild(3, "小唐");
        binaryTree.addRightChild(4, "大千");

        // 前序遍历
        binaryTree.preOrder();
        System.out.println();

        // 删除2子树
        binaryTree.delNode(2);

        binaryTree.preOrder();
        System.out.println();


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
     * 删除节点
     * @param no 删除节点的no号
     */
    public void delNode(int no) {
        // 判断是否树为空
        if (root != null) {
            // 如果树只有一个节点，判断是否要删除的节点，是就删除，把树变为空。
            if (root.no == no) {
                root = null;
                return;
            }else {
                root.delNode(no);
            }
        }else {
            System.out.println("没找到节点");
        }
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
         * 删除节点
         *
         * @param no 删除节点的no号
         */
        public void delNode(int no) {
            // 在此节点中应该判断左右节点是否需要删除

            // 判断当前节点的左节点是否为空，且左节点是否需要删除，是就删除，
            // 否则 就递归左子树（即把左子树当成一颗新的树，再进行同样的判断）
            if (this.leftChild != null) {
                if (this.leftChild.no == no) {
                    // 找到就删除节点
                    this.leftChild = null;
                    return;
                } else {
                    // 递归左子树
                    this.leftChild.delNode(no);
                }
            }
            // 判断当前节点的右节点是否为空，右节点是否需要删除，是就删除，
            // 否则就递归右子树（即把右子树当成一颗新的树，再进行同样的判断）
            if (this.rightChild != null) {
                if (this.rightChild.no == no) {
                    // 找到就删除节点
                    this.rightChild = null;
                    return;
                } else {
                    // 递归左子树
                    this.rightChild.delNode(no);
                }
            }

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

