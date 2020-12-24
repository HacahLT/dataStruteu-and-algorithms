package com.datastructure.linkedlist;

/**
 * @author Hacah
 * @date 2020/5/5 17:43
 */
public class Josepfu {

    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.add(5);
        circleSingleLinkedList.show();

        circleSingleLinkedList.countNode(1,2);

    }

}

/** 环单向链表 */
class CircleSingleLinkedList {
    private Node3 first;
    /**一共几节点*/
    private int size;

    /**
     * 添加一个有num个节点的环链表
     *
     * @param num
     */
    public void add(int num) {
        if (num < 1) {
            System.out.println("输入的值不正确");
            return;
        }
        Node3 cur = null;
        for (int i = 1; i <= num; i++) {
            Node3 node = new Node3(i);
            if (i == 1) {
                first = node;
                node.setNext(node);
                cur = node;
            } else {
                cur.setNext(node);
                node.setNext(first);
                cur = node;
            }
        }
        size = num;
    }

    /**
     * 打印
     */
    public void show() {
        //判断是否空
        if (first == null) {
            System.out.println("链表为空");
            return;
        }
        Node3 cur = first;

        while (true) {
            System.out.println(cur.getNo());
            if (cur.getNext() == first) {
                break;
            }
            cur = cur.getNext();
        }

    }

    /**
     * 计算出圈顺序
     *
     * @param startNo  开始位置
     * @param countNum 数几下数
     */
    public void countNode(int startNo, int countNum) {
        if (first == null || startNo < 1 || startNo > size ) {
            System.out.println("参数输入有误");
            return;
        }
        Node3 helper = first;
        //helper移动到first前一个位置
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        //helper和first移动到指定的开始位置
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //循环取出节点
        while (true) {
            //圈中只有一个节点
            if (helper == first) {
                break;
            }
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.println("出圈"+first.getNo());
            //删除节点
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println("剩下的节点："+first.getNo());
    }
}

/** 节点 */
class Node3 {
    private int no;
    private Node3 next;

    public Node3(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Node3 getNext() {
        return next;
    }

    public void setNext(Node3 next) {
        this.next = next;
    }
}
