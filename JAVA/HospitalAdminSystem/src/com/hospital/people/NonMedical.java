package com.hospital.people;

public class NonMedical extends Employee {

    private final String title;

    public NonMedical(String title, int salary, String name,
                      String birth, String persNumber, char gender) {
        super(salary, name, birth, persNumber, gender);
        this.title = title;
    }


    public String getTitle() {
        return this.title;
    }

}

