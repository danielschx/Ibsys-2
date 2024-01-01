package com.example.ibsys2.backend.controller.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.example.ibsys2.backend.Entity.Item;

public class ForecastResponse {
    private ArrayList<Item> forecasts;
    private List<Map<String, Object>> p1;
    private List<Map<String, Object>> p2;
    private List<Map<String, Object>> p3;

    public ArrayList<Item> getForecasts() {
        return forecasts;
    }

    public void setForecasts(ArrayList<Item> forecasts) {
        this.forecasts = forecasts;
    }

    public List<Map<String, Object>> getP1() {
        return p1;
    }

    public void setP1(List<Map<String, Object>> p1) {
        this.p1 = p1;
    }

    public List<Map<String, Object>> getP2() {
        return p2;
    }

    public void setP2(List<Map<String, Object>> p2) {
        this.p2 = p2;
    }

    public List<Map<String, Object>> getP3() {
        return p3;
    }

    public void setP3(List<Map<String, Object>> p3) {
        this.p3 = p3;
    }
}