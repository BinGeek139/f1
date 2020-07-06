/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ptit.managef1.view.user;

import com.ptit.managef1.dao.RaceDAO;
import com.ptit.managef1.dao.RacingTeamDAO;
import com.ptit.managef1.model.InformationRegister;
import com.ptit.managef1.model.Race;
import com.ptit.managef1.model.RacingTeam;
import com.ptit.managef1.model.User;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import sun.applet.Main;

/**
 *
 * @author ngocq
 */
public class RegistrationForRaceForm extends JFrame implements ActionListener {
    private User user;
    private JComboBox comRace;
    private JComboBox comRacingTeam;
    private  JButton subConFirm;


    public RegistrationForRaceForm(User user) {
        super("RegistrationForRaceForm");
        this.user = user;
        
      //intit comRace
         comRace=new JComboBox(new RaceDAO().findAllRace().toArray());
        
      //init comRacingTeam
    
        comRacingTeam=new JComboBox(new RacingTeamDAO().findAllRacingTeam().toArray());
        
        //init button confirm 
        subConFirm=new JButton("Xác nhận");
        subConFirm.addActionListener(this);
        
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
        
        JLabel lblHome = new JLabel("Đăng kí thi đấu");
        lblHome.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblHome.setFont(new Font(Font.SERIF, Font.BOLD, 30));
        lblHome.setForeground(Color.BLUE);
        listPane.add(lblHome);
        
        listPane.add(Box.createRigidArea(new Dimension(0, 40)));
        
       
        JPanel pnSelect=new JPanel();
        
        GridLayout gridLayout=new GridLayout(2,2);
        gridLayout.setVgap(30);
        pnSelect.setLayout(gridLayout);
        

        pnSelect.add(new JLabel("Chặng đua : "));
        
        pnSelect.add(comRace);
       
        
        pnSelect.add(new JLabel("Đội Đua : "));
        pnSelect.add(comRacingTeam);
        
         JPanel listSelect=new JPanel();
        listSelect.setLayout(new BoxLayout(listSelect, BoxLayout.X_AXIS));
        listSelect.add(Box.createRigidArea(new Dimension(100, 0)));
        listSelect.add(pnSelect);
        listSelect.add(Box.createRigidArea(new Dimension(75, 0)));
        listPane.add(listSelect);
        
 
        listPane.add(Box.createRigidArea(new Dimension(0, 30)));
        listPane.add(subConFirm);
         listPane.add(Box.createRigidArea(new Dimension(0, 30)));
        this.add(listPane);
        this.setSize(600,400);
        this.setLocationRelativeTo(null);
    }
  
    
    @Override
    public void actionPerformed(ActionEvent e) {
       if((e.getSource() instanceof JButton ) && ((JButton)e.getSource()).equals(subConFirm)){
           InformationRegister informationRegister=new InformationRegister();
           informationRegister.setRace((Race)comRace.getSelectedItem());
           informationRegister.setRacingTeam((RacingTeam)comRacingTeam.getSelectedItem());
           new SelectRacerForm(user, informationRegister).setVisible(true);
           this.dispose();
           
       }
    }
    public static void main(String[] args) {
           new RegistrationForRaceForm(new User(500, null, null, "Ngọc Quang", null, null, null, null, null)).setVisible((true));
    }
    
}
