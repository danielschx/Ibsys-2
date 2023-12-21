package com.example.ibsys2.backend.database;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zaxxer.hikari.HikariDataSource;
import com.example.ibsys2.backend.Entity.Workplace;
import com.example.ibsys2.backend.Entity.WorkplaceProductMerge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class WorkplacesDB {

    private static HikariDataSource dataSource = null;

    @Autowired
    public WorkplacesDB(HikariDataSource dataSource) { this.dataSource = dataSource; }

    public static ArrayList<Workplace> getWorkplaces() {
        ArrayList<Workplace> workplaces = new ArrayList<>();

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT * FROM public.\"Workplace\"";

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

        for (Map<String, Object> row : rows) {
            int id = (Integer) row.get("ID");
            int duration = (Integer) row.get("duration");
            String json = (String) row.get("durationsProducts");

            ArrayList<WorkplaceProductMerge> durationsProducts = convertJsonToWorkplaceProductMergeList(json);

            Workplace workplace = new Workplace(id, duration, durationsProducts);
            workplaces.add(workplace);
        }

        //dataSource.close();
        return workplaces;
    }

    private static ArrayList<WorkplaceProductMerge> convertJsonToWorkplaceProductMergeList(String json) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(json, new TypeReference<ArrayList<WorkplaceProductMerge>>() {});
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
