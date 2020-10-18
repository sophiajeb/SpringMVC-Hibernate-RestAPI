/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.theatricalplays.dao;

import com.mycompany.theatricalplays.model.Room;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sophi
 */
@Repository("RoomDao")
public class RoomDaoImpl extends AbstractDao<Integer, Room> implements RoomDao {

    public List<Room> findAllRooms() {
        Criteria criteria = createEntityCriteria();
        return (List<Room>) criteria.list();
    }

    public Room findById(int id) {
        return getByKey(id);
    }

    public void saveRoom(Room room) {
        persist(room);
    }

    public void deleteRoomById(int room_no_seat) {
        Query query = getSession().createSQLQuery("delete from Rooms where room_no_seat = :room_no_seat");
        query.setInteger("room_no_seat", room_no_seat);
        query.executeUpdate();
    }

}
