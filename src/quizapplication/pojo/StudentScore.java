/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizapplication.pojo;

import quizapplication.gui.ViewSingleStudentScoreFrame;

/**
 *
 * @author user
 */
public class StudentScore {

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public double getPer() {
        return per;
    }

    public void setPer(double per) {
        this.per = per;
    }
    private String language;
    private double per;
    
}
