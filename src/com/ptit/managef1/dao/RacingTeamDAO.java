/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ptit.managef1.dao;

import static com.ptit.managef1.dao.DAO.con;
import com.ptit.managef1.model.RacingTeam;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ngocq
 */
public class RacingTeamDAO extends DAO {

    public List<RacingTeam> findAllRacingTeam() {
        List<RacingTeam> racingTeams = new ArrayList<RacingTeam>();
        String sql = "SELECT id,name FROM tblRacingTeam ORDER BY name ASC";
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                RacingTeam racingTeam=new RacingTeam();
                racingTeam.setId(rs.getInt(1));
                racingTeam.setName(rs.getString(2));
                racingTeams.add(racingTeam);
                
            }
			
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return racingTeams;
    }
//    public static void main(String[] args) {
//        RacingTeamDAO dAO=new RacingTeamDAO();
//        List<RacingTeam> list=dAO.findAllRacingTeam();
//        list.forEach((RacingTeam rt) -> System.out.println(rt.getName()));
//    }
}
