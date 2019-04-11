package org.stepik.module2;

import java.util.Arrays;
import java.util.Scanner;
import java.math.BigInteger;

public class task4{
    private static Scanner scanner = new Scanner(System.in);
    
    public static int[] getArray(Scanner scanner) {
        int[] x = new int[scanner.nextInt()];
        for (int i = 0; i < x.length; i++)
            x[i] = scanner.nextInt();
        return x;
    }
    
    public static void task(){
//        System.out.println("Введите число, я выдам факториал");
//        int x = scanner.nextInt();
//        System.out.println(factorial(x));
    
//        System.out.println("Введите первый массив");
//        int[] a = getArray(scanner);
//        System.out.println("Введите второй массив");
//        int[] b = getArray(scanner);
//        System.out.println("Смерженный массив");
//        System.out.println(Arrays.toString(mergeArrays(a, b)));
        
        String[] roles = {
                "Городничий",
                "Аммос Федорович",
                "Артемий Филиппович",
                "Лука Лукич",
                "Кто-то, кто молчал"
        };
        
        String[] textLines = {
                "Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
                "Аммос Федорович: Как ревизор?",
                "Артемий Филиппович: Как ревизор?",
                "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
                "Аммос Федорович: Вот те на!",
                "Артемий Филиппович: Вот не было заботы, так подай!",
                "Лука Лукич: Господи боже! еще и с секретным предписаньем!"
        };
    
        System.out.println(printTextPerRole(roles, textLines));
    }
    
    /**
     * Calculates factorial of given <code>value</code>.
     *
     * @param value positive number
     * @return factorial of <code>value</code>
     */
    public static BigInteger factorial(int value) {
        BigInteger res = BigInteger.valueOf(1);
        for (int i = value; i > 1; i--)
            res = res.multiply(BigInteger.valueOf(i));
        return res;
    }
    
    /**
     * Merges two given sorted arrays into one
     *
     * @param a1 first sorted array
     * @param a2 second sorted array
     * @return new array containing all elements from a1 and a2, sorted
     */
    public static int[] mergeArrays(int[] a1, int[] a2) {
        int i = 0, j = 0, k = 0;
        int n = a1.length + a2.length;
        int[] res = new int[n];
        for (; i < a1.length & j < a2.length;) {
            if (a1[i] <= a2[j]) {
                res[k] = a1[i];
                i++;
            } else {
                res[k] = a2[j];
                j++;
            }
            k++;
        }
        if (i >= a1.length) { // Дополняем к res a2
            for (int l = j; l < a2.length; l++) {
                res[k] = a2[l];
                k++;
            }
        } else if (j >= a2.length) { // Дополняем к res a1
            for (int l = i; l < a1.length; l++) {
                res[k] = a1[l];
                k++;
            }
        }
        
        return res;
    }
    
    private static String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder[] whatToSay = new StringBuilder[roles.length];
        
        for (int i = 0; i < whatToSay.length; i++)
            whatToSay[i] = new StringBuilder();
        
        for (int i = 0; i < textLines.length; i++) {
            
            int endIndex = textLines[i].indexOf(":");
            String curRole = textLines[i].substring(0, endIndex);
            int roleIndex = 0;
            
            for (int j = 0; j< roles.length; j++) {
                if (curRole.equals(roles[j])) {
                    roleIndex = j;
                    break;
                }
            }
            
            whatToSay[roleIndex].append("" + (i + 1) + ") " + textLines[i].substring(endIndex + 2) + "\n");
            // endIndex + 2 Для того, чтобы пропустить : и пробел после него
        }
        
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < whatToSay.length; i++) {
            res.append(roles[i] + ":\n" + whatToSay[i].toString() + "\n");
        }
        return res.toString();
    }
    
    private static String printTextPerRole3(String[] roles, String[] textLines) {
        StringBuilder res = new StringBuilder();
        return "";
    }
}
