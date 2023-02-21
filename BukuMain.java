public class BukuMain {
    public static void main(String[] args) {
        Buku buku1 = new Buku("Harry Potter", "J.K. Rowling", "Gramedia", 50000, 3);
        buku1.tampilBuku();
        System.out.println("===========================\n");

        Buku buku2 = new Buku();
        buku2.nama = "Demian";
        buku2.pengarang = "Hermann Hesse";
        buku2.penerbit = "Semicolon Publisher";
        buku2.hargaSatuan = 160000;
        buku2.jumlah = 1;
        buku2.tampilBuku();
    }
}
