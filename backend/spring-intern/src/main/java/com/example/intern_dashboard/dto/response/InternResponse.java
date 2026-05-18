package com.example.intern_dashboard.dto.response;

public class InternResponse {

    private int id;
    private String name;
    private String email;
    private String department;
    private String college;
    private String phone;
    private String joiningDate;
    private String status;

    public InternResponse() {
    }

    public InternResponse(
            int id,
            String name,
            String email,
            String department,
            String college,
            String phone,
            String joiningDate,
            String status
    ) {
        this.id = id;
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

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}