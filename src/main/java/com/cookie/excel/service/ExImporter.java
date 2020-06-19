package com.cookie.excel.service;

import com.cookie.excel.config.ExcelConverterProperties;
import com.jvm123.excel.common.ExcelProperties;
import com.jvm123.excel.common.ExcelReader;
import com.jvm123.excel.in.ExcelImporter;
import com.jvm123.excel.in.FieldTypeBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.InputStream;
import java.util.List;

@Service
public class ExImporter {

    @Autowired
    private ExcelReader excelReader;
    @Autowired
    private FieldTypeBinder fieldTypeBinder;
    @Autowired
    private ExcelConverterProperties properties;
    @Autowired
    private ExcelImporter excelImporter;

    private final String DEFAULT_PROPS_NAME = "default";

    public <T> List<T> convert(String filePath, String propsName, Class<T> tClazz) {
        setConverterAttr(propsName);
        return excelImporter.convert(filePath, tClazz);
    }

    public <T> List<T> convert(File file, String propsName, Class<T> tClazz) {
        setConverterAttr(propsName);
        return excelImporter.convert(file, tClazz);
    }

    public <T> List<T> convert(InputStream is, String propsName, Class<T> tClazz) {
        setConverterAttr(propsName);
        return excelImporter.convert(is, tClazz);
    }


    public <T> List<T> convert(String filePath, Class<T> tClazz) {
        setConverterAttr(DEFAULT_PROPS_NAME);
        return excelImporter.convert(filePath, tClazz);
    }

    public <T> List<T> convert(File file, Class<T> tClazz) {
        setConverterAttr(DEFAULT_PROPS_NAME);
        return excelImporter.convert(file, tClazz);
    }

    public <T> List<T> convert(InputStream is, Class<T> tClazz) {
        setConverterAttr(DEFAULT_PROPS_NAME);
        return excelImporter.convert(is, tClazz);
    }


    private void setConverterAttr(ExcelProperties props) {
        excelImporter.setExcelReader(excelReader);
        excelImporter.setFieldTypeBinder(fieldTypeBinder);
        excelImporter.setExcelProperties(props);
    }

    private void setConverterAttr(String propsName) {
        excelImporter.setExcelReader(excelReader);
        excelImporter.setFieldTypeBinder(fieldTypeBinder);
        ExcelProperties props = properties.getPropsMap().get(propsName);
        excelImporter.setExcelProperties(props);
    }

    public ExcelImporter getExcelImporter() {
        return excelImporter;
    }

    public int multiPlus(int... nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
