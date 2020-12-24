package com.datastructure.recursion;

/**
 * @author Hacah
 * @date 2020/9/26 13:11
 */
public class QueueEight {

    /**定义最大的皇后数量*/
    private int max = 8;
    /**
     * 创建数组，存放皇后放置位置
     * 用 下标作为行，内容作为列
     */
    private int[] array = new int[max];

    private static int num;
    public static void main(String[] args) {
        // 测试方法，有几种放置方法
        QueueEight queueEight = new QueueEight();
        queueEight.checkAndDo(0);
        System.out.println("一共有"+num+"种方法");
    }

    /**
     * 放置棋子，检查位置是否能够存放棋子
     */
    private void checkAndDo(int n) {
        // n:0-7代表8行 n=max代表放完8个棋子了
        if (n == max){
            print();
            return;
        }

        // 放入皇后，判断是否冲突
        // 循环列，放入棋子
        for (int i = 0; i < 8 ;i++) {
            // 先放到第一列
            array[n] = i;
            if (judge(n)){
                // 没发生冲突,继续放置下一行
                checkAndDo(n+1);
            }
        }
    }


    /**
     * 检测放置皇后棋子与前面放置的棋子是否出现冲突
     * @param n 表示第n个皇后
     * @return 是否冲突 ，true表示没有，false表示有
     */
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            // 当array[i] = array[n] 表示第n个皇后与n-1个皇后在同一列
            // Math.abs(n-i) == Math.abs(array[n]-array[i]) 判断是否在同一斜线
            if (array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n]-array[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 打印数组
     */
    private void print() {
        num+=1;
        for (int i = 0; i < max; i++) {
            System.out.print(array[i]);
        }
        System.out.println();
    }

}
