package com.hospital.facility;

import com.hospital.schedule.Schedule;

public class ExaminationRoom extends Room {

    private Schedule schedule;
    private static int roomNR = 10;


    public ExaminationRoom() {
        super(roomNR);
        roomNR++;
        schedule = new Schedule();
    }


    public void addActivity(String activity, int time, String date) {
        schedule.setActivity(activity, time, date);
    }


}

