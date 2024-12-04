package view;

import model.Produk;
import java.util.ArrayList;

public class ProdukView {

    public void tampilkanDaftarProduk(ArrayList<Produk> daftarProduk) {
        System.out.println("\n+-------------------------------------------------------------------------------------------+");
        System.out.println("|                                       Daftar Produk                                        |");
        System.out.println("+-------------------------------------------------------------------------------------------+");
        System.out.printf("| %-4s | %-20s | %-15s | %-10s |\n", "No", "Nama Produk", "Harga (Rp)", "Stok");
        System.out.println("+-------------------------------------------------------------------------------------------+");
        int noProduk = 1;
        for (Produk produk : daftarProduk) {
            System.out.printf("| %-4d | %-20s | %-15.2f | %-10d |\n", noProduk++, produk.getNama(), produk.getHarga(), produk.getStok());
        }
        System.out.println("+-------------------------------------------------------------------------------------------+");
    }

    public void tampilkanPesan(String pesan) {
        System.out.println(pesan);
    }
}
