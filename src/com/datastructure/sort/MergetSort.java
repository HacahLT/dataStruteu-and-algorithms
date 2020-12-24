package com.datastructure.sort;

import java.util.Arrays;

/**
 * @author Hacah
 * @date 2020/10/28 20:54
 */
public class MergetSort {

    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        int[] tempArr = new int[arr.length];
        merget(arr, 0, arr.length - 1, tempArr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * @param arr   排序的数组
     * @param left  数组的最左的下标
     * @param right 数组最右的下标
     */
    public static void merget(int[] arr, int left, int right, int[] tempArr) {
        if (left < right) {
            int mid = (left+right) / 2;
            merget(arr, left, mid, tempArr);
            merget(arr, mid + 1, right, tempArr);
            arrMerget(arr, left, mid, right, tempArr);
        }
    }

    /**
     * 合并的方法，把两个数组排序合并
     *
     * @param arr     排序的数组
     * @param left    数组最左边的下标
     * @param mid     数组中间的下标
     * @param right   数组最右边的下标
     * @param tempArr 一个临时的数组
     */
    public static void arrMerget(int[] arr, int left, int mid, int right, int[] tempArr) {
        // 一个数组的开始索引
        int first = left;
        // 另一个数组的开始索引
        int first2 = mid + 1;
        // 声明临时数组的索引
        int tempArrIndex = 0;


        // 把两个数组的数据按序放到临时数组，直到有一个数组的数据全部放过去了。
        while (first <= mid && first2 <= right) {
            if (arr[first] <= arr[first2]) {
                tempArr[tempArrIndex] = arr[first];
                tempArrIndex++;
                first++;
            } else {
                tempArr[tempArrIndex] = arr[first2];
                tempArrIndex++;
                first2++;
            }

        }

        // 把剩下一个数组中还有的数组也放到临时的数组中
        while (first <= mid) {
            tempArr[tempArrIndex] = arr[first];
            tempArrIndex++;
            first++;
        }
        while (first2 <= right) {
            tempArr[tempArrIndex] = arr[first2];
            tempArrIndex++;
            first2++;
        }

        // 把临时数组的数据复制到原数组中
        // 初始化索引
        tempArrIndex = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = tempArr[tempArrIndex];
            tempArrIndex++;
            tempLeft++;
        }


    }
}
