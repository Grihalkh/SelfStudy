package org.stepik.module3;

public class NegativeTextAnalyzer extends KeywordAnalyzer implements TextAnalyzer{
    
    @Override
    protected String[] getKeywords() {
        return keys;
    }
    
    @Override
    protected Label getLabel() {
        return Label.NEGATIVE_TEXT;
    }
    
    private static final String[] keys = new String[]{":(", "=(", ":|"};
    
}
