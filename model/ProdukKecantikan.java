package model;

public class ProdukKecantikan extends Produk {
    private final String jenis;

    public ProdukKecantikan(String nama, double harga, int stok, String jenis) {
        super(nama, harga, stok);
        this.jenis = jenis;
    }

    public String getJenis() {
        return jenis;
    }

    @Override
    public double hitungTotalNilaiStok() {
        return harga * stok; // Menggunakan metode baru
    }
}
