package com.example.ibsys2.backend.Handler;

import com.example.ibsys2.backend.Entity.ProductionPlanEntity;
import com.example.ibsys2.backend.controller.ResponseEntity.ProductionItem;
import com.example.ibsys2.backend.controller.ResponseEntity.ReserveStockProduct;
import com.example.ibsys2.backend.controller.ResponseEntity.WorkingTime;
import com.example.ibsys2.backend.controller.ResponseEntity.Calculations;
import com.example.ibsys2.backend.controller.ResponseEntity.NewOrder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;


@Component
public class PlanningHandler {

    public ArrayList<ProductionItem> planProcudts( Map<String, Object> requestBody) {
        List<Map<String, Object>> productionListJson = (List<Map<String, Object>>) requestBody.get("production");
        List<Map<String, Object>> reserveStockListJson = (List<Map<String, Object>>) requestBody.get("products");
        ArrayList<ReserveStockProduct> productionList = new ArrayList<>();
        ArrayList<ProductionPlanEntity> planningList = new ArrayList<>();

        for (int i = 0; i < productionListJson.size(); i++) {
            Map<String, Object> productionItem = productionListJson.get(i);
            int product1Consumption = (int) productionItem.get("p1");
            int product2Consumption = (int) productionItem.get("p2");
            int product3Consumption = (int) productionItem.get("p3");

            ProductionPlanEntity planEntity = new ProductionPlanEntity(i + 1, product1Consumption, product2Consumption,
                    product3Consumption);
            planningList.add(planEntity);
        }

        for (int i = 0; i < reserveStockListJson.size(); i++) {
            Map<String, Object> reserveStockItem = reserveStockListJson.get(i);
            int productId = (int) reserveStockItem.get("productId");
            int reserveStock = (int) reserveStockItem.get("reserveStock");

            ReserveStockProduct reserveStockProduct = new ReserveStockProduct(productId, reserveStock);
            productionList.add(reserveStockProduct);
        }

        System.out.println("Sicherheitsbestände:");
        for (ReserveStockProduct reserveStockProduct : productionList) {
            System.out.println("ProductId: " + reserveStockProduct.getProductId() + " Sicherheitsbestand: "
                    + reserveStockProduct.getReserveStock());
        }
        System.out.println("----------------------");

        // gebe die Liste der Produktionsplanung aus
        System.out.println("Produktionsplanung:");
        for (ProductionPlanEntity planEntity : planningList) {
            System.out.println("Periode: " + planEntity.getPeriode());
            System.out.println("Product1Consumption: " + planEntity.product1Consumption);
            System.out.println("Product2Consumption: " + planEntity.product2Consumption);
            System.out.println("Product3Consumption: " + planEntity.product3Consumption);
            System.out.println("----------------------");
        }

        System.out.println(("Fertigungsaufträge Berechnung gestartet"));
        ArrayList<ProductionItem> productionItems = Calculations
                .createProductionByProductionPlanning(planningList, productionList);

        System.out.println("----------------------");
        System.out.println("Fertigungsaufträge Berechnung abgeschlossen:");
        System.out.println("----------------------");

        // Return the response map with the appropriate status
        return productionItems;
    }

    public ArrayList<NewOrder> planOrders(Map<String, Object> requestBody) {
        List<Map<String, Object>> productionListJson = (List<Map<String, Object>>) requestBody.get("production");

        ArrayList<ProductionPlanEntity> planningList = new ArrayList<>();

        for (int i = 0; i < productionListJson.size(); i++) {
            Map<String, Object> productionItem = productionListJson.get(i);
            int product1Consumption = (int) productionItem.get("p1");
            int product2Consumption = (int) productionItem.get("p2");
            int product3Consumption = (int) productionItem.get("p3");

            ProductionPlanEntity planEntity = new ProductionPlanEntity(i + 1, product1Consumption, product2Consumption,
                    product3Consumption);
            planningList.add(planEntity);
        }

        // gebe die Liste der Produktionsplanung aus
        System.out.println("Produktionsplanung:");
        for (ProductionPlanEntity planEntity : planningList) {
            System.out.println("Periode: " + planEntity.getPeriode());
            System.out.println("Product1Consumption: " + planEntity.product1Consumption);
            System.out.println("Product2Consumption: " + planEntity.product2Consumption);
            System.out.println("Product3Consumption: " + planEntity.product3Consumption);
            System.out.println("----------------------");
        }

        System.out.println(("Bestellungen Berechnung gestartet"));
        ArrayList<NewOrder> orders = Calculations.createOrdersByProductionPlanning(planningList);

        System.out.println("Bestellungen Berechnung abgeschlossen:");
        System.out.println("----------------------");

        for (NewOrder order : orders) {
            System.out.println("Artikel: " + order.getArticle());
            System.out.println("Menge: " + order.getQuantity());
            System.out.println("Modus: " + order.getModus());
            System.out.println("Infos: " + order.getOrderInfos());
            System.out.println("----------------------");
        }

        return orders;
    }

    public ArrayList<WorkingTime> updateCapacity(ProductionItem[] items) {
        ArrayList<ProductionItem> productionItems = new ArrayList<>(Arrays.asList(items));

        // Hier kannst du die ArrayList<ProductionItem> weiterverarbeiten
        // ...

        // Beispiel: Ausgabe der empfangenen Daten
        for (ProductionItem item : productionItems) {
            System.out.println("Sequence Number: " + item.getSequenceNumer());
            System.out.println("Article: " + item.getArticle());
            System.out.println("Quantity: " + item.getQuantity());
            System.out.println();
        }

        System.out.println(("Kapazitätsplanung Berechnung gestartet"));
        ArrayList<WorkingTime> workingTimes = Calculations
                .CalculateWorkingtimesByProductionList(productionItems);

        System.out.println("Kapazitätsplanung Berechnung abgeschlossen:");
        System.out.println("----------------------");

        return workingTimes;
    }
}
