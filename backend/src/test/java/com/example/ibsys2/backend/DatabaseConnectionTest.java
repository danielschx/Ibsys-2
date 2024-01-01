package com.example.ibsys2.backend;

import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
public class DatabaseConnectionTest {

    @Autowired
    private HikariDataSource dataSource;

    @Test
    public void testConnection() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT COUNT(*) FROM public.\"Product\"";
        //Alternativ:String sql = "SELECT COUNT(*) FROM public.\"Order\"";
        int rowCount = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println("Number of rows: " + rowCount);
        dataSource.close();
    }
}
