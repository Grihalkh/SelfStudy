package org.stepik.module2;

import java.util.Locale;
import java.util.Scanner;

public class task1 {
    private static Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
    
    public static void task() {
//        boolean a, b, c, d;
//        System.out.println("Введите значения a, b, c и d (boolean) или введите что-то другое");
//
//        a = scanner.nextBoolean();
//        b = scanner.nextBoolean();
//        c = scanner.nextBoolean();
//        d = scanner.nextBoolean();
//        System.out.print("Только две переменные равны true =>  ");
//        System.out.println(booleanExpression(a, b, c, d));

//        System.out.println("Пример переполнения:");
//        byte x = 127;
//        System.out.println(x);
//        x++;
//        System.out.println(x);
//
//        System.out.println("Введите год, а я посчитаю кол-во високосных годов");
//        System.out.println(leapYearCount(scanner.nextInt()));
//
//        System.out.println("Тестим Юникод: тут должна быть омега => " + '\u03A9');
//
//        System.out.println("Тестим + бесконечноть (o_O) 1.0/0.0 = " + 1.0/0.0);
//        System.out.println("Тестим - бесконечноть (o_O) -1.0/0.0 = " + -1.0/0.0);
//        System.out.println("Есть еще и nan = 0.0 * inf = " + 0.0 * (1.0/0.0));
//        System.out.println("Тестим, что сложение float\'ов рано или поздно не дает то, что нужно");
//        System.out.print("Сумма 10ти 0.1 = ");
//        System.out.println(0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1);
//
//        System.out.println("Сравним float\'ы на равенство");
//        System.out.println("Введите a, b и c - float");
//        float a = scanner.nextFloat();
//        float b = scanner.nextFloat();
//        float c = scanner.nextFloat();
//        System.out.println("Ответ = " + doubleExpression(a, b, c));
//
//        System.out.println("Флипнем-ка битик! Введите значение - int, потом индекс - int");
//        int d = scanner.nextInt();
//        int i = scanner.nextInt();
//        System.out.println(flipBit(d, i));
    
        System.out.println("Введите число");
        int x = scanner.nextInt();
        System.out.println("Это число явл-ся степенью двойки = " + isPowerOfTwo(x));
        
    }
    
    public static boolean booleanExpression(boolean a, boolean b, boolean c, boolean d) {
        return !a&&!b&&c&&d ||
                !a&&b&&!c&&d ||
                !a&&b&&c&&!d ||
                a&&!b&&!c&&d ||
                a&&!b&&c&&!d ||
                a&&b&&!c&&!d;
    }
    
    public static int leapYearCount(int year) {
        int count = year / 4 - year / 100 + year / 400;
        return count;
    }
    
    public static boolean doubleExpression(double a, double b, double c) {
        float epsilon = 1e-4f;
        return Math.abs(a + b - c) < epsilon;
    }
    
    /**
     * Flips one bit of the given <code>value</code>.
     *
     * @param value     any number
     * @param bitIndex  index of the bit to flip, 1 <= bitIndex <= 32
     * @return new value with one bit flipped
     */
    public static int flipBit(int value, int bitIndex) {
        int newbitpos = 1 << --bitIndex; // --bitIndex т.к. индекс от 1 до 32 (а не от 0 до 31)
        return newbitpos ^ value;
    }
    
    /**
     * Checks if given <code>value</code> is a power of two.
     *
     * @param value any number
     * @return <code>true</code> when <code>value</code> is power of two, <code>false</code> otherwise
     */
    public static boolean isPowerOfTwo(int value) {
        // 000001000000
        // 100000000000 - неверно
        if (java.lang.Integer.bitCount(Math.abs(value)) == 1)
            return true;
        return false;
    }
    
}