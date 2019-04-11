package org.stepik.module3;

public class AsciiCharSequence implements CharSequence{
    
    private byte[] string;
    
    public AsciiCharSequence(byte[] string) {
        this.string = string.clone();
    }
    
    @Override
    public int length() {
        return string.length;
    }
    
    @Override
    public char charAt(int index) {
        return (char)string[index];
    }
    
    @Override
    public CharSequence subSequence(int start, int end) {
        byte[] substr = new byte[end - start];
        
        for (int i = start, k = 0; i < end; i++, k++) {
            substr[k] = string[i];
        }
        
        AsciiCharSequence res = new AsciiCharSequence(substr);
        return res;
    }
    
    @Override
    public String toString() {
       StringBuilder s = new StringBuilder();
       for (int i = 0; i < string.length; i++) {
           s.append(charAt(i));
       }
       return s.toString();
    }
}
