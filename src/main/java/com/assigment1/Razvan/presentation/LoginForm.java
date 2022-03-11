package com.assigment1.Razvan.presentation;

import com.assigment1.Razvan.bussiness.UserService;
import com.assigment1.Razvan.bussiness.VacationsService;
import com.assigment1.Razvan.persistence.UserEntity;
import org.apache.commons.codec.digest.DigestUtils;

import javax.swing.*;
import java.util.Arrays;

public class LoginForm {
    private JTextField usernameField;
    private JPanel mainPanel;
    private JButton loginButton;
    private JButton registerButton;
    private JPasswordField passwordField;

    private JFrame frame;

    public LoginForm(UserService userService, VacationsService vacationsService) {
        frame = new JFrame("Login Page");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        loginButton.addActionListener(e -> {
            String md5Hex = DigestUtils.md5Hex(Arrays.toString(passwordField.getPassword())).toUpperCase();
            UserEntity userEntity = userService.findByName(usernameField.getText());
            if(userEntity == null) {
                JOptionPane.showMessageDialog(frame, "Invalid username!");
                return;
            }
            if(!md5Hex.equals(userEntity.getHash())) {
                JOptionPane.showMessageDialog(frame, "Invalid password!");
                return;
            }
            UserEntity user = userService.findByName(usernameField.getText());
            userService.setLoggedUser(user);
            new UserTravelsForm(userService, vacationsService);
            //JOptionPane.showMessageDialog(frame, "Success!");
        });
        registerButton.addActionListener(e -> {
            new SignupForm(userService, vacationsService);
            frame.dispose();
        });
    }

}
