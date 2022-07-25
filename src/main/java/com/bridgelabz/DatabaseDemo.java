package com.bridgelabz;

import java.sql.*;

public class DatabaseDemo {
    public static void main(String[] args) throws SQLException {
        System.out.println("Welcome the Database");
        String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service?userSSL=false";
        String name = "root";
        String password = "Sahil@6436";
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver is Loaded");
            connection = DriverManager.getConnection(jdbcURL, name, password);
            System.out.println("connection is successfully");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from payroll_service.employee_payroll");
            System.out.println("Retrive the Employee Payroll");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + " " + resultSet.getString("name")
                        + " " + resultSet.getString("start"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            connection.close();
        }
    }
}
