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
public class InformationRegister {
    private Race race;
    private RacingTeam racingTeam;
    private Racer racer;
    private Date registrationDate;

    public InformationRegister(Race race, RacingTeam racingTeam, Racer racer, Date registrationDate) {
        this.race = race;
        this.racingTeam = racingTeam;
        this.racer = racer;
        this.registrationDate = registrationDate;
    }

    

    
    public InformationRegister() {
    }
    

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public RacingTeam getRacingTeam() {
        return racingTeam;
    }

    public void setRacingTeam(RacingTeam racingTeam) {
        this.racingTeam = racingTeam;
    }

    public Racer getRacer() {
        return racer;
    }

    public void setRacer(Racer racer) {
        this.racer = racer;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
    
}
