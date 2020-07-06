/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ptit.managef1.model;

import java.sql.Date;

/**
 *
 * @author ngocq
 */
public class Racer {
    private Integer id;
    private String name;
    private Date date;
    private String nationality;
    private RacingTeam racingTeam;

    public Racer(Integer id, String name, Date date, String nationality, RacingTeam racingTeam) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.nationality = nationality;
        this.racingTeam = racingTeam;
    }

    public Racer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public RacingTeam getRacingTeam() {
        return racingTeam;
    }

    public void setRacingTeam(RacingTeam racingTeam) {
        this.racingTeam = racingTeam;
    }

    @Override
    public String toString() {
        return this.name;
    }
    
    
}
