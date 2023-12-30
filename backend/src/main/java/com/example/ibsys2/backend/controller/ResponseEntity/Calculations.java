package com.example.ibsys2.backend.controller.ResponseEntity;



import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.ibsys2.backend.Entity.Order;
import com.example.ibsys2.backend.Entity.Product;
import com.example.ibsys2.backend.Entity.ProductionPlanEntity;
import com.example.ibsys2.backend.Entity.ProductionProduct;
import com.example.ibsys2.backend.Entity.WaitingListProduct;
import com.example.ibsys2.backend.database.WaitingListProductsDB;
import com.example.ibsys2.backend.database.ProductionProductsDB;
import com.example.ibsys2.backend.database.ProductsDB;
import com.example.ibsys2.backend.database.OrdersDB;

public class Calculations {

        

        public static ArrayList<ProductionItem> createProductionByProductionPlanning(
                        ArrayList<ProductionPlanEntity> productionPlan,
                        ArrayList<ReserveStockProduct> reserveStockProducts) {

                ArrayList<ProductionItem> productionItems = new ArrayList<>();
                ArrayList<WaitingListProduct> waitingListProducts = WaitingListProductsDB
                                .getWaitingListProductsFromDB();
                System.out.println(
                                "Für Produktionmengen zuerst alle Produkte die nicht bestellt werden können aus DB holen ");
                System.out.println("----------------------");

                ArrayList<ProductionProduct> products = ProductionProductsDB.getProductionProducts();

                // gebe alle Produkte aus, mit dem aktuellen Lagerbestand
                for (ProductionProduct product : products) {
                        for (ReserveStockProduct r : reserveStockProducts) {
                                if (product.getId() == r.getProductId()) {
                                        ;
                                        product.setReserveStock(r.getReserveStock());
                                }
                        }
                }
                for (ProductionProduct product : products) {
                        for (WaitingListProduct w : waitingListProducts) {
                                if (product.getId() == w.getProductId()) {
                                        product.setWaitingListQuantity(w.getWaitlistQuantity());
                                        product.setInProductionQuantity(w.getInWorkQuantity());
                                }
                        }
                }

                // bestimme für Fertigungsaufträge für p1
                int p1 = 0;
                int p2 = 0;
                int p3 = 0;
                int p4 = 0;
                int p5 = 0;
                int p6 = 0;
                int p7 = 0;
                int p8 = 0;
                int p9 = 0;
                int p10 = 0;
                int p11 = 0;
                int p12 = 0;
                int p13 = 0;
                int p14 = 0;
                int p15 = 0;
                int p16 = 0;
                int p17 = 0;
                int p18 = 0;
                int p19 = 0;
                int p20 = 0;
                int p26 = 0;
                int p29 = 0;
                int p30 = 0;
                int p31 = 0;
                int p49 = 0;
                int p50 = 0;
                int p51 = 0;
                int p54 = 0;
                int p55 = 0;
                int p56 = 0;

                ProductionProduct p1Product = getProductById(1, products);
                ProductionProduct p2Product = getProductById(2, products);
                ProductionProduct p3Product = getProductById(3, products);
                ProductionProduct p4Product = getProductById(4, products);
                ProductionProduct p5Product = getProductById(5, products);
                ProductionProduct p6Product = getProductById(6, products);
                ProductionProduct p7Product = getProductById(7, products);
                ProductionProduct p8Product = getProductById(8, products);
                ProductionProduct p9Product = getProductById(9, products);
                ProductionProduct p10Product = getProductById(10, products);
                ProductionProduct p11Product = getProductById(11, products);
                ProductionProduct p12Product = getProductById(12, products);
                ProductionProduct p13Product = getProductById(13, products);
                ProductionProduct p14Product = getProductById(14, products);
                ProductionProduct p15Product = getProductById(15, products);
                ProductionProduct p16Product = getProductById(16, products);
                ProductionProduct p17Product = getProductById(17, products);
                ProductionProduct p18Product = getProductById(18, products);
                ProductionProduct p19Product = getProductById(19, products);
                ProductionProduct p20Product = getProductById(20, products);
                ProductionProduct p26Product = getProductById(26, products);
                ProductionProduct p29Product = getProductById(29, products);
                ProductionProduct p30Product = getProductById(30, products);
                ProductionProduct p31Product = getProductById(31, products);
                ProductionProduct p49Product = getProductById(49, products);
                ProductionProduct p50Product = getProductById(50, products);
                ProductionProduct p51Product = getProductById(51, products);
                ProductionProduct p54Product = getProductById(54, products);
                ProductionProduct p55Product = getProductById(55, products);
                ProductionProduct p56Product = getProductById(56, products);

                p1 += productionPlan.get(0).product1Consumption + p1Product.getReserveStock() - p1Product.getStock()
                                - p1Product.getWaitingListQuantity() - p1Product.getInProductionQuantity();

                p1Product.addInformation("Produktionsplan P1: " + productionPlan.get(0).product1Consumption);
                p1Product.addInformation("Sicherheitsbestand: " + p1Product.getReserveStock());
                p1Product.addInformation("Lagerbestand: " + p1Product.getStock());
                p1Product.addInformation("Warteschlange: " + p1Product.getWaitingListQuantity());
                p1Product.addInformation("In Produktion: " + p1Product.getInProductionQuantity());

                p2 += productionPlan.get(0).product2Consumption + p2Product.getReserveStock() - p2Product.getStock()
                                - p2Product.getWaitingListQuantity() - p2Product.getInProductionQuantity();

                p2Product.addInformation("Produktionsplan P2: " + productionPlan.get(0).product2Consumption);
                p2Product.addInformation("Sicherheitsbestand: " + p2Product.getReserveStock());
                p2Product.addInformation("Lagerbestand: " + p2Product.getStock());
                p2Product.addInformation("Warteschlange: " + p2Product.getWaitingListQuantity());
                p2Product.addInformation("In Produktion: " + p2Product.getInProductionQuantity());

                p3 += productionPlan.get(0).product3Consumption + p3Product.getReserveStock() - p3Product.getStock()
                                - p3Product.getWaitingListQuantity() - p3Product.getInProductionQuantity();

                p3Product.addInformation("Produktionsplan P3: " + productionPlan.get(0).product3Consumption);
                p3Product.addInformation("Sicherheitsbestand: " + p3Product.getReserveStock());
                p3Product.addInformation("Lagerbestand: " + p3Product.getStock());
                p3Product.addInformation("Warteschlange: " + p3Product.getWaitingListQuantity());
                p3Product.addInformation("In Produktion: " + p3Product.getInProductionQuantity());

                p26 = p1 + p1Product.getWaitingListQuantity() + p2 + p2Product.getWaitingListQuantity() + p3
                                + p3Product.getWaitingListQuantity() + p26Product.getReserveStock()
                                - p26Product.getStock()
                                - p26Product.getWaitingListQuantity() - p26Product.getInProductionQuantity();

                p26Product.addInformation("Produktionsmenge P1: " + p1);
                p26Product.addInformation("Produktionsmenge P2: " + p2);
                p26Product.addInformation("Produktionsmenge P3: " + p3);
                p26Product.addInformation("Sicherheitsbestand: " + p26Product.getReserveStock());
                p26Product.addInformation("Lagerbestand: " + p26Product.getStock());
                p26Product.addInformation("Warteschlange: " + p26Product.getWaitingListQuantity());
                p26Product.addInformation("In Produktion: " + p26Product.getInProductionQuantity());

                p51 += p1 + p1Product.getWaitingListQuantity() + p51Product.getReserveStock() - p51Product.getStock()
                                - p51Product.getWaitingListQuantity() - p51Product.getInProductionQuantity();

                p51Product.addInformation("Produktionsmenge P1: " + p1);
                p51Product.addInformation("Warteschlange: " + p1Product.getWaitingListQuantity());
                p51Product.addInformation("Sicherheitsbestand: " + p51Product.getReserveStock());
                p51Product.addInformation("Lagerbestand: " + p51Product.getStock());
                p51Product.addInformation("Warteschlange: " + p51Product.getWaitingListQuantity());
                p51Product.addInformation("In Produktion: " + p51Product.getInProductionQuantity());

                p56 += p2 + p2Product.getWaitingListQuantity() + p56Product.getReserveStock() - p56Product.getStock()
                                - p56Product.getWaitingListQuantity() - p56Product.getInProductionQuantity();

                p56Product.addInformation("Produktionsmenge P2: " + p2);
                p56Product.addInformation("Warteschlange: " + p2Product.getWaitingListQuantity());
                p56Product.addInformation("Sicherheitsbestand: " + p56Product.getReserveStock());
                p56Product.addInformation("Lagerbestand: " + p56Product.getStock());
                p56Product.addInformation("Warteschlange: " + p56Product.getWaitingListQuantity());
                p56Product.addInformation("In Produktion: " + p56Product.getInProductionQuantity());

                p31 += p3 + p3Product.getWaitingListQuantity() + p31Product.getReserveStock() - p31Product.getStock()
                                - p31Product.getWaitingListQuantity() - p31Product.getInProductionQuantity();

                p31Product.addInformation("Produktionsmenge P3: " + p3);
                p31Product.addInformation("Warteschlange: " + p3Product.getWaitingListQuantity());
                p31Product.addInformation("Sicherheitsbestand: " + p31Product.getReserveStock());
                p31Product.addInformation("Lagerbestand: " + p31Product.getStock());
                p31Product.addInformation("Warteschlange: " + p31Product.getWaitingListQuantity());
                p31Product.addInformation("In Produktion: " + p31Product.getInProductionQuantity());

                // p1 p2 p3
                p16 += p51 + p51Product.getWaitingListQuantity() + p56 + p56Product.getWaitingListQuantity() + p31
                                + p31Product.getWaitingListQuantity() + p16Product.getReserveStock()
                                - p16Product.getStock()
                                - p16Product.getWaitingListQuantity() - p16Product.getInProductionQuantity();

                p16Product.addInformation("Produktionsmenge P51: " + p51);
                p16Product.addInformation("Warteschlange P51: " + p51Product.getWaitingListQuantity());
                p16Product.addInformation("Produktionsmenge P56: " + p56);
                p16Product.addInformation("Warteschlange P56: " + p56Product.getWaitingListQuantity());
                p16Product.addInformation("Produktionsmenge P31: " + p31);
                p16Product.addInformation("Warteschlange P31: " + p31Product.getWaitingListQuantity());
                p16Product.addInformation("Sicherheitsbestand: " + p16Product.getReserveStock());
                p16Product.addInformation("Lagerbestand: " + p16Product.getStock());
                p16Product.addInformation("Warteschlange: " + p16Product.getWaitingListQuantity());
                p16Product.addInformation("In Produktion: " + p16Product.getInProductionQuantity());

                p17 += p51 + p51Product.getWaitingListQuantity() + p56 + p56Product.getWaitingListQuantity() + p31
                                + p31Product.getWaitingListQuantity() + p17Product.getReserveStock()
                                - p17Product.getStock()
                                - p17Product.getWaitingListQuantity() - p17Product.getInProductionQuantity();

                p17Product.addInformation("Produktionsmenge P51: " + p51);
                p17Product.addInformation("Warteschlange P51: " + p51Product.getWaitingListQuantity());
                p17Product.addInformation("Produktionsmenge P56: " + p56);
                p17Product.addInformation("Warteschlange P56: " + p56Product.getWaitingListQuantity());
                p17Product.addInformation("Produktionsmenge P31: " + p31);
                p17Product.addInformation("Warteschlange P31: " + p31Product.getWaitingListQuantity());
                p17Product.addInformation("Sicherheitsbestand: " + p17Product.getReserveStock());
                p17Product.addInformation("Lagerbestand: " + p17Product.getStock());
                p17Product.addInformation("Warteschlange: " + p17Product.getWaitingListQuantity());
                p17Product.addInformation("In Produktion: " + p17Product.getInProductionQuantity());

                // p1
                p50 += p51 + p51Product.getWaitingListQuantity() + p50Product.getReserveStock() - p50Product.getStock()
                                - p50Product.getWaitingListQuantity() - p50Product.getInProductionQuantity();

                p50Product.addInformation("Produktionsmenge P51: " + p51);
                p50Product.addInformation("Warteschlange P51: " + p51Product.getWaitingListQuantity());
                p50Product.addInformation("Sicherheitsbestand: " + p50Product.getReserveStock());
                p50Product.addInformation("Lagerbestand: " + p50Product.getStock());
                p50Product.addInformation("Warteschlange: " + p50Product.getWaitingListQuantity());
                p50Product.addInformation("In Produktion: " + p50Product.getInProductionQuantity());

                // p2
                p55 += p56 + p56Product.getWaitingListQuantity() + p55Product.getReserveStock() - p55Product.getStock()
                                - p55Product.getWaitingListQuantity() - p55Product.getInProductionQuantity();

                p55Product.addInformation("Produktionsmenge P56: " + p56);
                p55Product.addInformation("Warteschlange P56: " + p56Product.getWaitingListQuantity());
                p55Product.addInformation("Sicherheitsbestand: " + p55Product.getReserveStock());
                p55Product.addInformation("Lagerbestand: " + p55Product.getStock());
                p55Product.addInformation("Warteschlange: " + p55Product.getWaitingListQuantity());
                p55Product.addInformation("In Produktion: " + p55Product.getInProductionQuantity());

                // p3
                p30 += p31 + p31Product.getWaitingListQuantity() + p30Product.getReserveStock() - p30Product.getStock()
                                - p30Product.getWaitingListQuantity() - p30Product.getInProductionQuantity();

                p30Product.addInformation("Produktionsmenge P31: " + p31);
                p30Product.addInformation("Warteschlange P31: " + p31Product.getWaitingListQuantity());
                p30Product.addInformation("Sicherheitsbestand: " + p30Product.getReserveStock());
                p30Product.addInformation("Lagerbestand: " + p30Product.getStock());
                p30Product.addInformation("Warteschlange: " + p30Product.getWaitingListQuantity());
                p30Product.addInformation("In Produktion: " + p30Product.getInProductionQuantity());

                // p1
                p4 += p50 + p50Product.getWaitingListQuantity() + p4Product.getReserveStock() - p4Product.getStock()
                                - p4Product.getWaitingListQuantity() - p4Product.getInProductionQuantity();

                p4Product.addInformation("Produktionsmenge P50: " + p50);
                p4Product.addInformation("Warteschlange P50: " + p50Product.getWaitingListQuantity());
                p4Product.addInformation("Sicherheitsbestand: " + p4Product.getReserveStock());
                p4Product.addInformation("Lagerbestand: " + p4Product.getStock());
                p4Product.addInformation("Warteschlange: " + p4Product.getWaitingListQuantity());
                p4Product.addInformation("In Produktion: " + p4Product.getInProductionQuantity());

                p10 = p50 + p50Product.getWaitingListQuantity() + p10Product.getReserveStock() - p10Product.getStock()
                                - p10Product.getWaitingListQuantity() - p10Product.getInProductionQuantity();

                p10Product.addInformation("Produktionsmenge P50: " + p50);
                p10Product.addInformation("Warteschlange P50: " + p50Product.getWaitingListQuantity());
                p10Product.addInformation("Sicherheitsbestand: " + p10Product.getReserveStock());
                p10Product.addInformation("Lagerbestand: " + p10Product.getStock());
                p10Product.addInformation("Warteschlange: " + p10Product.getWaitingListQuantity());
                p10Product.addInformation("In Produktion: " + p10Product.getInProductionQuantity());

                p49 += p50 + p50Product.getWaitingListQuantity() + p49Product.getReserveStock() - p49Product.getStock()
                                - p49Product.getWaitingListQuantity() - p49Product.getInProductionQuantity();

                p49Product.addInformation("Produktionsmenge P50: " + p50);
                p49Product.addInformation("Warteschlange P50: " + p50Product.getWaitingListQuantity());
                p49Product.addInformation("Sicherheitsbestand: " + p49Product.getReserveStock());
                p49Product.addInformation("Lagerbestand: " + p49Product.getStock());
                p49Product.addInformation("Warteschlange: " + p49Product.getWaitingListQuantity());
                p49Product.addInformation("In Produktion: " + p49Product.getInProductionQuantity());

                p7 = p49 + p49Product.getWaitingListQuantity() + p7Product.getReserveStock() - p7Product.getStock()
                                - p7Product.getWaitingListQuantity() - p7Product.getInProductionQuantity();

                p7Product.addInformation("Produktionsmenge P49: " + p49);
                p7Product.addInformation("Warteschlange P49: " + p49Product.getWaitingListQuantity());
                p7Product.addInformation("Sicherheitsbestand: " + p7Product.getReserveStock());
                p7Product.addInformation("Lagerbestand: " + p7Product.getStock());
                p7Product.addInformation("Warteschlange: " + p7Product.getWaitingListQuantity());
                p7Product.addInformation("In Produktion: " + p7Product.getInProductionQuantity());

                p13 = p49 + p49Product.getWaitingListQuantity() + p13Product.getReserveStock() - p13Product.getStock()
                                - p13Product.getWaitingListQuantity() - p13Product.getInProductionQuantity();

                p13Product.addInformation("Produktionsmenge P49: " + p49);
                p13Product.addInformation("Warteschlange P49: " + p49Product.getWaitingListQuantity());
                p13Product.addInformation("Sicherheitsbestand: " + p13Product.getReserveStock());
                p13Product.addInformation("Lagerbestand: " + p13Product.getStock());
                p13Product.addInformation("Warteschlange: " + p13Product.getWaitingListQuantity());
                p13Product.addInformation("In Produktion: " + p13Product.getInProductionQuantity());

                p18 = p49 + p49Product.getWaitingListQuantity() + p18Product.getReserveStock() - p18Product.getStock()
                                - p18Product.getWaitingListQuantity() - p18Product.getInProductionQuantity();

                p18Product.addInformation("Produktionsmenge P49: " + p49);
                p18Product.addInformation("Warteschlange P49: " + p49Product.getWaitingListQuantity());
                p18Product.addInformation("Sicherheitsbestand: " + p18Product.getReserveStock());
                p18Product.addInformation("Lagerbestand: " + p18Product.getStock());
                p18Product.addInformation("Warteschlange: " + p18Product.getWaitingListQuantity());
                p18Product.addInformation("In Produktion: " + p18Product.getInProductionQuantity());

                // p2
                p5 = p55 + p55Product.getWaitingListQuantity() + p5Product.getReserveStock() - p5Product.getStock()
                                - p5Product.getWaitingListQuantity() - p5Product.getInProductionQuantity();

                p5Product.addInformation("Produktionsmenge P55: " + p55);
                p5Product.addInformation("Warteschlange P55: " + p55Product.getWaitingListQuantity());
                p5Product.addInformation("Sicherheitsbestand: " + p5Product.getReserveStock());
                p5Product.addInformation("Lagerbestand: " + p5Product.getStock());
                p5Product.addInformation("Warteschlange: " + p5Product.getWaitingListQuantity());
                p5Product.addInformation("In Produktion: " + p5Product.getInProductionQuantity());

                p11 = p55 + p55Product.getWaitingListQuantity() + p11Product.getReserveStock() - p11Product.getStock()
                                - p11Product.getWaitingListQuantity() - p11Product.getInProductionQuantity();

                p11Product.addInformation("Produktionsmenge P55: " + p55);
                p11Product.addInformation("Warteschlange P55: " + p55Product.getWaitingListQuantity());
                p11Product.addInformation("Sicherheitsbestand: " + p11Product.getReserveStock());
                p11Product.addInformation("Lagerbestand: " + p11Product.getStock());
                p11Product.addInformation("Warteschlange: " + p11Product.getWaitingListQuantity());
                p11Product.addInformation("In Produktion: " + p11Product.getInProductionQuantity());

                p54 = p55 + p55Product.getWaitingListQuantity() + p54Product.getReserveStock() - p54Product.getStock()
                                - p54Product.getWaitingListQuantity() - p54Product.getInProductionQuantity();

                p54Product.addInformation("Produktionsmenge P55: " + p55);
                p54Product.addInformation("Warteschlange P55: " + p55Product.getWaitingListQuantity());
                p54Product.addInformation("Sicherheitsbestand: " + p54Product.getReserveStock());
                p54Product.addInformation("Lagerbestand: " + p54Product.getStock());
                p54Product.addInformation("Warteschlange: " + p54Product.getWaitingListQuantity());
                p54Product.addInformation("In Produktion: " + p54Product.getInProductionQuantity());

                p8 = p54 + p54Product.getWaitingListQuantity() + p8Product.getReserveStock() - p8Product.getStock()
                                - p8Product.getWaitingListQuantity() - p8Product.getInProductionQuantity();

                p8Product.addInformation("Produktionsmenge P54: " + p54);
                p8Product.addInformation("Warteschlange P54: " + p54Product.getWaitingListQuantity());
                p8Product.addInformation("Sicherheitsbestand: " + p8Product.getReserveStock());
                p8Product.addInformation("Lagerbestand: " + p8Product.getStock());
                p8Product.addInformation("Warteschlange: " + p8Product.getWaitingListQuantity());
                p8Product.addInformation("In Produktion: " + p8Product.getInProductionQuantity());

                p14 = p54 + p54Product.getWaitingListQuantity() + p14Product.getReserveStock() - p14Product.getStock()
                                - p14Product.getWaitingListQuantity() - p14Product.getInProductionQuantity();

                p14Product.addInformation("Produktionsmenge P54: " + p54);
                p14Product.addInformation("Warteschlange P54: " + p54Product.getWaitingListQuantity());
                p14Product.addInformation("Sicherheitsbestand: " + p14Product.getReserveStock());
                p14Product.addInformation("Lagerbestand: " + p14Product.getStock());
                p14Product.addInformation("Warteschlange: " + p14Product.getWaitingListQuantity());
                p14Product.addInformation("In Produktion: " + p14Product.getInProductionQuantity());

                p19 = p54 + p54Product.getWaitingListQuantity() + p19Product.getReserveStock() - p19Product.getStock()
                                - p19Product.getWaitingListQuantity() - p19Product.getInProductionQuantity();

                p19Product.addInformation("Produktionsmenge P54: " + p54);
                p19Product.addInformation("Warteschlange P54: " + p54Product.getWaitingListQuantity());
                p19Product.addInformation("Sicherheitsbestand: " + p19Product.getReserveStock());
                p19Product.addInformation("Lagerbestand: " + p19Product.getStock());
                p19Product.addInformation("Warteschlange: " + p19Product.getWaitingListQuantity());
                p19Product.addInformation("In Produktion: " + p19Product.getInProductionQuantity());

                // p3
                p6 = p30 + p30Product.getWaitingListQuantity() + p6Product.getReserveStock() - p6Product.getStock()
                                - p6Product.getWaitingListQuantity() - p6Product.getInProductionQuantity();

                p6Product.addInformation("Produktionsmenge P30: " + p30);
                p6Product.addInformation("Warteschlange P30: " + p30Product.getWaitingListQuantity());
                p6Product.addInformation("Sicherheitsbestand: " + p6Product.getReserveStock());
                p6Product.addInformation("Lagerbestand: " + p6Product.getStock());
                p6Product.addInformation("Warteschlange: " + p6Product.getWaitingListQuantity());
                p6Product.addInformation("In Produktion: " + p6Product.getInProductionQuantity());

                p12 = p30 + p30Product.getWaitingListQuantity() + p12Product.getReserveStock() - p12Product.getStock()
                                - p12Product.getWaitingListQuantity() - p12Product.getInProductionQuantity();

                p12Product.addInformation("Produktionsmenge P30: " + p30);
                p12Product.addInformation("Warteschlange P30: " + p30Product.getWaitingListQuantity());
                p12Product.addInformation("Sicherheitsbestand: " + p12Product.getReserveStock());
                p12Product.addInformation("Lagerbestand: " + p12Product.getStock());
                p12Product.addInformation("Warteschlange: " + p12Product.getWaitingListQuantity());
                p12Product.addInformation("In Produktion: " + p12Product.getInProductionQuantity());

                p29 = p30 + p30Product.getWaitingListQuantity() + p29Product.getReserveStock() - p29Product.getStock()
                                - p29Product.getWaitingListQuantity() - p29Product.getInProductionQuantity();

                p29Product.addInformation("Produktionsmenge P30: " + p30);
                p29Product.addInformation("Warteschlange P30: " + p30Product.getWaitingListQuantity());
                p29Product.addInformation("Sicherheitsbestand: " + p29Product.getReserveStock());
                p29Product.addInformation("Lagerbestand: " + p29Product.getStock());
                p29Product.addInformation("Warteschlange: " + p29Product.getWaitingListQuantity());
                p29Product.addInformation("In Produktion: " + p29Product.getInProductionQuantity());

                p9 = p29 + p29Product.getWaitingListQuantity() + p9Product.getReserveStock() - p9Product.getStock()
                                - p9Product.getWaitingListQuantity() - p9Product.getInProductionQuantity();

                p9Product.addInformation("Produktionsmenge P29: " + p29);
                p9Product.addInformation("Warteschlange P29: " + p29Product.getWaitingListQuantity());
                p9Product.addInformation("Sicherheitsbestand: " + p9Product.getReserveStock());
                p9Product.addInformation("Lagerbestand: " + p9Product.getStock());
                p9Product.addInformation("Warteschlange: " + p9Product.getWaitingListQuantity());
                p9Product.addInformation("In Produktion: " + p9Product.getInProductionQuantity());

                p15 = p29 + p29Product.getWaitingListQuantity() + p15Product.getReserveStock() - p15Product.getStock()
                                - p15Product.getWaitingListQuantity() - p15Product.getInProductionQuantity();

                p15Product.addInformation("Produktionsmenge P29: " + p29);
                p15Product.addInformation("Warteschlange P29: " + p29Product.getWaitingListQuantity());
                p15Product.addInformation("Sicherheitsbestand: " + p15Product.getReserveStock());
                p15Product.addInformation("Lagerbestand: " + p15Product.getStock());
                p15Product.addInformation("Warteschlange: " + p15Product.getWaitingListQuantity());
                p15Product.addInformation("In Produktion: " + p15Product.getInProductionQuantity());

                p20 = p29 + p29Product.getWaitingListQuantity() + p20Product.getReserveStock() - p20Product.getStock()
                                - p20Product.getWaitingListQuantity() - p20Product.getInProductionQuantity();

                p20Product.addInformation("Produktionsmenge P29: " + p29);
                p20Product.addInformation("Warteschlange P29: " + p29Product.getWaitingListQuantity());
                p20Product.addInformation("Sicherheitsbestand: " + p20Product.getReserveStock());
                p20Product.addInformation("Lagerbestand: " + p20Product.getStock());
                p20Product.addInformation("Warteschlange: " + p20Product.getWaitingListQuantity());
                p20Product.addInformation("In Produktion: " + p20Product.getInProductionQuantity());

                // Add production items to the list
                productionItems
                                .add(new ProductionItem(p1Product.getId(), p1Product.getName(), p1,
                                                p1Product.getInformations()));
                productionItems
                                .add(new ProductionItem(p2Product.getId(), p2Product.getName(), p2,
                                                p2Product.getInformations()));
                productionItems
                                .add(new ProductionItem(p3Product.getId(), p3Product.getName(), p3,
                                                p3Product.getInformations()));
                productionItems
                                .add(new ProductionItem(p4Product.getId(), p4Product.getName(), p4,
                                                p4Product.getInformations()));
                productionItems
                                .add(new ProductionItem(p5Product.getId(), p5Product.getName(), p5,
                                                p5Product.getInformations()));
                productionItems
                                .add(new ProductionItem(p6Product.getId(), p6Product.getName(), p6,
                                                p6Product.getInformations()));
                productionItems
                                .add(new ProductionItem(p7Product.getId(), p7Product.getName(), p7,
                                                p7Product.getInformations()));
                productionItems
                                .add(new ProductionItem(p8Product.getId(), p8Product.getName(), p8,
                                                p8Product.getInformations()));
                productionItems
                                .add(new ProductionItem(p9Product.getId(), p9Product.getName(), p9,
                                                p9Product.getInformations()));
                productionItems
                                .add(new ProductionItem(p10Product.getId(), p10Product.getName(), p10,
                                                p10Product.getInformations()));
                productionItems
                                .add(new ProductionItem(p11Product.getId(), p11Product.getName(), p11,
                                                p11Product.getInformations()));
                productionItems
                                .add(new ProductionItem(p12Product.getId(), p12Product.getName(), p12,
                                                p12Product.getInformations()));
                productionItems
                                .add(new ProductionItem(p13Product.getId(), p13Product.getName(), p13,
                                                p13Product.getInformations()));
                productionItems
                                .add(new ProductionItem(p14Product.getId(), p14Product.getName(), p14,
                                                p14Product.getInformations()));
                productionItems
                                .add(new ProductionItem(p15Product.getId(), p15Product.getName(), p15,
                                                p15Product.getInformations()));
                productionItems
                                .add(new ProductionItem(p16Product.getId(), p16Product.getName(), p16,
                                                p16Product.getInformations()));
                productionItems
                                .add(new ProductionItem(p17Product.getId(), p17Product.getName(), p17,
                                                p17Product.getInformations()));
                productionItems
                                .add(new ProductionItem(p18Product.getId(), p18Product.getName(), p18,
                                                p18Product.getInformations()));
                productionItems
                                .add(new ProductionItem(p19Product.getId(), p19Product.getName(), p19,
                                                p19Product.getInformations()));
                productionItems
                                .add(new ProductionItem(p20Product.getId(), p20Product.getName(), p20,
                                                p20Product.getInformations()));
                productionItems
                                .add(new ProductionItem(p26Product.getId(), p26Product.getName(), p26,
                                                p26Product.getInformations()));
                productionItems
                                .add(new ProductionItem(p29Product.getId(), p29Product.getName(), p29,
                                                p29Product.getInformations()));
                productionItems
                                .add(new ProductionItem(p30Product.getId(), p30Product.getName(), p30,
                                                p30Product.getInformations()));
                productionItems
                                .add(new ProductionItem(p31Product.getId(), p31Product.getName(), p31,
                                                p31Product.getInformations()));
                productionItems
                                .add(new ProductionItem(p49Product.getId(), p49Product.getName(), p49,
                                                p49Product.getInformations()));
                productionItems
                                .add(new ProductionItem(p50Product.getId(), p50Product.getName(), p50,
                                                p50Product.getInformations()));
                productionItems
                                .add(new ProductionItem(p51Product.getId(), p51Product.getName(), p51,
                                                p51Product.getInformations()));
                productionItems
                                .add(new ProductionItem(p54Product.getId(), p54Product.getName(), p54,
                                                p54Product.getInformations()));
                productionItems
                                .add(new ProductionItem(p55Product.getId(), p55Product.getName(), p55,
                                                p55Product.getInformations()));
                productionItems
                                .add(new ProductionItem(p56Product.getId(), p56Product.getName(), p56,
                                                p56Product.getInformations()));

                // setzte die Sequenznummer für die Produktionsmengen
                for (int i = 0; i < productionItems.size(); i++) {
                        productionItems.get(i).setSequenceNumber(i + 1);
                        productionItems.get(i).id = i + 1;
                        if (productionItems.get(i).getQuantity() < 0) {
                                productionItems.get(i).setQuantity(0);
                        }
                }

                System.out.println("----------------------");
                System.out.println("Folgende Produktionsmengen werden vorgeschlagen:");
                System.out.println("----------------------");
                for (ProductionItem productionItem : productionItems) {
                        System.out.println("Article: " + productionItem.getArticle());
                        System.out.println("Quantity: " + productionItem.getQuantity());
                        System.out.println("Reihenfolge : " + productionItem.getSequenceNumer());
                        System.out.println("----------------------");
                }

                System.out.println("Produktionsmengen Berechnung erfolgreich");

                return productionItems;
        }

