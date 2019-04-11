package org.stepik.module4;

public class task1_2{
    
    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        anotherMethod();
    }
    
    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
    }
    
    public static String getCallerClassAndMethodName() {
        try {
            StackTraceElement[] trace = new Throwable().getStackTrace();
            StackTraceElement curEl = trace[2];
            String className = curEl.getClassName();
            String methodName = curEl.getMethodName();
            return className + "#" + methodName;
        } catch (Exception e) {
            return null;
        }
    }
}
