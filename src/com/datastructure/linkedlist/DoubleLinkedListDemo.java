package com.datastructure.linkedlist;

import sun.awt.ModalExclude;

/**
 * @author Hacah
 * @date 2020/5/5 14:22
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        //尾部添加
        doubleLinkedList.add(new Node2(4, "aa", "aa"));
        doubleLinkedList.add(new Node2(5, "bb", "bb"));
        doubleLinkedList.add(new Node2(6, "bb", "bb"));

        //显示
        doubleLinkedList.list();

        //修改
        doubleLinkedList.update(new Node2(5, "cc", "bb"));

        System.out.println();
        doubleLinkedList.list();

        //删除
        doubleLinkedList.delete(6);
        System.out.println();
        doubleLinkedList.list();

        //按序号添加
        doubleLinkedList.addByOrder(new Node2(6, "cc", "bb"));
        doubleLinkedList.addByOrder(new Node2(2, "cc", "bb"));
        doubleLinkedList.addByOrder(new Node2(3, "cc", "bb"));
        System.out.println();
        doubleLinkedList.list();

    }

}

class DoubleLinkedList {
    /** 初始化头结点 */
    private Node2 head = new Node2(0, "", "");


    /**
     * 末尾添加
     * @param node
     */
    public void add(Node2 node) {
        Node2 temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
        node.pre = temp;
    }

    /**
     * 按序号插入数据
     * @param node
     */
    public void addByOrder(Node2 node) {
        Node2 temp = head;
        while (true) {
            if (temp.next == null) {
                temp.next = node;
                node.pre = temp;
                break;
            }
            if (temp.next.no > node.no) {
                node.next = temp.next;
                temp.next.pre = node;
                temp.next = node;
                node.pre = temp;
                break;
            }
            if (temp.next.no == node.no) {
                System.out.println("已有相同编号，无法添加");
                break;
            }
            temp = temp.next;
        }
    }

    /**
     * 根据节点的编号修改信息
     * @param node
     */
    public void update(Node2 node) {
        //判断是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        Node2 temp = head;
        //是否查到该节点
        boolean flag = false;
        while (true) {
            //编号相同
            if (temp.next.no == node.no) {
                flag = true;
                break;
            }
            //到了链表的尾部
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next.name = node.name;
            temp.next.nickname = node.nickname;
        } else {
            //没有找到编号
            System.out.println("没有这个编号，无法修改");
        }
    }

    /**
     * 删除对应节点
     * @param n
     */
    public void delete(int n) {
        //判断
        if (head.next == null) {
            System.out.println("链表为空，无法删除");
            return;
        }
        Node2 temp = head.next;
        //是否查到该节点
        boolean flag = false;
        while (true) {
            if (temp.no == n) {
                flag = true;
                break;
            }
            if (temp == null) {
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.pre.next = temp.next;
            //如果是最后一个节点就不需要执行，空指针异常出现
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.println("没有找到对应编号，无法删除");
        }


    }

    /**
     * 遍历显示链表
     */
    public void list() {
        //判断是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        Node2 temp = head.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }

    }
}

/** 定义链表节点 */
class Node2 {
    /** 数据 */
    public int no;
    public String name;
    public String nickname;
    /** 指向上一个节点的变量 */
    public Node2 pre;
    /** 指向下一个节点的变量 */
    public Node2 next;

    public Node2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
