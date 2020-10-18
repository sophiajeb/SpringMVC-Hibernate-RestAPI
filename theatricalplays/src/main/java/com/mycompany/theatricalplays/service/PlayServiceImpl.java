/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.theatricalplays.service;

import com.mycompany.theatricalplays.dao.PlayDao;
import com.mycompany.theatricalplays.model.Play;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sophi
 */
@Service("PlayService")
@Transactional
public class PlayServiceImpl implements PlayService {

    @Autowired
    private PlayDao dao;

    public Play findById(int play_id) {
        return dao.findById(play_id);
    }

    public List<Play> findAllPlays() {
        return dao.findAllPlays();
    }

    public void savePlay(Play play) {
        dao.savePlay(play);
    }

    public void deletePlayById(int play_id) {
        dao.deletePlayById(play_id);
    }

    public void updatePlay(Play play) {
        Play entity = dao.findById(play.getPlay_id());
        if (entity != null) {
            entity.setCode(play.getCode());
            entity.setTitle(play.getTitle());
            entity.setDescription(play.getDescription());
            entity.setStart_date(play.getStart_date());
            entity.setEnd_date(play.getEnd_date());
            entity.setRoom_no_seat(play.getRoom_no_seat());
        }
    }

}
