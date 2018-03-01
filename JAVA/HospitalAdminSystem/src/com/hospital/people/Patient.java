package com.hospital.people;

public class Patient extends Person {

    private final String condition;

    public Patient(String condition, String name, String birth,
                   String persNumber, char gender) {
        super(name, birth, persNumber, gender);
        this.condition = condition;
    }


    public String getCondition() {
        return this.condition;
    }
}

