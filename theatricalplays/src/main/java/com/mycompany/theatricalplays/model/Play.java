/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.theatricalplays.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author sophi
 */
@Entity
@Table(name = "play")

public class Play implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int play_id;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "start_date", nullable = false)
    private String start_date;

    @Column(name = "end_date", nullable = false)
    private String end_date;

    @Column(name = "room_no_seat")
    private int room_no_seat;

    /* ---------------- Getters and Setters -----------------------------------*/
    public int getPlay_id() {
        return play_id;
    }

    public void setPlay_id(int play_id) {
        this.play_id = play_id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public int getRoom_no_seat() {
        return room_no_seat;
    }

    public void setRoom_no_seat(int room_no_seat) {
        this.room_no_seat = room_no_seat;
    }

    @Override
    public String toString() {
        return "Play{" + "play_id=" + play_id + ", code=" + code + ", title=" + title + ", description=" + description + ", start_date=" + start_date + ", end_date=" + end_date + ", room_no_seat=" + room_no_seat + '}';
    }

}
