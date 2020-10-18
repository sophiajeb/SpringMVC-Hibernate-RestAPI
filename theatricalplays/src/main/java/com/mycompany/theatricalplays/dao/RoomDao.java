/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.theatricalplays.dao;

import com.mycompany.theatricalplays.model.Room;
import java.util.List;

/**
 *
 * @author sophi
 */
public interface RoomDao {

    Room findById(int id);


    List<Room> findAllRooms();

    void saveRoom(Room room);

    void deleteRoomById(int id);
}
