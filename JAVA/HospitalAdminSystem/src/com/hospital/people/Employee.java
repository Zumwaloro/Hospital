package com.hospital.people;

public class Employee extends Person {

    private static int e_ID = 9999;
    private final int salary;

    public Employee(int salary, String name, String birth,
                    String persNumber, char gender) {
        super(name, birth, persNumber, gender);
        this.salary = salary;
        e_ID++;
    }


    public int getSalary() {
        return this.salary;
    }

    public int getID() {
        return e_ID;
    }



}
