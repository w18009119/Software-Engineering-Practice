/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rss;
import java.sql.*;
import java.util.Scanner;
import java.time.LocalDate; // import the LocalDate class
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
/**
 *
 * @author (Ahmed Karam W18013861)
 */


public class RSS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        // TODO code application logic here
        
     
  connect();
  
 
  Volunterr myVolunterr = new Volunterr();
  myVolunterr.setVisible(true);
}
    
    
    
    

 public static void connect() {
        Connection conn = null;
        try {
            // db parameters
            
            
            
            String url = "jdbc:sqlite:C:\\Users\\Ahmed Karam\\Documents\\NetBeansProjects\\RSS\\src\\rss\\booking.db";
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
 
 

 
}    