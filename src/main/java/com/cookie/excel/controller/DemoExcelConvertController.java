package com.cookie.excel.controller;

import com.cookie.excel.domain.Grade;
import com.cookie.excel.domain.Person;
import com.cookie.excel.domain.TotalGrade;
import com.cookie.excel.service.ExTplExporter;
import com.jvm123.excel.common.ExcelProperties;
import com.jvm123.excel.out.tpl.ExcelTplExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author sky
 * @date 2020/6/19 14:39
 */
@RestController
public class DemoExcelConvertController {

    @Autowired
    private ExTplExporter exTplExporter;

    //localhost:8080/excel
    @GetMapping("excel")
    public void test5(HttpServletResponse response) throws IOException {
        Person person = createPerson();
        response.addHeader("Content-Disposition","attachment;filename=grade.xlsx");

        exTplExporter.export("模板.xlsx", person,
                response.getOutputStream(), "grade");
    }

//    private void initProperties(ExcelTplExporter tplExporter){
//        ExcelProperties properties = new ExcelProperties();
//        LinkedHashMap<String, Object> nameLocationMap = new LinkedHashMap<>();
//        nameLocationMap.put("name", "B2");
//        nameLocationMap.put("age", "D2");
//        nameLocationMap.put("address", "b4");
//        LinkedHashMap<String, String> gradeMap = new LinkedHashMap<>();
//        gradeMap.put("project", "b8");
//        gradeMap.put("grade", "c8");
//        nameLocationMap.put("gradeList", gradeMap);
//        LinkedHashMap<String, String> totalGradeMap = new LinkedHashMap<>();
//        totalGradeMap.put("project", "b13");
//        totalGradeMap.put("grade", "c13");
//        nameLocationMap.put("totalGrade", totalGradeMap);
//
//        properties.setNameLocationMap(nameLocationMap);
//        tplExporter.setProperties(properties);
//    }

    private Person createPerson(){
        Person person = new Person();
        person.setName("西门");
        person.setAddress("甘肃");
        person.setAge(18);
        person.setDate(new Date());

        Grade grade1 = new Grade();
        grade1.setProject("语文");
        grade1.setGrade(new Float(91.0));

        Grade grade2 = new Grade();
        grade2.setProject("数学");
        grade2.setGrade(new Float(91.0));

        Grade grade3 = new Grade();
        grade3.setProject("English");
        grade3.setGrade(new Float(91.0));

        Grade grade4 = new Grade();
        grade4.setProject("历史");
        grade4.setGrade(new Float(91.0));

        List<Grade> grades = new ArrayList<>();
        grades.add(grade1);
        grades.add(grade2);
        grades.add(grade3);
        grades.add(grade4);
        person.setGradeList(grades);

        TotalGrade totalGrade = new TotalGrade();
        totalGrade.setProject("总分");
        totalGrade.setGrade(new Float(366.0));
        person.setTotalGrade(totalGrade);

        return person;
    }
}