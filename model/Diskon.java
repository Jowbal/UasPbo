package model;

public abstract class Diskon {
    protected double total;

    public Diskon(double total) {
        this.total = total;
    }

    public abstract double hitungDiskon();
}
