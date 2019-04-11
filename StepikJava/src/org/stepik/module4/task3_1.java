package org.stepik.module4;

import java.util.logging.*;

public class task3_1{
    private static void configureLogging() {
        Logger A = Logger.getLogger("org.stepic.java.logging.ClassA");
        Logger B = Logger.getLogger("org.stepic.java.logging.ClassB");
        A.setLevel(Level.ALL);
        B.setLevel(Level.WARNING);
    
        Logger top = Logger.getLogger("org.stepic.java");
        top.setUseParentHandlers(false);
        top.setLevel(Level.ALL);
        
        Handler handler = new ConsoleHandler();
        handler.setFormatter(new XMLFormatter());
        handler.setLevel(Level.ALL);
        
        top.addHandler(handler);
    }
}