        private static ProductionProduct getProductById(int id, ArrayList<ProductionProduct> products) {
                for (ProductionProduct product : products) {
                        if (product.getId() == id) {
                                return product;
                        }
                }
                return null;
        }

        public static ArrayList<NewOrder> createOrdersByProductionPlanning(
            ArrayList<ProductionPlanEntity> proudctionPlans) {

        ArrayList<NewOrder> orders = new ArrayList<>();

        System.out.println("Für Bestellungen zuerst alle Produkte die Bestellt werden können aus DB holen ");
        System.out.println("----------------------");

        ArrayList<Product> products = ProductsDB.getProducts();

        System.out.println("Für Bestellungen von jedem Produkt den Lagerbestandverlauf updaten  ");
        System.out.println("dafür den Lagerbestandsverlauf anhand der noch offenen Bestellungen updaten ");
        System.out.println(
                "anschließend anhand des Produktionsplans und dem momentanen Bestand den Lagerbestandsverlauf über die nächsten Perioden updaten ");
        System.out.println("----------------------");
        System.out.println("Zuletzt die Bestellung erstellen, abhängig vom Produkt und Lagerbestand ");
        System.out.println("----------------------");

        for (Product product : products) {

            ArrayList<Order> oldOrders = OrdersDB.getOrders();
            // update stockHistorieByOrders
            product.setStockHistory(Order.updateStockHistoryByOrders(product, oldOrders));

            // update stockHistoryByForecast
            product.setStockHistory(Product.updateStockHistoryByForecast(product, proudctionPlans));

            // create orders for the product
            NewOrder order = NewOrder.createOrder(product);
            if (order != null) {
                orders.add(order);
            }
        }

        System.out.println("Folgende Bestellungen wurden für diese Periode vorgeschlagen: ");

        for (NewOrder order : orders) {
            System.out.println("Article: " + order.getArticle());
            System.out.println("Quantity: " + order.getQuantity());
            System.out.println("Modus: " + order.getModus());
            System.out.println("----------------------");
        }

        return orders;
    }
}