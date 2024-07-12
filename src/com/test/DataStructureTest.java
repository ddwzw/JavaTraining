package com.test;

import com.test.base.BaseTest;

import java.util.*;

public class DataStructureTest implements BaseTest {

    private static final String TAG = "DataStructureTest";

    @Override
    public void runTest() {
        // array test
        testArray();
        testList();
        testSet();
        testMap();
        testStack();
        testQueue();
        testHeap();
    }

    // Array
    private void testArray() {
        System.out.printf(TAG + ", Test Array Start\n");
        // define
        int[] array = new int[5];
        // Array access and assignment
        array[0] = 1;
        array[1] = 2;
        array[2] = 3;
        array[3] = 4;
        array[4] = 5;
        // Array Iteration and Printing
        for (int i = 0; i < array.length; i++) {
            System.out.printf(TAG + ", array[%d]=%d\n", i, array[i]);
        }
        System.out.printf(TAG + ", Test Array End\n");
    }

    // List
    private void testList() {
        testArrayList();
        testLinkedList();
    }

    private void testArrayList() {
        System.out.printf(TAG + ", Test ArrayList Start\n");
        List<String> arrayList = new ArrayList<>();
        // Add element from the end
        arrayList.add("Hello");
        arrayList.add("World");
        // Add element from index
        arrayList.add(1, "yes");
        arrayList.add(2, "no");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.printf(TAG + ", arrayList[%d]=%s\n", i, arrayList.get(i));
        }
        System.out.printf(TAG + ", Test ArrayList End\n");
    }

    private void testLinkedList() {
        System.out.printf(TAG + ", Test LinkedList Start\n");
        List<String> LinkedList = new LinkedList<>();
        // Add element from the end
        LinkedList.add("Hello");
        LinkedList.add("World");
        // Add element from index
        LinkedList.add(1, "yes");
        LinkedList.add(2, "no");
        for (int i = 0; i < LinkedList.size(); i++) {
            System.out.printf(TAG + ", LinkedList[%d]=%s\n", i, LinkedList.get(i));
        }
        System.out.printf(TAG + ", Test LinkedList End\n");
    }

    // Set
    private void testSet() {
        testHashSet();
        testTreeSet();
    }

    private void testHashSet() {
        System.out.printf(TAG + ", Test HashSet Start\n");
        Set<String> hashSet = new HashSet<>();
        // Add element
        hashSet.add("hello");
        hashSet.add("world");
        hashSet.add("hello");    // This line of code doesn't actually affect the collection because "hello" has already been added.
        // Traversing a HashSet with an Enhanced for Loop
        // Because it's not order, we can access element via index
        int i = 0;
        for (String element : hashSet) {
            System.out.println(TAG + ", hashSet[" + i + "]=" + element);
            i++;
        }
    }

    private void testTreeSet() {
        System.out.printf(TAG + ", Test TreeSet Start\n");
        Set<String> treeSet = new TreeSet<>();
        // Add element
        treeSet.add("hello");
        treeSet.add("world");
        treeSet.add("hello");    // This line of code doesn't actually affect the collection because "hello" has already been added.
        // Traversing a HashSet with an Enhanced for Loop
        // Because it's not order, we can access element via index
        int i = 0;
        for (String element : treeSet) {
            System.out.println(TAG + ", treeSet[" + i + "]=" + element);
            i++;
        }
        System.out.printf(TAG + ", Test TreeSet End\n");
    }

    // Map
    private void testMap() {
        testHashMap();
        testTreeMap();
    }

    private void testHashMap() {
        System.out.printf(TAG + ", Test HashMap Start\n");
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("hello", 1);
        hashMap.put("world", 2);
        hashMap.put("world", 3);
        hashMap.remove("hello");
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println(TAG + ", hashMap[" + entry.getKey() + "]=" + entry.getValue());
        }
        System.out.printf(TAG + ", Test HashMap End\n");
    }

    private void testTreeMap() {
        System.out.printf(TAG + ", Test TreeMap Start\n");
        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("hello", 1);
        treeMap.put("world", 2);
        treeMap.put("world", 3);
        treeMap.remove("hello");
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            System.out.println(TAG + ", treeMap[" + entry.getKey() + "]=" + entry.getValue());
        }
        System.out.printf(TAG + ", Test TreeMap End\n");
    }

    // Stack
    private void testStack() {
        System.out.printf(TAG + ", Test Stack Start\n");
        Stack<Integer> st = new Stack<Integer>();
        System.out.println("stack: " + st);
        stackPush(st, 42);
        stackPush(st, 66);
        stackPush(st, 99);
        stackPop(st);
        stackPop(st);
        stackPop(st);
        try {
            stackPop(st);
        } catch (EmptyStackException e) {
            System.out.println("empty stack");
        }
        System.out.printf(TAG + ", Test Stack End\n");
    }

    private void stackPush(Stack<Integer> st, int a) {
        st.push(new Integer(a));
        System.out.println("push(" + a + ")");
        System.out.println("stack: " + st);
    }

    private void stackPop(Stack<Integer> st) {
        System.out.print("pop -> ");
        Integer a = (Integer) st.pop();
        System.out.println(a);
        System.out.println("stack: " + st);
    }

    // Test Queue
    private void testQueue() {
        System.out.printf(TAG + ", Test Queue Start\n");
        Queue<String> queue = new LinkedList<String>();
        //Add element
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");
        queue.offer("e");
        for(String q : queue){
            System.out.println(q);
        }
        System.out.println("===");
        System.out.println("poll=" + queue.poll()); // Returns the first element and removes it from the queue
        for(String q : queue){
            System.out.println(q);
        }
        System.out.println("===");
        System.out.println("element=" + queue.element()); // Returns the first element
        for(String q : queue){
            System.out.println(q);
        }
        System.out.println("===");
        System.out.println("peek=" + queue.peek()); // Returns the first element
        for(String q : queue){
            System.out.println(q);
        }
    }

    // Heap
    private void testHeap() {
        System.out.printf(TAG + ", Test Heap Start\n");
        PriorityQueue<Integer> numbers = new PriorityQueue<>();
        //使用add()方法
        numbers.add(4);
        numbers.add(2);
        System.out.println("PriorityQueue: " + numbers);

        //使用offer()方法
        numbers.offer(1);
        System.out.println("更新后的PriorityQueue: " + numbers);

        //使用 peek() 方法
        System.out.println("PriorityQueue: " + numbers);
        int number = numbers.peek();
        System.out.println("访问元素: " + number);

        //使用remove()方法
        System.out.println("PriorityQueue: " + numbers);
        boolean result = numbers.remove(2);
        System.out.println("元素2是否已删除? " + result);

        //使用poll()方法
        System.out.println("PriorityQueue: " + numbers);
        number = numbers.poll();
        System.out.println("使用poll()删除的元素: " + number);

        //使用iterator()方法
        System.out.print("使用iterator()遍历PriorityQueue : ");
        Iterator<Integer> iterate = numbers.iterator();
        while(iterate.hasNext()) {
            System.out.print(iterate.next());
            System.out.print(", ");
        }
        System.out.print("\n");
        System.out.printf(TAG + ", Test Heap End\n");
    }
}
