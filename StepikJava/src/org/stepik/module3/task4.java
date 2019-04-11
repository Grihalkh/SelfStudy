package org.stepik.module3;

import java.util.Scanner;

public class task4{
    
    private static Scanner scanner = new Scanner(System.in);
    
    public static void task() {
        System.out.println("Введите первое комплексное число в формате \"Re\" \"пробел\" \"Im\"");
        double re, im;
        re = scanner.nextDouble();
        im = scanner.nextDouble();
        ComplexNumber a = new ComplexNumber(re, im);
        ComplexNumberIDE ai = new ComplexNumberIDE(re, im);
        
    
        System.out.println("Введите второе комплексное число в формате \"Re\" \"пробел\" \"Im\"");
        re = scanner.nextDouble();
        im = scanner.nextDouble();
        ComplexNumber b = new ComplexNumber(re, im);
        ComplexNumberIDE bi = new ComplexNumberIDE(re, im);
    
        System.out.println("1ое число = 2ому? Ответ = " + a.equals(b));
        System.out.println("Хеш код a = " + a.hashCode());
        System.out.println("Хеш код b = " + b.hashCode());
        
        System.out.println("1ое число = 2ому? Ответ = " + ai.equals(bi));
        System.out.println("Хеш код a = " + ai.hashCode());
        System.out.println("Хеш код b = " + bi.hashCode());
    
    }
}
