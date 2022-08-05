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
public class Vaccine{
    private String vaccineID;
    private String vaccineName;

    public Vaccine(String vaccineID, String vaccineName) {
        this.vaccineID = vaccineID;
        this.vaccineName = vaccineName;
    }

    
    
    public String getVaccineID() {
        return vaccineID;
    }

    public void setVaccineID(String vaccineID) {
        this.vaccineID = vaccineID;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }
    
    

    public void printVaccine(){
        String msg;
        msg = String.format("||%-20.20s||%-20.20s||", vaccineID,vaccineName);
        System.out.println(msg);
    }
    
    
}
