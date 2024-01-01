package com.example.ibsys2.backend.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.ibsys2.backend.Handler.ForecastHandler;
import com.example.ibsys2.backend.Handler.ImportHandler;
import com.example.ibsys2.backend.Handler.PlanningHandler;
import com.example.ibsys2.backend.controller.ResponseEntity.ForecastResponse;
import com.example.ibsys2.backend.controller.ResponseEntity.NewOrder;
import com.example.ibsys2.backend.controller.ResponseEntity.ProductionItem;
import com.example.ibsys2.backend.controller.ResponseEntity.WorkingTime;

/**
 * RestController für den XML-Import
 */

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000")
public class Controller {

    @Autowired
    private ImportHandler importHandler;
    @Autowired
    private ForecastHandler forecastHandler;
    @Autowired
    private PlanningHandler planningHandler;

    @PostMapping("/import")
    public ResponseEntity parseJson(@RequestBody Map<String, Object> requestBody) {
        try {
            // Null check for requestBody
            if (requestBody != null) {
                System.out.println(requestBody);
                importHandler.parseBody((Map<String, Object>) requestBody);
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            // Add proper error handling (log the error, return a specific HTTP status code,
            // etc.)
            e.printStackTrace(); // Log the exception or use a logging framework
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/forecasts")
    public ResponseEntity<ForecastResponse> getForecast() {
        try {
            return ResponseEntity.ok(forecastHandler.getForecast());
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/productionorders")
    public ArrayList<ProductionItem> productPlanning(@RequestBody Map<String, Object> requestBody) {
        // try {
            return planningHandler.planProcudts(requestBody);
        // } catch (Exception e) {
        //     e.printStackTrace();
        //     return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        // }
    }

    @PostMapping("/orders")
    public ArrayList<NewOrder> orderPlanning(@RequestBody Map<String, Object> requestBody) {
        // try {
            return planningHandler.planOrders(requestBody);
        // } catch (Exception e) {
        //     e.printStackTrace();
        //     return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        // }
    }

    @PostMapping("/capacity")
    public ArrayList<WorkingTime> updateCapacity(@RequestBody ProductionItem[] items) {
        return planningHandler.updateCapacity(items);
    }
}
