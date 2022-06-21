
package com.daniela.doctors.be.data;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Database {

    private static Database theInstance;

    public static Database instance() {
        if (theInstance == null) {
            theInstance = new Database();
        }
        return theInstance;
    }

    Connection cnx;

    public Database() {
        cnx = this.getConnection();
    }

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String URL_conexion
                    = "jdbc:mysql://192.168.100.23:3306/doctors?user="
                    + "dani"
                    + "&password="
                    + "dani"
                    + "&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
            Connection conn = (Connection) DriverManager.getConnection(URL_conexion);
            return conn;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException ex) { 
            System.out.println(ex.getMessage());
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Error e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public PreparedStatement prepareStatement(String statement) throws SQLException {
        return cnx.prepareStatement(statement);
    }

    public int executeUpdate(PreparedStatement statement) {
        try {
            statement.executeUpdate();
            return statement.getUpdateCount();
        } catch (SQLException ex) {
            return 0;
        }
    }

    public ResultSet executeQuery(PreparedStatement statement) {
        try {
            return statement.executeQuery();
        } catch (SQLException ex) {
        }
        return null;
    }
}
