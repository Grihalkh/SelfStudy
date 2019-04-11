package org.stepik.module4;

public class task1{
    
    public static void task() {
        B b = new B();
//        A a = (A) b;
        double x = 5;
        System.out.println(sqrt(x));
        x = -5;
        System.out.println(sqrt(x));
    }
    
    public static double sqrt(double x) throws java.lang.IllegalArgumentException {
        if (x < 0)
            throw new java.lang.IllegalArgumentException("Expected non-negative number, got " + x);
        return Math.sqrt(x);
    }
}

class A extends B {
    public int x;
}

class B {
    public int c;
}