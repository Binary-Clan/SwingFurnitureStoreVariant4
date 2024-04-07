//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.List;
//
//public class Login extends JDialog {
//    private JTextField textFieldUserName;
//    private JPasswordField textFieldPassword;
//    private JButton loginButton;
//    private JButton cancelButton;
//    private JLabel labelUserName;
//    private JLabel labelPassword;
//    private JPanel loginPanel;
//    private JButton registerButton;
//
//    public boolean isAuthenticated = false;
//
//    public Login() {
//        setTitle("Login");
//        setContentPane(loginPanel);
//        setMinimumSize(new Dimension(500, 600));
//        setModal(true);
//        setLocationRelativeTo(null);
//        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//
//        // Set background color to reddish-brown
//        loginPanel.setBackground(new Color(100, 150, 150));
//
//        // Set foreground (text) color to white
//        labelUserName.setForeground(Color.WHITE);
//        labelPassword.setForeground(Color.WHITE);
//
//        loginButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String userName = textFieldUserName.getText();
//                String password = new String(textFieldPassword.getPassword());
//
//                // Simulated user authentication
//                List<User> userList = UserList.getUserList();
//                boolean authenticatedUser = false;
//                for (User user : userList) {
//                    if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
//                        authenticatedUser = true;
//                        break;
//                    }
//                }
//                if (authenticatedUser) {
//                    dispose();
//                    isAuthenticated = true;
//                    // Open the home page
//                    openHomePage();
//                } else {
//                    JOptionPane.showMessageDialog(Login.this, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
//                }
//            }
//        });
//
//        cancelButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                dispose();
//            }
//        });
//
//        registerButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                openRegisterPage();
//            }
//        });
//
//        setVisible(true);
//    }
//
//    private void openHomePage() {
//        dispose();
//        Home homePage = new Home();
//        homePage.setVisible(true);
//    }
//
//    private void openRegisterPage() {
//        Register register = new Register((JFrame) SwingUtilities.getWindowAncestor(SwingUtilities.getWindowAncestor(Login.this)));
//        register.setVisible(true);
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            Login loginDialog = new Login();
//            loginDialog.setVisible(true);
//        });
//    }
//}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Login extends JDialog {
    private JTextField textFieldUserName;
    private JPasswordField textFieldPassword;
    private JButton loginButton;
    private JButton cancelButton;
    private JLabel labelUserName;
    private JLabel labelPassword;
    private JPanel loginPanel;
    private JButton registerButton;

    public boolean isAuthenticated = false;

    public Login() {
        setTitle("Login");
        setContentPane(loginPanel);
        setMinimumSize(new Dimension(800, 800));
        setModal(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Set background color to reddish-brown
//        loginPanel.setBackground(new Color(100, 150, 150));

        // Set foreground (text) color to white
        labelUserName.setForeground(Color.WHITE);
        labelPassword.setForeground(Color.WHITE);

        // Set button background color to reddish
//        Color buttonColor = new Color(150, 84, 16); // Reddish-brown color
//        loginButton.setBackground(buttonColor);
//        cancelButton.setBackground(buttonColor);
//        registerButton.setBackground(buttonColor);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = textFieldUserName.getText();
                String password = new String(textFieldPassword.getPassword());
//                String userName = "user1";
//                String password = "password1";

                // Simulated user authentication
                List<User> userList = UserList.getUserList();
                boolean authenticatedUser = false;
                for (User user : userList) {
                    if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
                        authenticatedUser = true;
                        break;
                    }
                }
                if (authenticatedUser) {
                    dispose();
                    isAuthenticated = true;
                    // Open the home page
                    openHomePage();
                } else {
                    JOptionPane.showMessageDialog(Login.this, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openRegisterPage();
            }
        });

        setVisible(true);
    }

    private void openHomePage() {
        dispose();
        Home homePage = new Home();
        homePage.setVisible(true);
    }

    private void openRegisterPage() {
        Register register = new Register((JFrame) SwingUtilities.getWindowAncestor(SwingUtilities.getWindowAncestor(Login.this)));
        register.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Login loginDialog = new Login();
            loginDialog.setVisible(true);
        });
    }
}
