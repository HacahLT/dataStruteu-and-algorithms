package com.datastructure.search;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Hacah
 * @date 2020/11/12 22:57
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {11, 45, 5, 5, 945, 248, 52, 93, 945};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
//        int a = binarySearch(0, arr.length - 1, arr, 52);
//        System.out.println(a);
        ArrayList arrayList = binarySearchs(0, arr.length - 1, arr, 945);
        System.out.println(arrayList);

    }


    /**
     * 二分查找法
     *
     * @param left  左指针
     * @param right 右指针
     * @param arr   数组
     * @param value 查找的值
     */
    public static int binarySearch(int left, int right, int[] arr, int value) {
        int midIndex = (left + right) / 2;
        int midValue = arr[midIndex];

        if (left <= right) {
            if (value < midValue) {
                return binarySearch(left, midIndex - 1, arr, value);
            } else if (value > midValue) {
                return binarySearch(midIndex + 1, right, arr, value);
            } else if (value == midValue) {
                return midIndex;
            }
        }

        return -1;
    }


    /**
     * 查询多个结果
     * @param left
     * @param right
     * @param arr
     * @param value
     * @return
     */
    public static ArrayList binarySearchs(int left, int right, int[] arr, int value) {
        int midIndex = (left + right) / 2;
        int midValue = arr[midIndex];

        if (left <= right) {
            if (value < midValue) {
                return binarySearchs(left, midIndex - 1, arr, value);
            } else if (value > midValue) {
                return binarySearchs(midIndex + 1, right, arr, value);
            } else if (value == midValue) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(midIndex);
                // midValue的左边
                int temp = midIndex - 1;
                while (temp >= 0 && value == arr[temp]) {
                    list.add(temp);
                    temp--;
                }
                // midValue的右边
                int tempR = midIndex + 1;
                while (tempR <= right && value == arr[tempR]) {
                    list.add(tempR);
                    tempR++;
                }
                return list;
            }
        }

        return null;
    }
}
