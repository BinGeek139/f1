/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ptit.managef1.view.user;

import com.ptit.managef1.dao.UserDAO;
import com.ptit.managef1.model.Role;
import com.ptit.managef1.model.User;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author ngocq
 */
public class LoginForm extends JFrame implements ActionListener {

    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;

    public LoginForm() {
        super("Login");
        txtUsername = new JTextField(15);
        txtPassword = new JPasswordField(15);
        txtPassword.setEchoChar('*');
        btnLogin = new JButton("Login");

        JPanel pnMain = new JPanel();
        pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.PAGE_AXIS));
        pnMain.add(Box.createRigidArea(new Dimension(0, 10)));
        
        JLabel lblHome = new JLabel("Login");
        lblHome.setFont(new Font(Font.SERIF, Font.BOLD, 30));
        lblHome.setForeground(Color.BLUE);
        pnMain.add(lblHome);
        pnMain.add(Box.createRigidArea(new Dimension(0, 10)));

        JPanel pnUsername = new JPanel();
        pnUsername.setLayout(new FlowLayout());
        pnUsername.add(new JLabel("Username:"));
        pnUsername.add(txtUsername);
        pnMain.add(pnUsername);

        JPanel pnPass = new JPanel();
        pnPass.setLayout(new FlowLayout());
        pnPass.add(new JLabel("Password:"));
        pnPass.add(txtPassword);
        pnMain.add(pnPass);;

        pnMain.add(btnLogin);
        pnMain.add(Box.createRigidArea(new Dimension(0, 10)));
        btnLogin.addActionListener(this);

        this.setSize(400, 200);
        this.setContentPane(pnMain);
        //chi đóng frame đó các frame khác kiên quan ko bị đóng
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //đặt vị trí cửa sổ so với chỉ định
        this.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ((e.getSource() instanceof JButton) && (((JButton) e.getSource()).equals(btnLogin))) {
            if (!validateData()) {
                resetTextFeild();
                return;
            }
            
            User user = new User();
            user.setUsername(txtUsername.getText());
            user.setPassword(txtPassword.getText());
            UserDAO userDAO = new UserDAO();
            if (userDAO.checkLogin(user)) {
                if (Role.MANAGER.getPosition().equalsIgnoreCase(user.getPosition())) {
                    new ManagerHomeForm(user).setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "The function of the role " + user.getPosition() + " is under construction!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Incorrect username and/or password!");
                resetTextFeild();
            }

        }
    }

    public void resetTextFeild() {
        txtUsername.setText("");
        txtPassword.setText("");
    }

    public boolean validateData() {
        if ("".equals(txtUsername.getText())) {
            JOptionPane.showMessageDialog(this, "Please enter Username");
            return false;
        }
        if (txtPassword.getText().length() < 9) {
            JOptionPane.showMessageDialog(this, "Password is at least 6 characters");
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        new LoginForm().setVisible(true);
    }
}
