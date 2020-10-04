package com.example.burgerfreakz.Classes;

public class Employee {
    private int id;
    private String EmpName, EmpEmail, EmpCity, EmpContactNumber;

    public Employee() {
    }

    public Employee(int id, String empName, String empEmail, String empCity, String empContactNumber) {
        this.id = id;
        this.EmpName = empName;
        this.EmpEmail = empEmail;
        this.EmpCity = empCity;
        this.EmpContactNumber = empContactNumber;
    }

    public Employee(String empName, String empEmail, String empCity, String empContactNumber) {
        EmpName = empName;
        EmpEmail = empEmail;
        EmpCity = empCity;
        EmpContactNumber = empContactNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmpName() {
        return EmpName;
    }

    public void setEmpName(String empName) {
        EmpName = empName;
    }

    public String getEmpEmail() {
        return EmpEmail;
    }

    public void setEmpEmail(String empEmail) {
        EmpEmail = empEmail;
    }

    public String getEmpCity() {
        return EmpCity;
    }

    public void setEmpCity(String empCity) {
        EmpCity = empCity;
    }

    public String getEmpContactNumber() {
        return EmpContactNumber;
    }

    public void setEmpContactNumber(String empContactNumber) {
        EmpContactNumber = empContactNumber;
    }
}
