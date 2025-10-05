package com.idn;

import com.idn.map.MyMap;
import com.idn.map.MyMapByArrayList;
import com.idn.map.MyMapByHashMap;
import com.idn.map.MyMapByLinkedList;
import com.idn.util.Person;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        // 1. 创建MyMap1实例
        MyMap personMap = new MyMapByHashMap(); // 需要替换为你的实现类

        // 2. 准备测试数据
        Person alice = new Person(25, "Alice", 1, "Female");
        Person bob = new Person(30, "Bob", 2, "Male");

        // 3. 测试put和get
        personMap.put(alice,1);
        personMap.put(bob,2);
        assert personMap.get(1).equals(alice) : "测试1失败：获取Alice失败";
        assert personMap.get(2).equals(bob) : "测试2失败：获取Bob失败";

        // 4. 测试delete
        personMap.delete(2);
        assert personMap.get(1) == null : "测试3失败：删除Alice失败";
        assert personMap.get(2) != null : "测试4失败：误删Bob";
        // 5. 测试覆盖写入
        Person newAlice = new Person(26, "Alice", 1, "Donotkwon");
        personMap.put(newAlice, 1);
        assert personMap.get(1).equals(newAlice) : "测试5失败：覆盖写入失败";

        System.out.println("所有assert测试通过！");

        testImplementation(personMap, personMap.getClass().getName());
    }

    private static final int TEST_SIZE = 10_000; // 测试数据量
    private static final int WARMUP = 100;

    // JVM预热次数
    private static void testImplementation(MyMap map, String implName) {
        System.out.println("\n=== 测试 " + implName + " ===");

        // JVM预热
        IntStream.range(0, WARMUP).forEach(i -> {
            map.put(new Person(0, "Warm", i, "X"),i);
            map.get(i);
            map.delete(i);
        });

        // 生成测试数据
        Person[] testData = new Person[TEST_SIZE];
        IntStream.range(0, TEST_SIZE).forEach(i ->
                testData[i] = new Person( i, "Person_" + i,i ,"")
        );

        // 1. 测试put性能
        long putStart = System.nanoTime();
        for (Person p : testData) {
            map.put(p, p.getId());
        }
        double putTime = (System.nanoTime() - putStart) / 1e6;
        System.out.printf("PUT %d次: %.2f ms (平均%.3f μs/次)\n",
                TEST_SIZE, putTime, putTime * 1000 / TEST_SIZE);

        // 2. 测试get性能
        long getStart = System.nanoTime();
        for (int i = 0; i < TEST_SIZE; i++) {
            map.get(i);
        }
        double getTime = (System.nanoTime() - getStart) / 1e6;
        System.out.printf("GET %d次: %.2f ms (平均%.3f μs/次)\n",
                TEST_SIZE, getTime, getTime * 1000 / TEST_SIZE);

        // 3. 测试delete性能
        long deleteStart = System.nanoTime();
        for (int i = 0; i < TEST_SIZE; i++) {
            map.delete(i);
        }
        double deleteTime = (System.nanoTime() - deleteStart) / 1e6;
        System.out.printf("DELETE %d次: %.2f ms (平均%.3f μs/次)\n",
                TEST_SIZE, deleteTime, deleteTime * 1000 / TEST_SIZE);

        // 4. 正确性验证
        map.put(testData[0], 1);
        assert map.get(1) == testData[0] : "正确性验证失败";
        map.delete(1);
        assert map.get(1) == null : "正确性验证失败";
    }
    }
