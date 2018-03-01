package com.hospital.people;

public class Medical extends Employee {

    private final String department;

    public Medical(String department, int salary, String name,
                   String birth, String persNumber, char gender) {
        super(salary, name, birth, persNumber, gender);
        this.department = department;
    }


    public String getDepartment() {
        return this.department;
    }

}

