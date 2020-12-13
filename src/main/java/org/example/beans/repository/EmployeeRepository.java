package org.example.beans.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
@Repository
public class EmployeeRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
}
