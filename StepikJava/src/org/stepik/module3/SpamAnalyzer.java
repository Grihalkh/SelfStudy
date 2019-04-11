package org.stepik.module3;

public class SpamAnalyzer extends KeywordAnalyzer implements TextAnalyzer{
    
    private String[] keywords;
    
    public SpamAnalyzer(String[] keywords) {
        this.keywords = keywords.clone();
    }
    
    @Override
    protected String[] getKeywords() {
        return keywords;
    }
    
    @Override
    protected Label getLabel() {
        return Label.SPAM;
    }
    
}
