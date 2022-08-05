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
public class Injection {
    private String injectionID;
    private String studentID;
    private String vaccineID;
    private String injectionDate1st;
    private String injectionPlace1st;
    private String injectionDate2nd;
    private String injectionPlace2nd;

    public Injection(String injectionID, String studentID, String vaccineID, String injectionDate1st, String injectionPlace1st, String injectionDate2nd, String injectionPlace2nd) {
        this.injectionID = injectionID;
        this.studentID = studentID;
        this.vaccineID = vaccineID;
        this.injectionDate1st = injectionDate1st;
        this.injectionPlace1st = injectionPlace1st;
        this.injectionDate2nd = injectionDate2nd;
        this.injectionPlace2nd = injectionPlace2nd;
    }

    public String getInjectionID() {
        return injectionID;
    }

    public void setInjectionID(String injectionID) {
        this.injectionID = injectionID;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getVaccineID() {
        return vaccineID;
    }

    public void setVaccineID(String vaccineID) {
        this.vaccineID = vaccineID;
    }

    public String getInjectionDate1st() {
        return injectionDate1st;
    }

    public void setInjectionDate1st(String injectionDate1st) {
        this.injectionDate1st = injectionDate1st;
    }

    public String getInjectionPlace1st() {
        return injectionPlace1st;
    }

    public void setInjectionPlace1st(String injectionPlace1st) {
        this.injectionPlace1st = injectionPlace1st;
    }

    public String getInjectionDate2nd() {
        return injectionDate2nd;
    }

    public void setInjectionDate2nd(String injectionDate2nd) {
        this.injectionDate2nd = injectionDate2nd;
    }

    public String getInjectionPlace2nd() {
        return injectionPlace2nd;
    }

    public void setInjectionPlace2nd(String injectionPlace2nd) {
        this.injectionPlace2nd = injectionPlace2nd;
    }
    
     // show
    public void showInjection(){
       String msg = String.format("||%-15.15s||%-15.15s||%-15.15s||%-20.20s||%-20.20s||%-20.20s||%-20.20s||", getInjectionID(), getStudentID(), getVaccineID(), getInjectionDate1st(), getInjectionPlace1st(), getInjectionDate2nd(), getInjectionPlace2nd());
        System.out.println(msg);
    }

  
    
    
   
    
}
