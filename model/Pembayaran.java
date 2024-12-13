package model;

public abstract class Pembayaran implements HitungTotal {
    protected double total;

    public Pembayaran(double total) {
        this.total = total;
    }

    @Override
    public abstract double hitungTotal();
}
