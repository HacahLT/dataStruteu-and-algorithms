package com.datastructure.stack;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Hacah
 * @date 2020/9/20 11:47
 */
public class PolandNotation {
    public static void main(String[] args) {

        //把中缀表达式转换成后缀表达式
        //1. 1+((2+3)*4)-5 => 1 2 3 + 4 * 5 -
        //转为List-- 1+((2+3)*4)-5 => ArrayList[1,+,(,(,2,+,3,),*,4,),-,5]
        String expression = "1+((2+3)*4)-5";
        List<String> infixExpressionList = toInfixExpressionList(expression);
        System.out.println(infixExpressionList);
        //把中缀表达list转为后缀表达list
        //ArrayList[1,+,(,(,2,+,3,),*,4,),-,5] => ArrayList[1,2,3,+,4,*,5,-]
        List<String> parseSuffixExpressionList = parseSuffixExpressionList(infixExpressionList);
        System.out.println(parseSuffixExpressionList);
/*
        //定义逆波兰表达式
        // (3+4)*5-6 => 3 4 + 5 * 6 -
        String suffixExpression = "3 4 + 5 * 6 -";
        //把表达式存入集合中
        List<String> list = getListString(suffixExpression);
        System.out.println("放到list的数据是：" + list);
        int i = calculate(list);
        System.out.println("计算的结果是：" + i);*/
    }

    /**
     * 中缀表达式转换为后缀表达式
     * @param infixExpressionList
     * @return
     */
    private static List<String> parseSuffixExpressionList(List<String> infixExpressionList) {
        //初始化栈
        //符号栈
        Stack<String> s1 = new Stack<>();
        //初始化一个list存放后缀表达式，因为用栈的话没有使用到pop，完成后需要逆序获取。
        ArrayList<String> stringArrayList = new ArrayList<>();
        for (String item : infixExpressionList) {
            if (item.matches("\\d+")){
                //数字就添加
                stringArrayList.add(item);
            }else if (item.equals("(")) {
                s1.add(item);
            }else if (item.equals(")")) {
                while (!s1.peek().equals("(")) {
                    stringArrayList.add(s1.pop());
                }
                //弹出括号
                s1.pop();
            }else {
                while (s1.size() != 0 && !isHigherPriority(item,s1.peek())){
                    //如果item的优先级小于等于栈中的优先级
                    stringArrayList.add(s1.pop());
                }
                //压入栈中
                s1.push(item);
            }
        }
        while (s1.size() != 0){
            stringArrayList.add(s1.pop());
        }
        return stringArrayList;
    }

    public static List<String> toInfixExpressionList(String expression) {
        char[] chars = expression.toCharArray();
        ArrayList<String> stringArrayList = new ArrayList<String>();
        //拼接字符串，用于存储多位数与单位数
        String str = "";
        for (char aChar : chars) {
            //字符不是数字
            if (aChar < 48 || aChar > 57) {
                //判断不是空串就不添加
                if (str.length() > 0) {
                    stringArrayList.add(str);
                }
                //拼接的字符串变量转0
                str = "";
                stringArrayList.add("" + aChar);
            } else {
                str += "" + aChar;
            }

        }
        stringArrayList.add(str);
        return stringArrayList;
    }

    public static boolean isHigherPriority(String c1,String c2){
        int cc1 = 0;
        int cc2 = 0;
        if (c1.equals("*") || c1.equals("/")){
            cc1 = 2;
        }else if (c1.equals("+") || c1.equals("-")){
            cc1 = 1;
        }
        if (c2.equals("*") || c2.equals("/")){
            cc2 = 2;
        }else if (c2.equals("+") || c2.equals("-")){
            cc2 = 1;
        }
        return cc1>cc2;
    }

    /**
     * 逆波兰表达式放入list
     *
     * @param suffixExpression
     * @return
     */
    public static List<String> getListString(String suffixExpression) {
        //分割字符串，得到数组
        String[] s = suffixExpression.split(" ");
        ArrayList<String> strings = new ArrayList<String>();
        for (String item : s) {
            strings.add(item);
        }
        return strings;
    }

    public static int calculate(List<String> list) {
        Stack<String> stringStack = new Stack<String>();
        for (String item : list) {
            if (item.matches("\\d+")) {
                //数字就添加到栈里
                stringStack.push(item);
            } else {
                int num2 = Integer.parseInt(stringStack.pop());
                int num1 = Integer.parseInt(stringStack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("出现符号错误");
                }
                stringStack.push("" + res);
            }
        }
        return Integer.parseInt(stringStack.pop());
    }

}
