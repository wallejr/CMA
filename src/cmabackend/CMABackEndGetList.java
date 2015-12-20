/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmabackend;

import cmabackend.Entities.Course;
import cmabackend.Entities.Grade;
import cmabackend.Entities.Student;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author wallejr
 */
public class CMABackEndGetList
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
    private ArrayList<Student> sl = new ArrayList<>();
    ListManager lm = new ListManager();
    
    
    
    public ArrayList<Course> getAllCourses()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver"); 
            
            cn = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
            

            
            checkStmt = cn.prepareStatement("select AnmCode as 'Anmälningskod', CourseCode as ' Kurskod', CourseName as 'Kursnamn', CourseTermin as 'Termin' from mydb.Courses");
            
            result = checkStmt.executeQuery();
            
            if (!result.next())
            {
                success = "Det finns inga kurser";
            }
            else
            {
                do
                {
                    kurs = new Course();
                    kurs.setAnmCode(result.getString(1));
                    kurs.setCourseCode(result.getString(2));
                    kurs.setCourseName(result.getString(3));
                    kurs.setCourseTermin(result.getString(4));

                    lm.addCourse(kurs);
                }while(result.next());
                
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
        
        return lm.getCourseList();
    }
    
    public ArrayList<Student> getAllStudents()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver"); 
            
            cn = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
            
            checkStmt = cn.prepareStatement("select s.Student_ID as 'Student ID', s.StudFName as 'Förnamn', s.StudLName as 'Efternamn', c.CourseCode as 'Kurs'  from (Students s, Courses c) left join Students_has_Courses sc On sc.Students_Student_ID=s.Student_ID where c.AnmCode = sc.Courses_AnmCode");
            
            result = checkStmt.executeQuery();
            
            if (!result.next())
            {
                success = "Det finns inga elever";
            }
            else
            {
                do
                {
                    stud = new Student();
                    this.stud.setStudent_ID(result.getString(1));
                    this.stud.setStudFName(result.getString(2));
                    this.stud.setStudLName(result.getString(3));
                    this.stud.setCourse_FK(result.getString(4));
                    
                   lm.addStudent(stud);
                }while(result.next());
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
        
        return lm.getStudentList();
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
