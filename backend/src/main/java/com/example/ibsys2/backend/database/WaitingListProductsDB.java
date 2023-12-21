package com.example.ibsys2.backend.database;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.zaxxer.hikari.HikariDataSource;
import com.example.ibsys2.backend.Entity.Order;
import com.example.ibsys2.backend.Entity.WaitingListProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class WaitingListProductsDB {

    private static HikariDataSource dataSource = null;

    @Autowired
    public WaitingListProductsDB(HikariDataSource dataSource) { this.dataSource = dataSource; }

    // Wie viele von welchem Produkt. Maschine egal.
    public static ArrayList<WaitingListProduct> getWaitingListProductsFromDB() {
        ArrayList<WaitingListProduct> waitingListProducts = new ArrayList<>();

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT * FROM public.\"ProductWaitlist\"";

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

        for (Map<String, Object> row : rows) {
            WaitingListProduct waitingListProduct = new WaitingListProduct(
                    (Integer) row.get("ID"),
                    (Integer) row.get("waitlistQuantity"),
                    (Integer) row.get("inWorkQuantity"));
            waitingListProducts.add(waitingListProduct);
        }
        return waitingListProducts;
    }

    // OrdersinWorkQuantitiy + WaitingListQuantity

    public static void putWaitingListProducts(ArrayList<WaitingListProduct> waitingListProducts) {
        clearWaitingListProductTable();

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "INSERT INTO public.\"ProductWaitlist\" (\"ID\", \"waitlistQuantity\", \"inWorkQuantity\") VALUES (?, ?, ?)";

        for (WaitingListProduct waitingListProduct : waitingListProducts) {
            jdbcTemplate.update(sql, waitingListProduct.getProductId(), waitingListProduct.getWaitlistQuantity(), waitingListProduct.getInWorkQuantity());
        }
    }

    /*public static void updateWaitingListProducts(ArrayList<WaitingListProduct> waitingListProducts) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "UPDATE public.\"ProductWaitlist\" SET \"quantity\" = ? WHERE \"ID\" = ?";
        for (WaitingListProduct waitingListProduct : waitingListProducts) {
            jdbcTemplate.update(sql, waitingListProduct.getQuantity(), waitingListProduct.getProductId());
        }
    }*/

// OrdersInWork
    // p1 100 = 20 Warteliste + 30 OrdersinWork = 50
    // E4 -> 100*E4

    private static void clearWaitingListProductTable() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "TRUNCATE TABLE public.\"ProductWaitlist\"";
        jdbcTemplate.update(sql);
    }

    public static int getWaitingListQuantityById(int productId) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT \"waitlistQuantity\" FROM public.\"ProductWaitlist\" WHERE \"ID\" = ?";
        Object[] params = { productId };

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, params);

        if (!rows.isEmpty()) {
            Map<String, Object> row = rows.get(0);
            return (Integer) row.get("waitlistQuantity");
        }

        return 0;
    }

    public static int getInWorkQuantityById(int productId) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT \"inWorkQuantity\" FROM public.\"ProductWaitlist\" WHERE \"ID\" = ?";
        Object[] params = { productId };

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, params);

        if (!rows.isEmpty()) {
            Map<String, Object> row = rows.get(0);
            return (Integer) row.get("inWorkQuantity");
        }

        return 0;
    }


}
