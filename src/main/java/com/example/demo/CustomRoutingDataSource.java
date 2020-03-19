package com.example.demo;

import com.example.demo.utils.UrlModifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class CustomRoutingDataSource extends AbstractRoutingDataSource {

    @Autowired
    private UrlModifier urlModifier;

    @Override
    protected Object determineCurrentLookupKey() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if(attr != null && attr.getRequest().getParameter("datasource") != null) {
            return attr.getRequest().getParameter("datasource");
        } else if(urlModifier.getSuffix().equals("")){
            return "mariadbDS";
        } else {
            return urlModifier.getSuffix();
        }
    }
}