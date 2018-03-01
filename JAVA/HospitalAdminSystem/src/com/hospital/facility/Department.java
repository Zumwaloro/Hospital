package com.hospital.facility;

import com.hospital.people.*;

import java.util.ArrayList;

public class Department {

    private final String name;
    private ArrayList<Employee> staff;
    private Bedroom[] bedrooms;
    private final ExaminationRoom examRoom;
    private final SurgeryRoom surgroom;

    public Department(String name, int nrOfRoom) {
        this.name= name;
        staff = new ArrayList<Employee>();
        bedrooms = new Bedroom[nrOfRoom];
        examRoom = new ExaminationRoom();
        surgroom = new SurgeryRoom();
    }

    //gets foramtted details about the dep:
    public void getDepDetails() {
        System.out.format("%-20s %20s%n", "Department:", getType());
        System.out.format("%-20s %20s%n", "Number of bedrooms:", bedrooms.length);
        System.out.format("%-20s %20s%n", "Examination room?", "Yes");
        System.out.format("%-20s %20s%n", "Surgery room?", "Yes");
        System.out.println("______________________________________________________________");
        System.out.format("%-20s %20s %20s%n", "Staff:", "Date-of-birth:", "Salary:");
        for (Employee e : staff) {
            if(e != null) {
                System.out.format("%-20s %20s %20s%n", e.getName(), e.getBirth(), e.getSalary());
            } else {
                System.out.println("\n");
                return;
            }
        }
        System.out.println("**************************************************************\n");
    }

    //get the type of the department:
    public String getType() {
        return this.name;
    }

    //adds GP to the department:
    public void addGP(String name, String birth, String persNumber, String department,
                      int salary, char gender) {
        GP newGP = new GP(department, salary, name, birth, persNumber, gender);
        staff.add(newGP);
    }

    //adds specialist to the department:
    public void addSpecialist(String name, String birth, String persNumber, String department,
                              int salary, char gender, String specialisation) {
        Specialist newSP = new Specialist(specialisation, department, salary, name,
                birth, persNumber, gender);
        staff.add(newSP);
    }

    //adds a nurse to the dep:
    public void addNurse(String name, String birth, String persNumber, String department,
                         int salary, char gender) {
        Nurse newNU = new Nurse(department, salary, name,
                birth, persNumber, gender);
        staff.add(newNU);
    }

    //adds non-medical staff member to the dep:
    public void addNonMedic(String name, String birth, String persNumber,
                            int salary, char gender, String title) {
        NonMedical newNM = new NonMedical(title, salary, name,
                birth, persNumber, gender);
        staff.add(newNM);
    }

}
