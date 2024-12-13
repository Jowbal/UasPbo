package model;

public class ProdukMakanan extends Produk {
    private final String tanggalKedaluwarsa;

    public ProdukMakanan(String nama, double harga, int stok, String tanggalKedaluwarsa) {
        super(nama, harga, stok);
        this.tanggalKedaluwarsa = tanggalKedaluwarsa;
    }

    public String getTanggalKedaluwarsa() {
        return tanggalKedaluwarsa;
    }

    @Override
    public double hitungTotalNilaiStok() {
        return harga * stok; // Menggunakan metode baru
    }
}
