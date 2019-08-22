/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizapplication.pojo;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class QuestionStore 
{
    ArrayList <Questions> questionList;
    public QuestionStore()
    {
        questionList=new ArrayList<Questions>();
    }
    public void addQuestion(Questions q)
    {
        questionList.add(q);
    }
    public Questions getQuestion(int pos)
    {   
      //  System.out.println("inside get Question");
     //   System.out.println(questionList.get(pos));
        return questionList.get(pos);
    }
     public void removeQuestion(int pos)
    {
        questionList.remove(pos);
    }
    public void setQuestionAt(int loc,Questions q)
    {
        questionList.add(loc,q);
    }
    public ArrayList<Questions> getAllQuestion()
    {
        return questionList;
    }
    public int getCount()
    {
        return questionList.size();
    }
}
