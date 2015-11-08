/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmabackend;

import com.sun.xml.internal.ws.api.message.SuppressAutomaticWSARequestHeadersFeature;

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
        String cours = "L0008B";
        String termin = "vt15";
        String examNr = "Provnr5";
        String grade = "G";
        String anmkod;
        
        // TODO code application logic here
        CMABackEnd test = new CMABackEnd();
        
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
