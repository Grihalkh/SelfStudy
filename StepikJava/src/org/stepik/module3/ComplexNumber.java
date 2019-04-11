package org.stepik.module3;

import java.lang.Double;

public final class ComplexNumber {
    private final double re;
    private final double im;
    
    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }
    
    public double getRe() {
        return re;
    }
    
    public double getIm() {
        return im;
    }
    
    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (other instanceof ComplexNumber) {
            ComplexNumber x = (ComplexNumber) other;
            if (this.re == x.getRe() & this.im == x.getIm())
                return true;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return hashCode(re) ^ (hashCode(im) >>> 32);
    }
    
    private int hashCode(double value) {
        long bits = Double.doubleToLongBits(value);
        return (int)(bits ^ (bits >>> 32));
    }
    
    /*
    HashCode convention
    http://www.seostella.com/ru/article/2012/10/04/kak-sgenerirovat-hashcode-v-java.html
    
    
    
    public class TestClass {
    private boolean booleanValue = true;
    private char charValue = 'd';
    private String stringValue = "TestClass";
    private long longValue = 34829245849498300l;
    private float floatValue = 345832400.93f;
    private double doubleValue = 98584292348454.9834;
    private byte[] arrayValue = {1, 2, 3};

    @Override
    public int hashCode() {
        int result = 17;
        
        result = 37 * result + ( booleanValue ? 1 : 0 );
        result = 37 * result + (int) charValue;
        result = 37 * result + (stringValue == null ? 0 : stringValue.hashCode());
        result = 37 * result + (int)(longValue - (longValue >>> 32));
        result = 37 * result + Float.floatToIntBits(floatValue);
        long longBits = Double.doubleToLongBits(doubleValue);
        result = 37 * result + (int)(longBits - (longBits >>> 32));
        for( byte b : arrayValue )
            result = 37 * result + (int) b;
        
        return result;
    }
    
}

     */
}