package it.unisa.basic;

public class CalculatorFixed {

    public int add(int left, int right) {
        return left + right;
    }

    public int divide(int left, int right) {
        if (right == 0) {
            throw new ArithmeticException();
        }
        int absoluteLeft = Math.abs(left);
        int absoluteRight = Math.abs(right);

        int num = 0;
        int remainder = absoluteLeft;
        while (remainder >= absoluteRight) {
            remainder = remainder - absoluteRight;
            num++;
        }

        if (left < 0 ^ right < 0) {
            return -num;
        } else {
            return num;
        }
    }

}
