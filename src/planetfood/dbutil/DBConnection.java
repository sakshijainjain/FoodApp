/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planetfood.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class DBConnection {
    private static Connection conn;
    static{
        try{
        Class.forName("oracle.jdbc.OracleDriver");
        conn=DriverManager.getConnection("jdbc:oracle:thin:@//UPLC:1521/XE", "planetfood", "student");
        System.out.println("connection opened!");
    }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, " DB error in opening connection", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
    public static Connection getConnection(){
        return conn;
    }
    public static void closeConnection(){
        try{
            conn.close();
            JOptionPane.showMessageDialog(null, " DB error in opening connection");
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, " DB error in closing connection", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
}
