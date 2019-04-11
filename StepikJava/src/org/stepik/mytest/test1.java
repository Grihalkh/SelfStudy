package org.stepik.mytest;

import java.util.Arrays;
import java.util.Scanner;

public class test1 {
    
    private static Scanner scanner = new Scanner(System.in);
    
    public static void test() {
        System.out.println("Проверка на передачу в функции переменных по ссылке");
        
        System.out.println("Введите число");
        int x;
        x = scanner.nextInt();
        checkInt(x);
        System.out.println("Число + 1 = " + x);
    
        System.out.println("Введите строку");
        String s;
        s = scanner.nextLine();
        System.out.println("Сейчас строка поменяется на hi (а может и нет)");
        checkString(s);
        System.out.println(s);
    
        System.out.println("Введите массив из 3 эл-ов");
        int[] a = new int[3];
        for (int i=0; i < 3; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println("Сейчас первый эл-т поменяется на 1");
        checkArray(a);
        System.out.println(Arrays.toString(a));
    
        System.out.println("Попробуем не String, а свой класс. Изначально поле = false, должно стать true");
        A aa = new A();
        checkA(aa);
        System.out.println("" + aa.getX());
    
    }
    
    private static void checkInt(int x) {
        x = x + 1;
    }
    
    private static void checkString(String s) {
        s = "hi";
    }
    
    private static void checkArray(int[] a) {
        a[0] = 1;
    }
    
    private static class A {
        public boolean getX() {
            return x;
        }
    
        public void setX(boolean x) {
            this.x = x;
        }
    
        private boolean x;
        
        public A() {
            this.x = false;
        }
    }
    
    private static void checkA(A a) {
        a.setX(true);
    }
}
