package com.hospital.schedule;

import java.time.LocalDate;
import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.ArrayList;
import java.util.Collections;

public class Schedule {

    private ArrayList<Activity> table;

    public Schedule() {

        table = new ArrayList<Activity>();

    }

    //inner class for info about the activities:
    private class Activity implements Comparable<Activity> {

        String toDo;
        int time;
        String date;

        Activity(String toDo, int time, String date) {
            this.toDo = toDo;
            this.time = time;
            this.date = date;
        }

        @Override
        public int compareTo(Activity other) {
            String a = ""+other.time;
            String b = ""+this.time;
            return b.compareTo(a);
        }

    }


//here we start the methods of Schedule:

    //we set activity for the given day:
    public void setActivity(String activity, int time, String date) {

        if (isDateTaken(date, time)) {
            System.out.println("Date is already taken. Please choose another one.");
            return;
        }

        else {

            Activity act = new Activity(activity, time, date);
            table.add(act);

        }

    }

    //finds the day of a given date:
    public DayOfWeek getDay(String date) {
        String[] values = date.split("\\.");
        LocalDate day = LocalDate.of(Integer.parseInt(values[2]),
                Integer.parseInt(values[1]),
                Integer.parseInt(values[0]));
        return day.getDayOfWeek();

    }

    //gets the activities by given day:
    public void getDailyActivity(String date) {
        ArrayList<Activity> collection = new ArrayList<Activity>();

        for(Activity a : table) {
            if (a.date.equals(date)) {
                collection.add(a);
            }
        }

        Collections.sort(collection);

        System.out.format("%-13s %13s %13s%n", "Date:", date, getDay(date));
        System.out.println("-----------------------------------------");
        System.out.format("%-20s %20s%n", "Activity:", "Time:");

        for(Activity act : collection) {
            System.out.format("%-20s %20s%n", act.toDo, act.time);
        }
    }

    //returns true if date is taken:
    public Boolean isDateTaken(String date, int time) {
        for (Activity a : table) {
            if (a == null) {
                return false;
            } else if (a.date.equals(date) && a.time == time) {
                return true;
            }
        }
        return false;
    }


}

