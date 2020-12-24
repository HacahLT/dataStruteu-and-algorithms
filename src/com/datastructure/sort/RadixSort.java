package com.datastructure.sort;

import java.util.Arrays;

/**
 * @author Hacah
 * @date 2020/11/9 22:45
 * <p>
 * 基数排序
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] arr = {53, 34, 232, 36, 157, 375};
        radixSort(arr);
    }


    public static void radixSort(int[] arr) {

        // 得到基数
        // 1.获取数组中最大的数
        int maxInt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxInt) {
                maxInt = arr[i];
            }
        }
        // 得到把数组放桶中排序的次数
        int times = String.valueOf(maxInt).length();
        // 创建出十个桶存放排序数据，每个桶最大放的数据是排序数组的所有数据。
        int[][] bucket = new int[10][arr.length];
        // 创建一个数组用来记录每一个桶存放了多少数据,该数组的下标对应桶的编号。
        int[] bucketCounts = new int[10];


        for (int t = 0; t < times ;t++) {

            // 1.把数组的数据放到对应的桶里。
            // 遍历数组，获得每一个数组的个位数
            for (int j = 0; j < arr.length; j++) {
                // 获得相应的位数的数值存在变量baseInt里
                int pow = (int)Math.pow(10, t);
                int baseInt = arr[j] /pow % 10;
                // 把对应的数组放到桶中
                bucket[baseInt][bucketCounts[baseInt]] = arr[j];
                bucketCounts[baseInt]++;
            }
            // 2.按照顺序把桶的数据取出来放回原来的数组
            // 遍历每一个桶
            // 设置数组下标
            int index = 0;
            for (int i = 0; i < bucketCounts.length; i++) {
                // 判断桶中是否有数据
                if (bucketCounts[i] != 0) {
                    for (int v = 0; v < bucketCounts[i]; v++) {
                        arr[index] = bucket[i][v];
                        index++;
                    }
                }
                // 把记录数组重置为0,避免影响下次存取数据。
                bucketCounts[i] = 0;
            }

            System.out.println(Arrays.toString(arr));
        }
    }

}
