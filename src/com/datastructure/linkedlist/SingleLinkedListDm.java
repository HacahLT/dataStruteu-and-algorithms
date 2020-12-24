package com.datastructure.linkedlist;

import jdk.nashorn.internal.ir.BreakableNode;
import jdk.nashorn.internal.ir.annotations.Ignore;

import java.util.Stack;

/**
 * @author Hacah
 * @date 2020/5/4 14:55
 */
public class SingleLinkedListDm {

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(new Node(4, "aa", "aa"));
        singleLinkedList.add(new Node(5, "bb", "bb"));
        singleLinkedList.add(new Node(6, "bb", "bb"));
        //按照编号加入
//        singleLinkedList.addByOrder(new Node(1, "aa", "aa"));
//        singleLinkedList.addByOrder(new Node(3, "aa", "aa"));
//        singleLinkedList.addByOrder(new Node(2, "aa", "aa"));
//        singleLinkedList.addByOrder(new Node(2, "aa", "aa"));


        //显示
        System.out.println();
        singleLinkedList.list();
        System.out.println();
//
//        //修改
//        singleLinkedList.update(new Node(2, "bb", "aa"));
//        singleLinkedList.update(new Node(3, "cc", "aa"));
//        singleLinkedList.update(new Node(1, "aaa", "aa"));
//
//        //显示
//        singleLinkedList.list();
//        System.out.println();
//
//        //删除
//        singleLinkedList.delete(new Node(3, "cc", "aa"));
//
//        //显示
//        singleLinkedList.list();
//        System.out.println();
//
//        //System.out.println(getLength(singleLinkedList.getHead()));
//
//        //System.out.println(findLastIndexNode(singleLinkedList.getHead(), 6));
//
//        //reverseList(singleLinkedList.getHead());
//        //显示
//        //singleLinkedList.list();
//        //System.out.println();
//
//
//        reversePrint(singleLinkedList.getHead());
//


    }

    /**
     * 面试1：查询链表的有效长度
     *
     * @param head
     * @return
     */
    public static int getLength(Node head) {
        int length = 0;
        //保存节点的变量
        Node cur = head;
        while (cur.next != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

    /**
     * 面试2：查询倒数第几个节点
     *
     * @param head
     * @param index
     * @return
     */
    public static Node findLastIndexNode(Node head, int index) {
        //为空返回null
        if (head.next == null) {
            return null;
        }
        //有效长度
        int length = getLength(head);
        Node cur = head.next;
        //存在这个数
        if (length - index >= 0 && index > 0) {
            for (int i = 1; i <= length - index; i++) {
                cur = cur.next;
            }
        } else {
            System.out.println("索引异常");
            return null;
        }
        return cur;
    }

    public static Node findLastIndexNode2(Node head, int index) {
        //为空返回null
        if (head.next == null) {
            return null;
        }
        int size = 0;
        Node temp = head;
        while (temp.next != null) {
            size++;
            temp = temp.next;
        }
        if (size - index >= 0 && index > 0) {
            int tindex = size - index + 1;
            temp = head;
            for (int i = 0; i < tindex; i++) {
                temp = temp.next;
            }
            return temp;
        }
            return null;


    }

    /**
     * 面试3：链表反转
     */
    public static void reverseList(Node head) {
        //判断链表为空或者只有一个节点。
        if (head.next == null || head.next.next == null) {
            return;
        }
        //定义一个指针,指向当前节点
        Node cur = head.next;
        //指向当前节点的下一个节点
        Node next = null;
        Node reverseHead = new Node(0, "", "");
        //遍历原来的链表，取出放到新的链表中
        while (cur != null) {
            next = cur.next;

            //链表头插法
            cur.next = reverseHead.next;
            reverseHead.next = cur;

            cur = next;
        }
        //头指向反转链表。
        head.next = reverseHead.next;

    }


    /**
     * 面试4：打印反转，不改变结构
     *
     * @param head
     */
    public static void reversePrint(Node head) {
        if (head.next == null) {
            return;
        }
        Stack<Node> stack = new Stack<Node>();
        Node cur = head.next;
        while (cur != null) {
            stack.add(cur);
            cur = cur.next;
        }
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }

    }


}

class SingleLinkedList {
    /** 初始化头结点 */
    private Node head = new Node(0, "", "");
    /** 定义尾指针 */
    private Node tail = null;

    public Node getHead() {
        return head;
    }

    /**
     * @param node
     */
    public void add(Node node) {
        Node temp = head;
        if (temp.next == null) {
            temp.next = node;
        } else {
            tail.next = node;
        }
        tail = node;
    }


    /**
     * 按no排序插入
     */
    public void addByOrder(Node node) {
        Node temp = head;
        //是否有相同节点的编号的判断依据
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > node.no) {
                //在temp和temp.next之间插入
                break;
            } else if (temp.next.no == node.no) {
                //编号存在
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //判断
        if (flag) {
            System.out.println("数据编号已存在，无法添加");
        } else {
            node.next = temp.next;
            temp.next = node;
        }

    }

    /**
     * 根据节点的编号修改信息
     *
     * @param node
     */
    public void update(Node node) {
        //判断是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        Node temp = head;
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
            //把被修改节点的下一个节点用新结点指向
            node.next = temp.next.next;
            //把被修改节点的下一个节点指定为空，释放资源
            temp.next.next = null;
            //把被修改节点的前一个节点指向新节点
            temp.next = node;
        } else {
            //没有找到编号
            System.out.println("没有这个编号，无法修改");
        }
    }

    /**
     * 删除对应节点
     *
     * @param node
     */
    public void delete(Node node) {
        //判断
        if (head.next == null) {
            System.out.println("链表为空，无法删除");
            return;
        }
        Node temp = this.head;
        //是否查到该节点
        boolean flag = false;
        while (true) {
            if (temp.next.no == node.no) {
                flag = true;
                break;
            }
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
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
        Node temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }

    }

}


/** 定义链表节点 */
class Node {
    /** 数据 */
    public int no;
    public String name;
    public String nickname;
    /** 指向下一个节点的变量 */
    public Node next;

    public Node(int no, String name, String nickname) {
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
