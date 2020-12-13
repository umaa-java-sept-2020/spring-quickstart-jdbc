package org.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@PropertySource("database.properties")
public class AppConfig {

    @Value("${db.url}")
    private String dbUrl;
    @Value("${db.driver-class}")
    private String dbDriverClass;
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;

    @Bean
    public DataSource getDataSource()
    {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(dbDriverClass);
        ds.setUsername(username);
        ds.setPassword(password);
        ds.setUrl(dbUrl);
        return ds;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate()
    {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        return jdbcTemplate;
    }
}
