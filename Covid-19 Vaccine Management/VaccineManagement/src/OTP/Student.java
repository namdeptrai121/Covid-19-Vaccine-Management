/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OTP;

/**
 *
 * @author DELL
 */
public class Student{
    private String studentID;
    public String studentName;
     
    public Student(String studentID, String studentName) {
        this.studentID = studentID;
        this.studentName = studentName;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void printStudent(){
        String msg;
        msg = String.format("||%-20.20s||%-20.20s||", studentID,studentName);
        System.out.println(msg);
    }
   
    
    
  
}
