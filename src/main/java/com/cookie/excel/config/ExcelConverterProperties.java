package com.cookie.excel.config;

import com.jvm123.excel.common.ExcelProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "excel.converter")
@Primary
public class ExcelConverterProperties {

    private String name;

    private Map<String, ExcelProperties> propsMap;

    @PostConstruct
    public void setDefault() {
        if (propsMap == null) {
            propsMap = new HashMap<>();
        }
        if (!propsMap.containsKey("default")) {
            propsMap.put("default", new ExcelProperties());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, ExcelProperties> getPropsMap() {
        return propsMap;
    }

    public void setPropsMap(Map<String, ExcelProperties> propsMap) {
        this.propsMap = propsMap;
    }
}
