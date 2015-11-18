/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmabackend;

import cmabackend.Entities.*;



/**
 *
 * @author wallejr
 */
public class CMAMainTest
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        String student = "andjoh-6";
        String cours = "D0007N";
        String termin = "vt14";
        String examNr = "Provnr5";
        String grade = "G";
        String anmkod;
        ListManager lm = new ListManager();
        
       
        
        // TODO code application logic here
        CMABackEndClass test = new CMABackEndClass();
        
        lm = test.getAllCourses();
        for (Course c : lm.getCourseList())
        {
            System.out.println(c.toString());
        }
        
        lm = test.getAllStudents();
        for (Student s : lm.getStudentList())
        {
            System.out.println(s.toString());
        }
        
        
        
        anmkod = test.checkCourseExistence(cours, termin);
        
        System.out.println(anmkod);
        
        
        String studonCourse = test.checkStudonCourse(anmkod, student);
        if (!studonCourse.equalsIgnoreCase("valid"))
        {
            System.out.println(studonCourse);
        }
        
        String registerdGrade = test.aissgnGrades(student, anmkod, examNr, grade);
        
        System.out.println(registerdGrade);
        
        
        
        
    }
    
}
