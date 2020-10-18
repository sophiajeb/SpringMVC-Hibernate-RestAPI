/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.theatricalplays.service;

import com.mycompany.theatricalplays.dao.RoomDao;
import com.mycompany.theatricalplays.model.Room;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sophi
 */
@Service("RoomService")
@Transactional
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomDao dao;

    public List<Room> findAllRooms() {
        return dao.findAllRooms();
    }

    public Room findById(int id) {
        return dao.findById(id);
    }

    public void saveRoom(Room room) {
        dao.saveRoom(room);
    }

    public void deleteRoomById(int room_no_seat) {
        dao.deleteRoomById(room_no_seat);
    }

    public void updateRoom(Room room) {
        Room entity = dao.findById(room.getId());
        if (entity != null) {
            entity.setRoom_no_seat(room.getRoom_no_seat());
            entity.setSeat_id(room.getSeat_id());
            entity.setRoom_no(room.getRoom_no());
        }
    }

}
