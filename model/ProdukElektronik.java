package model;

public class ProdukElektronik extends Produk {
    private final int garansi; // dalam bulan

    public ProdukElektronik(String nama, double harga, int stok, int garansi) {
        super(nama, harga, stok);
        this.garansi = garansi;
    }

    public int getGaransi() {
        return garansi;
    }

    @Override
    public double hitungTotalNilaiStok() {
        return harga * stok;
    }
}
