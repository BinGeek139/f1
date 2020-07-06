/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ptit.managef1.dao;

import static com.ptit.managef1.dao.DAO.con;
import com.ptit.managef1.model.Race;
import com.ptit.managef1.model.RacingTeam;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ngocq
 */
public class RaceDAO  extends DAO{
    public List<Race> findAllRace(){
        List<Race> races=new ArrayList<Race>();
        String sqlFindRace = "SELECT id,name FROM tblRace ORDER BY name ASC";
                try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sqlFindRace);
            while (rs.next()) {
                Race race =new Race();
                race.setId(rs.getInt(1));
                race.setName(rs.getString(2));
                races.add(race);
                
            }
			
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return races;
    }
//    public static void main(String[] args) {
//        RaceDAO aO= new RaceDAO();
//        aO.findAllRace().forEach((Race race) -> System.out.println(race.getName()));
//    }
          
        
}
