package com.cookie.excel;

import com.cookie.excel.domain.Grade;
import com.cookie.excel.domain.Person;
import com.cookie.excel.domain.TotalGrade;
import com.jvm123.excel.common.ExcelProperties;
import com.jvm123.excel.out.tpl.ExcelTplExporter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.*;

/**
 * @author sky
 * @date 2020/6/19 15:10
 */
public class Test3 {

    public static void main(String[] args) throws FileNotFoundException {
        Person p = createPerson();
//        p.setAddress("广东广州黄浦区科技企业加速器开元大道");
//        p.setAge(12);
//        p.setName("柳成功");
//
//        List<Map> gradeList = new ArrayList<>();
//        Map<String, Object> yuwen = new HashMap<>();
//        yuwen.put("project", "语文");
//        yuwen.put("grade", "90");
//        Map<String, Object> shuxue = new HashMap<>();
//        shuxue.put("project", "数学");
//        shuxue.put("grade", "100");
//        gradeList.add(yuwen);
//        gradeList.add(shuxue);
//        p.setGradeList(gradeList);
//
//        Map<String, Object> totalGrade = new HashMap<>();
//        totalGrade.put("project", "总分");
//        totalGrade.put("grade", "190");
//        p.setTotalGrade(totalGrade);
//
        ExcelProperties properties = new ExcelProperties();
        LinkedHashMap<String, Object> nameLocationMap = new LinkedHashMap<>();
        nameLocationMap.put("name", "B2");
        nameLocationMap.put("age", "D2");
        nameLocationMap.put("address", "b4");
        LinkedHashMap<String, String> gradeMap = new LinkedHashMap<>();
        gradeMap.put("project", "b8");
        gradeMap.put("grade", "c8");
        nameLocationMap.put("gradeList", gradeMap);
        LinkedHashMap<String, String> totalGradeMap = new LinkedHashMap<>();
        totalGradeMap.put("project", "b13");
        totalGradeMap.put("grade", "c13");
        nameLocationMap.put("totalGrade", totalGradeMap);


        properties.setNameLocationMap(nameLocationMap);

        ExcelTplExporter tplExporter = new ExcelTplExporter();
        tplExporter.setProperties(properties);
        tplExporter.export("模板.xlsx", p, new FileOutputStream(p.getName() + "同学成绩单.xlsx"));
    }

    private static Person createPerson(){
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
