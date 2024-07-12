package com.test.base;

import java.io.*;

public class SerializeTest implements BaseTest {

    private static final String TAG = "SerializeTest";

    @Override
    public void runTest() {
        testSerialize();
        testDeserialize();
    }

    private void testSerialize() {
        System.out.printf("%s, Test Serialize Start\n", TAG);
        MyClass obj = new MyClass("test");
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream("./object.ser"));
            out.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.printf("%s, Test Serialize End\n", TAG);
    }

    private void testDeserialize() {
        System.out.printf("%s, Test Deserialize Start\n", TAG);
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream("./object.ser"));
            MyClass obj = (MyClass) in.readObject();
            System.out.printf("%s, Test Deserialize my name is:%s\n", TAG, obj.getMyName());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.printf("%s, Test Deserialize End\n", TAG);
    }

    public static class MyClass implements Serializable { // Make MyClass static
        private String myName;

        public MyClass(String name) {
            this.myName = name;
        }

        public String getMyName() {
            return myName;
        }
    }
}