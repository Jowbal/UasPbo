package view;

import model.Pembayaran;

public class PembayaranView {

    public void tampilkanTotalPembayaran(Pembayaran pembayaran) {
        System.out.printf("Total yang harus dibayar: %.2f\n", pembayaran.hitungTotal());
    }

    public void tampilkanPesan(String pesan) {
        System.out.println(pesan);
    }
}
