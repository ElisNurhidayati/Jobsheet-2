public class Snake {
    int x, y, width, height;

    Snake() {

    }

    Snake(int xx, int yy, int w, int h) {
        x = xx;
        y = yy;
        width = w;
        height = h;
    }

    void moveLeft() {
        if (x > 1) {
            x--;
            printPosition();
        } else {
            detectCollision(x, y);
        }
    }

    void moveRight() {
        if (x < width - 1) {
            x++;
            printPosition();
        } else {
            detectCollision(x, y);
        }
    }

    void moveUp() {
        if (y > 1) {
            y--;
            printPosition();
        } else {
            detectCollision(x, y);
        }
    }

    void moveDown() {
        if (y < height - 1) {
            y++;
            printPosition();
        } else {
            detectCollision(x, y);
        }
    }

    void detectCollision(int x, int y) {
        System.out.println("-----------GAME OVER-----------");
    }

    void printPosition() {
        for (int i = 0; i <= height; i++) {
            for (int j = 0; j <= width; j++) {
                if (i == 0 || i == height || j == 0 || j == width) {
                    System.out.print("E  ");
                } else if (i == y && j == x) {
                    System.out.print(i + 1 + "  O");

                } else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }
}