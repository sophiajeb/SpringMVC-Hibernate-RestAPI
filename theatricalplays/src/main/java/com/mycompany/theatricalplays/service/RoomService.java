/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.theatricalplays.service;

import com.mycompany.theatricalplays.model.Room;
import java.util.List;

/**
 *
 * @author sophi
 */
public interface RoomService {

    List<Room> findAllRooms();

    Room findById(int id);

    void saveRoom(Room room);

    void updateRoom(Room room);

    void deleteRoomById(int id);
}
