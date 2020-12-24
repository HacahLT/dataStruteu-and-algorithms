package com.datastructure.search;

/**
 * @author Hacah
 * @date 2020/12/19 23:51
 */
public class InsertValueSearch {

    public static void main(String[] args) {
        //创建一个数组{1, 2, 3, 4, 5, 6,..., 100}
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i+1;
        }
        // 要查找的值
        int findValue = 97;
        int loc = insertValueSearch(array, 0, array.length - 1, findValue);
        System.out.println(loc);

    }

    public static int insertValueSearch(int[] arr, int left, int right , int findValue) {

        // 不符合逻辑就退出
        if (left > right || findValue < arr[left] || findValue > arr[right]) {
            return -1;
        }

        // 获得插值
        int mid = left + (right - left) * (findValue - arr[left]) / (arr[right] - arr[left]);

        // findValue比插值还小，向左边走
        if (findValue < arr[mid]) {
            return insertValueSearch(arr, left, mid - 1, findValue);
        }else if (findValue > arr[mid]) {
            // findValue比插值大，向右边走
            return insertValueSearch(arr, mid + 1, right, findValue);
        }else {
            // 返回找到的值位置
            return mid;
        }

    }


}
