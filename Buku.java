public class Buku {
    String nama, pengarang, penerbit;
    int hargaSatuan, jumlah;

    Buku() {
    }

    Buku(String nm, String pgr, String pnb, int hs, int jml) {
        nama = nm;
        pengarang = pgr;
        penerbit = pnb;
        hargaSatuan = hs;
        jumlah = jml;
    }

    int hitungHargaTotal() {
        return hargaSatuan * jumlah;
    }

    int hitungDiskon() {
        int hargaTotal = hitungHargaTotal();
        int diskon = 0;
        if (hargaTotal > 100000) {
            diskon = (int) (hargaTotal * 10 / 100);
        } else if (hargaTotal >= 50000) {
            diskon = (int) (hargaTotal * 5 / 100);
        }
        return diskon;
    }

    int hitungHargaBayar() {
        return hitungHargaTotal() - hitungDiskon();
    }

    void tampilBuku() {
        System.out.println("Nama Buku: " + nama);
        System.out.println("Pengarang: " + pengarang);
        System.out.println("Penerbit: " + penerbit);
        System.out.println("Harga Satuan: " + hargaSatuan);
        System.out.println("Jumlah: " + jumlah);
        System.out.println("Harga Total: " + hitungHargaTotal());
        System.out.println("Diskon: " + hitungDiskon());
        System.out.println("Total Bayar: " + hitungHargaBayar());
    }
}