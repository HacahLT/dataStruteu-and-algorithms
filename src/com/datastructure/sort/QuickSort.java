package com.datastructure.sort;

import java.util.Arrays;

/**
 * @author Hacah
 * @date 2020/10/15 19:57
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {10,7,2,4,7,62,3,4,2,1,8,9,19};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr,int leftIndex,int rightIndex) {
        if (leftIndex > rightIndex) {
            return;
        }
        // 左边的索引
        int l = leftIndex;
        // 右边的索引
        int r = rightIndex;
        // 设定基数
        int pivot = arr[leftIndex];
        while (l < r) {
            // 右边的索引先移动确保当l=r时arr[r]或者arr[l]是等于或小于pivot的。
            // 为什么要保证这样？在代码里寻找。
            while (pivot<=arr[r] && l < r) {
                r--;
            }
            while (pivot>=arr[l] && l < r) {
                l++;
            }
            if (l < r) {
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
        }
        arr[leftIndex] = arr[l];
        arr[l] = pivot;
        quickSort(arr,leftIndex,r-1);
        quickSort(arr,r+1,rightIndex);
    }
}
