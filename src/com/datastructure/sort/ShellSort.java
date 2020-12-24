package com.datastructure.sort;

import java.util.Arrays;

/**
 * @author Hacah
 * @date 2020/10/13 20:21
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        // shellSort1(arr);
        shellSort2(arr);
    }

    // 交换法   -->慢
    public static void shellSort1(int[] arr) {

        // 声明作为交换的临时变量
        int temp = 0;
        // 记录次数
        int count = 0;
        // 循环增量
        for (int gap = arr.length / 2; gap > 0; gap = gap / 2) {
            // 分几组开始循环
            for (int i = gap; i < arr.length; i++) {
                // 获得同组的数据，遍历各组的元素（共gap组，步长为gap步）
                for (int j = i - gap; j >= 0; j -= gap) {
                    // 数据交换
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j + gap];
                        arr[j + gap] = arr[j];
                        arr[j] = temp;
                    }
                }

            }

            System.out.println("第" + ++count + "次循环" + Arrays.toString(arr));
        }

    }

    // 插入法
    public static void shellSort2(int[] arr) {
        int count = 0;
        for (int gap = arr.length / 2; gap > 0; gap = gap / 2) {
            // 从第gap个元素，逐个对其所在的组进行直接插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                // 记录要插入的数据
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                   while (j - gap >= 0 && temp < arr[j - gap]) {
                       // 移动
                       arr[j] = arr[j - gap];
                       j -= gap;
                   }
                }
                arr[j] = temp;
            }
            System.out.println("第" + ++count + "次循环" + Arrays.toString(arr));
        }


    }

}
