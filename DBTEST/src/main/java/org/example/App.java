package org.example;

import java.sql.*;

public class App {

    public static void main( String[] args ) throws SQLException {
        //create connection for a server installed in localhost, with a user "root" with no password
        try (Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost/test", "root", "password")) {
            // create a Statement
            try (Statement stmt = conn.createStatement()) {
                //execute query
                try (ResultSet rs = stmt.executeQuery("show tables")) {
                    //position result to first
                    while(rs.next()){
                        System.out.println(rs.getString(1));
                    }
                    //rs.first();
                    //System.out.println(rs.getString(1)); //result is "Hello World!"
                } catch(Exception e){
                    System.out.print("Exception: ");
                    System.out.println(e);
                }
            }
        }
    }
}