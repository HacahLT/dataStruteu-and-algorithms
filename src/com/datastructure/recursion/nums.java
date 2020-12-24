package com.datastructure.recursion;

/**
 * @author Hacah
 * @date 2020/11/18 15:42
 */
public class nums {

    public static void main(String[] args) {
        int num = num(9);
        System.out.println(num);

    }

    public static int num(int n){
        if (n == 1) return 1;
        if (n == 2 ) return 2;

        return num(n-1) + num(n-2);
    }
}
