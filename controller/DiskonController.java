package controller;

import model.Diskon;
import model.DiskonNominal;
import model.DiskonPersen;
import view.DiskonView;

public class DiskonController {
    private final DiskonView diskonView;

    public DiskonController(DiskonView diskonView) {
        this.diskonView = diskonView;
    }

    public double hitungTotalSetelahDiskon(double total, int jenisDiskon, double nilaiDiskon) {
        Diskon diskon = null;

        switch (jenisDiskon) {
            case 1 -> diskon = new DiskonPersen(total, nilaiDiskon);
            case 2 -> diskon = new DiskonNominal(total, nilaiDiskon);
            default -> diskonView.tampilkanPesan("Jenis diskon tidak valid.");
        }

        if (diskon != null) {
            double nilaiDiskonDiterapkan = diskon.hitungDiskon();
            diskonView.tampilkanDiskon(nilaiDiskonDiterapkan);
            return total - nilaiDiskonDiterapkan;
        }

        return total;
    }
}
