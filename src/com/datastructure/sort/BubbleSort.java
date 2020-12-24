package com.datastructure.sort;

import java.util.Arrays;

/**
 * @author Hacah
 * @date 2020/9/28 14:32
 */
public class BubbleSort {

    public static void main(String[] args) {
        // 定义一个数组存放要排序的数据
        int[] arr = {3, 9, -1, 10, -2};

        // 这个数据因为我们编写的优化只需要2次排序就可以完成
        // int[] arrt = {3, 9, -1, 10, 20};

        bubbleSorts(arr);
        // bubbleSorts(arrt);


    }

    /**
     * 冒泡排序的方法
     * @param arr 排序的数组
     */
    public static void bubbleSorts(int [] arr) {
        // 定义临时变量。
        int temp = 0;

        // 定义一个状态，表示是否有进行交换，用于优化这个算法
        // 假如一次循环中没有发生交换，那就直接返回数据
        boolean flag = false;

        // 循环排序的次数
        for (int i = arr.length - 1; i > 0; i--) {
            // 每一次排序确定一个数，所以循环判断的次数减少
            for (int j = 0; j < i; j++) {
                // 如果前面的数比后面的数大则交换
                if (arr[j] > arr[j + 1]) {
                    // 执行到这里代表进行的交换
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

            if (!flag) {
                break;
            }else {
                flag = false;
            }

            System.out.println("第"+(5-i)+"次循环数据是："+Arrays.toString(arr));
        }

        System.out.println(Arrays.toString(arr));

    }

}
