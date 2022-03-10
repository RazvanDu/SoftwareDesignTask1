package com.assigment1.Razvan.presentation;

import org.apache.commons.codec.digest.DigestUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class LoginForm {
    private JTextField usernameField;
    private JPanel mainPanel;
    private JButton loginButton;
    private JButton registerButton;
    private JPasswordField passwordField;

    private JFrame frame;

    public LoginForm() {
        frame = new JFrame("Food Delivery Management System");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        loginButton.addActionListener(e -> {
            String md5Hex = DigestUtils.md5Hex(Arrays.toString(passwordField.getPassword())).toUpperCase();
        });
    }

}
