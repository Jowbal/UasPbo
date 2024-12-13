package model;

public class ProdukBuku extends Produk {
    private final String penulis;

    public ProdukBuku(String nama, double harga, int stok, String penulis) {
        super(nama, harga, stok);
        this.penulis = penulis;
    }

    public String getPenulis() {
        return penulis;
    }

    @Override
    public double hitungTotalNilaiStok() {
        return harga * stok; // Menggunakan metode baru
    }
}
