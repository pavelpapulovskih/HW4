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
                "(id integer PRIMARY KEY ,\n" +
                "first_name text NOT NULL,\n" +
                "last_name text NOT NULL,\n" +
                "phone_number text NOT NULL);");
        createTable("CREATE TABLE IF NOT EXISTS employee (\n"
                + " id integer PRIMARY KEY,\n"
                + " name text NOT NULL,\n"
                + " capacity real,\n"
                + " info_id integer NOT NULL\n"
                + ");");
        insertValue("MAX",100);
        insertValue("JAR",110);
        insertValue("IAN",90);
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

    private static void insertValue(String name, double capacity, Integer info) {
        String sql = "INSERT INTO employee(name, capacity, info) VALUES(?,?, ?)";
        try{
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setDouble(2, capacity);
            pstmt.setInt(3, info);
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
        String sql = "DELETE FROM employees";
        try {
            Statement stmt  = connection.createStatement();
            stmt.execute(sql);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        connection.close();
        System.out.println("Closed database successfully");
    }
}
