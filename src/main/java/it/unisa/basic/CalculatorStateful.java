package it.unisa.basic;

public class CalculatorStateful {
    private Esito esito;
    private double valore;

    public CalculatorStateful() {
        esito = Esito.EMPTY;
        valore = 0;
    }

    public void clear() {
        esito = Esito.EMPTY;
    }

    public void put(double num) {
        if (esito == Esito.EMPTY) {
            valore = num;
            esito = Esito.OK;
        }
    }

    public void add(double num) {
        if (esito == Esito.OK) {
            valore += num;
        }
    }

    public void sub(double num) {
        if (esito == Esito.OK) {
            valore -= num;
        }
    }

    public void mul(double num) {
        if (esito == Esito.OK) {
            valore *= num;
        }
    }

    public void div(double num) {
        if (esito == Esito.OK) {
            if (num == 0) {
                esito = Esito.ERROR;
            } else {
                valore /= num;
            }
        }
    }

    public Esito getEsito() {
        return esito;
    }

    public double getValore() {
        return valore;
    }

    public enum Esito {EMPTY, OK, ERROR}
}
