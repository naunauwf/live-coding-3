

public class Deposito extends Rekening {
    private int jangkaWaktuBulan;
    private double sukuBunga;

    public Deposito(String nama, String noRek, double saldo, int jangka, double bunga) {
        super(nama, noRek, saldo);
        this.jangkaWaktuBulan = jangka;
        this.sukuBunga = bunga;
    }

    // Rumus Soal 4: Bunga = sukuBunga * saldo * jangkaWaktuBulan
    public void hitungBunga() {
        double bunga = sukuBunga * saldo * jangkaWaktuBulan;
        System.out.println("Bunga Deposito: Rp" + bunga);
    }

    @Override
    public void tarik(double jumlah) {
        // Override Soal 4: Denda 10% dari saldo jika ditarik awal
        double denda = 0.10 * saldo;
        saldo -= (jumlah + denda);
        System.out.println("Penarikan Deposito sebelum jatuh tempo! Denda 10% (Rp" + denda + ") dikenakan.");
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("--- Rekening Deposito ---");
        super.tampilkanInfo();
        System.out.println("Jangka Waktu   : " + jangkaWaktuBulan + " bulan");
    }
}