package com.test;

import com.test.base.BaseTest;

import java.util.ArrayList;
import java.util.List;

public class GenericsTest implements BaseTest {
    @Override
    public void runTest() {
        testPrint();
        testMax();
        testGenericsClass();
        testGetData();
        testGetNumber();
    }

    private void testPrint() {
        // 创建不同类型数组： Integer, Double 和 Character
        Integer[] intArray = { 1, 2, 3, 4, 5 };
        Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
        Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };

        System.out.println( "整型数组元素为:" );
        printArray(intArray); // 传递一个整型数组

        System.out.println( "\n双精度型数组元素为:" );
        printArray(doubleArray); // 传递一个双精度型数组

        System.out.println( "\n字符型数组元素为:" );
        printArray(charArray); // 传递一个字符型数组

    }

    private static <E> void printArray(E[] inputArray) {
        for (E element : inputArray) {
            System.out.println(element);
        }
        System.out.println();
    }

    private void testMax() {
        System.out.printf( "%d, %d 和 %d 中最大的数为 %d\n\n",
                3, 4, 5, maximum( 3, 4, 5 ) );

        System.out.printf( "%.1f, %.1f 和 %.1f 中最大的数为 %.1f\n\n",
                6.6, 8.8, 7.7, maximum( 6.6, 8.8, 7.7 ) );

        System.out.printf( "%s, %s 和 %s 中最大的数为 %s\n","pear",
                "apple", "orange", maximum( "pear", "apple", "orange" ) );
    }

    private static <T extends Comparable<T>> T maximum(T x, T y, T z) {
        T max = x;
        if (y.compareTo(max) > 0) {
            max = y;
        }
        if (z.compareTo(max) > 0) {
            max = z;
        }
        return max;
    }

    private void testGenericsClass() {
        Box<Integer> integerBox = new Box<Integer>();
        Box<String> stringBox = new Box<String>();

        integerBox.add(new Integer(10));
        stringBox.add(new String("菜鸟教程"));

        System.out.printf("整型值为 :%d\n\n", integerBox.get());
        System.out.printf("字符串为 :%s\n", stringBox.get());
    }

    public class Box<T> {
        private T t;

        public void add(T t) {
            this.t = t;
        }

        public T get() {
            return this.t;
        }
    }

    private void testGetData() {
        List<String> name = new ArrayList<String>();
        List<Integer> age = new ArrayList<Integer>();
        List<Number> number = new ArrayList<Number>();

        name.add("icon");
        age.add(18);
        number.add(314);

        getData(name);
        getData(age);
        getData(number);
    }

    private static void getData(List<?> data) {
        System.out.println("data :" + data.get(0));
    }

    private void testGetNumber() {
        List<String> name = new ArrayList<String>();
        List<Integer> age = new ArrayList<Integer>();
        List<Number> number = new ArrayList<Number>();
        List<Object> objects = new ArrayList<Object>();

        name.add("icon");
        age.add(18);
        number.add(314);
        objects.add(3394);

        // getNumber(name);  // 提示报错. 类型不匹配
        // getNumber(age);   // 提示报错. 类型不匹配
        getNumber(number);
        getNumber(objects);
    }

    private static void getNumber(List<? super Number> data) {
        System.out.println("data :" + data.get(0));
    }
}


