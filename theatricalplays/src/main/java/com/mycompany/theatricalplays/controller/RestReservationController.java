/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.theatricalplays.controller;


import com.mycompany.theatricalplays.model.Reservation;
import com.mycompany.theatricalplays.service.ReservationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author sophi
 */
@CrossOrigin
@RestController
@RequestMapping("/api")
public class RestReservationController {
    
    
    @Autowired
    ReservationService reservationService;  //Service which will do all data retrieval/manipulation work

    //-------------------Retrieve All Reservations--------------------------------------------------------
    // /theatricalplays/api/reservations
    @RequestMapping(value = "/reservations", method = RequestMethod.GET)
    public ResponseEntity<List<Reservation>> listAllReservations() {
        List<Reservation> reservations = reservationService.findAllReservations();
        if (reservations.isEmpty()) {
            return new ResponseEntity<List<Reservation>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Reservation>>(reservations, HttpStatus.OK);
    }

    //-------------------Retrieve Single Reservation--------------------------------------------------------
    // /theatricalplays/api/reservation/{id}
    @RequestMapping(value = "/reservation/{reservation_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Reservation> getReservation(@PathVariable("reservation_id") int reservation_id) {
        System.out.println("Fetching Reservation with id " + reservation_id);
        Reservation reservation = reservationService.findById(reservation_id);
        if (reservation == null) {
            System.out.println("Reservation with id " + reservation_id + " not found");
            return new ResponseEntity<Reservation>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Reservation>(reservation, HttpStatus.OK);
    }
    
    //-------------------Create a Reservation--------------------------------------------------------
    /* 
    /theatricalplays/api/reservation
    {
      "user_id": 8,
      "play_id": 4,
      "room_no_seat": 236
    }
    */
    @RequestMapping(value = "/reservation", method = RequestMethod.POST)
    public ResponseEntity<Void> createReservation(@RequestBody Reservation reservation, UriComponentsBuilder ucBuilder) {
        
        System.out.println("Creating Reservation " + reservation.getReservation_id());

        if (reservationService.findById(reservation.getReservation_id()) != null) {
            System.out.println("A Reservation with id " + reservation.getReservation_id() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

       reservationService.saveReservations(reservation);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/reservation/{reservation_id}").buildAndExpand(reservation.getReservation_id()).toUri());
        
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

   
    //------------------- Delete a Reservation --------------------------------------------------------
    // /theatricalplays/api/reservation/{id}
    @RequestMapping(value = "/reservation/{reservation_id}", method = RequestMethod.DELETE)
    public ResponseEntity<Reservation> deleteReservation(@PathVariable("reservation_id") int reservation_id) {
        System.out.println("Fetching & Deleting Reservation with id " + reservation_id);

        Reservation reservation = reservationService.findById(reservation_id);
        if (reservation == null) {
            System.out.println("Unable to delete. Reservation with id " + reservation_id + " not found");
            return new ResponseEntity<Reservation>(HttpStatus.NOT_FOUND);
        }

        reservationService.deleteReservationById(reservation_id);
        return new ResponseEntity<Reservation>(HttpStatus.NO_CONTENT);
    }
    
    
}
