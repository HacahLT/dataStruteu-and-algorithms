package com.datastructure.sparseAray;

import java.util.Collection;
import java.util.LinkedList;

/**
 * @author Hacah
 */
public class SparseArray {

    public static void main(String[] args) {
        //创建一个原始的二维数组 11 * 11
        //0表示没有棋子，1表示黑子，2表示白子
        int chessArr[][] = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        chessArr[3][6] = 1;

        //输出数组原始二维数组
        printArrays(chessArr);

//        int[][] sparseArr = originToSparse(chessArr);
        // 对比第一次实现，以空间换时间，减少了一次双循环
        int[][] sparseArr = originToSparse2(chessArr);
        sparseToOrigin(sparseArr);


    }

    /**
     * 稀疏数组转换为原始数组
     *
     * @param sparseArr
     * @return
     */
    public static int[][] sparseToOrigin(int[][] sparseArr) {
        //1.先读取第一行得到数组结构,创建恢复原始数组
        int[][] chessArr = new int[sparseArr[0][0]][sparseArr[0][1]];
        //2.遍历稀疏数组，从第二行开始,得到元素数据，存放到恢复原始数组
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        //3.输出恢复数组
        System.out.println("恢复后的数组：");
        printArrays(chessArr);
        return null;
    }

    /**
     * 原始数组转换为稀疏数组
     *
     * @param chessArr
     * @return int[][]
     */
    public static int[][] originToSparse(int[][] chessArr) {
        //原始数组的行
        int r = chessArr.length;
        //原始数组的列
        int c = chessArr[0].length;

        //1.将二维数组转为稀疏数组
        //2遍历二位数组得到非0元素个数
        int sum = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (chessArr[i][j] != 0) {
                    sum++;
                }
            }
        }

        //2.2创建稀疏数组
        int sparseArr[][] = new int[sum + 1][3];
        sparseArr[0][0] = r;
        sparseArr[0][1] = c;
        sparseArr[0][2] = sum;

        //3遍历二位数组。得到非零数的索引
        //记录第几个非零数据
        int count = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (chessArr[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr[i][j];
                }
            }
        }

        //4输出稀疏数组
        System.out.println();
        System.out.println("得到的稀疏数组为：");
        printArrays(sparseArr);
        System.out.println();

        return sparseArr;

    }

    /**
     *
     * 重写优化稀疏数组的实现
     * @author hacah
     * @date 2021/12/16 20:38
     * @return java.lang.String[][]
     */
    public static int[][] originToSparse2(int[][] originArr) {

        // 行数
        int lengthR = originArr.length;
        // 列数
        int lengthC = originArr[0].length;
        int sepNumCount = 0;
        LinkedList<int[]> sparseList = new LinkedList<>();
        for (int i = 0; i < originArr.length; i++) {
            for (int j = 0; j < originArr[i].length; j++) {
                // i为行，j为列
                // 有特殊值
                int val = originArr[i][j];
                if (val != 0) {
                    int[] valArray = {i, j, val};
                    sparseList.add(valArray);
                    sepNumCount++;
                }
            }
        }
        sparseList.addFirst(new int[]{lengthR,lengthC,sepNumCount});
        int[][] ints = new int[sepNumCount + 1][3];
        sparseList.toArray(ints);
        System.out.println();
        System.out.println("得到的稀疏数组为：");
        printArrays(ints);
        System.out.println();
        return ints;
    }

    /**
     * 打印二维数组
     */
    public static void printArrays(int[][] array) {
        for (int[] row : array) {
            for (int col : row) {
                System.out.printf("%d\t", col);
            }
            System.out.println();
        }
    }


}
