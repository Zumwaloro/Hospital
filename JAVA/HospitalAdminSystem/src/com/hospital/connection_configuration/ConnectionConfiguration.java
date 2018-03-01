package com.hospital.connection_configuration;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionConfiguration {

    public static Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital",
                                                    "root", "Oktatok2010");
        }

        catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
