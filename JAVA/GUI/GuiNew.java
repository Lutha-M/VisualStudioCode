package GUI;

/**This is a simple gui app with a single button*/
import javax.swing.*;

public class GuiNew {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Gui v0.1");
        JButton button = new JButton("Press");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.getContentPane().add(button);
        frame.setVisible(true);

    }

}
// Code works
