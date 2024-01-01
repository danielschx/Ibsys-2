package com.example.ibsys2.backend.database;

import com.zaxxer.hikari.HikariDataSource;
import com.example.ibsys2.backend.Entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class OrdersDB {

    private static HikariDataSource dataSource = null;

    @Autowired
    public OrdersDB(HikariDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static ArrayList<Order> getOrders() {
        ArrayList<Order> orders = new ArrayList<>();

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT * FROM public.\"Order\"";

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

        for (Map<String, Object> row : rows) {
            Order order = new Order(
                    (Integer) row.get("ID"),
                    (Integer) row.get("productID"),
                    (Integer) row.get("quantity"),
                    (Integer) row.get("days"));
            orders.add(order);
        }

        // dataSource.close();
        return orders;
    }

    public static void putOrders(ArrayList<Order> orders) {
        clearOrdersTable();

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "INSERT INTO public.\"Order\" (\"ID\", \"productID\", \"quantity\", \"days\") VALUES (?, ?, ?, ?)";

        for (Order order : orders) {
            jdbcTemplate.update(sql, order.getId(), order.getProductId(), order.getQuantity(),
                    order.getDaysAfterToday());
        }
        // dataSource.close();
    }

    private static void clearOrdersTable() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "TRUNCATE TABLE public.\"Order\"";
        jdbcTemplate.update(sql);
        // dataSource.close();
    }
}
