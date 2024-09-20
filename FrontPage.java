package com.studyopedia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrontPage extends JFrame implements ActionListener {

    // Declare UI components
    private Container container;
    private JLabel userLabel;
    private JLabel passwordLabel;
    private JTextField userTextField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel messageLabel;

    // Variables for login attempts
    private int attemptCount = 0;
    private final int maxAttempts = 3;

    // Constructor to initialize and set up the frame
    public FrontPage() {
        // Set the frame title and size
        setTitle("Login Page");
        setBounds(300, 90, 400, 220);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);

        // Get the content pane of the frame
        container = getContentPane();
        container.setLayout(null);

        // Create and set properties for the username label
        userLabel = new JLabel("Username");
        userLabel.setBounds(70, 30, 100, 30);
        container.add(userLabel);

        // Create and set properties for the username text field
        userTextField = new JTextField();
        userTextField.setBounds(150, 30, 170, 30);
        container.add(userTextField);

        // Create and set properties for the password label
        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(70, 70, 100, 30);
        container.add(passwordLabel);

        // Create and set properties for the password field
        passwordField = new JPasswordField();
        passwordField.setBounds(150, 70, 170, 30);
        container.add(passwordField);

        // Create and set properties for the login button
        loginButton = new JButton("Login");
        loginButton.setBounds(125, 110, 150, 30);
        loginButton.addActionListener(this);
        container.add(loginButton);

        // Create and set properties for the message label
        messageLabel = new JLabel("");
        messageLabel.setBounds(70, 140, 250, 30);
        container.add(messageLabel);

        // Make the frame visible
        setVisible(true);
    }

    // ActionListener method for handling button click events
    @Override
    public void actionPerformed(ActionEvent e) {
        // Predefined credentials for login validation
        String userName = "admin";
        String password = "12345";

        if (e.getSource() == loginButton) {
            // Get input from the user
            String enteredUsername = userTextField.getText();
            String enteredPassword = new String(passwordField.getPassword());

            // Check if the input matches the predefined credentials
            if (enteredUsername.equals(userName) && enteredPassword.equals(password)) {
                JOptionPane.showMessageDialog(FrontPage.this, "Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } else {
                attemptCount++;  // Increment the login attempt counter
                messageLabel.setText("Invalid Username or Password. Attempt " + attemptCount + "/" + maxAttempts);
                messageLabel.setForeground(Color.RED);

                // Disable login and close window after max attempts
                if (attemptCount >= maxAttempts) {
                    JOptionPane.showMessageDialog(FrontPage.this, "Max attempts reached! The application will now close.", "Locked Out", JOptionPane.ERROR_MESSAGE);
                    dispose();  // Close the login window
                }
            }
        }
    }

    public static void main(String[] args) {
        // Run the login page
        new FrontPage();
    }
}
