package com.example.ibsys2.backend.database;

import com.zaxxer.hikari.HikariDataSource;
import com.example.ibsys2.backend.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductsDB {

    private static HikariDataSource dataSource = null;

    @Autowired
    public ProductsDB(HikariDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static ArrayList<Product> getProducts() {
        ArrayList<Product> products = new ArrayList<>();

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT * FROM public.\"Product\"";

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

        for (Map<String, Object> row : rows) {
            Product product = new Product(
                    (Integer) row.get("ID"),
                    (String) row.get("name"),
                    (Integer) row.get("discountQuantity"),
                    (Integer) row.get("deliverytime"),
                    (Integer) row.get("variance"),
                    (Integer) row.get("product1Consumption"),
                    (Integer) row.get("product2Consumption"),
                    (Integer) row.get("product3Consumption"),
                    (Integer) row.get("stock"));
            products.add(product);
        }

        //dataSource.close();
        return products;
    }

    public static void updateProductStock(HashMap<Integer, Integer> stock) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "UPDATE public.\"Product\" SET \"stock\" = ? WHERE \"ID\" = ?";
        stock.forEach((id, newStock) -> {
            jdbcTemplate.update(sql, newStock, id);
        });
        //dataSource.close();
    }
}

