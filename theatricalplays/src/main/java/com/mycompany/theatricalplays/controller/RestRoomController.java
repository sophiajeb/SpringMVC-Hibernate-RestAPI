/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.theatricalplays.controller;

import com.mycompany.theatricalplays.model.Room;
import com.mycompany.theatricalplays.service.RoomService;
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
public class RestRoomController {

    @Autowired
    RoomService roomService;  //Service which will do all data retrieval/manipulation work

    //-------------------Retrieve All Rooms--------------------------------------------------------
    // /theatricalplays/api/rooms
    @RequestMapping(value = "/rooms", method = RequestMethod.GET)
    public ResponseEntity<List<Room>> listAllPlays() {
        List<Room> plays = roomService.findAllRooms();
        if (plays.isEmpty()) {
            return new ResponseEntity<List<Room>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Room>>(plays, HttpStatus.OK);
    }

    //-------------------Retrieve Single Room--------------------------------------------------------
    // /theatricalplays/api/room/{room_no_seat}
    @RequestMapping(value = "/room/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Room> getPlay(@PathVariable("room_no_seat") int id) {
        System.out.println("Fetching Room with id " + id);
        Room room = roomService.findById(id);
        if (room == null) {
            System.out.println("Room with id " + id + " not found");
            return new ResponseEntity<Room>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Room>(room, HttpStatus.OK);
    }

    //-------------------Create a Room--------------------------------------------------------
    // /theatricalplays/api/room
    /*
       {
        "seat_id": 38,
        "room_no": 5,
        "room_no_seat": 385
    }
    
    */
    @RequestMapping(value = "/room", method = RequestMethod.POST)
    public ResponseEntity<Void> createRoom(@RequestBody Room room, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Room " + room.getRoom_no_seat());

        roomService.saveRoom(room);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/room/{id}").buildAndExpand(room.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //------------------- Update a Room --------------------------------------------------------
    // /theatricalplays/api/room/{room_no_seat}
    @RequestMapping(value = "/room/{String}", method = RequestMethod.PUT)
    public ResponseEntity<Room> updateRoom(@PathVariable("String") int id, @RequestBody Room room) {
        System.out.println("Updating Room " + id);

        Room currentRoom = roomService.findById(id);

        if (currentRoom == null) {
            System.out.println("Room with id " + id + " not found");
            return new ResponseEntity<Room>(HttpStatus.NOT_FOUND);
        }

        currentRoom.setRoom_no_seat(room.getRoom_no_seat());
        currentRoom.setSeat_id(room.getSeat_id());
        currentRoom.setRoom_no(room.getRoom_no());

        roomService.updateRoom(currentRoom);
        return new ResponseEntity<Room>(currentRoom, HttpStatus.OK);
    }

    //------------------- Delete a Room --------------------------------------------------------
     // /theatricalplays/api/room/{room_no_seat}
    @RequestMapping(value = "/room/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Room> deleteRoom(@PathVariable("id") int id) {
        System.out.println("Fetching & Deleting Room with id " + id);

        Room room = roomService.findById(id);
        if (room == null) {
            System.out.println("Unable to delete. Room with id " + id + " not found");
            return new ResponseEntity<Room>(HttpStatus.NOT_FOUND);
        }

        roomService.deleteRoomById(id);
        return new ResponseEntity<Room>(HttpStatus.NO_CONTENT);
    }

}
