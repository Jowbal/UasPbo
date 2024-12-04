package controller;

import model.Pembayaran;
import model.PembayaranKartuKredit;
import model.PembayaranTransfer;
import model.PembayaranTunai;
import view.PembayaranView;

public class PembayaranController {
    private final PembayaranView pembayaranView;

    public PembayaranController(PembayaranView pembayaranView) {
        this.pembayaranView = pembayaranView;
    }

    public Pembayaran buatPembayaran(double total, int metode) {
        Pembayaran pembayaran = null;

        switch (metode) {
            case 1 -> pembayaran = new PembayaranTunai(total);
            case 2 -> pembayaran = new PembayaranKartuKredit(total);
            case 3 -> pembayaran = new PembayaranTransfer(total);
            default -> pembayaranView.tampilkanPesan("Metode pembayaran tidak valid.");
        }

        if (pembayaran != null) {
            pembayaranView.tampilkanTotalPembayaran(pembayaran);
        }

        return pembayaran;
    }
}
