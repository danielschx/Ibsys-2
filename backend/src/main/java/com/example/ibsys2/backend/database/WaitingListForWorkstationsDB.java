package com.example.ibsys2.backend.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.zaxxer.hikari.HikariDataSource;
import com.example.ibsys2.backend.Entity.WaitingListItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class WaitingListForWorkstationsDB {

    private static HikariDataSource dataSource = null;

    @Autowired
    public WaitingListForWorkstationsDB(HikariDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static ArrayList<WaitingListItem> getWaitingListForWorkstations() {
        ArrayList<WaitingListItem> waitingListItems = new ArrayList<>();

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT * FROM public.\"WorkstationWaitlist\"";

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

        for (Map<String, Object> row : rows) {
            int id = (Integer) row.get("ID");
            int timeneed = (Integer) row.get("timeneed");

            WaitingListItem waitingListItem = new WaitingListItem(id, timeneed);
            waitingListItems.add(waitingListItem);
        }

        // dataSource.close();
        return waitingListItems;
    }

    public static void updateWaitingListForWorkstations(HashMap<Integer, Integer> waitlist) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "UPDATE public.\"WorkstationWaitlist\" SET \"timeneed\" = ? WHERE \"ID\" = ?";
        waitlist.forEach((id, newTimeneed) -> {
            jdbcTemplate.update(sql, newTimeneed, id);
        });
        // dataSource.close();
    }
}