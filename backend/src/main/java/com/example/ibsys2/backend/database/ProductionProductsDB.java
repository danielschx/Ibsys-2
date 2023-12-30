package com.example.ibsys2.backend.database;

import com.zaxxer.hikari.HikariDataSource;
import com.example.ibsys2.backend.Entity.ProductionProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductionProductsDB {

    private static HikariDataSource dataSource = null;

    @Autowired
    public ProductionProductsDB(HikariDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static ArrayList<ProductionProduct> getProductionProducts() {
        ArrayList<ProductionProduct> productionProducts = new ArrayList<>();

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT * FROM public.\"ProductionProduct\"";

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

        for (Map<String, Object> row : rows) {
            ProductionProduct productionProduct = new ProductionProduct(
                    (Integer) row.get("ID"),
                    (String) row.get("name"),
                    (Integer) row.get("product1Consumption"),
                    (Integer) row.get("product2Consumption"),
                    (Integer) row.get("product3Consumption"),
                    (Integer) row.get("stock"));
            productionProducts.add(productionProduct);
        }

        // dataSource.close();
        return productionProducts;
    }

    public static void updateProductionProductsStock(HashMap<Integer, Integer> stocklist) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "UPDATE public.\"ProductionProduct\" SET \"stock\" = ? WHERE \"ID\" = ?";
        stocklist.forEach((id, newStock) -> {
            jdbcTemplate.update(sql, newStock, id);
        });
        // dataSource.close();
    }
}
