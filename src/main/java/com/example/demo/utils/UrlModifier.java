package com.example.demo.utils;

import org.springframework.stereotype.Component;

@Component
public class UrlModifier {

    private String suffix = "";

    public String getSuffix() {
        return suffix;
    }

    public void setSuffixForMariaDB() {
        this.suffix = "mariadbDS";
    }

    public void setSuffixForPostgres() {
        this.suffix = "postgresDS";
    }
}
