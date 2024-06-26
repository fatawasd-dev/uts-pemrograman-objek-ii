/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.laundry.fahmi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class Koneksi {
    // URL, username, dan password untuk database Anda
    private static final String URL = "jdbc:mysql://localhost:3306/laundrydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    // Koneksi statis
    private static Connection connection = null;

    // Metode untuk mendapatkan Koneksi
    public static Connection getConnection() {
        if (connection == null) {
            try {
                // Memuat driver JDBC
                Class.forName("com.mysql.cj.jdbc.Driver");
                // Membuat Koneksi ke database
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    // Metode untuk menutup Koneksi
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
