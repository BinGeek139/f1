/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ptit.managef1.view.user;

import com.ptit.managef1.model.User;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author ngocq
 */
public class ManagerHomeForm extends JFrame implements ActionListener {

    private JButton btnManagerSalary;
    private JButton btnManagerRacingTeam;
    private JButton btnManagerRacer;
    private JButton btnManagerRace;
    private JButton btnManagerTicket;
    private JButton btnRegistrationForRace;
    private User user;

    public ManagerHomeForm(User user) {
        super("Manager Home");
        this.user = user;
        JPanel listPane = new JPanel();
        listPane.setLayout(new BoxLayout(listPane, BoxLayout.Y_AXIS));

        JPanel lblPane = new JPanel();
        lblPane.setLayout(new BoxLayout(lblPane, BoxLayout.X_AXIS));
        lblPane.add(Box.createRigidArea(new Dimension(350, 0)));
        JLabel lblUser = new JLabel("Đăng nhập bởi : " + user.getFullName());
        lblUser.setAlignmentX(Component.RIGHT_ALIGNMENT);

        lblPane.add(lblUser);
        listPane.add(lblPane);

        listPane.add(Box.createRigidArea(new Dimension(0, 30)));
        JLabel lblHome = new JLabel("Trang chủ Quản Lý");
        lblHome.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblHome.setFont(new Font(Font.SERIF, Font.BOLD, 30));
        lblHome.setForeground(Color.BLUE);
        listPane.add(lblHome);

        Panel pnButtons = new Panel();
        GridLayout gridLayout = new GridLayout(6, 1);
        gridLayout.setVgap(10);
        pnButtons.setLayout(gridLayout);

        listPane.add(Box.createRigidArea(new Dimension(0, 30)));
        btnManagerSalary = new JButton("Quản lý Lương");
        btnManagerSalary.addActionListener(this);
        pnButtons.add(btnManagerSalary);

        btnManagerTicket = new JButton("Quản lý vé");
        btnManagerTicket.addActionListener(this);
        pnButtons.add(btnManagerTicket);

        btnManagerRacingTeam = new JButton("Quản lý đội đua");
        btnManagerRacingTeam.addActionListener(this);
        pnButtons.add(btnManagerRacingTeam);

        btnManagerRace = new JButton("Quản lý chặng đua");
        btnManagerRace.addActionListener(this);
        pnButtons.add(btnManagerRace);

        btnManagerRacer = new JButton("Quản lý tay đua");
        btnManagerRace.addActionListener(this);
        pnButtons.add(btnManagerRace);

        btnRegistrationForRace = new JButton("Đăng kí thi đấu");
        btnRegistrationForRace.addActionListener(this);
        pnButtons.add(btnRegistrationForRace);

        JPanel listSelectLine = new JPanel();
        listSelectLine.setLayout(new BoxLayout(listSelectLine, BoxLayout.X_AXIS));
        listSelectLine.add(Box.createRigidArea(new Dimension(100, 0)));
        listSelectLine.add(pnButtons);
        listSelectLine.add(Box.createRigidArea(new Dimension(100, 0)));

        listPane.add(listSelectLine);
        this.setSize(600, 500);
        this.setLocationRelativeTo(null);
        this.add(listPane);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            if (((JButton) e.getSource()).equals(btnRegistrationForRace)) {
                new RegistrationForRaceForm(user).setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Feature is under construction");
            }
        }
    }

    public static void main(String[] args) {
        new ManagerHomeForm(new User(500, null, null, "Ngọc Quang", null, null, null, null, null)).setVisible((true));
    }

}
