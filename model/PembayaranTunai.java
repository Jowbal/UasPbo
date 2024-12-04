package model;

public class PembayaranTunai extends Pembayaran {
    public PembayaranTunai(double total) {
        super(total);
    }

    @Override
    public double hitungTotal() {
        return total; // Tidak ada tambahan biaya
    }
}