package com.cookie.excel.domain;

import java.util.Date;
import java.util.List;

/**
 * @author sky
 * @date 2020/6/19 14:55
 */
public class Person {

    private String name;
    private String address;
    private int age;
    private Date date;

    private List<Grade> gradeList;
    private TotalGrade totalGrade;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Grade> getGradeList() {
        return gradeList;
    }

    public void setGradeList(List<Grade> gradeList) {
        this.gradeList = gradeList;
    }

    public TotalGrade getTotalGrade() {
        return totalGrade;
    }

    public void setTotalGrade(TotalGrade totalGrade) {
        this.totalGrade = totalGrade;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
