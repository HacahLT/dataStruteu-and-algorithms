package com.datastructure.tree.heap;


import java.util.Arrays;


/**
 * @author Hacah
 * @date 2021/1/18 21:43
 */
public class HeapSortDemo {
    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9};
        heapSort(arr);
    }


    /**
     * 堆排序方法
     *
     * @param arr
     *
     * **大顶堆：arr[i] >= arr[2i+1] && arr[i] >= arr[2i+2]
     * **小顶堆：arr[i] <= arr[2i+1] && arr[i] <= arr[2i+2]
     *
     *
     */
    public static void heapSort(int[] arr) {
        // 最小的非叶子节点下标
        int index = arr.length/2 -1;
        // 1.将无需序列构建成一个堆，根据升序降序需求选择构建大顶堆。
        // 构建大顶堆
        for (int i = index;i >= 0;i--) {
            adjustHeap(arr, i, arr.length);
        }


        // 2.将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端;
        for (int i = arr.length - 1;i > 0;i--) {
            // 堆顶元素与末尾元素交换
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            // 重新调整结构，使其满足堆定义，由于前面已经构建过完整的大顶堆，所以只需调用一次adjustHeap方法
            adjustHeap(arr, 0, i);
        }

        System.out.println(Arrays.toString(arr));

    }


    /**
     * 将树调整大顶堆
     * 如果子树是大顶堆不用管
     * 如果子树不是大顶堆就构成大顶堆且循环往子节点的树调整大顶堆
     * （2 * i + 1） 是i下标的节点的左节点
     *
     * @param arr    准备调整的堆
     * @param i      非叶子节点在树中的索引
     * @param length 对多少个元素继续调整（这颗树拥有的节点）
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];

        // 进行大顶堆的调整，循环找到该节点的左节点
        for (int k = (2 * i + 1); k < length; k = (2 * k + 1)) {
            // 判断右节点是否大于左节点
            if (k+1 < length && arr[k] < arr[k+1]) {
                // 大于
                // 下标改为右节点
                k++;
            }

            // 判断该节点大还是子节点大
            // 子节点大
            if (arr[k] > arr[i]) {
                // 交换该节点与子节点的数据
                arr[i] = arr[k];
                arr[k] = temp;
                // 让子节点成为开始节点，继续向下调整大顶堆
                i = k;
            }else {
                break;
            }


        }
    }
}
