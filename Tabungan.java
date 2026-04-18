

public class Tabungan extends Rekening {
    private double bungaTahunan; // dalam persen

    public Tabungan(String nama, String noRek, double saldo, double bunga) {
        super(nama, noRek, saldo);
        this.bungaTahunan = bunga;
    }

    // Rumus Bunga: (bungaTahunan / 12) * saldo * bulan
    public void hitungBunga(int bulan) {
        double bunga = (bungaTahunan / 100 / 12) * saldo * bulan;
        System.out.println("Bunga Tabungan (" + bulan + " bulan): Rp" + bunga);
    }



    @Override
    public void tampilkanInfo() {
        System.out.println("--- Rekening Tabungan ---");
        super.tampilkanInfo();
        System.out.println("Bunga Tahunan  : " + bungaTahunan + "%");
    }
}