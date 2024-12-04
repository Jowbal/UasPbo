package controller;

import java.util.ArrayList;
import model.Produk;
import view.ProdukView;

public class ProdukController {
    private final ArrayList<Produk> daftarProduk;
    private final ProdukView produkView;

    public ProdukController(ProdukView produkView) {
        this.daftarProduk = new ArrayList<>();
        this.produkView = produkView;
    }

    public void tambahProduk(Produk produk) {
        daftarProduk.add(produk);
        produkView.tampilkanPesan("Produk berhasil ditambahkan: " + produk.getNama());
    }

    public void tampilkanDaftarProduk() {
        produkView.tampilkanDaftarProduk(daftarProduk);
    }

    public Produk cariProdukBerdasarkanIndex(int index) {
        if (index >= 0 && index < daftarProduk.size()) {
            return daftarProduk.get(index);
        }
        return null;
    }

    public boolean kurangiStokProduk(Produk produk, int jumlah) {
        if (produk != null && produk.getStok() >= jumlah) {
            produk.kurangiStok(jumlah);
            return true;
        }
        return false;
    }

    public ArrayList<Produk> getDaftarProduk() {
        return daftarProduk;
    }
}
