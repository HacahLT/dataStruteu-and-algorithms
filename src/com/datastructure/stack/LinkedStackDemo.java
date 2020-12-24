package com.datastructure.stack;

import java.awt.*;
import java.util.Stack;

/**
 * @author Hacah
 * @date 2020/5/6 11:59
 * 使用链表实现栈
 */
public class LinkedStackDemo {
    public static void main(String[] args) {
        LinkedStack stack = new LinkedStack();

        //进栈
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.show();

        //出栈
        stack.pop();
        stack.pop();
        stack.pop();
        stack.show();


    }

}


class LinkedStack {

    /**定义节点*/
    class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    /**头结点*/
    private Node head = new Node(0);
    /**尾指针*/
    private Node tail;


    public boolean isEmpty() {
        return head.next == null;
    }

    /**
     * 进栈
     */
    public void push(int i) {
        Node node = new Node(i);
        if (head.next == null) {
            head.next = node;
        }else {
            tail.next = node;
        }
        tail = node;
    }

    /**
     * 出栈
     * @return
     */
    public int pop() {
        if (isEmpty()) {
            throw new  RuntimeException("栈空");
        }
        Node temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }
        int value = tail.data;
        temp.next = null;
        tail = temp;
        return value;
    }

    /**
     * 展示
     */
    public void show() {
        if (isEmpty()) {
            System.out.println("栈是空");
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            System.out.println(temp.next.data);
            temp = temp.next;
        }
    }

}
