package com.datastructure.search;

/**
 * @author Hacah
 * @date 2020/11/10 22:08
 */
public class SeqSearch {

    public static void main(String[] args) {
        int[] arr = {1, 9, 24, 20, 16, 14, 265};
        int i = seqSearch(arr, 14);
        System.out.println(i);
    }

    /**
     * 线性查找，返回对应数据在数组中的下标
     * @param arr  查找数组
     * @param seaInt 要查找的数据
     * @return
     */
    public static int seqSearch(int[] arr,int seaInt) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == seaInt) {
                return i;
            }
        }
        return -1;
    }
}
