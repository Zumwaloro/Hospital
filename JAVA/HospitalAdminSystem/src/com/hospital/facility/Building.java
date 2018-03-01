package com.hospital.facility;

public class Building {

    private Department[] departments;
    public final String name;
    private int depIndex;

    public Building(String name) {
        this.name = name;
        departments = new Department[5];
        depIndex = 0;
    }


    public String getBuildingName() {
        return this.name;
    }

    public Department[] getListOfDeps() {
        return departments;
    }

    public void getDepartments() {
        if (departments.length == 0) {
            System.out.println("No departments available.");
        }
        System.out.format("%-30s%n", "Departments:");
        for (Department d : departments) {
            if (d != null) {
                System.out.format("%-30s %-20s%n", "Name:", d.getType());
            } else {
                return;
            }
        }
    }

    public void getFullDepDetails() {
        System.out.format("%-20s %20s%n", "Building:", name);
        for (Department d : departments) {
            if (d != null) {
                d.getDepDetails();
            } else {
                return;
            }
        }
    }

    public Boolean addDepartment(String name, int nrOfRoom) {
        if (depIndex == departments.length) {
            System.out.println("Building is full.");
            return false;
        } else {
            Department newD = new Department(name, nrOfRoom);
            departments[depIndex] = newD;
            depIndex++;
            return true;
        }
    }



}
