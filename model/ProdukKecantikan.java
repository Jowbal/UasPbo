package model;

public class ProdukKecantikan extends Produk {
    private final String tipeProduk;

    public ProdukKecantikan(String nama, double harga, int stok, String tipeProduk) {
        super(nama, harga, stok);
        this.tipeProduk = tipeProduk;
    }

    public String getTipeProduk() {
        return tipeProduk;
    }

    @Override
    public double hitungTotalNilaiStok() {
        return harga * stok;
    }
}
