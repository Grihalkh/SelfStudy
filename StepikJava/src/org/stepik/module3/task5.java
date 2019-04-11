package org.stepik.module3;

import java.util.function.DoubleUnaryOperator;

public class task5{
    public static void task() {
        
//        System.out.println(integrate(x -> 1,0, 10));
//
//        AsciiCharSequence mysuperString = new AsciiCharSequence(new byte[]{65, 66, 67});
//        System.out.println("MySuperAsciiString                     = " + mysuperString.toString());
//        System.out.println("MySuperAsciiString.charAt(1)           = " + mysuperString.charAt(1));
//        System.out.println("MySuperAsciiString.subSequence(1, len) = " + mysuperString.subSequence(1, mysuperString.length()).toString());
    
        System.out.println("Фильтрация текстов");
        String textGood = "Я хороший текст ";
        String textSad = "Я грустный :( текст ";
        String textTooLong = "Я оооооооооооооооооочень длииииииииииииииинный тееееееееееееекст ";
        String textSpam = "Во мне есть спам ";
        TextAnalyzer[] analyzers = new TextAnalyzer[]{
                new SpamAnalyzer(new String[]{"спам", "мат", "пошлятина"}),
                new NegativeTextAnalyzer(),
                new TooLongTextAnalyzer(30)
        };
        System.out.println(textGood + checkLabels(analyzers, textGood).name());
        System.out.println(textSad + checkLabels(analyzers, textSad).name());
        System.out.println(textTooLong + checkLabels(analyzers, textTooLong).name());
        System.out.println(textSpam + checkLabels(analyzers, textSpam).name());
        
        
    }
    
    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        double res = 0;
        double step = (double)1 / 1_000_000;
   
        for (double newa = a; newa < b; newa += step) {
            res += f.applyAsDouble(newa) * step;
        }
        return res;
    }
    
    public static Label checkLabels(TextAnalyzer[] analyzers, String text) {
        for (int i = 0; i < analyzers.length; i++) {
            Label label = analyzers[i].processText(text);
            if (label != Label.OK)
                return label;
        }
        return Label.OK;
    }
    
}
