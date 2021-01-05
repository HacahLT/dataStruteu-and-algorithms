package com.datastructure.tree.arrayTree;

import com.sun.deploy.util.ArrayUtil;

/**
 * @author Hacah
 * @date 2021/1/5 22:03
 * <p>
 * 完成一个顺序存储的二叉树的前序遍历。
 * 使用{1, 2, 3, 4, 5, 6, 7}这个存储的二叉树，实现前序、中序、后序遍历打印该树。
 */
public class ArrayBinaryTreeDemo {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(arr);
        // 前序遍历
        arrayBinaryTree.preOrder();
        System.out.println();
        // 中序遍历
        arrayBinaryTree.midOrder();
        System.out.println();
        // 后序遍历
        arrayBinaryTree.postOrder();

    }

}

class ArrayBinaryTree {
    private int[] arr;

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder() {
        // 开始的节点是数组下标为0的节点
        preOrder(0);
    }

    public void midOrder() {
        // 开始的节点是数组下标为0的节点
        midOrder(0);
    }

    public void postOrder() {
        // 开始的节点是数组下标为0的节点
        postOrder(0);
    }


    /**
     * 前序遍历
     *
     * @param num 开始节点
     */
    private void preOrder(int num) {
        if (arr != null && arr.length > 0) {
            // 打印开始节点数据
            System.out.print(arr[num] + " ");
            // 查看本节点的左节点是否存在数据
            int leftChild = getLeftChild(num);
            if (leftChild < arr.length) {
                // 存在左节点值
                preOrder(leftChild);
            }
            // 查看本节点的右节点是否存在数据
            int rightChild = getRightChild(num);
            if (rightChild < arr.length) {
                preOrder(rightChild);
            }
        }
    }

    /**
     * 中序遍历
     *
     * @param num 开始节点
     */
    private void midOrder(int num) {
        if (arr != null && arr.length > 0) {
            // 查看本节点的左节点是否存在数据
            int leftChild = getLeftChild(num);
            if (leftChild < arr.length) {
                // 存在左节点值
                midOrder(leftChild);
            }

            // 打印开始节点数据
            System.out.print(arr[num] + " ");

            // 查看本节点的右节点是否存在数据
            int rightChild = getRightChild(num);
            if (rightChild < arr.length) {
                midOrder(rightChild);
            }
        }
    }

    /**
     * 后序遍历
     *
     * @param num 开始节点
     */
    private void postOrder(int num) {
        if (arr != null && arr.length > 0) {
            // 查看本节点的左节点是否存在数据
            int leftChild = getLeftChild(num);
            if (leftChild < arr.length) {
                // 存在左节点值
                postOrder(leftChild);
            }
            // 查看本节点的右节点是否存在数据
            int rightChild = getRightChild(num);
            if (rightChild < arr.length) {
                postOrder(rightChild);
            }
            // 打印开始节点数据
            System.out.print(arr[num] + " ");
        }
    }

    /**
     * 得到左节点位置
     *
     * @param num
     * @return
     */
    public int getLeftChild(int num) {
        return (2 * num + 1);
    }

    /**
     * 得到右节点位置
     *
     * @param num
     * @return
     */
    public int getRightChild(int num) {
        return 2 * num + 2;
    }

}
