package com.example.ibsys2.backend.Handler;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.example.ibsys2.backend.Entity.Product;
import com.example.ibsys2.backend.Entity.ProductionProduct;
import com.example.ibsys2.backend.Entity.Item;
import com.example.ibsys2.backend.Entity.WaitingListProduct;
import com.example.ibsys2.backend.controller.ResponseEntity.ForecastResponse;
import com.example.ibsys2.backend.controller.ResponseEntity.ProductInfo;
import com.example.ibsys2.backend.database.ForecastsDB;
import com.example.ibsys2.backend.database.ProductsDB;
import com.example.ibsys2.backend.database.ProductionProductsDB;
import com.example.ibsys2.backend.database.WaitingListProductsDB;

@Component
public class ForecastHandler {
    public ForecastResponse getForecast() {
        ArrayList<Item> forecast = ForecastsDB.getForecast();
        ArrayList<Product> products = ProductsDB.getProducts();
        ArrayList<ProductionProduct> productionProducts = ProductionProductsDB.getProductionProducts();
        ArrayList<WaitingListProduct> waitingListProducts = WaitingListProductsDB.getWaitingListProductsFromDB();

        ArrayList<ProductInfo> forP1 = new ArrayList<>();
        ArrayList<ProductInfo> forP2 = new ArrayList<>();
        ArrayList<ProductInfo> forP3 = new ArrayList<>();

        for (ProductionProduct productionProduct : productionProducts) {
            int productId = productionProduct.getId();
            int product1Consumption = productionProduct.getProduct1Consumption();
            int product2Consumption = productionProduct.getProduct2Consumption();
            int product3Consumption = productionProduct.getProduct3Consumption();
            int stock = productionProduct.getStock();
            String name = productionProduct.getName();
            int ordersInWorkQuantity = GetInOrderQuantityById(productId, waitingListProducts);
            int waitingListQuantity = GetWaitingListQuantityById(productId, waitingListProducts);

            if (product1Consumption > 0) {
                ProductInfo productInfo = new ProductInfo(productId, name, stock, waitingListQuantity,
                        ordersInWorkQuantity);
                forP1.add(productInfo);
            }
            if (product2Consumption > 0) {
                ProductInfo productInfo = new ProductInfo(productId, name, stock, waitingListQuantity,
                        ordersInWorkQuantity);
                forP2.add(productInfo);
            }
            if (product3Consumption > 0) {
                ProductInfo productInfo = new ProductInfo(productId, name, stock, waitingListQuantity,
                        ordersInWorkQuantity);
                forP3.add(productInfo);
            }
        }

        ArrayList<ProductInfo> productInfos = new ArrayList<>();
        for (Product product : products) {
            int productId = product.getId();
            int stock = product.getStock();
            String name = product.getName();
            int waitingListQuantity = GetWaitingListQuantityById(productId, waitingListProducts);
            int ordersInWorkQuantity = GetInOrderQuantityById(productId, waitingListProducts);
            productInfos.add(new ProductInfo(productId, name, stock, waitingListQuantity, ordersInWorkQuantity));
        }

        forP1.sort(Comparator.comparingInt(ProductInfo::getProductId));
        forP2.sort(Comparator.comparingInt(ProductInfo::getProductId));
        forP3.sort(Comparator.comparingInt(ProductInfo::getProductId));

        ForecastResponse response = new ForecastResponse();
        response.setForecasts(forecast);
        response.setP1(convertToMapList(forP1));
        response.setP2(convertToMapList(forP2));
        response.setP3(convertToMapList(forP3));

        return response;
    }

    public static int GetWaitingListQuantityById(int productId, ArrayList<WaitingListProduct> waitingListProducts) {

        for (WaitingListProduct waitingListProduct : waitingListProducts) {
            if (waitingListProduct.getProductId() == productId) {
                return waitingListProduct.getWaitlistQuantity();
            }
        }

        return 0;
    }

    public static int GetInOrderQuantityById(int productId, ArrayList<WaitingListProduct> waitingListProducts) {

        for (WaitingListProduct waitingListProduct : waitingListProducts) {
            if (waitingListProduct.getProductId() == productId) {
                return waitingListProduct.getInWorkQuantity();
            }
        }

        return 0;
    }

    public List<Map<String, Object>> convertToMapList(ArrayList<ProductInfo> productInfos) {
        List<Map<String, Object>> mapList = new ArrayList<>();
        for (ProductInfo productInfo : productInfos) {
            Map<String, Object> map = new LinkedHashMap<>(); // Verwenden Sie LinkedHashMap, um die Reihenfolge der
                                                             // Felder beizubehalten
            map.put("productId", productInfo.getProductId());
            map.put("name", productInfo.getName());
            map.put("stock", productInfo.getStock());
            map.put("waitingListQuantity", productInfo.getWaitingListQuantity());
            map.put("ordersInWorkQuantity", productInfo.getOrdersInWorkQuantity());
            mapList.add(map);
        }
        return mapList;
    }
}
