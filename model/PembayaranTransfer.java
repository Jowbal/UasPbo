package model;

public class PembayaranTransfer extends Pembayaran {
    public PembayaranTransfer(double total) {
        super(total);
    }

    @Override
    public double hitungTotal() {
        return total; // Tidak ada tambahan biaya
    }
}
