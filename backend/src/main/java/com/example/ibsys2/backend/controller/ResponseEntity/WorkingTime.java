package com.example.ibsys2.backend.controller.ResponseEntity;

import java.util.ArrayList;

import com.example.ibsys2.backend.Entity.ProductionTimes;
import com.example.ibsys2.backend.Entity.SetupTimes;


public class WorkingTime {
    private int station;
    private int shift;
    private int overtime;
    public ArrayList<ProductionTimes> productionTimes;
    public ArrayList<SetupTimes> setupTimes;
    public int waitingDuration;
    public int overallDuration;

    public WorkingTime(int station, int shift, int overtime, ArrayList<ProductionTimes> productionTimes,
            ArrayList<SetupTimes> setupTimes, int waitingDuration, int overallDuration) {
        this.station = station;
        this.shift = shift;
        this.overtime = overtime;
        this.productionTimes = productionTimes;
        this.setupTimes = setupTimes;
        this.waitingDuration = waitingDuration;
        this.overallDuration = overallDuration;
    }

    public int getStation() {
        return station;
    }

    public void setStation(int station) {
        this.station = station;
    }

    public int getShift() {
        return shift;
    }

    public void setShift(int shift) {
        this.shift = shift;
    }

    public int getOvertime() {
        return overtime;
    }

    public void setOvertime(int overtime) {
        this.overtime = overtime;
    }

    public void addProductionTime(int productId, int quantity, int durationPerUnit) {
        ProductionTimes productionTime = new ProductionTimes(productId, quantity, durationPerUnit);
        this.productionTimes.add(productionTime);
    }

    public void addSetupTime(int productId, int setupTime, int setupQunatity) {
        SetupTimes setupTimeObject = new SetupTimes(productId, setupTime, setupQunatity);
        this.setupTimes.add(setupTimeObject);
    }

    public int getOverallDuration() {
        return overallDuration;
    }

    public void setOverallDuration(int overallDuration) {
        this.overallDuration = overallDuration;
    }
}
