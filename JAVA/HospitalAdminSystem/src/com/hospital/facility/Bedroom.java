package com.hospital.facility;

import com.hospital.people.Patient;

public class Bedroom extends Room {

    private Bed[] beds;
    private static int roomNR = 200;

    public Bedroom() {
        super(roomNR);
        beds = new Bed[10];
    }

    //checks if a patient is in the room, returns it if so:
    public Patient findPatient(String name) {
        for (Bed b : beds) {
            if (b.getPatient().getName().equals(name)) {
                return b.getPatient();
            } else {
                continue;
            }
        }
        System.out.println("patient not found.");
        return null;
    }

    //assigns a bed to a patient:
    public Boolean assignBed (Patient pat) {
        for (int x = 0; x < beds.length; x++) {
            if (beds[x] == null) {
                Bed newBed = new Bed(pat);
                beds[x] = newBed;
                return true;
            } else {
                continue;
            }
        }
        return false;
    }


}
