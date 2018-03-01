package com.hospital.people;

import java.time.Year;

public class Person {

    private final String name;
    private final String birth;
    private final String persNumber;
    private final char gender;

    public Person (String name, String birth, String persNumber, char gender) {

        this.name = name;
        this.birth = birth;
        this.persNumber = persNumber;
        this.gender = gender;

    }


    //some methods to get info out of the object:

    public String getName() {
        return this.name;
    }

    public String getBirth() {
        return this.birth;
    }

    public String getPersNumber() {
        return this.persNumber;
    }

    public int getAge() {
        String[] tmp = getBirth().split("\\.");
        return (Year.now().getValue() - Integer.parseInt(tmp[2]));
    }

    public char getGender() {
        return this.gender;
    }

}

