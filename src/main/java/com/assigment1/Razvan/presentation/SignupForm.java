package com.assigment1.Razvan.presentation;

import com.assigment1.Razvan.bussiness.DestinationService;
import com.assigment1.Razvan.bussiness.VacationsService;
import com.assigment1.Razvan.bussiness.UserService;
import com.assigment1.Razvan.bussiness.VacationsService;
import com.assigment1.Razvan.persistence.UserEntity;
import org.apache.commons.codec.digest.DigestUtils;

import javax.swing.*;
import java.util.Arrays;

public class SignupForm {
    private JTextField emailField;
    private JPasswordField passwordField;
    private JTextField nameField;
    private JButton signupButton;
    private JPanel mainPanel;

    private UserService userService;
    private JFrame frame;

    public SignupForm(UserService userService, VacationsService vacationsService, DestinationService destinationService) {
        this.userService = userService;
        frame = new JFrame("Signup Page");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        signupButton.addActionListener(e -> {
            String md5Hex = DigestUtils.md5Hex(Arrays.toString(passwordField.getPassword())).toUpperCase();
            UserEntity userEntity = new UserEntity(nameField.getText(), md5Hex, emailField.getText(), 0);
            userService.save(userEntity);
            JOptionPane.showMessageDialog(frame, "Success!");
            new LoginForm(userService, vacationsService, destinationService);
            frame.dispose();
        });
    }
}
