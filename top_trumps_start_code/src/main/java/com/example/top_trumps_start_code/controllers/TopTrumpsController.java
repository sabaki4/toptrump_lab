package com.example.top_trumps_start_code.controllers;

import com.example.top_trumps_start_code.models.Card;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/games")
public class TopTrumpsController {

    @PostMapping
    public ResponseEntity<String> processCard(@RequestBody Card cards){
        return new ResponseEntity<>("Cards Accepted", HttpStatus.OK);
    }

}





