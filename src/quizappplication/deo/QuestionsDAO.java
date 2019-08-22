/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizappplication.deo;

import java.sql.Connection;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import quizapplication.dbutil.DbConnection;
import quizapplication.pojo.QuestionStore;
import quizapplication.pojo.Questions;

public class QuestionsDAO {
    public static void updateQuestion(QuestionStore qStore)throws SQLException
    {
        Connection con=DbConnection.getConnection();
        PreparedStatement ps=con.prepareStatement("update Questions set question=?,answer1=?,answer2=?,answer3=?,answer4=?,correct_answer=?,language=? where examid=? AND qno=?");
        ArrayList<Questions> questionList=qStore.getAllQuestion();
        for(Questions obj:questionList)
        {
        ps.setString(1,obj.getQuestion());
        ps.setString(2,obj.getAnswer1());
        ps.setString(3,obj.getAnswer2());
        ps.setString(4,obj.getAnswer3());
        ps.setString(5,obj.getAnswer4());
        ps.setString(6,obj.getCorrect_answer());
        ps.setString(7,obj.getLanguage());
        ps.setString(8,obj.getExamid());
        ps.setInt(9,obj.getQno());
        ps.executeUpdate();
        }
    }
    public static void addQuestion(QuestionStore qStore)throws SQLException
    {
        String qry="insert into questions values(?,?,?,?,?,?,?,?,?)";
        ArrayList <Questions> questionList=qStore.getAllQuestion();
        Connection con=DbConnection.getConnection();
        PreparedStatement ps=con.prepareStatement(qry);
        for(Questions obj:questionList)
        {
            ps.setString(1,obj.getExamid());
            ps.setInt(2,obj.getQno());
            ps.setString(3,obj.getQuestion());
            ps.setString(4,obj.getAnswer1());
            ps.setString(5,obj.getAnswer2());
            ps.setString(6,obj.getAnswer3());
            ps.setString(7,obj.getAnswer4());
            ps.setString(8,obj.getCorrect_answer());
            ps.setString(9,obj.getLanguage());
            ps.executeUpdate();
        }
    }
    public static ArrayList<Questions> getQuestionsByExamid(String examid)throws SQLException
    {
        Connection con=DbConnection.getConnection();
        PreparedStatement ps=con.prepareStatement("select *  from questions where examid=? order by qno");
        ps.setString(1,examid);
        ArrayList<Questions> questionList=new ArrayList<>();
        ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
            int qno=rs.getInt(2);
            String question=rs.getString(3);
            String option1=rs.getString(4);
            String option2=rs.getString(5);
            String option3=rs.getString(6);
            String option4=rs.getString(7);
            String correctOption=rs.getString(8);
            String language=rs.getString(9);
            Questions obj=new Questions(examid,language,option1,option2,option3,option4,qno,correctOption,question);
            questionList.add(obj);
        }
        return questionList;
    }
}
