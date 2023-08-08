package com.youfeng.bolg;

import org.springframework.util.StopWatch;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author -侑枫
 * @date 2023/8/2 21:14:06
 */
public class Contain {
    static StopWatch stopWatch = new StopWatch();

    public static void main(String[] args) {
        List<String> testData = generateData();
        deduplicateDataBySort(testData);
        deduplicateDataByContain(testData);
        deduplicateDataByHashSet(testData);
        deduplicateDataByStream(testData);
        deduplicateDataByToSet(testData);
    }

    public static List<String> generateData() {
        List<String> testData = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 50000; i++) {
            testData.add("UniqueData" + i);
        }

        for (int i = 0; i < 50000; i++) {
            int randomIndex = random.nextInt(50000);
            testData.add(testData.get(randomIndex));
        }
        return testData;
    }

    public static void deduplicateDataByContain(List<String> testDate) {
        stopWatch.start();
        System.out.println("Contain去重之前条数：" + testDate.size());
        List<String> result = new ArrayList<>();
        for (String s : testDate) {
            if (!result.contains(s)) {
                result.add(s);
            }
        }
        System.out.println("Contain去重之前条数：" + result.size());
        stopWatch.stop();
        System.out.println("Contain去重耗时：" + stopWatch.getTotalTimeMillis());
    }

    public static void deduplicateDataByHashSet(List<String> testDate) {
        stopWatch.start();
        System.out.println("HashSet去重之前条数：" + testDate.size());
        List<String> result = new ArrayList<>(new HashSet<>(testDate));
        System.out.println("HashSet去重之前条数：" + result.size());
        stopWatch.stop();
        System.out.println("HashSet去重耗时：" + stopWatch.getTotalTimeMillis());
    }

    public static void deduplicateDataByStream(List<String> testDate) {
        stopWatch.start();
        System.out.println("Stream去重之前条数：" + testDate.size());
        List<String> result = testDate.stream().distinct().collect(Collectors.toList());
        System.out.println("Stream去重之前条数：" + result.size());
        stopWatch.stop();
        System.out.println("Stream去重耗时：" + stopWatch.getTotalTimeMillis());
    }

    public static void deduplicateDataByToSet(List<String> testDate) {
        stopWatch.start();
        System.out.println("ToSet去重之前条数：" + testDate.size());
        Set<String> uniqueData = testDate.stream().collect(Collectors.toSet());
        // 转换回List，去除重复的数据
        List<String> result = new ArrayList<>(uniqueData);
        System.out.println("ToSet去重之前条数：" + result.size());
        stopWatch.stop();
        System.out.println("ToSet去重耗时：" + stopWatch.getTotalTimeMillis());
    }

    public static void deduplicateDataBySort(List<String> testDate) {
        stopWatch.start();
        System.out.println("Sort去重之前条数：" + testDate.size());
        // 对数据进行排序（前提是数据已经有序）
        testDate.sort(String::compareTo);

        List<String> result = new ArrayList<>();
        int dataSize = testDate.size();
        int index = 0;

        while (index < dataSize) {
            String current = testDate.get(index);
            result.add(current);

            // 跳过相邻的重复元素
            while (index < dataSize && testDate.get(index).equals(current)) {
                index++;
            }
        }
        System.out.println("Sort去重之前条数：" + result.size());
        stopWatch.stop();
        System.out.println("Sort去重耗时：" + stopWatch.getTotalTimeMillis());
    }


}
