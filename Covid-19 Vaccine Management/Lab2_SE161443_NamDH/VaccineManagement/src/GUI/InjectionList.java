/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import OTP.Injection;
import OTP.Province;
import OTP.Student;
import OTP.Vaccine;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import java.util.StringTokenizer;

/**
 *
 * @author DELL
 */
public class InjectionList implements Funtion {

    ArrayList<Injection> list = new ArrayList<>();
    ArrayList<Student> list1 = new ArrayList<>();
    ArrayList<Vaccine> list2 = new ArrayList<>();
    ArrayList<Province> list3 = new ArrayList<>();
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";

    // find and check injection duplicate
    private Injection search(String injectionID) {
        injectionID = injectionID.trim();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getInjectionID().equalsIgnoreCase(injectionID)) {
                return list.get(i);
            }
        }
        return null;
    }

    private boolean isDuplicate(String injectionID) {
        injectionID = injectionID.trim();
        return search(injectionID) != null;
    }
    // fand student id of injection

    private Injection searchSt(String studentID) {
        studentID = studentID.trim();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getStudentID().equalsIgnoreCase(studentID)) {
                return list.get(i);
            }
        }
        return null;
    }

    //find and check student id
    private Student search1(String studentID) {
        studentID = studentID.trim();
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i).getStudentID().equalsIgnoreCase(studentID)) {
                return list1.get(i);
            }
        }
        return null;
    }

    private boolean isDuplicate1(String studentID) {
        studentID = studentID.trim();
        return search1(studentID) != null;
    }

    //find and check vaccine id
    private Vaccine search2(String vaccineID) {
        vaccineID = vaccineID.trim();
        for (int i = 0; i < list2.size(); i++) {
            if (list2.get(i).getVaccineID().equalsIgnoreCase(vaccineID)) {
                return list2.get(i);
            }
        }
        return null;
    }

    private boolean isDuplicate2(String vaccineID) {
        vaccineID = vaccineID.trim();
        return search2(vaccineID) != null;
    }

    // find and check provinceID
    private Province search3(String provinceID) {
        provinceID = provinceID.trim();
        for (int i = 0; i < list3.size(); i++) {
            if (list3.get(i).getProvince().equalsIgnoreCase(provinceID)) {
                return list3.get(i);
            }
        }
        return null;
    }

    private boolean isDuplicate3(String provinceID) {
        provinceID = provinceID.trim();
        return search3(provinceID) != null;
    }

    // print all
    @Override
    public void printAllWithSortByDate() {
        String msg = String.format("||%-15.15s||%-15.15s||%-20.20s||%-20.20s||%-20.20s||%-20.20s||%-20.20s||%-15.15s||%-20.20s||", "InjectionID", "StudentID", "StudentName", "InjectionDate1st", "InjectionPlace1st", "InjectionDate2nd", "InjectionPlace2nd", "VaccineID", "VaccineName");
        System.out.println(ANSI_RED + msg + ANSI_RESET);
        for (Injection i : list) {
            for (Student s : list1) {
                for (Vaccine v : list2) {
                    if (i.getStudentID().equalsIgnoreCase(s.getStudentID())) {
                        if (i.getVaccineID().equalsIgnoreCase(v.getVaccineID())) {
                            String msg1 = String.format("||%-15.15s||%-15.15s||%-20.20s||%-20.20s||%-20.20s||%-20.20s||%-20.20s||%-15.15s||%-20.20s||", i.getInjectionID(), i.getStudentID(), s.getStudentName(), i.getInjectionDate1st(), i.getInjectionPlace1st(), i.getInjectionDate2nd(), i.getInjectionPlace2nd(), i.getVaccineID(), v.getVaccineName());
                            System.out.println(msg1);
                        }
                    }

                }

            }
        }

        System.out.println("");
    }

