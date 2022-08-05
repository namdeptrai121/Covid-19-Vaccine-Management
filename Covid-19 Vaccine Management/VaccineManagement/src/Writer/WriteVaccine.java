/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Writer;


import OTP.Vaccine;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;


/**
 *
 * @author DELL
 */
public class WriteVaccine{
    public static void main(String[] args) {
          ArrayList<Vaccine> list = new ArrayList<>();
     
               
        try {
            String vaccineFile = "Vaccine.txt";
            FileWriter fw = new FileWriter(vaccineFile);
            PrintWriter pw = new PrintWriter(fw);
            list.add(new Vaccine("2", "Sinopharm"));
            list.add(new Vaccine("4", "AstraZeneca"));
            list.add(new Vaccine("6", "Gam_COVID_Vac"));
            list.add(new Vaccine("7", "Janssen"));
            list.add(new Vaccine("9", "Moderna"));
            list.add(new Vaccine("10", "Pfizer"));
            for (Vaccine o : list) {
                pw.println(o.getVaccineID() + "-" + o.getVaccineName());
            }
            pw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
            
        }
        
    }
    
     
}     
