import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class SortingPanel extends JPanel implements ActionListener {
    private int[] array;
    private Timer timer; // javax.swing.Timer
    private int currentIndex = 0;
    private boolean isSorting = false;

    public SortingPanel() {
        setBackground(Color.BLACK);
        setFocusable(true);

        JButton startButton = new JButton("Start Bubble Sort");
        startButton.addActionListener(e -> {
            if (!isSorting) {
                isSorting = true;
                currentIndex = 0;
                timer.start();
            }
        });

        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> {
            if (!isSorting) {
                generateArray();
                repaint();
            }
        });

        timer = new Timer(50, this); // This refers to javax.swing.Timer
        generateArray();

        this.add(startButton);
        this.add(resetButton);
    }

    public void generateArray() {
        Random rand = new Random();
        array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(500) + 10;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (currentIndex < array.length - 1) {
            for (int j = 0; j < array.length - currentIndex - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            currentIndex++;
        } else {
            isSorting = false;
            timer.stop();
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth() / array.length;

        for (int i = 0; i < array.length; i++) {
            g.setColor(Color.CYAN);
            g.fillRect(i * width, getHeight() - array[i], width, array[i]);
        }
    }
}
