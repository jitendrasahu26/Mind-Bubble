/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizapplication.dbutil;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class DbConnection {
private static Connection con;    
    static
    {
        try
            {
               Class.forName("oracle.jdbc.OracleDriver");
       //        JOptionPane.showMessageDialog(null,"driver loaded","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
               con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","quizapp","java");
         //      JOptionPane.showMessageDialog(null," connected to db","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
            }
        catch(ClassNotFoundException e)
        {
            JOptionPane.showMessageDialog(null,"driver not loaded","error",JOptionPane.ERROR_MESSAGE);
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,"db not connected","error",JOptionPane.ERROR_MESSAGE);
        }
    }
    public static Connection getConnection()
    {
        return con;
    }
}
