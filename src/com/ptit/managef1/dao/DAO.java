/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ptit.managef1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ngocq
 */
public class DAO {
    public static Connection con;
	
	public DAO(){
		if(con == null){
			String dbUrl = "jdbc:mysql://localhost:3306/f1";
		

			try {
                            con = DriverManager.getConnection (dbUrl, "root", "646278264");
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
        
}
