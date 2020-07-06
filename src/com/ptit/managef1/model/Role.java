/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ptit.managef1.model;

/**
 *
 * @author ngocq
 */
public enum Role {
    MANAGER("manager"),ADMIN("admin"),STAFF_INPUT("staff input"),CLIENT("client");
    private String position;

    private Role(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }
    
}
