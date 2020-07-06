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
public class Race {
    private Integer id;
    private String name;
    private String racecourse;
    private String place;
   

    public Race() {
    }

    public Race(Integer id, String name, String racecourse, String place) {
        this.id = id;
        this.name = name;
        this.racecourse = racecourse;
        this.place = place;
    }

    public String getRacecourse() {
        return racecourse;
    }

    public void setRacecourse(String racecourse) {
        this.racecourse = racecourse;
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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return this.name;
    }
    
    
}
