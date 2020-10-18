/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.theatricalplays.dao;

import com.mycompany.theatricalplays.model.Play;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sophi
 */
@Repository("PlayDao")
public class PlayDaoImpl extends AbstractDao<Integer, Play> implements PlayDao {

    public Play findById(int play_id) {
        return getByKey(play_id);
    }

    public void savePlay(Play play) {
        persist(play);
    }

    @SuppressWarnings("unchecked")
    public List<Play> findAllPlays() {
        Criteria criteria = createEntityCriteria();
        return (List<Play>) criteria.list();
    }

    public void deletePlayById(int play_id) {
        Query query = getSession().createSQLQuery("delete from Play where play_id = :play_id");
        query.setInteger("play_id", play_id);
        query.executeUpdate();
    }

}
