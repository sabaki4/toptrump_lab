package com.example.top_trumps_start_code.controllers;

import com.example.top_trumps_start_code.models.Card;
import com.example.top_trumps_start_code.services.TopTrumpsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/games")
public class TopTrumpsController {

    @Autowired
    TopTrumpsService topTrumpsService;

    @PostMapping
    public ResponseEntity<String> processCard(@RequestBody ArrayList<Card> cards){
        topTrumpsService = new TopTrumpsService(cards);
        String result = topTrumpsService.checkWinner();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}





