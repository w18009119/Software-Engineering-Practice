/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rss;
import java.sql.*;
import java.util.Scanner;
import java.time.LocalDate; // import the LocalDate class
/**
 *
 * @author W18013861
 */


public class RSS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        // TODO code application logic here
        
  createNewDatabase("booking.db");     
  connect();
  createNewTable();
  Volunterr myVolunterr = new Volunterr();
  myVolunterr.setVisible(true);
}
    
    
    public static void createNewDatabase(String fileName) {
 
        String url = "jdbc:sqlite:U:\\My Documents\\NetBeansProjects\\RSS\\src\\rss" + fileName;
 
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    

 public static void connect() {
        Connection conn = null;
        try {
            // db parameters
            
            
            
            String url = "jdbc:sqlite:U:\\My Documents\\NetBeansProjects\\RSS\\src\\rss\\booking.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
 
 
 public static void createNewTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:U:\\My Documents\\NetBeansProjects\\RSS\\src\\rss\\booking.db";
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS appointment (\n"
                + "    id integer PRIMARY KEY,\n"
                + "    time time NOT NULL,\n"
                + "    date date NOT NULL \n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
 
    

 
}    
