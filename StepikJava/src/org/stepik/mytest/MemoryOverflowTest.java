package org.stepik.mytest;

public class MemoryOverflowTest{
    
    private MemoryOverflowTest x;
    
    MemoryOverflowTest() {
        x = new MemoryOverflowTest();
    }
    
    @Override
    public String toString() {
        return "i have been turned into String";
    }
}
