import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Jlabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;


public class GUI implements ActionListener{

    private static JLabel label;
    private static JLabel PLabel;
    private static JLabel success;
    private static JTextField userText;
    private static JPasswordField passText;
    private static JButton button;

    public static void main(Static[] args) {
        JFrame frame = new JFrame();
        frame.setSize(350, 200);
        frame.DefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.add(label);
        panel.add(userText);

        JLabel label = new JLabel("User");
        label.setBounds(10, 20, 80, 25);

        JLabel PLabel = new JLabel("Password");
        PLabel.setBounds(10, 50, 80, 25);
        panel.add(PLabel);

        JTextField userText = new JTextField();
        userText.setBounds(100, 20, 165, 25);

        JPasswordField passText = new JPasswordField();
        passText.setBounds (100, 50, 165, 25);
        panel.add(passText);

        JButton button = new JButton();
        button.setBounds(10, 80, 80, 25);
        button.addActionListener(new GUI());
        panel.add(button);

        JLabel success = new JLabel("");
        success.setBounds(10, 110, 300, 25);
        panel.add(success);
        success.setText();

        
    }
    @Override
    public void actionPerformed (ActionEvent e) {
        String user = userText.getText();
        String password = passText.getText();

        if (user.equals("user") && password.equals ("jelly")){
            success,setText("Login successful");

        }
    }
}