package model;

public class ProdukPakaian extends Produk {
    private final String ukuran;

    public ProdukPakaian(String nama, double harga, int stok, String ukuran) {
        super(nama, harga, stok);
        this.ukuran = ukuran;
    }

    public String getUkuran() {
        return ukuran;
    }

    @Override
    public double hitungTotalNilaiStok() {
        return harga * stok; // Menggunakan metode baru
    }
}
