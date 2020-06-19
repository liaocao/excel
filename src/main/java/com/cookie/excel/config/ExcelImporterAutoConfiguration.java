package com.cookie.excel.config;

import com.cookie.excel.service.ExImporter;
import com.jvm123.excel.common.DefaultExcelReader;
import com.jvm123.excel.common.ExcelReader;
import com.jvm123.excel.in.ExcelImporter;
import com.jvm123.excel.in.FieldTypeBinder;
import com.jvm123.excel.in.impl.DefaultFieldTypeBinder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableConfigurationProperties(ExcelConverterProperties.class)
public class ExcelImporterAutoConfiguration {

//    @Bean
    public ExImporter exImporter() {
        return new ExImporter();
    }

    @Bean
    ExcelImporter excelImporter() {
        return new ExcelImporter();
    }

    @Bean
    @ConditionalOnMissingBean(ExcelReader.class)
    ExcelReader excelReader() {
        return new DefaultExcelReader();
    }

    @Bean
    @ConditionalOnMissingBean(FieldTypeBinder.class)
    FieldTypeBinder fieldTypeBinder() {
        return new DefaultFieldTypeBinder();
    }


}
