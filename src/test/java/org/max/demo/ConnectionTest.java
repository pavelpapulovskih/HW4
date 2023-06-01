package org.max.demo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class ConnectionTest {

    private static Connection connection;
    @BeforeAll
    static void init() throws SQLException {
        connect("connectiontest.db");
        createTable("CREATE TABLE IF NOT EXISTS employee_info\n" +
                "(id integer PRIMARY KEY,\n" +
                "first_name text NOT NULL,\n" +
                "last_name text NOT NULL,\n" +
                "phone_number text NOT NULL);");
        createTable("CREATE TABLE IF NOT EXISTS employee (\n"
                + " id integer PRIMARY KEY,\n"
                + " name text NOT NULL,\n"
                + " capacity real,\n"
                + " info_id integer NOT NULL\n"
                + ");");
        insertEmployeeInfo(1,"Иван", "Иванов", "+7 927 0000001");
        insertEmployeeInfo(2,"Петр", "Петров", "+7 927 0000002");
        insertEmployeeInfo(3,"Сидор", "Сидоров", "+7 927 0000003");
        insertEmployeeValue(1,"MAX",100,1);
        insertEmployeeValue(2,"JAR",110,2);
        insertEmployeeValue(3,"IAN",90,3);
    }


    private static void connect(String name) {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:"+name);
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }

    private static void createTable(String sql) {
        try{
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void insertEmployeeInfo(Integer id, String firstName, String lastName, String phone) {
        String sql = "INSERT INTO employee_info(id, first_name, last_name, phone_number) VALUES(?,?,?,?)";
        try{
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setString(2, firstName);
            pstmt.setString(3, lastName);
            pstmt.setString(4, phone);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void insertEmployeeValue(Integer id, String name, double capacity, Integer info) {
        String sql = "INSERT INTO employee(id, name, capacity, info_id) VALUES(?,?,?,?)";
        try{
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setDouble(3, capacity);
            pstmt.setInt(4, info);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void select() {
        String sql = "SELECT * FROM employees";

        try {
            Statement stmt  = connection.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" +
                        rs.getString("name") + "\t" +
                        rs.getDouble("capacity"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    @AfterAll
    static void close() throws SQLException {
        String sqlDeleteEmployee = "DELETE FROM employee";
        String sqlDeleteInfo = "DELETE FROM employee_info";

        try {
            Statement stmt  = connection.createStatement();
            stmt.execute(sqlDeleteEmployee);
            stmt.execute(sqlDeleteInfo);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        connection.close();
        System.out.println("Closed database successfully");
    }
}
