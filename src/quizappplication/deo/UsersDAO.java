/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizappplication.deo;

import java.sql.*;
import javax.swing.JOptionPane;
import quizapplication.dbutil.DbConnection;
import quizapplication.pojo.Users;

/**
 *
 * @author user
 */
public class UsersDAO {
     public static Users login(String username) throws SQLException
    {
        Users u=null;
        Connection con=DbConnection.getConnection();
        PreparedStatement ps=con.prepareStatement("select * from users where userno=?");
        ps.setString(1,username);
        ResultSet rs=ps.executeQuery();
        if(rs.next())
        {
            u=new Users();
            u.setUserid(rs.getString(1));
            u.setPassword(rs.getString(2));
            u.setUsertype(rs.getString(3));
        }
        return u;
    }
    public static boolean registration(String username,String Password) throws SQLException
    {
        Connection con=DbConnection.getConnection();
        PreparedStatement sp=con.prepareStatement("select * from users where userno=? ");
        sp.setString(1,username);
        ResultSet rs=sp.executeQuery();
        while(rs.next())
        {
            if(username.equals(rs.getString(1)))
                return true;
        }
        PreparedStatement ps=con.prepareStatement("insert into users values(?,?,?)");
        ps.setString(1,username);
        ps.setString(2,Password);
        ps.setString(3,"student");
        ps.executeUpdate();
        return false;
    }
    public static void updatePassword(String username,String Password)throws SQLException
    {
        Connection con=DbConnection.getConnection();
        PreparedStatement sp=con.prepareStatement("update users set password=? where userno=? ");
        sp.setString(1, Password);
        sp.setString(2,username);
        ResultSet rs=sp.executeQuery();
        rs.next();
        sp.executeUpdate();
    }
}