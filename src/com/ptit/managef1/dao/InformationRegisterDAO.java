/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ptit.managef1.dao;

import com.ptit.managef1.model.InformationRegister;
import com.ptit.managef1.model.Race;
import com.ptit.managef1.model.Racer;
import com.ptit.managef1.model.RacingTeam;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ngocq
 */
public class InformationRegisterDAO extends DAO {

    public boolean register(List<InformationRegister> informationRegisters){
        boolean result = false;
        String sqlRegister = "INSERT INTO tblInformationRegister VALUE(?,?,?,?)";
        try {
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement(sqlRegister);
            for (InformationRegister informationRegister : informationRegisters) {
                System.out.println();
                ps.setInt(1, informationRegister.getRacer().getId());
                ps.setInt(2, informationRegister.getRacingTeam().getId());
                ps.setInt(3, informationRegister.getRace().getId());
                ps.setDate(4, informationRegister.getRegistrationDate());
                result = ps.execute();
            }
            con.commit();
            result = true;
        }
        catch (Exception e) {
           
            e.printStackTrace();
            try {
                con.rollback();
                con.setAutoCommit(true);
            } catch (SQLException ex) {
                e.printStackTrace();
            }
           
            
        } finally {
                
            return result;
        }
    }
//
//    public static void main(String[] args) {
//        Race race = new Race();
//        Racer racer1 = new Racer();
//        Racer racer2 = new Racer();
//        RacingTeam racingTeam = new RacingTeam();
//        race.setId(2);
//        racingTeam.setId(1);
//        racer1.setId(10);
//        racer2.setId(3);
//        List<InformationRegister> informationRegisters = new ArrayList<>();
//        Date date = new Date(System.currentTimeMillis());
//        informationRegisters.add(new InformationRegister(race, racingTeam, racer1, date));
//        informationRegisters.add(new InformationRegister(race, racingTeam, racer2, date));
//        InformationRegisterDAO aO = new InformationRegisterDAO();
//        boolean result = aO.register(informationRegisters);
//        System.out.println(result);
//    }
}
