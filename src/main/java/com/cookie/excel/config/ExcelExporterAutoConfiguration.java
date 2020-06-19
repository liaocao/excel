package com.cookie.excel.config;

import com.cookie.excel.service.ExExporter;
import com.cookie.excel.service.ExTplExporter;
import com.jvm123.excel.out.ExcelExporter;
import com.jvm123.excel.out.tpl.ExcelTplExporter;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableConfigurationProperties(ExcelConverterProperties.class)
public class ExcelExporterAutoConfiguration {

//    @Bean
    public ExExporter exExporter() {
        return new ExExporter();
    }

//    @Bean
    public ExTplExporter exTplExporter() {
        return new ExTplExporter();
    }

    @Bean
    ExcelExporter excelExporter() {
        return new ExcelExporter();
    }

    @Bean
    ExcelTplExporter excelTplExporter() {
        return new ExcelTplExporter();
    }

}
