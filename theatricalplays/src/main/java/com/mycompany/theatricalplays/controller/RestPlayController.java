/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.theatricalplays.controller;

import com.mycompany.theatricalplays.model.Play;
import com.mycompany.theatricalplays.service.PlayService;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

/* based on this example http://websystique.com/springmvc/spring-mvc-4-restful-web-services-crud-example-resttemplate/ */
/**
 *
 * @author mac
 */
@CrossOrigin
@RestController
@RequestMapping("/api")
public class RestPlayController {

    @Autowired
    PlayService playService;  //Service which will do all data retrieval/manipulation workˆ

    //-------------------Retrieve All Plays--------------------------------------------------------
    // /theatricalplays/api/plays
    @RequestMapping(value = "/plays", method = RequestMethod.GET)
    public ResponseEntity<List<Play>> listAllPlays() {
        List<Play> plays = playService.findAllPlays();
        if (plays.isEmpty()) {
            return new ResponseEntity<List<Play>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Play>>(plays, HttpStatus.OK);
    }

    //-------------------Retrieve Single Play--------------------------------------------------------
    // /theatricalplays/api/play/{id}
    @RequestMapping(value = "/play/{play_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Play> getPlay(@PathVariable("play_id") int play_id) {
        System.out.println("Fetching Play with play_id " + play_id);
        Play play = playService.findById(play_id);
        if (play == null) {
            System.out.println("Play with id " + play_id + " not found");
            return new ResponseEntity<Play>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Play>(play, HttpStatus.OK);
    }

    //-------------------Create a Play--------------------------------------------------------
    /* 
    /theatricalplays/api/play
    {
        "code": "34",
        "title": "test2",
        "description": "test2",
        "start_date": "28/02/2020",
        "end_date": "29/03/2020",
        "room_no_seat": 358
    }
    */
    @RequestMapping(value = "/play", method = RequestMethod.POST)
    public ResponseEntity<Void> createPlay(@RequestBody Play play, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Play " + play.getTitle());

        if (playService.findById(play.getPlay_id()) != null) {
            System.out.println("A Play with title " + play.getTitle() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

        playService.savePlay(play);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/play/{play_id}").buildAndExpand(play.getPlay_id()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //------------------- Update a Play --------------------------------------------------------
    // /theatricalplays/api/play/{id}
    @RequestMapping(value = "/play/{play_id}", method = RequestMethod.PUT)
    public ResponseEntity<Play> updatePlay(@PathVariable("play_id") int play_id, @RequestBody Play play) {
        System.out.println("Updating Play " + play_id);

        Play currentPlay = playService.findById(play_id);

        if (currentPlay == null) {
            System.out.println("Play with id " + play_id + " not found");
            return new ResponseEntity<Play>(HttpStatus.NOT_FOUND);
        }

        currentPlay.setCode(play.getCode());
        currentPlay.setTitle(play.getTitle());
        currentPlay.setDescription(play.getDescription());
        currentPlay.setStart_date(play.getStart_date());
        currentPlay.setEnd_date(play.getEnd_date());
        currentPlay.setRoom_no_seat(play.getRoom_no_seat());

        playService.updatePlay(currentPlay);
        return new ResponseEntity<Play>(currentPlay, HttpStatus.OK);
    }

    //------------------- Delete a Play --------------------------------------------------------
    // /theatricalplays/api/play/{id}
    @RequestMapping(value = "/play/{play_id}", method = RequestMethod.DELETE)
    public ResponseEntity<Play> deletePlay(@PathVariable("play_id") int play_id) {
        System.out.println("Fetching & Deleting Play with Play " + play_id);

        Play play = playService.findById(play_id);
        if (play == null) {
            System.out.println("Unable to delete. Play with id " + play_id + " not found");
            return new ResponseEntity<Play>(HttpStatus.NOT_FOUND);
        }

        playService.deletePlayById(play_id);
        return new ResponseEntity<Play>(HttpStatus.NO_CONTENT);
    }
}
