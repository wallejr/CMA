/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmabackend.Entities;

/**
 *
 * @author wallejr
 */
public class Grade
{
    
    private String grade_ID;
    private String course_FK;
    private String coursePart;
    private String coursePartGrade;

    /**
     * @return the grade_ID
     */
    public String getGrade_ID()
    {
        return grade_ID;
    }

    /**
     * @param grade_ID the grade_ID to set
     */
    public void setGrade_ID(String grade_ID)
    {
        this.grade_ID = grade_ID;
    }

    /**
     * @return the course_FK
     */
    public String getCourse_FK()
    {
        return course_FK;
    }

    /**
     * @param course_FK the course_FK to set
     */
    public void setCourse_FK(String course_FK)
    {
        this.course_FK = course_FK;
    }

    /**
     * @return the coursePart
     */
    public String getCoursePart()
    {
        return coursePart;
    }

    /**
     * @param coursePart the coursePart to set
     */
    public void setCoursePart(String coursePart)
    {
        this.coursePart = coursePart;
    }

    /**
     * @return the coursePartGrade
     */
    public String getCoursePartGrade()
    {
        return coursePartGrade;
    }

    /**
     * @param coursePartGrade the coursePartGrade to set
     */
    public void setCoursePartGrade(String coursePartGrade)
    {
        this.coursePartGrade = coursePartGrade;
    }
    
    @Override
    public String toString()
    {
        return String.format("%-10s | %-15s | %-6s | %-10s", getGrade_ID(), getCourse_FK(), getCoursePart(), getCoursePartGrade());
    }
    
}
