package com.example.ibsys2.backend.Handler;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class ImportHandler {

    public void parseBody(Map<String, Object> body) {
        if(body != null) {
            parseForecast((Map<String, Object>) body.get("forecast"));
            parseWarehousestockArticles((List<Map<String, Object>>) ((Map<String, Object>)body.get("warehousestock")).get("articles"));
            parseInWardStockMovementOrders((List<Map<String, Object>>)((Map<String, Object>)body.get("inwardstockmovement")).get("order"));
            parseFutureInWardStockMovementOrders((List<Map<String, Object>>)((Map<String, Object>)body.get("futureinwardstockmovement")).get("order"));
            parseIdleTimeCostWorkplaces((List<Map<String, Object>>)((Map<String, Object>)body.get("idletimecosts")).get("workplace"));
            parseWaitingListWorkstations((List<Map<String, Object>>)((Map<String, Object>)body.get("waitinglistworkstations")).get("workplace"));
            parseWaitingListStock((List<Map<String, Object>>)((Map<String, Object>)body.get("waitingliststock")).get("missingpart"));
            parseOrdersInWork((List<Map<String, Object>>)((Map<String, Object>)body.get("ordersinwork")).get("workplace"));
            parseCompletedOrders((List<Map<String, Object>>)((Map<String, Object>)body.get("completeorders")).get("order"));
            parseCycleTimes((Map<String, Object>)body.get("cycletimes"));
            parseResult((Map<String, Object>) body.get("result"));
        }
    }

    private void parseResult(Map<String, Object> map) {
    }

    private void parseCycleTimes(Map<String, Object> map) {
    }

    private void parseCompletedOrders(List<Map<String, Object>> list) {
    }

    private void parseOrdersInWork(List<Map<String, Object>> list) {
    }

    private void parseWaitingListStock(List<Map<String, Object>> list) {
    }

    private void parseWaitingListWorkstations(List<Map<String, Object>> list) {
    }

    private void parseIdleTimeCostWorkplaces(List<Map<String, Object>> list) {
    }

    private void parseFutureInWardStockMovementOrders(List<Map<String, Object>> list) {
    }

    private void parseInWardStockMovementOrders(List<Map<String, Object>> list) {
    }

    private void parseWarehousestockArticles(List<Map<String, Object>> list) {
    }

    private void parseForecast(Map<String, Object> map) {
    }

}