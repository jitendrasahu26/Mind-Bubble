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
public class AnswerStore {
    ArrayList<Answerpojo> answerList;
    public AnswerStore()
    {
        answerList=new ArrayList<>();
    }
    public void addAnswer(Answerpojo answer)
    {
        answerList.add(answer);
    }
    public Answerpojo getAnswer(int pos)
    {   
        return answerList.get(pos);
    }
    public int removeAnswer(int pos)
    {
        answerList.remove(pos);
        return pos;
    }
    public void setAnswerAt(int pos,Answerpojo ans)
    {
        answerList.add(pos,ans);
       
    }
    public ArrayList<Answerpojo> getAllAnswer()
    {
        return answerList;
    }
    public int getCount()
    {
        return answerList.size();
    }
    public Answerpojo getAnswerByQno(int qno){
    //    System.out.println(" inside getAnswerbyqno "); 
     //   System.out.println(answerList);
        if((answerList!=null))
        for(Answerpojo ans:answerList){
       //     System.out.println(" inside for loop");
            if(ans.getQno()==qno)
            {    
                System.out.println(" inside if return ans ");
                return ans;
            }
          //  System.out.println("outside if return null");
         }
        //System.out.println("outside for");
        return null;
    }
    public int removeAnswer(Answerpojo answer)
    {
        int pos=answerList.indexOf(answer);
        answerList.remove(pos);
        return pos;
    }
}
