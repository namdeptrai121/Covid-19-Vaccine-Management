/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Writer;

import OTP.Student;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;


/**
 *
 * @author DELL
 */
public class WriterStudent {
    public static void main(String[] args) {
         ArrayList<Student> list = new ArrayList<>();
   
        try {
            String studentFile = "Student.txt";
            FileWriter fw = new FileWriter(studentFile);
            PrintWriter pw = new PrintWriter(fw);
            list.add(new Student("SE161443", "Duong Han Nam"));
            list.add(new Student("SE140001", "Nguyen Van An"));
            list.add(new Student("SE140002", "Tran Than Binh"));
            list.add(new Student("SE140003", "Pham Ngoc Mai"));
            list.add(new Student("SE140004", "Nguyen Huu Cuong"));
            list.add(new Student("SE140005", "Truong Tan Phat"));
            for (Student o : list) {
                pw.println(o.getStudentID()+ "-" + o.getStudentName());
            }
            pw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
            
        }
       
    
    }
    
  
}
