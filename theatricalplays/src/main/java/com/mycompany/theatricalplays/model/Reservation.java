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
@Table(name = "reservations")
public class Reservation implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reservation_id;

    @Column(name = "user_id", nullable = false)
    private int user_id;
    
    @Column(name = "play_id", nullable = false)
    private int play_id;
    
    @Column(name = "room_no_seat", nullable = false)
    private int room_no_seat;
    
    
    
    //---------------- Getters and Setters ---------------------------------------

    public int getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(int reservation_id) {
        this.reservation_id = reservation_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getPlay_id() {
        return play_id;
    }

    public void setPlay_id(int play_id) {
        this.play_id = play_id;
    }

    public int getRoom_no_seat() {
        return room_no_seat;
    }

    public void setRoom_no_seat(int room_no_seat) {
        this.room_no_seat = room_no_seat;
    }

    @Override
    public String toString() {
        return "Reservations{" + "reservation_id=" + reservation_id + ", user_id=" + user_id + ", play_id=" + play_id + ", room_no_seat=" + room_no_seat + '}';
    }
    
    
    
    
    
}
