package com.hospital.facility;
import com.hospital.schedule.Schedule;

public class SurgeryRoom extends Room {

    private Schedule schedule;
    private static int roomNr = 20;

    public SurgeryRoom() {
        super(roomNr);
        roomNr++;
        schedule = new Schedule();
    }


    public void addActivity(String activity, int time, String date) {
        schedule.setActivity(activity, time, date);
    }


}

