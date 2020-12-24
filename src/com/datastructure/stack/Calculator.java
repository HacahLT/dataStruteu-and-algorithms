package com.datastructure.stack;

import jdk.nashorn.internal.ir.IfNode;

import javax.print.DocFlavor;
import java.util.Arrays;

/**
 * @author Hacah
 * @date 2020/5/6 15:51
 */
public class Calculator {

    public static void main(String[] args) {

        String expression = "30+2*6-2*6+3";
        //创建两个栈
        ArrayStackX numsStack = new ArrayStackX(10);
        ArrayStackX operStack = new ArrayStackX(10);
        //表达式的索引
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        //每次得到的char
        char ch = ' ';
        //用于拼接数字
        String keep = "";
        //while语句循环expression
        while (true) {
            //得到每一个expression字符
            ch = expression.substring(index, index + 1).charAt(0);
            //判断是数字还是符号
            if (operStack.isOper(ch)) {
                if (!operStack.isEmpty()) {
                    //为字符且栈不空，判断字符的优先级
                    //加入的符号小于或等于栈顶的优先级
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        //输出两个数和一个字符进行运算
                        num1 = numsStack.pop();
                        num2 = numsStack.pop();
                        oper = operStack.pop();
                        res = numsStack.cal(num1, num2, oper);
                        //结果放入数栈
                        numsStack.push(res);
                        //把符号入栈
                        operStack.push(ch);
                    } else {
                        operStack.push(ch);
                    }
                } else {
                    //空直接入栈
                    operStack.push(ch);
                }
            } else {
                //为数，处理单位和多位数都需要考虑
                keep += ch;
                //是否为expression最后一位
                if (index == expression.length() - 1) {
                    numsStack.push(Integer.parseInt(keep));
                }else {
                    //判断下一个是否为数字
                    if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        //是符号
                        numsStack.push(Integer.parseInt(keep));
                        //keep要清空
                        keep = "";
                    }
                }

            }
            //让index加1，并判断是否在expression的最后
            index++;
            if (index >= expression.length()) {
                break;
            }
        }
        //扫面expression完毕，取栈数据运算
        while (true) {
            //如果符号栈为空，数栈只有一个数了
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numsStack.pop();
            num2 = numsStack.pop();
            oper = operStack.pop();
            res = numsStack.cal(num1, num2, oper);
            //结果放入数栈
            numsStack.push(res);
        }
        //将存放在数栈的最后结果输出
        System.out.println("表达式：" + expression + "=" + numsStack.pop());

    }
}


/**
 * 定义一个stack类
 */
class ArrayStackX {
    /** 栈大小 */
    private int maxSize;
    /** 数组模拟栈 */
    private int[] stack;
    /** 栈顶指针 */
    private int top = -1;

    public ArrayStackX(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    /**
     * 获取栈顶的值，不删除
     *
     * @return stack[top];
     */
    public int peek() {
        return stack[top];
    }

    /**
     * 判断是否满栈
     *
     * @return
     */
    public boolean isFull() {
        return top == this.maxSize - 1;
    }

    /**
     * 是否为空栈
     *
     * @return
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 进栈
     *
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
     *
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
        while (temp != -1) {
            System.out.print(stack[temp] + "\t");
            temp--;
        }
        System.out.println();
    }

    /**
     * 设置优先级
     *
     * @param oper
     * @return
     */
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * 判断是否是运算符
     *
     * @param val
     * @return
     */
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    /**
     * 运算
     *
     * @param num1
     * @param num2
     * @param oper
     * @return
     */
    public int cal(int num1, int num2, int oper) {
        //存放计算结果
        int res = 0;
        switch (oper) {
            case '+':
                res = num2 + num1;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num2 * num1;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }


}

