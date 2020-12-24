package com.datastructure.queue;

import java.util.Scanner;

/**
 * @author Hacah
 * @date 2020/5/3 15:26
 */
public class CircleArrayQueueDemos {

    public static void main(String[] args) {
        CircleArrayQueue queue = new CircleArrayQueue(3);
        //交互窗口,接收用户输入
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println();
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head):查看队列头数据");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        System.out.println("取出的数据是：" + queue.getQueue());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        System.out.println("队列头数据是：" + queue.headQueue());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}

/** 数组模拟队列 */
class CircleArrayQueue {

    /** 数组最大容量 */
    private int maxSize;
    /** 队列头，指向第一个数据，初始化为0 */
    private int front;
    /** 队列尾 指向最后一个数据的后一位，初始化为0 */
    private int rear;
    /** 数组，存放数据，模拟队列 */
    private int[] arr;

    /** 初始化队列 */
    public CircleArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = 0;
        rear = 0;
    }

    /** 判断队列是否满了 */
    public boolean isFull() {
        return (rear+1) % maxSize == front;
    }

    /** 判断队列是否为空 */
    public boolean isEmpty() {
        return rear == front;
    }

    /** 添加数据到队列 */
    public void addQueue(int n) {
        //判断队列是否已满
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        //赋值
        arr[rear] = n;
        //后移
        rear = (rear+1)%maxSize;

    }

    /** 数据出列 */
    public int getQueue() {
        //判断是否为空队列
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        int temp = arr[front];
        //后移
        front = (front + 1) % maxSize;
        return temp;
    }

    /** 展示所有数据 */
    public void showQueue() {
        //判断
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        for (int i = front; i < front+size(); i++) {
            System.out.printf("%d\t", arr[i%maxSize]);
        }
    }

    /** 求出当前队列数据个数*/
    public int size() {
        return (rear-front+maxSize)%maxSize;
    }

    /** 显示头数据 */
    public int headQueue() {
        //判断
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front];

    }

}
