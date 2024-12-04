package model;

public class DiskonPersen extends Diskon {
    private final double persen;

    public DiskonPersen(double total, double persen) {
        super(total);
        this.persen = persen;
    }

    @Override
    public double hitungDiskon() {
        return total * (persen / 100);
    }
}
