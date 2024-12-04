package model;

public abstract class Pembayaran {
    protected double total;

    public Pembayaran(double total) {
        this.total = total;
    }

    public double getTotal() {
        return total;
    }

    public abstract double hitungTotal();
}
