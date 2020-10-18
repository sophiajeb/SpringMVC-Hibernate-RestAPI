/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.theatricalplays.dao;


import com.mycompany.theatricalplays.model.Reservation;
import java.util.List;

/**
 *
 * @author sophi
 */
public interface ReservationDao {
    
    Reservation findById(int reservation_id);

    List<Reservation> findAllReservations();

    void saveReservation(Reservation Reservation);

    void deleteReservationById(int reservation_id);
    
}
