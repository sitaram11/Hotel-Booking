import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class LoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    public static HashMap<String, String> users = new HashMap<>();
    public static HashMap<String, ReservationHistory> reservations = new HashMap<>();

    public LoginFrame() {
        setTitle("Hotel Booking System - Login");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        panel.add(usernameField);

        panel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        JButton loginButton = new JButton("Login");
        JButton signupButton = new JButton("Signup");
        panel.add(loginButton);
        panel.add(signupButton);

        add(panel);

        loginButton.addActionListener(e -> login());
        signupButton.addActionListener(e -> signup());
    }

    private void login() {
        String user = usernameField.getText();
        String pass = new String(passwordField.getPassword());

        if (users.containsKey(user) && users.get(user).equals(pass)) {
            JOptionPane.showMessageDialog(this, "Login Successful!");
            this.dispose();
            new HotelListFrame(user).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Invalid credentials.");
        }
    }

    private void signup() {
        String user = usernameField.getText();
        String pass = new String(passwordField.getPassword());

        if (users.containsKey(user)) {
            JOptionPane.showMessageDialog(this, "Username already exists.");
        } else {
            users.put(user, pass);
            reservations.put(user, new ReservationHistory(user));
            JOptionPane.showMessageDialog(this, "Signup Successful! Please login.");
        }
    }
}
