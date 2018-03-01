package com.hospital.facility;

import java.util.ArrayList;

public class Hospital {

    public final String name;
    private ArrayList<Building> buildings;

    public Hospital(String name) {
        this.name = name;
        buildings = new ArrayList<Building>();
    }


    public void getBuildingsInfo() {
        if(buildings.size() == 0) {
            System.out.println("No buildings.");
            return;
        } else {
            for (Building b : buildings) {
                System.out.println(b.getBuildingName() + ":\n");
                b.getFullDepDetails();
                System.out.println("------------------------------------------------");
            }
        }
    }

    public void setBuilding(String name) {
        Building newb = new Building(name);
        buildings.add(newb);
    }

    public Department findDepartment(String depName) {
        for (Building b : buildings) {
            for (Department d : b.getListOfDeps()) {
                if (d != null && d.getType().equals(depName)) {
                    return d;
                } else {
                    continue;
                }
            }
        }
        System.out.println("No department found.");
        return null;
    }

    public Building getBuilding (String name) {
        if (buildings.size() != 0) {
            for (Building b : buildings) {
             if (b.getBuildingName().equals(name)) {
                 return b;
             }
            }
        }
     return null;
    }


}

