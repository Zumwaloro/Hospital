package com.hospital.people;

public class Specialist extends Doctor {

    private final String spec;

    public Specialist (String spec ,String department, int salary, String name,
                       String birth, String persNumber, char gender) {

        super(department, salary, name, birth, persNumber, gender);

        this.spec = spec;

    }

    public String getSpecialisation() {
        return this.spec;
    }


}

