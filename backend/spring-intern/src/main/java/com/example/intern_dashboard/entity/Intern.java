package com.example.intern_dashboard.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "interns")

public class Intern {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    private String name;
    private String email;
    private String department;
    private String college;
    private String phone;

    @Column(name = "joining_date")
    private String joiningDate;

    private String status;

    public Intern() {
    }

    public Intern(
            String name,
            String email,
            String department,
            String college,
            String phone,
            String joiningDate,
            String status
    ) {

        this.name = name;
        this.email = email;
        this.department = department;
        this.college = college;
        this.phone = phone;
        this.joiningDate = joiningDate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartment() {
        return department;
    }

    public String getCollege() {
        return college;
    }

    public String getPhone() {
        return phone;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public String getStatus() {
        return status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}