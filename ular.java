import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ular {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GamePanel gamePanel = new GamePanel();
        frame.getContentPane().add(gamePanel);

        frame.pack();
        frame.setVisible(true);
    }

}

class GamePanel extends JPanel implements ActionListener, KeyListener {

    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;
    private static final int CELL_SIZE = 20;

    private ArrayList<Point> snake;
    private Point apple;
    private int score;

    private Timer timer;
    private int delay;

    private int direction;

    public GamePanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);

        snake = new ArrayList<Point>();
        snake.add(new Point(0, 0));
        snake.add(new Point(0, 1));
        snake.add(new Point(0, 2));

        placeApple();

        delay = 200;
        timer = new Timer(delay, this);
        timer.start();
    }

    private void placeApple() {
        Random random = new Random();
        int x = random.nextInt(WIDTH / CELL_SIZE) * CELL_SIZE;
        int y = random.nextInt(HEIGHT / CELL_SIZE) * CELL_SIZE;
        apple = new Point(x, y);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // draw snake
        g.setColor(Color.GREEN);
        for (Point p : snake) {
            g.fillRect(p.x * CELL_SIZE, p.y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
        }

        // draw apple
        g.setColor(Color.RED);
        g.fillOval(apple.x, apple.y, CELL_SIZE, CELL_SIZE);

        // draw score
        g.setColor(Color.WHITE);
        g.drawString("Score: " + score, 10, 20);
    }

    private void move() {
        // move body of snake
        for (int i = snake.size() - 1; i > 0; i--) {
            snake.set(i, snake.get(i - 1));
        }

        // move head of snake
        Point head = snake.get(0);
        switch (direction) {
            case KeyEvent.VK_UP:
                head = new Point(head.x, head.y - 1);
                break;
            case KeyEvent.VK_DOWN:
                head = new Point(head.x, head.y + 1);
                break;
            case KeyEvent.VK_LEFT:
                head = new Point(head.x - 1, head.y);
                break;
            case KeyEvent.VK_RIGHT:
                head = new Point(head.x + 1, head.y);
                break;
        }
        snake.set(0, head);

        // check if snake ate apple
        if (head.equals(apple)) {
            snake.add(new Point(-1, -1));
            placeApple();
            score++;
            if (score % 5 == 0) {
                delay -= 10;
                timer.setDelay(delay);
            }
        }
    }
}
// check if snake collided with wall or itself
// if (head.x < 0 || head.x >=
