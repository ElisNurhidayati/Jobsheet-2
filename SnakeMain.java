import java.util.Scanner;

public class SnakeMain {

    public static void main(String[] args) {
        Snake snke = new Snake(1, 1, 10, 10);
        Scanner sc = new Scanner(System.in);

        System.out.println("=======================================");
        System.out.println("Aturan Bermain");
        System.out.println("Tombol a untuk mengarahkan ke kiri");
        System.out.println("Tombol d untuk mengarahkan ke kanan");
        System.out.println("Tombol w untuk mengarahkan ke atas");
        System.out.println("Tombol s untuk mengarahkan ke bawah");
        System.out.println("ketik  exit untuk keluar");
        System.out.println("=======================================");

        snke.printPosition();
        loop: while (true) {
            switch (sc.nextLine()) {
                case "a":
                    snke.moveLeft();
                    break;

                case "d":
                    snke.moveRight();
                    break;

                case "w":
                    snke.moveUp();
                    break;

                case "s":
                    snke.moveDown();
                    break;

                case "exit":
                    snke.detectCollision(-1, -1);
                    break loop;

                default:
                    snke.printPosition();
            }
        }
    }
}