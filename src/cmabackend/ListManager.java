/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmabackend;

import cmabackend.Entities.*;
import java.util.ArrayList;

/**
 *
 * @author wallejr
 */
public class ListManager
{
    private ArrayList<Student> StudentList= new ArrayList<>();
    private ArrayList<Course> CourseList= new ArrayList<>();
    
    
    public void addStudent(Student s)
    {
        StudentList.add(s);
    }
    
    public void addCourse(Course c)
    {
        getCourseList().add(c);
    }
    
    public int getStudCount()
    {
        return  getStudentList().size(); 
    }
    
    public String getStudentAtIndex(int x)
    {
       return getStudentList().get(x).toString();
    }

    /**
     * 
     * Method to dislplay all the registered students
     * @return the StudentList
     */
    public ArrayList<Student> getStudentList()
    {
        return StudentList;
    }

    /**
     * 
     * Method to dislplay all the registered courses
     * @return the CourseList
     */
    public ArrayList<Course> getCourseList()
    {
        return CourseList;
    }
}
