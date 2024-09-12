package Solutions.pack5_new;

import java.util.Arrays;

public class MyStackA {
    private int MAXSIZE = 10;
    private double[] data = new double[MAXSIZE];

    private int size = 0;

    private double pop(){
        return data [size--];
    }

    public void push(double i) {
        data[size++] = i;
    }
    public double peek(){
        return data [size-1];
    }
    @Override
    public String toString() {
        return "MyStackA [MAXSIZE=" + MAXSIZE + ", data=" + Arrays.toString(data) + ", size=" + size + ", pop()="
                + pop() + ", peek()=" + peek() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
    }
    
}
