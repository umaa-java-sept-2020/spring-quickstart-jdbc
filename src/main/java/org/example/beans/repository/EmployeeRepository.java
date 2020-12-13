package org.example.beans.repository;

import org.example.beans.mapper.EmployeeRowMapper;
import org.example.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Component
@Repository
// dont write try/catch in repository layer
public class EmployeeRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private EmployeeRowMapper employeeRowMapper;


    private final String SELECT_BY_UID = "SELECT * FROM TBL_EMPLOYEE WHERE UID=?";
    private final String SELECT_ALL = "SELECT * FROM TBL_EMPLOYEE";
    private final String INSERT = "INSERT INTO TBL_EMPLOYEE(UID, FIRST_NAME,LAST_NAME) VALUES(?,?,?)";
    private final String UPDATE_FIRST_NAME = "UPDATE TBL_EMPLOYEE SET FIRST_NAME=? WHERE UID=?";
    private final String DELETE_BY_UID = "DELETE FROM TBL_EMPLOYEE WHERE UID=?";

    public int delete(String uid)
    {
        Object[] args = new Object[]{ uid};
        int rows = jdbcTemplate.update(DELETE_BY_UID, args);
        System.out.println("rows deleted: " + rows);
        return rows;
    }
    public Employee update(Employee e)
    {
        Object[] args = new Object[]{ e.getFirstName(), e.getUid()};
        int rows = jdbcTemplate.update(UPDATE_FIRST_NAME, args);
        System.out.println("rows updated: " + rows);
        return e;
    }
    public Employee insert(Employee e) {
        Object[] args = new Object[]{e.getUid(), e.getFirstName(), e.getLastName()};
        int rows = jdbcTemplate.update(INSERT, args);
        System.out.println("rows inserted: " + rows);
        return e;
    }

    public Employee selectByUid(String uid) {
        Object[] args = new Object[]{uid};
        Employee e = jdbcTemplate.queryForObject(SELECT_BY_UID, employeeRowMapper, args);
        return e;
    }

    public List<Employee> selectAll() {
        List<Employee> employees = jdbcTemplate.query(SELECT_ALL, employeeRowMapper);
        return employees;
    }
}
