/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ptit.managef1.dao;

import com.ptit.managef1.model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ngocq
 */
public class UserDAO extends DAO{
    
    public boolean checkLogin(User user) {
		boolean result = false;
		String sql = "SELECT full_name, position FROM tblUser WHERE username = ? AND password = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				user.setFullName(rs.getString("full_name"));
				user.setPosition(rs.getString("position"));
				result = true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
//    public static void main(String[] args) {
//        User user=new User();
//        user.setUsername("quang123");
//        user.setPassword("123456789");
//        UserDAO dao=new UserDAO();
//        
//        System.out.println(dao.checkLogin(user));
//        System.out.println(user.getFullName());
//        System.out.println(user.getPosition());
//    }
            
}
