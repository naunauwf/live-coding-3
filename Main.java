

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Rekening> daftarNasabah = new ArrayList<>();

        // Inisialisasi Data
        Tabungan t = new Tabungan("Andi", "77777777", 5300000, 6);
        Giro g = new Giro("Budi", "8888888", 600000, 2800000);
        Deposito d = new Deposito("Citra", "9999999", 8500000, 12, 0.05);

        daftarNasabah.add(t);
        daftarNasabah.add(g);
        daftarNasabah.add(d);

        // Tampilkan Semua Rekening (Soal 5)
        System.out.println("");
        Rekening tertinggi = daftarNasabah.get(0);
        Rekening terendah = daftarNasabah.get(0);

        for (Rekening r : daftarNasabah) {
            r.tampilkanInfo();
            System.out.println("----------------------------");

            // Cari Saldo Tertinggi & Terendah
            if (r.saldo > tertinggi.saldo) tertinggi = r;
            if (r.saldo < terendah.saldo) terendah = r;
        }

        System.out.println("Saldo Tertinggi: " + tertinggi.namaPemilik + " Rp" + tertinggi.saldo);
        System.out.println("Saldo Terendah : " + terendah.namaPemilik + " Rp" + terendah.saldo);

        // Simulasi Soal 4 (Deposito)
        System.out.println("\n- Simulasi Denda -");
        d.tarik(1000000); // Tarik 1 juta, harusnya kena denda 10% dari saldo awal (8.5jt)
        System.out.println("Saldo Deposito Citra sekarang: Rp" + d.saldo);

        // Transfer Antar Rekening
        System.out.println("\n========== TRANSFER ANTAR REKENING ==========");

        System.out.println("\nTransfer dari Tabungan (Andi) ke Giro (Budi) - GRATIS");
        t.transferKe(g, 200000);
        System.out.println("Saldo Andi (Tabungan): Rp" + t.saldo);
        System.out.println("Saldo Budi (Giro)    : Rp" + g.saldo);

        System.out.println("\nTransfer dari Giro (Budi) ke Tabungan (Andi) - Biaya Admin Rp5.000");
        g.transferKe(t, 100000);
        System.out.println("Saldo Budi (Giro)    : Rp" + g.saldo);
        System.out.println("Saldo Andi (Tabungan): Rp" + t.saldo);


        t.setor(500000);           
        t.tarik(200000);           
        t.cetakLaporan();
    }
}