package com.datastructure.recursion;

/**
 * @author Hacah
 * @date 2020/9/22 11:04
 */
public class RecursionTest {
    public static void main(String[] args) {

    }

    //打印问题
    public static void test(int n) {
        if (n > 2){
            test(n - 1);
        }
        System.out.println(n);
    }

    //阶乘
    public static int factorial(int n) {
        if (n == 1){
            return n;
        }else {
            return factorial(n - 1) * n;
        }
    }



}
