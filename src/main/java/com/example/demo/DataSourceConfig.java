package com.example.demo;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.HashMap;
import java.util.Map;

public class DataSourceConfig {

    public static Map<Object, Object> getDataSourceHashMap() {

        DriverManagerDataSource h2DS = new DriverManagerDataSource();
        h2DS.setDriverClassName("org.h2.Driver");
        h2DS.setUrl("jdbc:h2:mem:testdb");
        h2DS.setUsername("SA");
        h2DS.setPassword("");

        DriverManagerDataSource mariadbDS = new DriverManagerDataSource();
        mariadbDS.setDriverClassName("org.mariadb.jdbc.Driver");
        mariadbDS.setUrl("jdbc:mariadb://web-mariadb:3306/springboot_mariadb?createDatabaseIfNotExist=true");
        mariadbDS.setUsername("root");
        mariadbDS.setPassword("password");

        DriverManagerDataSource postgresDS = new DriverManagerDataSource();
//        postgresDS.setDriverClassName("org.postgresql.Driver");
        postgresDS.setUrl("jdbc:postgresql://web-pgdb:5432/postgres?createDatabaseIfNotExist=true");
        postgresDS.setUsername("postgres");
        postgresDS.setPassword("password");

        HashMap hashMap = new HashMap();
        hashMap.put("h2DS", h2DS);
        hashMap.put("mariadbDS", mariadbDS);
        hashMap.put("postgresDS", postgresDS);
        return hashMap;
    }
}
