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
public class Course
{
    private String anmCode;
    private String courseCode;
    private String courseTermin;
    private String courseName;

    /**
     * @return the anmCode
     */
    public String getAnmCode()
    {
        return anmCode;
    }

    /**
     * @param anmCode the anmCode to set
     */
    public void setAnmCode(String anmCode)
    {
        this.anmCode = anmCode;
    }

    /**
     * @return the courseCode
     */
    public String getCourseCode()
    {
        return courseCode;
    }

    /**
     * @param courseCode the courseCode to set
     */
    public void setCourseCode(String courseCode)
    {
        this.courseCode = courseCode;
    }

    /**
     * @return the courseTermin
     */
    public String getCourseTermin()
    {
        return courseTermin;
    }

    /**
     * @param courseTermin the courseTermin to set
     */
    public void setCourseTermin(String courseTermin)
    {
        this.courseTermin = courseTermin;
    }

    /**
     * @return the courseName
     */
    public String getCourseName()
    {
        return courseName;
    }

    /**
     * @param courseName the courseName to set
     */
    public void setCourseName(String courseName)
    {
        this.courseName = courseName;
    }
    
    @Override
    public String toString()
    {
        return String.format("%-10s | %-15s | %-6s | %-10s", getAnmCode(), getCourseCode(), getCourseName(), getCourseTermin());
    }
    
}
