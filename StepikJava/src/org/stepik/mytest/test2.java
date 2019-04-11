package org.stepik.mytest;

public class test2{
    
    public static void test() {
        try {
            MemoryOverflowTest x = new MemoryOverflowTest();
            System.out.println(x.toString());
        } catch (Error e) {
            e.printStackTrace();
            System.out.println("\nКороче, поймал следующее исключение = " + e.toString());
        }
    }
}
