import javax.swing.*;

public class SortingVisualizer {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sorting Visualizer");
        SortingPanel panel = new SortingPanel();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(panel);
        frame.setVisible(true);
    }
}
