package com.datastructure.tree.huffmantree;

import java.util.*;

/**
 * @author Hacah
 * @date 2021/2/4 13:42
 *
 * 构建霍夫曼树的实现
 */
public class Huffmantree {

    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        Node huffmanTree = createHuffmanTree(arr);
        // 前序遍历输出
        // 预测67, 29，38, 15, 7, 8, 23, 10, 4, 1, 3, 6, 13
        huffmanTree.preNode();

    }

    public static Node createHuffmanTree(int[] arr) {
        // 1、遍历数组把每一个数据都转成一颗二叉树,并且添加到treeSet中
        // 使用treeSet的原因是会自动按设置的规则排序，这里设置了重小到大排序
        TreeSet treeSet = new TreeSet<Node>();
        for (int i : arr) {
            treeSet.add(new Node(i));
        }

        // 在构建完成后set的内部会剩1个数据，所以treeSet.size() > 1就一直构建二叉树
        while (treeSet.size() > 1) {
            // 2、取出最小的两个节点,并从set中删除
            Node leftNode = (Node) treeSet.pollFirst();
            Node rightNode = (Node) treeSet.pollFirst();

            // 3、构建二叉树
            Node parentNode = new Node(leftNode.value + rightNode.value);
            parentNode.leftNode = leftNode;
            parentNode.rightNode = rightNode;

            // 4、根节点添加到set中
            treeSet.add(parentNode);

        }
        // 返回哈夫曼树的根节点
        return (Node) treeSet.pollFirst();

    }





}





/**
 * 创建一个树的节点类
 * 实现比较类
 */
class Node implements Comparable<Node>{

    /** 节点的权 */
    public int value;

    public Node leftNode;

    public Node rightNode;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        // 从小到大比较
        return this.value - o.value;
    }

    /**
     * 前序遍历输出
     */
    public void preNode() {
        System.out.println(this);
        if (this.leftNode != null) {
            leftNode.preNode();
        }
        if (this.rightNode != null) {
            rightNode.preNode();
        }
    }
}
