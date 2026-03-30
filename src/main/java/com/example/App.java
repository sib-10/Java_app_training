package com.example;

import java.sql.*;
import java.io.*;

public class App {

    public int add(int a, int b) {
        return a + b;
    }

    // VULN 1: SQL Injection
    public void getUser(Connection conn, String userInput) throws SQLException {
        Statement stmt = conn.createStatement();
        String query = "SELECT * FROM users WHERE name = '" + userInput + "'";
        stmt.executeQuery(query);
    }

    // VULN 2: Path Traversal
    public String readFile(String filename) throws IOException {
        File file = new File("/data/" + filename);
        return new String(java.nio.file.Files.readAllBytes(file.toPath()));
    }

    // VULN 3: Command Injection
    public void runCommand(String userInput) throws IOException {
        Runtime.getRuntime().exec("ping " + userInput);
    }

    // VULN 4: Hardcoded Password
    public Connection connectDB() throws SQLException {
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/mydb",
            "admin",
            "SuperSecret123!"
        );
    }

    public static void main(String[] args) {
        App app = new App();
        System.out.println("Sum: " + app.add(5, 3));
    }
}