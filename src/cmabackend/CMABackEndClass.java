/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmabackend;

import cmabackend.Entities.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author wallejr
 */
public class CMABackEndClass
{
    
    private PreparedStatement checkStmt = null;
    private Connection cn = null;
    private ResultSet result = null;
    private Course kurs;
    private Grade betyg;
    private Student stud;
    private final String USERNAME = "walle";
    private final String PASSWORD = "kalleanka";
    private final String DBURL = "jdbc:mysql://10.0.1.19:3306/mydb";
    private String success = "";
    
    public String checkCourseExistence(String coursecode, String termin)
    {
//       PreparedStatement checkStmt = null;
//    Connection cn = null;
//     ResultSet result = null;
//     Course kurs;
//     Grade betyg;
//     Student stud;
//     final String USERNAME = "walle";
//     final String PASSWORD = "kalleanka";
//    final String DBURL = "jdbc:mysql://10.0.1.19:3306/mydb";
//    String success = "";
        
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver"); 
            
            cn = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
            

            
            checkStmt = cn.prepareStatement("select anmcode from mydb.Courses where coursecode='"+coursecode+"' and coursetermin='"+termin+"' ");
            
            result = checkStmt.executeQuery();
            
            if (!result.next())
            {
                success = "Det finns ingen kurs med kod " + coursecode + " som gick terminen " + termin + ".";
            }
            else
            {
                kurs = new Course();
                this.kurs.setAnmCode(result.getString("anmcode"));
                success = this.kurs.getAnmCode();
                
            }
                
            
        } catch (SQLException e)
        {
            success = "Det uppstod ett fel vid verifiering av kurs.\n" + 
                    e.getMessage() + 
                    "\nVar vänlig försök igen senare eller kontakta systemadministratören.\n";
        } catch (ClassNotFoundException ex)
        {
            Logger.getLogger(CMABackEndClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
                closeConnections();

        }
        
        return success;
    }
    
        public String checkStudonCourse(String anmCode, String student)
    {
        
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver"); 
            
            cn = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
            
            if(cn == null)
            {
                throw new SQLException("Uppkoppling mot databas saknas");
            }
            
            checkStmt = cn.prepareStatement("select * from mydb.Students_has_Courses where Courses_AnmCode ='"+anmCode+"' and Students_Student_ID='"+student+"' ");
            
            result = checkStmt.executeQuery();
            
            if (!result.next())
            {
                success = "Det finns ingen student med id " + student + " som är registrerade på kurs med anmälningskod " + anmCode + ".";
            }
            else
            {
//                stud = new Student();
//                this.stud.setStudFName(result.getString("STUDFNAME"));
//                this.stud.setStudLName(result.getString("STUDLNAME"));
//                success = this.stud.getStudFName() + " " + this.stud.getStudLName() + " är reigstrerad på kursen";
                success ="valid";
            }
                
            
        } catch (Exception e)
        {
            System.err.println("Det uppstod ett fel vid verifiering av student.\nVar vänlig försök igen senare eller kontakta systemadministratören." + e.getMessage());
        }
        finally
        {
            closeConnections();
        }
        
        return success;
    }
        
    public String aissgnGrades(String student, String anmCode, String examNr, String grade)
    {
       
        try
        {
            Class.forName("com.mysql.jdbc.Driver"); 
            
           cn = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
            
            if(cn == null)
            {
                throw new SQLException("Uppkoppling mot databas saknas");
            }
            
            checkStmt = cn.prepareStatement("select Students_Student_ID, Courses_AnmCode, CoursePart, CoursePartGrade from mydb.Grades where Students_Student_ID='"+student+"'");
            
            result = checkStmt.executeQuery();
            if (!result.next())
            {
                    
                checkStmt = cn.prepareStatement("insert into mydb.Grades (Students_Student_ID, Courses_AnmCode, CoursePart, CoursePartGrade)" +
                        "VALUES (?, ?, ?, ?)");

                checkStmt.setString(1, student);
                checkStmt.setString(2, anmCode);
                checkStmt.setString(3, examNr);
                checkStmt.setString(4, grade);

                int i = checkStmt.executeUpdate();

                if (i > 0)
                {
                    success = "Resultatet har registrerats i Ladok";
                }
                else
                    success = "Ett problem uppstod när registreringen skulle slutföras. Var vänlig försök igen senare";
            }
            else
            {
                success = "Student med id: " + student + " har redan betyg " + grade + " registrerat på kursen " + anmCode + ".";
            }
                
            
        } catch (Exception e)
        {
            System.err.println("Det uppstod ett fel vid verifiering av kurs.\nVar vänlig försök igen senare eller kontakta systemadministratören.\n" + e.getMessage());
        }
        finally
        {
           closeConnections();
        }
        
        return success;
    }
        
    private void closeConnections()
    {
        try
        {
            if (checkStmt != null)
            {
                checkStmt.close();
            }
            if (cn != null)
            {
                cn.close();
            }           
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * @return the kurs
     */
    public Course getKurs()
    {
        return kurs;
    }

    /**
     * @param kurs the kurs to set
     */
    public void setKurs(Course kurs)
    {
        this.kurs = kurs;
    }

    /**
     * @return the betyg
     */
    public Grade getBetyg()
    {
        return betyg;
    }

    /**
     * @param betyg the betyg to set
     */
    public void setBetyg(Grade betyg)
    {
        this.betyg = betyg;
    }

    /**
     * @return the stud
     */
    public Student getStud()
    {
        return stud;
    }

    /**
     * @param stud the stud to set
     */
    public void setStud(Student stud)
    {
        this.stud = stud;
    }
    
    
    
}


