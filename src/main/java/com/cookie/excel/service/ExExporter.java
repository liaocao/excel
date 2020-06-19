package com.cookie.excel.service;

import com.cookie.excel.config.ExcelConverterProperties;
import com.jvm123.excel.common.ExcelProperties;
import com.jvm123.excel.out.ExcelExporter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

@Service
public class ExExporter {

    @Autowired
    private ExcelConverterProperties properties;
    @Autowired
    private ExcelExporter exporter;

    private final String DEFAULT_PROPS_NAME = "default";

    private static final Logger logger = LoggerFactory.getLogger(ExExporter.class);

    public <T> void export(List<T> beanList, String pathFile){
        init();
        exporter.setProperties(getProps(DEFAULT_PROPS_NAME));
        exporter.export(beanList, pathFile);
    }

    public <T> void export(List<T> beanList, File file){
        init();
        exporter.setProperties(getProps(DEFAULT_PROPS_NAME));
        exporter.export(beanList, file);
    }

    public <T> void export(List<T> beanList, OutputStream os){
        init();
        exporter.setProperties(getProps(DEFAULT_PROPS_NAME));
        exporter.export(beanList, os);
    }

    public <T> void export(List<T> beanList, String pathFile, String propsName){
        init();
        exporter.setProperties(getProps(propsName));
        exporter.export(beanList, pathFile);
    }

    public <T> void export(List<T> beanList, File file, String propsName){
        init();
        exporter.setProperties(getProps(propsName));
        exporter.export(beanList, file);
    }

    public <T> void export(List<T> beanList, OutputStream os, String propsName){
        init();
        exporter.setProperties(getProps(propsName));
        exporter.export(beanList, os);
    }

    public void exportMapList(List<Map<String, Object>> mapList, String pathFile){
        init();
        exporter.setProperties(getProps(DEFAULT_PROPS_NAME));
        exporter.exportMapList(mapList, pathFile);
    }

    public void exportMapList(List<Map<String, Object>> mapList, File file){
        init();
        exporter.setProperties(getProps(DEFAULT_PROPS_NAME));
        exporter.exportMapList(mapList, file);
    }

    public void exportMapList(List<Map<String, Object>> mapList, OutputStream os){
        init();
        exporter.setProperties(getProps(DEFAULT_PROPS_NAME));
        exporter.exportMapList(mapList, os);
    }

    public void exportMapList(List<Map<String, Object>> mapList, String pathFile, String propsName){
        init();
        exporter.setProperties(getProps(propsName));
        exporter.exportMapList(mapList, pathFile);
    }

    public void exportMapList(List<Map<String, Object>> mapList, File file, String propsName){
        init();
        exporter.setProperties(getProps(propsName));
        exporter.exportMapList(mapList, file);
    }

    public void exportMapList(List<Map<String, Object>> mapList, OutputStream os, String propsName){
        init();
        exporter.setProperties(getProps(propsName));
        exporter.exportMapList(mapList, os);
    }

    private ExcelProperties getProps(String propsName) {
        ExcelProperties props = properties.getPropsMap().get(propsName);
        if (props == null) {
            props = new ExcelProperties();
            logger.warn("未配置excel转换属性\"{}\"，使用\"default\"属性。", propsName);
        }
        return props;
    }

    private void init() {
        exporter.setWorkbook(new XSSFWorkbook());
    }
}
