package view;

public class DiskonView {

    public void tampilkanTotalSetelahDiskon(double totalSetelahDiskon) {
        System.out.printf("Total setelah diskon: %.2f\n", totalSetelahDiskon);
    }

    public void tampilkanDiskon(double nilaiDiskon) {
        System.out.printf("Nilai diskon: %.2f\n", nilaiDiskon);
    }

    public void tampilkanPesan(String pesan) {
        System.out.println(pesan);
    }
}
