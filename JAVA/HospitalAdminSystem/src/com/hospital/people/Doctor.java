package com.hospital.people;

import com.hospital.schedule.Schedule;

public class Doctor extends Medical {

    private Schedule schedule;

    public Doctor(String department, int salary, String name,
                  String birth, String persNumber, char gender) {

        super(department, salary, name, birth, persNumber, gender);

        schedule = new Schedule();

    }

    public void addAppointment(String activity, int time, String date) {
        schedule.setActivity(activity, time, date);
    }

}

