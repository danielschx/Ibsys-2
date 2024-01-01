package com.example.ibsys2.backend.database;

import com.zaxxer.hikari.HikariDataSource;
import com.example.ibsys2.backend.Entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ForecastsDB {

    private static HikariDataSource dataSource = null;

    @Autowired
    public ForecastsDB(HikariDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static ArrayList<Item> getForecast() {
        ArrayList<Item> forecasts = new ArrayList<>();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT * FROM public.\"Forecast\"";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

        int p1 = 0;
        int p2 = 0;
        int p3 = 0;

        for (Map<String, Object> row : rows) {
            int id = (Integer) row.get("ID");
            int amount = (Integer) row.get("amount");

            if (id == 1) {
                p1 = amount;
            }
            if (id == 2) {
                p2 = amount;
            }
            if (id == 3) {
                p3 = amount;
            }
        }
        Item forecast = new Item(1, p1, p2, p3);
        forecasts.add(forecast);
        forecast = new Item(2, p1, p2, p3);
        forecasts.add(forecast);
        forecast = new Item(3, p1, p2, p3);
        forecasts.add(forecast);
        forecast = new Item(4, p1, p2, p3);
        forecasts.add(forecast);

        // dataSource.close();
        return forecasts;
    }

    public static void updateForecasts(HashMap<Integer, Integer> forecast) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "UPDATE public.\"Forecast\" SET \"amount\" = ? WHERE \"ID\" = ?";
        forecast.forEach((id, newAmount) -> {
            jdbcTemplate.update(sql, newAmount, id);
        });
        // dataSource.close();
    }
}
