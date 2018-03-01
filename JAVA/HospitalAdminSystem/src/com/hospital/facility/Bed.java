package com.hospital.facility;

import com.hospital.people.Patient;

public class Bed {

    private Patient patient;

    public Bed(Patient patient) {
        this.patient = patient;
    }


    public Patient getPatient() {
        return this.patient;
    }


}
