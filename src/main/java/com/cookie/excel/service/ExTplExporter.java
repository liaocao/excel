package com.cookie.excel.service;

import com.cookie.excel.config.ExcelConverterProperties;
import com.jvm123.excel.common.ExcelProperties;
import com.jvm123.excel.out.listener.TplExportListener;
import com.jvm123.excel.out.tpl.ExcelTplExporter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

@Service
public class ExTplExporter {

    @Autowired
    private ExcelConverterProperties properties;
    @Autowired
    private ExcelTplExporter tplExporter;

    private TplExportListener listener;

    private static final Logger logger = LoggerFactory.getLogger(ExTplExporter.class);

    public <T> void export(String tplPathFile, T bean, OutputStream os, String propsName){
        tplExporter.setProperties(getProps(propsName));
        tplExporter.export(tplPathFile, bean, os);
    }

    public <T> void export(File tplFile, T bean, OutputStream os, String propsName){
        tplExporter.setProperties(getProps(propsName));
        tplExporter.export(tplFile, bean, os);
    }

    public <T> void export(InputStream tplIs, T bean, OutputStream os, String propsName){
        tplExporter.setProperties(getProps(propsName));
        tplExporter.export(tplIs, bean, os);
    }

    public void exportMap(String tplPathFile, Map<String, Object> map, OutputStream os, String propsName){
        tplExporter.setProperties(getProps(propsName));
        tplExporter.exportMap(tplPathFile, map, os);
    }

    public void exportMap(File tplFile, Map<String, Object> map, OutputStream os, String propsName){
        tplExporter.setProperties(getProps(propsName));
        tplExporter.exportMap(tplFile, map, os);
    }

    public void exportMap(InputStream tplIs, Map<String, Object> map, OutputStream os, String propsName){
        tplExporter.setProperties(getProps(propsName));
        tplExporter.exportMap(tplIs, map, os);
    }

    private ExcelProperties getProps(String propsName) {
        ExcelProperties props = properties.getPropsMap().get(propsName);
        if (props == null) {
            props = new ExcelProperties();
            logger.warn("未配置excel转换属性\"{}\"，使用\"default\"属性。", propsName);
        }
        return props;
    }

    public TplExportListener getListener() {
        return listener;
    }

    public void setListener(TplExportListener listener) {
        this.listener = listener;
        if (listener != null) {
            tplExporter.setListener(listener);
        }
    }
}