// ham add
    @Override
    public void addInjection() {
        String choice;
        String injectionID, studentID, vaccineID, injectionDate1st, injectionDate2nd = "null", injectionPlace1st, injectionPlace2nd = "null", choice1;
        boolean duplicate, check;
        // vong lap
        do {
            // add injection
            do {
                injectionID = Inputter.inputStringPattern("Enter the Injection ID:   ", ANSI_RED + "!!!INVALID!!! - you may enter wrong format or don't enter ID" + ANSI_RESET, "^[a-zA-Z0-9\\s]{1,15}$");
                duplicate = isDuplicate(injectionID);
                if (duplicate) {
                    System.out.println(ANSI_RED + "!!!This Injection ID already existed!!!" + ANSI_RESET);
                }
            } while (duplicate == true);
            // add student id
            do {
                System.out.println(ANSI_BLUE + "List Student ID and their name: " + ANSI_RESET);
                String msg;
                msg = String.format("||%-20.20s||%-20.20s||", "StudentID", "StudentName");
                System.out.println(ANSI_RED + msg + ANSI_RESET);
                for (Student o : list1) {
                    o.printStudent();
                }
                studentID = Inputter.inputStringPattern("Enter the Student ID:   ", ANSI_RED + "!!!INVALID!!! - you may enter wrong format or don't enter ID" + ANSI_RESET, "^[a-zA-Z0-9\\s]{1,15}$");
                duplicate = isDuplicate1(studentID);

                if (duplicate) {
                    for (Injection i : list) {
                        if (i.getStudentID().equalsIgnoreCase(studentID)) {
                            System.out.println(ANSI_RED + "!!!This studentID is already used!!!" + ANSI_RESET);
                            duplicate = false;
                        }
                    }

                } else {
                    System.out.println(ANSI_RED + "!!!StudentID doesn't exist - Please enter the StudentID in the List!!!" + ANSI_RESET);

                }
            } while (duplicate == false);
            //add vaccine id
            do {
                System.out.println(ANSI_BLUE + "List Vaacine ID and thier name: " + ANSI_RESET);
                String msg;
                msg = String.format("||%-20.20s||%-20.20s||", "VaccineID", "VaccineName");
                System.out.println(ANSI_RED + msg + ANSI_RESET);
                for (Vaccine o : list2) {
                    o.printVaccine();
                }
                vaccineID = Inputter.inputStringPattern("Enter the Vaccine ID:   ", ANSI_RED + "!!!INVALID!!! - you may enter wrong format or don't enter ID" + ANSI_RESET, "^[0-9\\s]{1,20}$");
                duplicate = isDuplicate2(vaccineID);
                if (duplicate == false) {
                    System.out.println(ANSI_RED + "!!!VaccineID doesn't exist - Please enter the VaccineID in the List!!!" + ANSI_RESET);
                }
            } while (duplicate == false);
            // add date 1
            injectionDate1st = Inputter.inputDate("Enter the Injection Date1 (yyyy/mm/dd):  ");
            // add place 1
            do {

                injectionPlace1st = Inputter.inputString("Enter the Injection Place 1st: ");
                duplicate = isDuplicate3(injectionPlace1st);
                if (duplicate == false) {
                    System.out.println(ANSI_RED + "!!!Province doesn't exist - Please enter the Province in the List!!!" + ANSI_RESET);
                }

            } while (duplicate == false);

            System.out.println(ANSI_BLUE + "Injection 1st had been ADDED" + ANSI_RESET);
            // choose add 2
            choice1 = Inputter.inputString("Do you want to add Injection 2nd Now:  ");
            if (choice1.equalsIgnoreCase("y")) {
                // place 2
                do {
                    injectionDate2nd = Inputter.inputDate("Enter The Injection Date2 (yyyy/mm/dd):  ");
                    check = Inputter.check(injectionDate1st, injectionDate2nd);
                    if (check == false) {
                        System.out.println(ANSI_BLUE + "Please enter InjectionDate 2nd again" + ANSI_RESET);
                    }

                } while (check == false);
                ;
                //place 2
                do {

                    injectionPlace2nd = Inputter.inputString("Enter the Injeciton Place 2nd");
                    duplicate = isDuplicate3(injectionPlace2nd);
                    if (duplicate == false) {
                        System.out.println(ANSI_RED + "!!!Province doesn't exist - Please enter the Province in the List!!!" + ANSI_RESET);
                    }
                } while (duplicate == false);

            } else {
                System.out.println(ANSI_BLUE + "You choose don't add Injection 2nd Now" + ANSI_RESET);
            }

            list.add(new Injection(injectionID, studentID, vaccineID, injectionDate1st, injectionPlace1st, injectionDate2nd, injectionPlace2nd));
            choice = Inputter.inputString("Do you want to add AGAIN: choose (y) to add again or choose other to finish:   ");
        } while (choice.equalsIgnoreCase("y"));
        saveToFileInjection();
        System.out.println(ANSI_BLUE + "This function is FINISHED" + ANSI_RESET);
        System.out.println("");

    }

    // update
    @Override
    public void updateInjection() {
        boolean choice = false;
        String injectionID, injectionDate2nd, injectionPlace2nd;
        boolean check;

        do {

            injectionID = Inputter.inputStringPattern("Enter the Injection ID:   ", ANSI_RED + "!!!INVALID!!! - you may enter wrong format or don't enter ID" + ANSI_RESET, "^[a-zA-Z0-9\\s]{1,20}$");
            Injection x = search(injectionID);
            if (x == null) {
                System.out.println(ANSI_RED + "InjectionID does not exist!!!!" + ANSI_RESET);
            } else {
                if (!x.getInjectionDate2nd().equals("null")) {
                    String msg1 = String.format("||%-15.15s||%-15.15s||%-15.15s||%-20.20s||%-20.20s||%-20.20s||%-20.20s||", "InjectionID", "StudentID", "VaccineID", "InjectionDate1st", "InjectionPlace1st", "InjectionDate2nd", "InjectionPlace2nd");
                    System.out.println(ANSI_RED + msg1 + ANSI_RESET);
                    x.showInjection();
                    System.out.println(ANSI_RED + "This injectionID have Student have 2 injection" + ANSI_RESET);

                } else {

                    System.out.println(ANSI_BLUE + "Here is the Injection before updating" + ANSI_RESET);
                    String msg = String.format("||%-15.15s||%-15.15s||%-15.15s||%-20.20s||%-20.20s||%-20.20s||%-20.20s||", "InjectionID", "StudentID", "VaccineID", "InjectionDate1st", "InjectionPlace1st", "InjectionDate2nd", "InjectionPlace2nd");
                    System.out.println(ANSI_RED + msg + ANSI_RESET);
                    x.showInjection();
                    // add date 2
                    do {
                        injectionDate2nd = Inputter.inputDate("Enter The Injection Date2 (yyyy/mm/dd):  ");
                        check = Inputter.check(x.getInjectionDate1st(), injectionDate2nd);
                        if (check == false) {
                            System.out.println(ANSI_BLUE + "Please enter InjectionDate 2nd again" + ANSI_RESET);
                        }
                        x.setInjectionDate2nd(injectionDate2nd);
                    } while (check == false);
                    //add place 2
                    do {

                        injectionPlace2nd = Inputter.inputString("Enter the Injeciton Place 2nd");
                        check = isDuplicate3(injectionPlace2nd);
                        if (check == false) {
                            System.out.println(ANSI_RED + "!!!Province doesn't exist - Please enter the Province in the List!!!" + ANSI_RESET);
                        }
                        x.setInjectionPlace2nd(injectionPlace2nd);
                    } while (check == false);
                    String msg2 = String.format("||%-15.15s||%-15.15s||%-15.15s||%-20.20s||%-20.20s||%-20.20s||%-20.20s||", "InjectionID", "StudentID", "VaccineID", "InjectionDate1st", "InjectionPlace1st", "InjectionDate2nd", "InjectionPlace2nd");
                    System.out.println(ANSI_RED + msg2 + ANSI_RESET);
                    x.showInjection();
                    System.out.println(ANSI_BLUE + "Injection 2nd had been UPDATED" + ANSI_RESET);

                }
                choice = true;
            }
        } while (choice == false);
        saveToFileInjection();
        System.out.println(ANSI_BLUE + "This funtion is FINISHED" + ANSI_RESET);
        System.out.println("");
    }

    @Override
    public void removeByInjectionID() {
        String choice;
        boolean check = false;
        do {
            if (list.isEmpty()) {
                System.out.println(ANSI_RED + "!!!Empty list -- Remove can not be performed!!!" + ANSI_RESET);

            } else {
                String injectionID = Inputter.inputStringPattern("Enter the Injection ID:   ", ANSI_RED + "!!!INVALID!!! - you may enter wrong format or don't enter ID" + ANSI_RESET, "^[a-zA-Z0-9\\s]{1,20}$");
                Injection pos = search(injectionID);
                if (pos == null) {
                    System.out.println(ANSI_RED + "!!!The Injection ID doesn't existed!!!" + ANSI_RESET);

                } else {
                    String confirm = Inputter.inputString("Do you want to re move?? Please CONFIRM (choose (y) to accept and other to refuse):    ");
                    if (confirm.equalsIgnoreCase("y")) {
                        list.remove(pos);
                        check = true;
                        System.out.println(ANSI_BLUE + "The Injection ID has been removed" + ANSI_RESET);

                    } else if (confirm.equalsIgnoreCase("n")) {
                        System.out.println(ANSI_RED + "!!!Remove can not perfromed - You refused to perform this function!!!" + ANSI_RESET);
                        check = true;
                    }
                }
            }
        } while (check == false);
        saveToFileInjection();
        System.out.println(ANSI_BLUE + "This funtion is FINISHED" + ANSI_RESET);
        System.out.println("");
    }

    @Override
    public void searchByStudentID() {
        String choice;
        boolean duplicate;
        do {
            if (list.isEmpty()) {
                System.out.println(ANSI_RED + "!!!List Injection is Empty -- Search can not be performed!!!" + ANSI_RESET);
            } else {
                do {
                    System.out.println(ANSI_BLUE + "List Student ID and thier name: " + ANSI_RESET);
                    String msg;
                    msg = String.format("||%-20.20s||%-20.20s||", "StudentID", "StudentName");
                    System.out.println(ANSI_RED + msg + ANSI_RESET);
                    for (Student o : list1) {
                        o.printStudent();
                    }
                    String studentID = Inputter.inputStringPattern("Enter the the Student ID:   ", ANSI_RED + "!!!INVALID!!! - you may enter wrong format or don't enter ID" + ANSI_RESET, "^[a-zA-Z0-9\\s]{1,20}$");
                    Injection a = searchSt(studentID);
                    duplicate = isDuplicate1(studentID);
                    if (duplicate) {
                        if (a == null) {
                            System.out.println(ANSI_RED + "!!!This Student ID doesn't have any injection -- The funtion can not performed!!! " + ANSI_RESET);
                            duplicate = false;
                        } else {
                            String msg1 = String.format("||%-15.15s||%-15.15s||%-15.15s||%-20.20s||%-20.20s||%-20.20s||%-20.20s||", "InjectionID", "StudentID", "VaccineID", "InjectionDate1st", "InjectionPlace1st", "InjectionDate2nd", "InjectionPlace2nd");
                            System.out.println(ANSI_RED + msg1 + ANSI_RESET);
                            a.showInjection();
                            duplicate = true;
                        }

                    } else {
                        System.out.println(ANSI_RED + "!!! This Student ID doesn't exist -- Please enter the Student ID in the list!!!" + ANSI_RESET);
                    }
                } while (duplicate == false);

            }
            choice = Inputter.inputString("Do you want to add AGAIN: choose (y) to add again or choose other to finish:   ");
        } while (choice.equalsIgnoreCase("y"));
        System.out.println(ANSI_BLUE + "This function is FINISHED" + ANSI_RESET);
        System.out.println("");
    }

    public void searchByStudentID1() {
        String choice;
        boolean duplicate;
        do {
            if (list.isEmpty()) {
                System.out.println(ANSI_RED + "!!!List Injection is Empty -- Search can not be performed!!!" + ANSI_RESET);
            } else {
                do {
                    System.out.println(ANSI_BLUE + "List Vaacine ID and thier name: " + ANSI_RESET);
                    String msg;
                    msg = String.format("||%-20.20s||%-20.20s||", "VaccineID", "VaccineName");
                    System.out.println(ANSI_RED + msg + ANSI_RESET);
                    for (Vaccine o : list2) {
                        o.printVaccine();
                    }
                    String vaccineID = Inputter.inputStringPattern("Enter the Vaccine ID:   ", ANSI_RED + "!!!INVALID!!! - you may enter wrong format or don't enter ID" + ANSI_RESET, "^[0-9\\s]{1,20}$");
                    duplicate = isDuplicate2(vaccineID);

                    if (duplicate) {
                        String msg1 = String.format("||%-15.15s||%-15.15s||%-15.15s||%-20.20s||%-20.20s||%-20.20s||%-20.20s||", "InjectionID", "StudentID", "VaccineID", "InjectionDate1st", "InjectionPlace1st", "InjectionDate2nd", "InjectionPlace2nd");
                        System.out.println(ANSI_RED + msg1 + ANSI_RESET);
                        for (Injection i : list) {
                            if (i.getVaccineID().equalsIgnoreCase(vaccineID)) {
                               
                                i.showInjection();
                                duplicate = true;
                            } 
                           
                        }
                           

                    } else {
                        System.out.println(ANSI_RED + "!!! This vaccine ID doesn't exist -- Please enter the vaccine ID in the list!!!" + ANSI_RESET);
                    }
                } while (duplicate == false);

            }
            choice = Inputter.inputString("Do you want to add AGAIN: choose (y) to add again or choose other to finish:   ");
        } while (choice.equalsIgnoreCase("y"));
        System.out.println(ANSI_BLUE + "This function is FINISHED" + ANSI_RESET);
        System.out.println("");
    }

    @Override
    public boolean saveToFileInjection() {

        try {
            String injectionFile = "Injection.txt";
            FileWriter fw = new FileWriter(injectionFile);
            PrintWriter pw = new PrintWriter(fw);
            for (Injection o : list) {
                pw.println(o.getInjectionID() + "-" + o.getStudentID() + "-" + o.getVaccineID() + "-" + o.getInjectionDate1st() + "-" + o.getInjectionPlace1st() + "-" + o.getInjectionDate2nd() + "-" + o.getInjectionPlace2nd());
            }
            pw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean loadFileInjection() {

        try {
            String injectionFile = "Injection.txt";
            File f = new File(injectionFile);
            String details;
            if (!f.exists()) {
                return false;
            } else {
                FileReader fr = new FileReader(f);
                BufferedReader bf = new BufferedReader(fr);
                while ((details = bf.readLine()) != null) {
                    if (details.length() > 0) {
                        StringTokenizer stk = new StringTokenizer(details, "-");
                        String injectionID = stk.nextToken();
                        String studentID = stk.nextToken();
                        String vaccineID = stk.nextToken();
                        String injectionDate1st = stk.nextToken();
                        String injectionPlace1st = stk.nextToken();
                        String injectionDate2nd = stk.nextToken();
                        String injectionPlace2nd = stk.nextToken();
                        list.add(new Injection(injectionID, studentID, vaccineID, injectionDate1st, injectionPlace1st, injectionDate2nd, injectionPlace2nd));
                    }
                }
                bf.close();
                fr.close();
            }
        } catch (Exception e) {
            System.out.println("Empty File - nothing can load");
            return false;
        }
        return true;

    }

    public boolean loadFileStudent() {

        try {
            String studentFile = "Student.txt";
            File f = new File(studentFile);
            String details;
            if (!f.exists()) {
                return false;
            } else {
                FileReader fr = new FileReader(f);
                BufferedReader bf = new BufferedReader(fr);
                while ((details = bf.readLine()) != null) {
                    if (details.length() > 0) {
                        StringTokenizer stk = new StringTokenizer(details, "-");
                        String studentID = stk.nextToken();
                        String studentName = stk.nextToken();

                        list1.add(new Student(studentID, studentName));
                    }
                }
                bf.close();
                fr.close();
            }
        } catch (Exception e) {
            System.out.println("Empty File - nothing can load");
            return false;
        }
        return true;

    }

    public boolean loadFileVaccine() {

        try {
            String vaccineFile = "Vaccine.txt";
            File f = new File(vaccineFile);
            String details;
            if (!f.exists()) {
                return false;
            } else {
                FileReader fr = new FileReader(f);
                BufferedReader bf = new BufferedReader(fr);
                while ((details = bf.readLine()) != null) {
                    if (details.length() > 0) {
                        StringTokenizer stk = new StringTokenizer(details, "-");
                        String vaccineID = stk.nextToken();
                        String vaccineName = stk.nextToken();
                        list2.add(new Vaccine(vaccineID, vaccineName));
                    }
                }
                bf.close();
                fr.close();
            }
        } catch (Exception e) {
            System.out.println("Empty File - nothing can load");
            return false;
        }
        return true;
    }

    @Override
    public boolean loadFileProvince() {

        try {
            String provinceFile = "Province.txt";
            File f = new File(provinceFile);
            String details;
            if (!f.exists()) {
                return false;
            } else {
                FileReader fr = new FileReader(f);
                BufferedReader bf = new BufferedReader(fr);
                while ((details = bf.readLine()) != null) {
                    if (details.length() > 0) {
                        StringTokenizer stk = new StringTokenizer(details, "/");
                        String province = stk.nextToken();

                        list3.add(new Province(province));
                    }
                }
                bf.close();
                fr.close();
            }
        } catch (Exception e) {
            System.out.println("Empty File - nothing can load");
            return false;
        }
        return true;

    }

}
