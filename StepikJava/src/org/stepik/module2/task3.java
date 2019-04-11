package org.stepik.module2;

import java.util.Scanner;

public class task3{
    private static Scanner scanner = new Scanner(System.in);
    
    public static void task(){
//        System.out.println("Тестим странные преобразования");
//        System.out.println("A" + ('\t' + '\u0003'));
//        System.out.println('A' + "12");
//        System.out.println("A" + 12);
//        System.out.println('A' + '1' + "2");
//
//        int[] x = new int[0];
//        int[] y = null;
//        int[] c = null;
//        System.out.println(x);
//        System.out.println(y);
        System.out.println("Введите строку для проверки на палиндром");
        String s = scanner.nextLine();
        System.out.println("Ответ       = " + isPalindrome(s));
        System.out.println("Ответ (o_O) = " + isPalindromeWUT(s));
    
    }
    
    /**
     * Checks if given <code>text</code> is a palindrome.
     *
     * @param text any string
     * @return <code>true</code> when <code>text</code> is a palindrome, <code>false</code> otherwise
     */
    public static boolean isPalindrome(String text) {
        String init = text.toLowerCase();
        init = init.replaceAll("[^a-zA-z0-9]", "");
        StringBuilder rev = new StringBuilder(init);
        if(rev.reverse().toString().equals(init))
            return true;
        return false;
    }
    
    public static boolean isPalindromeWUT(String text) {
        String init = text.toLowerCase();
        //init = init.replaceAll("[^a-zA-z0-9]", "");
        StringBuilder rev = new StringBuilder(init);
        System.out.println(init);
        System.out.println(rev.reverse().toString());
        if(rev.reverse().toString().equals(init))
            return true;
        return false;
    }
}
