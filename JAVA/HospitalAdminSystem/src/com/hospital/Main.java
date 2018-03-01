package com.hospital;

import com.hospital.connection_configuration.ConnectionConfiguration;
import com.hospital.facility.Department;
import com.hospital.facility.Hospital;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Main {


    public static void main (String[] args) {

        //Establishing connection with server:
        Connection connection = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            if (connection != null) {
                System.out.println("Connection established!");
            }


            Statement statement = connection.createStatement();

            //We create our virtual hospital:
            Hospital hospital = new Hospital("Saint Margaret Hospital");
            hospital.setBuilding("North Wing");
            hospital.setBuilding("South Wing");

            //Now we add departments listed in the MySQL database:
            String getDep = "SELECT *FROM department";
            ResultSet results = statement.executeQuery(getDep);

            int index = 1;
            while (results.next()) {
                String depName = results.getString("department_name");
                int nrOfRooms = results.getInt("nr_of_bedrooms");

                if (index % 2 == 0) {
                    hospital.getBuilding("North Wing").addDepartment(depName, nrOfRooms);
                    index++;
                } else {
                    hospital.getBuilding("South Wing").addDepartment(depName, nrOfRooms);
                    index++;
                }
            }

            results.close();

            //We also pull staff data from MySQL database:
            String getStaff = "SELECT *FROM staff";
            results = statement.executeQuery(getStaff);

            while (results.next()) {
                String firstName = results.getString("first_name");
                String lastName = results.getString("last_name");
                String dob = results.getString("date_of_birth");
                String[] newDOB = dob.split("-");
                dob = newDOB[2] + "." + newDOB[1] + "." + newDOB[0];
                String persNr = results.getString("personal_number");
                String role = results.getString("role");
                String dept = results.getString("department");
                char gender = results.getString("gender").charAt(0);
                int salary = results.getInt("monthly_salary");

                Department d = hospital.findDepartment(dept);

                if (role.equals("Specialist")) {
                    d.addSpecialist((firstName + " " + lastName), dob, persNr, dept,
                            salary, gender, role);
                } else if (role.equals("GP")) {
                    d.addGP((firstName + " " + lastName), dob, persNr, dept,
                            salary, gender);
                } else {
                    d.addNonMedic((firstName + " " + lastName), dob, persNr,
                            salary, gender, role);
                }
            }

            hospital.getBuilding("North Wing").getFullDepDetails();
            System.out.println("\n");
            hospital.getBuilding("South Wing").getFullDepDetails();
            results.close();

           /* //Just a few lines to show that we can also insert data into the MySQL database:
            String addActivity = "INSERT INTO activity VALUE" +
                    "('Surgery', '2018-04-15', 1000, 'Betty Ware')," +
                    "('Consultation', '2018-03-07', 1300, 'Teresa Browder')," +
                    "('Check-up', '2018-02-20', 1400, 'Michael Douglass')";
            statement.execute(addActivity);*/


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
  }

