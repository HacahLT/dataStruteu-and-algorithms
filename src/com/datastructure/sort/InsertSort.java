package com.datastructure.sort;

import java.util.Arrays;

/**
 * @author Hacah
 * @date 2020/10/11 20:59
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {3, 6, 1, 7, 5};
        insertSort(arr);
    }

    public static void insertSort(int[] arr) {

        // 循环排序，从第二个数开始判断所以i=1。
        for (int i = 1; i < arr.length; i++) {
            // 要插入进有序表的数据
            int insertVal = arr[i];
            // 将要插入数据的位置，开始假设在前一个位置
            int insertIndex = i - 1;
            // 向前找到合适的插入位置，把数据向后移动
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                // 把数据后移
                arr[insertIndex + 1] = arr[insertIndex];
                // 把插入的位置向前移动
                insertIndex--;
            }

            // insertIndex + 1是插入的位置
            // 把数据插入找到的位置
            arr[insertIndex + 1] = insertVal;

            System.out.println("第"+i+"轮插入后的数据：");
            System.out.println(Arrays.toString(arr));

        }


    }
}
