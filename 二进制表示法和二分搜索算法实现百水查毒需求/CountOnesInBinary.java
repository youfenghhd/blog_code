package com.youfeng.blog;

/**
 * @author -侑枫
 * @date 2023/8/19 22:35:19
 */
public class CountOnesInBinary {
    public static int countOnes(int num) {
        // 用于存储二进制中 1 的个数
        int count = 0;
        while (num > 0) {
            // 通过与运算检查二进制的最低位是否为 1
            if ((num & 1) == 1) {
                count++;
            }
            // 将整数右移一位，相当于将二进制位向右移动一位
            num >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        // 总共的二进制中 1 的个数
        int totalOnes = 0;
        for (int i = 1; i <= 100; i++) {
            totalOnes += countOnes(i);
        }
        System.out.println("从 1 到 100 的二进制中总共有 " + totalOnes + " 个 1。");
    }

//    public static void main(String[] args) {
//        int initialValue = 100;
//        int result = 0;
//
//        while (initialValue > 2) {
//            result += initialValue;
//            initialValue /= 2;
//        }
//
//        result += 2;
//
//        System.out.println("总共需要倒出：" + result+" 滴水");
//    }


}

