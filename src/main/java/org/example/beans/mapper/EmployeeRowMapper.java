package org.example.beans.mapper;

import org.example.model.Employee;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component("employeeRowMapper")
public class EmployeeRowMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet resultSet, int i) throws SQLException {

        Integer id = resultSet.getInt("ID");
        String uid = resultSet.getString("UID");
        String firstName = resultSet.getString("FIRST_NAME");
        String lastName = resultSet.getString("LAST_NAME");
        Employee e = new Employee(id, uid, firstName, lastName);
        return e;
    }
}
