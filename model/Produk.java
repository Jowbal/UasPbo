package model;

public abstract class Produk {
    protected String nama;
    protected double harga;
    protected int stok;

    public Produk(String nama, double harga, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    public void kurangiStok(int jumlah) {
        if (stok >= jumlah) {
            stok -= jumlah;
        }
    }

    public abstract double hitungTotalNilaiStok();
}