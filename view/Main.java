package view;
import controller.DiskonController;
import controller.PembayaranController;
import controller.ProdukController;
import java.util.Scanner;
import model.*;

public class Main {
    public static void main(String[] args) {
        // Inisialisasi komponen MVC
        ProdukView produkView = new ProdukView();
        PembayaranView pembayaranView = new PembayaranView();
        DiskonView diskonView = new DiskonView();
        InputView inputView = new InputView();

        ProdukController produkController = new ProdukController(produkView);
        PembayaranController pembayaranController = new PembayaranController(pembayaranView);
        DiskonController diskonController = new DiskonController(diskonView);

        // Tambahkan produk awal
        produkController.tambahProduk(new ProdukMakanan("Indomie", 2500, 50, "24/12/2025"));
        produkController.tambahProduk(new ProdukElektronik("Charger", 25000, 10, 12));
        produkController.tambahProduk(new ProdukPakaian("Kemeja", 100000, 20, "L"));

        try (Scanner scanner = new Scanner(System.in)) {
            boolean selesai = false;

        System.out.println("+-------------------------------------------------+");
        System.out.println("|          PROGRAM MANAJEMEN TOKO RETAIL          |");
        System.out.println("+-------------------------------------------------+");
            while (!selesai) {
                System.out.println("\n=== Menu Utama ===");
                System.out.println("1. Tampilkan Produk");
                System.out.println("2. Tambah Produk");
                System.out.println("3. Pembelian Barang");
                System.out.println("4. Keluar");
                System.out.print("Pilih opsi: ");
                int pilihan = scanner.nextInt();
                scanner.nextLine(); // Membersihkan newline di buffer
        
                switch (pilihan) {
                    case 1 -> // Tampilkan produk
                        produkController.tampilkanDaftarProduk();
        
                    case 2 -> {
                        // Tambah produk
                        System.out.println("\n=== Tambah Produk ===");
                        System.out.println("Pilih jenis produk:");
                        System.out.println("1. Makanan");
                        System.out.println("2. Elektronik");
                        System.out.println("3. Pakaian");
                        System.out.println("4. Buku");
                        System.out.println("5. Kecantikan");
                        System.out.print("Pilihan: ");
                        int jenisProduk = scanner.nextInt();
                        scanner.nextLine(); // Membersihkan newline di buffer
        
                        System.out.print("Nama produk: ");
                        String namaProduk = scanner.nextLine();
                        System.out.print("Harga produk: ");
                        double hargaProduk = scanner.nextDouble();
                        System.out.print("Stok produk: ");
                        int stokProduk = scanner.nextInt();
                        scanner.nextLine(); // Membersihkan newline di buffer
        
                        switch (jenisProduk) {
                            case 1 -> {
                                System.out.print("Tanggal kedaluwarsa: ");
                                String tanggalKedaluwarsa = scanner.nextLine();
                                produkController.tambahProduk(new ProdukMakanan(namaProduk, hargaProduk, stokProduk, tanggalKedaluwarsa));
                        }
                            case 2 -> {
                                System.out.print("Garansi (bulan): ");
                                int garansi = scanner.nextInt();
                                scanner.nextLine(); // Membersihkan newline di buffer
                                produkController.tambahProduk(new ProdukElektronik(namaProduk, hargaProduk, stokProduk, garansi));
                        }
                            case 3 -> {
                                System.out.print("Ukuran: ");
                                String ukuran = scanner.nextLine();
                                produkController.tambahProduk(new ProdukPakaian(namaProduk, hargaProduk, stokProduk, ukuran));
                        }
                            case 4 -> {
                                System.out.print("Penulis: ");
                                String penulis = scanner.nextLine();
                                produkController.tambahProduk(new ProdukBuku(namaProduk, hargaProduk, stokProduk, penulis));
                        }
                            case 5 -> {
                                System.out.print("Tipe produk kecantikan: ");
                                String tipeProduk = scanner.nextLine();
                                produkController.tambahProduk(new ProdukKecantikan(namaProduk, hargaProduk, stokProduk, tipeProduk));
                        }
                            default -> System.out.println("Pilihan jenis produk tidak valid.");
                        }
                    }
        
                        case 3 -> {
                            // Pembelian barang
                            produkController.tampilkanDaftarProduk();
                            int indexProduk = inputView.mintaInputAngka("Pilih nomor produk yang ingin dibeli: ") - 1;
                            Produk produkDipilih = produkController.cariProdukBerdasarkanIndex(indexProduk);
                            
                            if (produkDipilih != null) {
                                int jumlah = inputView.mintaInputAngka("Masukkan jumlah yang ingin dibeli: ");
                                if (produkController.kurangiStokProduk(produkDipilih, jumlah)) {
                                    double total = produkDipilih.getHarga() * jumlah;
                                    System.out.println("Total harga: " + total);
                                    
                                    // Pilih metode pembayaran
                                    System.out.println("Pilih metode pembayaran:");
                                    System.out.println("1. Tunai");
                                    System.out.println("2. Kartu Kredit");
                                    System.out.println("3. Transfer");
                                    int metode = inputView.mintaInputAngka("Metode pembayaran: ");
                                    Pembayaran pembayaran = pembayaranController.buatPembayaran(total, metode);
                                    
                                    // Pilih diskon
                                    char gunakanDiskon = inputView.mintaInputKarakter("Gunakan diskon? (y/n): ");
                                    if (gunakanDiskon == 'y' || gunakanDiskon == 'Y') {
                                        System.out.println("Pilih jenis diskon:");
                                        System.out.println("1. Diskon Persen");
                                        System.out.println("2. Diskon Nominal");
                                        int jenisDiskon = inputView.mintaInputAngka("Jenis diskon: ");
                                        double nilaiDiskon = inputView.mintaInputDouble("Masukkan nilai diskon: ");
                                        double totalSetelahDiskon = diskonController.hitungTotalSetelahDiskon(pembayaran.hitungTotal(), jenisDiskon, nilaiDiskon);
                                        pembayaranView.tampilkanPesan("Total setelah diskon: " + totalSetelahDiskon);
                                    }
                                } else {
                                    produkView.tampilkanPesan("Stok tidak mencukupi.");
                                }
                            } else {
                                produkView.tampilkanPesan("Produk tidak ditemukan.");
                            }
                    }

                        
                    case 4 -> {
                        selesai = true;
                        System.out.println("Terima kasih telah menggunakan aplikasi.");
                        System.out.println("-------------------------------------------------------------");
                        System.out.println("Program dibuat oleh 'Kelompok 4'.");
                        System.out.println("Kode ini tersedia di GitHub: 'https://github.com/Jowbal/PBO'.");
                    }
        
                    default -> System.out.println("Pilihan tidak valid.");
                }
            }
        }
    }
}