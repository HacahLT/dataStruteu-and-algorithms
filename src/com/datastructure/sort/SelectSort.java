package com.datastructure.sort;

import java.util.Arrays;

/**
 * @author Hacah
 * @date 2020/9/29 20:47
 */
public class SelectSort {

    public static void main(String[] args) {
        // 定义数组
        int[] arr = {101, 34, 119, 1};
        // 选择排序
        selectSort(arr);
        // 打印结果
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 选择排序
     *
     * @param arr 排序数组
     */
    public static void selectSort(int[] arr) {

        // 循环排序的次数。
        for (int i = 0; i < arr.length - 1; i++) {

            // 设置临时变量存放最小的数和最小数的索引，开始假设为第i次循环的第一个数。
            int minNum = arr[i];
            int minIndex = i;

            // 循环获取最小数，存放在临时变量里。
            for (int j = 1 + i; j < arr.length; j++) {
                if (minNum > arr[j]) {
                    minNum = arr[j];
                    minIndex = j;
                }
            }

            // 交换数据。
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = minNum;
            }

            //System.out.println("第"+(i+1)+"次循环："+Arrays.toString(arr));
        }

    }
}
