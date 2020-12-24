package com.datastructure.search;

import com.sun.org.apache.bcel.internal.util.BCELifier;

import java.util.Arrays;

/**
 * @author Hacah
 * @date 2020/12/22 21:43
 */
public class FibonacciSearch {

    public static void main(String[] args) {

        int[] arr = {1, 8, 10, 89, 1000, 1234};

        int i = fibnaSearch(arr, 8);
        System.out.println(i);


    }

    /**
     * 斐波那契数列
     * @return
     */
    public static int[] fibna() {
        int[] ints = new int[20];
        ints[0] = 1;
        ints[1] = 1;
        for (int j = 2; j < ints.length; j++) {
            ints[j] = ints[j-1] + ints[j-2];
        }
        return ints;
    }


    /**
     * 斐波那契查找
     */
    public static int fibnaSearch(int[] arr, int findVal) {
        int left = 0;
        int right = arr.length - 1;
        // 记录是第几可斐波那契数列
        int k = 0;
        // 记录中间值
        int mid = 0;
        // 斐波那契数列
        int[] f = fibna();
        // 把f[k] - 1（f[k] - 1中的减1是因为索引从0开始）这个数增加到比数组最大索引长或一样。
        while (right > f[k] - 1) {
            k++;
        }

        // 把数组复制而且增加到f[k]的长度
        int[] copy = Arrays.copyOf(arr, f[k]);

        // 把新的数组填满，为0的都填上旧数组的最后一个数
        for (int i = right + 1; i < copy.length; i++) {
            copy[i] = arr[right];
        }

        while (left <= right) {
            if (k - 1 < 0) {
                break;
            }
            mid = left + f[k - 1] - 1;
            if (findVal < copy[mid]) {
                right = mid - 1;
                k--;
            }else if(findVal > copy[mid]) {
                left = mid + 1;
                k-=2;
            }else {
                if (mid <= right) {
                    return mid;
                }else {
                    return right;
                }
            }

        }

        return -1;




    }
}
