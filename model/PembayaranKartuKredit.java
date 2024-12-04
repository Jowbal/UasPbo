package model;

public class PembayaranKartuKredit extends Pembayaran {
    public PembayaranKartuKredit(double total) {
        super(total);
    }

    @Override
    public double hitungTotal() {
        return total + (total * 0.02); // Biaya tambahan 2%
    }
}
