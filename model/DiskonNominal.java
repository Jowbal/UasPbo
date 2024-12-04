package model;

public class DiskonNominal extends Diskon {
    private final double nominal;

    public DiskonNominal(double total, double nominal) {
        super(total);
        this.nominal = nominal;
    }

    @Override
    public double hitungDiskon() {
        return nominal;
    }
}
