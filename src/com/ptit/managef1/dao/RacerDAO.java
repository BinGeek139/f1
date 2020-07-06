/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ptit.managef1.dao;

import com.ptit.managef1.model.Racer;
import com.ptit.managef1.model.RacingTeam;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ngocq
 */
public class RacerDAO extends DAO{
    public List<Racer> findRacerForTeam(RacingTeam team){
        List<Racer> racers =new ArrayList<Racer>();
        String sql="select id,name from tblRacer where id_racing_team= ?  ORDER BY name ASC";
        try {
            PreparedStatement ps=  con.prepareStatement(sql);
            ps.setInt(1,team.getId());
            ResultSet resultSet=ps.executeQuery();
            while (resultSet.next()) {                
                Racer racer=new Racer();
                racer.setId(resultSet.getInt(1));
                racer.setName(resultSet.getString(2));
                racers.add(racer);
            }
            
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return racers;
    }
//    public static void main(String[] args) {
//        RacingTeam racingTeam=new RacingTeam();
//        racingTeam.setId(10);
//        RacerDAO racerDAO=new RacerDAO();
//        racerDAO.findRacerForTeam(racingTeam).forEach((Racer r) -> System.out.println(r.getName()));
//    }
         
}
