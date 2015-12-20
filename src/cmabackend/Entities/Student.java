/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmabackend.Entities;


import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author wallejr
 */
@XmlRootElement
public class Student
{
    private String student_ID;
    private String StudFName;
    private String StudLName;
    private String StudPersNr;
    private String Course_FK;

    /**
     * @return the student_ID
     */
    public String getStudent_ID()
    {
        return student_ID;
    }

    /**
     * @param student_ID the student_ID to set
     */
    public void setStudent_ID(String student_ID)
    {
        this.student_ID = student_ID;
    }

    /**
     * @return the StudFName
     */
    public String getStudFName()
    {
        return StudFName;
    }

    /**
     * @param StudFName the StudFName to set
     */
    public void setStudFName(String StudFName)
    {
        this.StudFName = StudFName;
    }

    /**
     * @return the StudLName
     */
    public String getStudLName()
    {
        return StudLName;
    }

    /**
     * @param StudLName the StudLName to set
     */
    public void setStudLName(String StudLName)
    {
        this.StudLName = StudLName;
    }

    /**
     * @return the StudPersNr
     */
    public String getStudPersNr()
    {
        return StudPersNr;
    }

    /**
     * @param StudPersNr the StudPersNr to set
     */
    public void setStudPersNr(String StudPersNr)
    {
        this.StudPersNr = StudPersNr;
    }

    /**
     * @return the Course_FK
     */
    public String getCourse_FK()
    {
        return Course_FK;
    }

    /**
     * @param Course_FK the Course_FK to set
     */
    public void setCourse_FK(String Course_FK)
    {
        this.Course_FK = Course_FK;
    }
    
    @Override
    public String toString()
    {
        return String.format("%-10s | %-15s | %-6s | %-10s | %-10s", getStudent_ID(), getStudFName(), getStudLName(), getStudPersNr(), getCourse_FK());
    }


    
}
