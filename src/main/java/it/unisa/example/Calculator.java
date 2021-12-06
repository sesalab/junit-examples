package it.unisa.example;

public class Calculator {

    public int add(int left, int right) {
        return left + right;
    }

    public int divide(int left, int right) {
        int num = 0;
        int remainder = left;
        while (remainder > 0) {
            remainder = remainder - right;
            num++;
        }
        return num;
    }

}
