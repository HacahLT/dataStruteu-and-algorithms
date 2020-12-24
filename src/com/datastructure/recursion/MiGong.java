package com.datastructure.recursion;

/**
 * @author Hacah
 * @date 2020/9/23 11:56
 */
public class MiGong {

    public static void main(String[] args) {

        // 创建一个二维数组，模拟迷宫
        int[][] map = new int[8][7];
        // 使用1表示墙

        // 四边置为墙

        // 上下两边设为墙
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        // 设置中间板
        map[3][1] = 1;
        map[3][2] = 1;
        // 左右两边设为墙
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        showMap(map);
        System.out.println("");



        setWay(map,1,1);
        showMap(map);


    }

    /**
     * 递归找路的方法实现
     * i,j表示开始的位置,map[5][6]表示终点
     * 当map[i][j]为0表示改点没有走过，当1为墙；2是通路，3是已经走过走不通
     * 策略：下 -> 右-> 上->左 不通就回溯
     *
     * @param map 表示地图
     * @param i   位置
     * @param j   位置
     * @return 找到返回true
     */
    public static boolean setWay(int[][] map, int i, int j) {
        // 到达终点
        if (map[6][5] == 2) {
            return true;
        } else {
            // 没有走过
            if (map[i][j] == 0) {
                // 标记为通路
                map[i][j] = 2;
                // 向下走
                if (setWay(map, i + 1, j)) {
                    return true;
                } else if (setWay(map, i, j + 1)) {
                    return true;
                } else if (setWay(map, i - 1, j)) {
                    return true;
                } else if (setWay(map, j, i - 1)) {
                    return true;
                }else {
                    // 该点走不通
                    map[i][j] = 3;
                    return false;
                }
            }else { // 如果是1， 2， 3 直接返回false
                return false;
            }
        }

    }


    public static void showMap(int map[][]) {
        // 输出地图
        System.out.println("地图");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }


}
