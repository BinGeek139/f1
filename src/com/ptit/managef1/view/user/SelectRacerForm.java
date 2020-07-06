/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ptit.managef1.view.user;

import com.ptit.managef1.dao.InformationRegisterDAO;
import com.ptit.managef1.dao.RacerDAO;
import com.ptit.managef1.model.InformationRegister;
import com.ptit.managef1.model.Race;
import com.ptit.managef1.model.Racer;
import com.ptit.managef1.model.User;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author ngocq
 */
public class SelectRacerForm extends JFrame implements ActionListener {

    private User user;
    private InformationRegister informationRegister;
    private JComboBox comRacer1;
    private JComboBox comRacer2;
    private JButton btnConfirm;

    public SelectRacerForm(User user, InformationRegister informationRegister) {
        this.user = user;
        this.informationRegister = informationRegister;

        Object[] races = new RacerDAO().findRacerForTeam(informationRegister.getRacingTeam()).toArray();
        comRacer1 = new JComboBox(races);
        comRacer2 = new JComboBox(races);
        comRacer2.setSelectedIndex(1);
        btnConfirm = new JButton("Xác nhận");

        JPanel listPane = new JPanel();
        listPane.setLayout(new BoxLayout(listPane, BoxLayout.Y_AXIS));

        listPane.add(Box.createRigidArea(new Dimension(0, 10)));
        JPanel pnHeader = new JPanel();
        pnHeader.setLayout(new BoxLayout(pnHeader, BoxLayout.X_AXIS));
        pnHeader.add(Box.createRigidArea(new Dimension(300, 0)));
        JLabel lblUser = new JLabel("Đăng nhập bởi : " + user.getFullName());
        lblUser.setAlignmentX(Component.RIGHT_ALIGNMENT);
        pnHeader.add(lblUser);

        listPane.add(pnHeader);
        listPane.add(Box.createRigidArea(new Dimension(0, 40)));

        JLabel lblHome = new JLabel("Chọn Tay đua");
        lblHome.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblHome.setFont(new Font(Font.SERIF, Font.BOLD, 30));
        lblHome.setForeground(Color.BLUE);
        listPane.add(lblHome);

        listPane.add(Box.createRigidArea(new Dimension(0, 40)));

        JPanel pnSelect = new JPanel();
        GridLayout gridLayout = new GridLayout(4, 4);
        gridLayout.setVgap(20);
        pnSelect.setLayout(gridLayout);
        pnSelect.add(new JLabel("Chặng đua: "));
        pnSelect.add(new JLabel(informationRegister.getRace().getName()));

        pnSelect.add(new JLabel("Đội đua: "));
        pnSelect.add(new JLabel(informationRegister.getRacingTeam().getName()));
        pnSelect.add(new JLabel("Tay Đua 1: "));
        pnSelect.add(comRacer1);
        pnSelect.add(new JLabel("Tay Đua 2"));
        pnSelect.add(comRacer2);

        JPanel listSelect = new JPanel();
        listSelect.setLayout(new BoxLayout(listSelect, BoxLayout.X_AXIS));
        listSelect.add(Box.createRigidArea(new Dimension(100, 0)));
        listSelect.add(pnSelect);
        listSelect.add(Box.createRigidArea(new Dimension(75, 0)));
        listPane.add(listSelect);

        listPane.add(Box.createRigidArea(new Dimension(0, 40)));
        btnConfirm = new JButton("Xác nhận");
        btnConfirm.addActionListener(this);
        btnConfirm.setAlignmentX(Component.CENTER_ALIGNMENT);
        listPane.add(btnConfirm);
        listPane.add(Box.createRigidArea(new Dimension(0, 40)));
        this.add(listPane);
        this.setSize(600, 500);
        this.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ((e.getSource() instanceof JButton) && ((JButton) e.getSource()).equals(btnConfirm)) {
            if(comRacer1.getSelectedItem().equals(comRacer2.getSelectedItem())){
                JOptionPane.showMessageDialog(this, "2 Tay đua đăng kí trùng nhau");
                return;
            }
            List<InformationRegister> informationRegisters = new ArrayList<InformationRegister>();
            informationRegister.setRacer((Racer) comRacer1.getSelectedItem());
            Date date = new Date(System.currentTimeMillis());
            informationRegister.setRegistrationDate(date);
            informationRegisters.add(informationRegister);
            informationRegisters.add(new InformationRegister(informationRegister.getRace(), informationRegister.getRacingTeam(), (Racer) comRacer2.getSelectedItem(), date));
       
                boolean insert;
                insert = new InformationRegisterDAO().register(informationRegisters);
                if (insert) {
                    JOptionPane.showMessageDialog(this, "Đăng kí thành công");
                    new ManagerHomeForm(user).setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Đăng kí thất bại vui long chọn lại");
                }
            

        }
    }

}
