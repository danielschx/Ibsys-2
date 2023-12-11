package com.example.ibsys2.backend.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ibsys2.backend.Handler.ImportHandler;

/**
 * RestController für den XML-Import
 */

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000")
public class ImportController {
    
    @Autowired
    private ImportHandler importHandler;

    @PostMapping("/import")
    public ResponseEntity parseJson(@RequestBody Map<String, Object> requestBody){
        try{
            System.out.println(requestBody);
            importHandler.parseBody((Map<String, Object>)requestBody.get("results")); 
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
