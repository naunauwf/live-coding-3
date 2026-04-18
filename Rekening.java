
import java.util.ArrayList;

public class Rekening {
    protected String namaPemilik;
    protected String nomorRekening;
    protected double saldo;

    // Fitur 3: ArrayList untuk menyimpan riwayat transaksi
    protected ArrayList<String> riwayatTransaksi = new ArrayList<>();

    public Rekening(String namaPemilik, String nomorRekening, double saldo) {
        this.namaPemilik = namaPemilik;
        this.nomorRekening = nomorRekening;
        this.saldo = saldo;
    }

    // Soal 3: Overloading method setor()
    // Versi 1: Setor tunai biasa
    public void setor(double jumlah) {
        saldo += jumlah;
        System.out.println("Setor tunai berhasil: Rp" + jumlah);
        riwayatTransaksi.add("[SETOR] Rp" + jumlah + " | Saldo: Rp" + saldo);
    }

    // Versi 2: Setor via transfer (potong biaya admin Rp 2.500)
    public void setor(double jumlah, boolean transfer) {
        if (transfer) {
            double biayaAdmin = 2500;
            saldo += (jumlah - biayaAdmin);
            System.out.println("Transfer masuk. Biaya admin Rp2.500. Saldo: Rp " + (jumlah - biayaAdmin));
            riwayatTransaksi.add("[SETOR TRANSFER] Rp" + jumlah + " (biaya admin Rp2.500) | Saldo: Rp" + saldo);
        } else {
            setor(jumlah);
        }
    }

    public void tarik(double jumlah) {
        if (jumlah <= saldo) {
            saldo -= jumlah;
            System.out.println("Penarikan berhasil: Rp" + jumlah);
            riwayatTransaksi.add("[TARIK] Rp" + jumlah + " | Saldo: Rp" + saldo);
        } else {
            System.out.println("Gagal! Saldo tidak mencukupi.");
            riwayatTransaksi.add("[TARIK GAGAL] Rp" + jumlah + " | Saldo tidak mencukupi");
        }
    }

    // Fitur 1: Transfer antar rekening
    // Tabungan -> Giro: gratis | Giro -> Tabungan: kena biaya admin Rp 5.000
    public void transferKe(Rekening tujuan, double jumlah) {
        double biayaAdmin = 0;

        if (this instanceof Giro && tujuan instanceof Tabungan) {
            biayaAdmin = 5000;
        }

        double totalDebit = jumlah + biayaAdmin;

        if (totalDebit <= saldo) {
            saldo -= totalDebit;
            tujuan.saldo += jumlah;

            String keterangan = biayaAdmin > 0
                ? " (biaya admin Rp" + biayaAdmin + ")"
                : " (gratis)";

            System.out.println("Transfer Rp" + jumlah + " dari " + namaPemilik
                + " ke " + tujuan.namaPemilik + keterangan + " berhasil.");

            riwayatTransaksi.add("[TRANSFER KELUAR] Rp" + jumlah + keterangan + " ke " + tujuan.namaPemilik + " | Saldo: Rp" + saldo);
            tujuan.riwayatTransaksi.add("[TRANSFER MASUK] Rp" + jumlah + " dari " + namaPemilik + " | Saldo: Rp" + tujuan.saldo);
        } else {
            System.out.println("Transfer gagal! Saldo tidak mencukupi (butuh Rp" + totalDebit + ").");
            riwayatTransaksi.add("[TRANSFER GAGAL] Rp" + jumlah + " ke " + tujuan.namaPemilik + " | Saldo tidak mencukupi");
        }
    }

    // Fitur 3: Cetak laporan riwayat transaksi
    public void cetakLaporan() {
        System.out.println("====== LAPORAN TRANSAKSI ======");
        System.out.println("Nama           : " + namaPemilik);
        System.out.println("Nomor Rekening : " + nomorRekening);
        System.out.println("Saldo Akhir    : Rp" + saldo);
        System.out.println("-------------------------------");
        if (riwayatTransaksi.isEmpty()) {
            System.out.println("Belum ada transaksi.");
        } else {
            for (int i = 0; i < riwayatTransaksi.size(); i++) {
                System.out.println((i + 1) + ". " + riwayatTransaksi.get(i));
            }
        }
    }

    public void tampilkanInfo() {
        System.out.println("Nama           : " + namaPemilik);
        System.out.println("Nomor Rekening : " + nomorRekening);
        System.out.println("Saldo          : Rp" + saldo);
    }
}