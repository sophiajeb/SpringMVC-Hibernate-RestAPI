/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.theatricalplays.dao;

import com.mycompany.theatricalplays.model.Play;
import java.util.List;

/**
 *
 * @author sophi
 */
public interface PlayDao {

    Play findById(int play_id);

    List<Play> findAllPlays();

    void savePlay(Play play);

    void deletePlayById(int play_id);

}
