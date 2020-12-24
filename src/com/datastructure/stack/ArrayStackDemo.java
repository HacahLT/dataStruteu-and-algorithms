package com.datastructure.stack;

/**
 * @author Hacah
 * @date 2020/5/6 11:07
 *  使用数组实现栈
 */
public class ArrayStackDemo {

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.show();
        stack.pop();
        stack.show();

    }
}

/**
 * 定义一个stack类
 */
class ArrayStack {
    /** 栈大小 */
    private int maxSize;
    /** 数组模拟栈 */
    private int[] stack;
    /** 栈顶指针 */
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    /**
     * 判断是否满栈
     * @return
     */
    public boolean isFull() {
        return top == this.maxSize - 1;
    }

    /**
     * 是否为空栈
     * @return
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 进栈
     * @param value
     */
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    /**
     * 出栈
     * @return
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        int value = stack[top];
        top--;
        return value;
    }

    /**
     * 展示栈数据
     */
    public void show() {
        if (isEmpty()) {
            System.out.println("栈空");
            return;
        }
        int temp = top;
        while(temp!=-1) {
            System.out.print(stack[temp]+"\t");
            temp--;
        }
        System.out.println();
    }

}
