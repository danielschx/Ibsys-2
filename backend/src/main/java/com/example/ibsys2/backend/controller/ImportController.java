package com.example.ibsys2.backend.controller;

import java.util.List;
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
        try {
            // Null check for requestBody
            if (requestBody != null) {
                System.out.println(requestBody);
                importHandler.parseBody( (Map<String, Object>) requestBody);
                return new ResponseEntity<>(HttpStatus.OK);
                }
                else {
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                }
        } catch (Exception e) {
            // Add proper error handling (log the error, return a specific HTTP status code, etc.)
            e.printStackTrace(); // Log the exception or use a logging framework
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
