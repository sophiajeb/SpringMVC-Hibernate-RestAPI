/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.theatricalplays.dao;

import com.mycompany.theatricalplays.model.Reservation;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sophi
 */

@Repository("ReservationDao")
public class ReservationDaoImpl  extends AbstractDao<Integer, Reservation> implements ReservationDao {
    
     public Reservation findById(int reservation_id) {
        return getByKey(reservation_id);
    }

    public void saveReservation(Reservation reservation) {
        persist(reservation);
    }

    @SuppressWarnings("unchecked")
    public List<Reservation> findAllReservations() {
        Criteria criteria = createEntityCriteria();
        return (List<Reservation>) criteria.list();
    }

    public void deleteReservationById(int reservation_id) {
        Query query = getSession().createSQLQuery("delete from Reservations where reservation_id = :reservation_id");
        query.setInteger("reservation_id", reservation_id);
        query.executeUpdate();
    }
    
}
