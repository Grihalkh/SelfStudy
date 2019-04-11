import java.util.Scanner;

public class Main{
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("Введите номер задания:");
        String num = scanner.nextLine();
        switch(num) {
            case "mytest1":
                org.stepik.mytest.test1.test();
                break;
            case "mytest2":
                org.stepik.mytest.test2.test();
                break;
            case "2.1":
                org.stepik.module2.task1.task();
                break;
            case "2.3":
                org.stepik.module2.task3.task();
                break;
            case "2.4":
                org.stepik.module2.task4.task();
                break;
            case "3.3":
                org.stepik.module3.task3.task();
                break;
            case "3.4":
                org.stepik.module3.task4.task();
                break;
            case "3.5":
                org.stepik.module3.task5.task();
                break;
            case "4.1":
                org.stepik.module4.task1.task();
                break;
            case "4.2":
                org.stepik.module4.task2.task();
                break;
            default:
                System.out.println("Нет такого урока");
                break;
        }
    }
}
/* /* csmnacnoias  **/
