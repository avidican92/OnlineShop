package com.fasttrackit.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBHelper {
	public static Connection getConnection() {
        Properties connectionProps = new Properties();
        connectionProps.put("user", "root");
        connectionProps.put("password", "fasttrackit");

        try {
        	Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception ex){
        	ex.printStackTrace();
        }
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/magazinonline",
                    connectionProps);
            System.out.println("Conexiunea la baza de date a fost deschisa");
            return con;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void closeConnection(Connection con) {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

