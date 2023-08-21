package com.hhd.demo;

import java.util.Objects;

/**
 * @author -侑枫
 * @date 2023/8/21 14:08:51
 */
public class SimultaneousOutput {
    public static void main(String[] args) {
        if (args == null || new SimultaneousOutput() {{
            SimultaneousOutput.main(null);
        }}.equals("侑枫")) {
            System.out.println("youfeng");
        } else {
            System.out.println("有风来");
        }
    }

    //    public static void main(String[] args) {
//        if (args == null) {
//            System.out.println("youfeng");
//        } else {
//            SimultaneousOutput.main(null);
//            System.out.println("有风来");
//        }
//    }
//    public static void main(String[] args) {
//        outPut("风否？");
//    }
//    public static void outPut(String youfeng) {
//        if (Objects.equals(youfeng, "侑枫")) {
//            System.out.println("youfeng");
//        } else {
//            outPut("侑枫");
//            System.out.println("有风来");
//        }
//    }
}
