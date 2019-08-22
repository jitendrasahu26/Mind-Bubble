/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizappplication.deo;

import java.sql.*;
import java.util.ArrayList;
import quizapplication.dbutil.DbConnection;
import quizapplication.pojo.Exam;
import quizapplication.pojo.Questions;

/**
 *
 * @author user
 */
public class ExamDAO{
    public static String getExamId()throws SQLException
    {
        Connection con=DbConnection.getConnection();
        PreparedStatement ps=con.prepareStatement("select count(*) as totalrows from exam");
        ResultSet rs=ps.executeQuery();
        String examid;
        int rowCount=0;
        if(rs.next())
        {
            rowCount=rs.getInt(1);
        }
        examid="EX-"+rowCount;
        return examid;
    }
    public static void addExam(Exam e)throws SQLException
    {
        Connection con=DbConnection.getConnection();
        PreparedStatement ps=con.prepareStatement("insert into exam values(?,?,?)");
        ps.setString(1,e.getExamid());
        ps.setString(2,e.getLanguage());
        ps.setInt(3,e.getTotalQuestion());
        ps.executeUpdate();
    }
    public static ArrayList<String> getExamIdBySubject(String subject)throws SQLException
    {
        Connection con=DbConnection.getConnection();
        PreparedStatement ps=con.prepareStatement("select examno from exam where language=?");
        ps.setString(1,subject);
        ResultSet rs=ps.executeQuery();
        ArrayList<String> examList=new ArrayList<>(); 
        while(rs.next())
        {
            examList.add(rs.getString(1));
        }
        return examList;
    }
    public static int getQuestionCountByExam(String examid)throws SQLException
    {
        Connection con=DbConnection.getConnection();
        PreparedStatement ps=con.prepareStatement("select total_question from exam where examno=?");
        ps.setString(1,examid);
        ResultSet rs=ps.executeQuery();
        rs.next();
        int rowCount=rs.getInt(1);
        return rowCount;
    }
  
}
