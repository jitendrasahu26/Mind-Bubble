/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizappplication.deo;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import quizapplication.dbutil.DbConnection;
import quizapplication.pojo.Performance;
import quizapplication.pojo.Questions;
import quizapplication.pojo.StudentScore;

/**
 *
 * @author user
 */
public class PerformanceDAO {
    public static ArrayList<String> getAllStudentid()throws SQLException
    {
        Connection con=DbConnection.getConnection();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select distinct userid from performance");
        ArrayList<String> studentidList=new ArrayList<>();
        while(rs.next())
        {
            studentidList.add(rs.getString(1));
        }
        return studentidList;
    }
    public static ArrayList<String> getAllExamid(String userid)throws SQLException
    {
        Connection con=DbConnection.getConnection();
        PreparedStatement ps=con.prepareStatement("select examid from performance where userid=?");
        ps.setString(1,userid);
        ResultSet rs=ps.executeQuery();
        ArrayList<String> examid=new ArrayList<>();
        while(rs.next())
        {
            String id=rs.getString(1);
            examid.add(id);
        }
        return examid;
    }
    public static StudentScore getScore(String studentid,String examid)throws SQLException
    {
        Connection con=DbConnection.getConnection();
        
        PreparedStatement ps=con.prepareStatement("select language,per from performance where userid=? AND examid=?");
        ps.setString(1,studentid);
        ps.setString(2,examid);   
        ResultSet rs=ps.executeQuery();
        StudentScore sScore=new StudentScore();
        while(rs.next())
        {
        sScore.setLanguage(rs.getString(1));
        sScore.setPer(rs.getDouble(2));
        }
        return sScore;
    }
    public static ArrayList<String> getExamidByUserid(String userid)throws SQLException
    {
         Connection con=DbConnection.getConnection();
        PreparedStatement ps=con.prepareStatement("select examid from performance where userid=?");
        ps.setString(1,userid);
        ResultSet rs=ps.executeQuery();
        ArrayList<String> examList=new ArrayList<>(); 
        while(rs.next())
        {
            examList.add(rs.getString(1));
        }
        return examList;
    }
    public static ArrayList<Performance> getAllData()throws SQLException
    {
        Connection con=DbConnection.getConnection();
        PreparedStatement ps=con.prepareStatement("select * from performance");
        ResultSet rs=ps.executeQuery();
        ArrayList<Performance> allData=new ArrayList<>();
        while(rs.next())
        {
            String userid=rs.getString(1);
            String examid=rs.getString(2);
            int right=rs.getInt(3);
            int wrong=rs.getInt(4);
            int notAttempted=rs.getInt(5);
            double per=rs.getDouble(6);
            String language=rs.getString(7);
            Performance perform=new Performance(userid,examid,right,wrong,notAttempted,per,language);
            allData.add(perform);
        }
        return allData;
    }
    public static void addPerfroamnce(Performance perform)throws SQLException
    {
        Connection con=DbConnection.getConnection();
        PreparedStatement ps=con.prepareStatement("insert into  performance values(?,?,?,?,?,?,?)");
        ps.setString(1,perform.getUserid());
        ps.setString(2,perform.getExamid());
        ps.setInt(3,perform.getRight());
        ps.setInt(4,perform.getWrong());
        ps.setInt(5,perform.getUnattempted());
        ps.setDouble(6,perform.getPer());
        ps.setString(7,perform.getLanguage());
        ResultSet rs=ps.executeQuery();   
    }
}
