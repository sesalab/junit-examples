package it.unisa.example;

public class Calculator {

    public int add(int left, int right) {
        return left + right;
    }

    public int divide(int left, int right) {
        return left / right;
    }

    public int divideBySubtract(int left, int right) {
        int num = 0;
        int total = left;
        while (total > 0) {
            total = total - right;
            num++;
        }
        return num;
    }

}
