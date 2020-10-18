/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.theatricalplays.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author sophi
 */
@Entity
@Table(name = "rooms")
public class Room  implements Serializable {

    
    @Id
    @Column(name = "id")
    private int id;
    
    @Column(name = "seat_id")
    private String seat_id;
    
    @Column(name = "room_no")
    private String room_no;
    
     @Column(name = "room_no_seat")
    private String room_no_seat = seat_id + " - " + room_no;
    
    
    

//    ----------- Getters and Setters ------------------------------------------------------

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoom_no_seat() {
        return room_no_seat;
    }

    public void setRoom_no_seat(String room_no_seat) {
        this.room_no_seat = room_no_seat;
    }

    public String getSeat_id() {
        return seat_id;
    }

    public void setSeat_id(String seat_id) {
        this.seat_id = seat_id;
    }

    public String getRoom_no() {
        return room_no;
    }

    public void setRoom_no(String room_no) {
        this.room_no = room_no;
    }

    @Override
    public String toString() {
        return "Room{" + "id=" + id + ", room_no_seat=" + room_no_seat + ", seat_id=" + seat_id + ", room_no=" + room_no + '}';
    }

 
}