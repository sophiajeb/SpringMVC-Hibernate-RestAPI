/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.theatricalplays.service;

import com.mycompany.theatricalplays.dao.ReservationDao;
import com.mycompany.theatricalplays.model.EmailMessage;
import com.mycompany.theatricalplays.model.Reservation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sophi
 */

@Service("ReservationService")
@Transactional
public class ReservationServiceImpl implements ReservationService {
    
    
    @Autowired
    private ReservationDao dao;
    
    
      public Reservation findById(int reservation_id) {
        return dao.findById(reservation_id);
    }

    public List<Reservation> findAllReservations() {
        return dao.findAllReservations();
    }

    public void saveReservations(Reservation reservation) {
        String password = "PerKal22$";
        EmailService emailService;
        EmailMessage msg = new EmailMessage("theatricalplays@gmail.com", 
                                            "sophiajeb93@gmail.com", 
                                            "Your Reservation at Theatrical Plays", 
                                            "Your reservation with Id, " + reservation.getReservation_id() + " is booked!\n\nEnjoy your play!", 
                                            null);
        emailService = new EmailService(msg, password);
        dao.saveReservation(reservation);
        emailService.sendEmail();
    }

    public void deleteReservationById(int reservation_id) {
        dao.deleteReservationById(reservation_id);
    }

    public void updateReservations(Reservation reservation) {
        Reservation entity = dao.findById(reservation.getReservation_id());
        if (entity != null) {
            entity.setUser_id(reservation.hashCode());
            entity.setPlay_id(reservation.getPlay_id());
            entity.setRoom_no_seat(reservation.getRoom_no_seat());
            
        }
    }
}
