/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizapplication.pojo;

/**
 *
 * @author user
 */
public class Exam {

    public Exam(String examid, String language, int totalQuestion) {
        this.examid = examid;
        this.language = language;
        this.totalQuestion = totalQuestion;
    }
    private String examid;
    private String language;
    private int totalQuestion;

    public String getExamid() {
        return examid;
    }

    public void setExamid(String examid) {
        this.examid = examid;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getTotalQuestion() {
        return totalQuestion;
    }

    public void setTotalQuestion(int totalQuestion) {
        this.totalQuestion=totalQuestion;
    }

   
}
