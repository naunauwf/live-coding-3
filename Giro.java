

public class Giro extends Rekening {
    private double limitPenarikan;

    public Giro(String nama, String noRek, double saldo, double limit) {
        super(nama, noRek, saldo);
        this.limitPenarikan = limit;
    }

    @Override
    public void tarik(double jumlah) {
        // Override: Penarikan bisa melebihi saldo tapi tidak boleh melebihi limit
        if (jumlah <= (saldo + limitPenarikan)) {
            saldo -= jumlah;
            System.out.println("Penarikan Giro berhasil: Rp " + jumlah);
        } else {
            System.out.println("Gagal! Penarikan melebihi limit Giro.");
        }
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("--- Rekening Giro ---");
        super.tampilkanInfo();
        System.out.println("Limit Penarikan: Rp" + limitPenarikan);
    }
}