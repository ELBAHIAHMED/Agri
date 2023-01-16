package com.example.agri_back.contoller;

import com.example.agri_back.dto.CooperativeDto;
import com.example.agri_back.services.CooperativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/cooperative")
public class CooperativeController {
    @Autowired
    CooperativeService cooperativeService ;

    @PostMapping("create")
    private ResponseEntity<CooperativeDto> createCooprative(@RequestBody CooperativeDto cooperativeDto){
        CooperativeDto cooperativeDto1 = cooperativeService.CreateCooperative(cooperativeDto);
        return new ResponseEntity<>(cooperativeDto1, HttpStatus.ACCEPTED);
    }

    @GetMapping("getAll")
    private ResponseEntity<List<CooperativeDto>> getAllCoop(){
        return new ResponseEntity<>(cooperativeService.allCooperatives(),HttpStatus.ACCEPTED);
    }

}
