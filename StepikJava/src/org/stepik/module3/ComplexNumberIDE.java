package org.stepik.module3;

import java.util.Objects;

public final class ComplexNumberIDE{
    private final double re;
    private final double im;
    
    public ComplexNumberIDE(double re, double im) {
        this.re = re;
        this.im = im;
    }
    
    public double getRe() {
        return re;
    }
    
    public double getIm() {
        return im;
    }
    
//
//    @Override
//    public boolean equals(Object other) {
//        if (this == other)
//            return true;
//        if (other instanceof ComplexNumberIDE) {
//            ComplexNumberIDE x = (ComplexNumberIDE) other;
//            if (this.re == x.getRe() & this.im == x.getIm())
//                return true;
//        }
//        return false;
//    }
//
//    @Override
//    public int hashCode() {
//        return hashCode(re) ^ (hashCode(im) >>> 32);
//    }
//
//    private int hashCode(double value) {
//        long bits = Double.doubleToLongBits(value);
//        return (int)(bits ^ (bits >>> 32));
//    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComplexNumberIDE that = (ComplexNumberIDE) o;
        return Double.compare(that.re, re) == 0 &&
                Double.compare(that.im, im) == 0;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(re, im);
    }
}