/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;



import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class Inputter {

    public static Scanner sc = new Scanner(System.in);
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
     public static final String ANSI_RESET = "\u001B[0m";
    //input int
    public static int inputInt(String msg, String error, int min, int max) {
        if (min > max) {
            int t = min;
            min = max;
            max = t;
        }
        int data;
        while (true) {
            try {
                System.out.format(msg);
                data = Integer.parseInt(sc.nextLine());
                if (data < min || data > max) {
                    throw new Exception();
                } else {
                    return data;
                }
            } catch (Exception e) {
                System.out.println(error);
            }
        }
    }

    //input string thuong
    public static String inputString(String msg) {
        System.out.println(msg);
        String data = sc.nextLine().replaceAll("\\s +", " ").trim().toUpperCase();
        return data;
    }

    //input string pattern
    public static String inputStringPattern(String msg, String error, String format) {
        boolean match;
        String data;
        while (true) {
            try {
                System.out.format(msg);
                data = sc.nextLine().replaceAll("\\s +", " ").trim().toUpperCase();
                match = data.matches(format);
                if (data.length() == 0 || data.isEmpty() || match == false) {
                    throw new Exception();
                } else {
                    return data;
                }
            } catch (Exception e) {
                System.out.println(error);
            }
        }
    }

    //input cac selection cho type voi place
    public static String inputStringSelections(String msg, String error, String msg1, String msg2, String msg3) {
        String data;
        while (true) {
            try {
                System.out.format(msg);
                data = sc.nextLine().trim().toUpperCase();
                if (data.equalsIgnoreCase(msg1) || data.equalsIgnoreCase(msg2) || data.equalsIgnoreCase(msg3)) {
                    return data;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println(error);
            }
        }
    }

    // check valid cho inputDate
    public static boolean checkValid(String s) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu/MM/dd").withResolverStyle(ResolverStyle.STRICT);
        LocalDate currentDate = LocalDate.now();
        String date = "2021/03/07";
        LocalDate datebegin = LocalDate.parse(date, formatter);
        try {
            LocalDate data = LocalDate.parse(s, formatter);
            if (data.isBefore(currentDate) || data.isEqual(currentDate)) {
                if (data.isAfter(datebegin)) {
                    return true;
                } else {
                    System.out.println(ANSI_RED+"!!!Injection date can not before 2021/03/08!!!"+ANSI_RESET);
                }
            } else {
                System.out.println(ANSI_RED+"!!!The expired date can be not after today!!!"+ANSI_RESET);
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    // input date
    public static String inputDate(String msg) {
        boolean check = false;
        String data;
        do {
            String dateFormat = "\\d{4}/\\d{2}/\\d{2}";
            System.out.format(msg);
            data = sc.nextLine().trim();
            if (data.matches(dateFormat)) {
                if (checkValid(data)) {
                    
                    check = true;
                } else {
                    System.out.println(ANSI_RED+"!!!Your Injection Date input is INVALID!!!"+ANSI_RESET);
                }
            } else {
                System.out.println(ANSI_RED+"!!!INVALID FORMAT!!! - Please input request format (yyyy/mm/dd)"+ANSI_RESET);
            }
        } while (check == false);
        return data;
    }

    public static boolean check(String a, String b) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu/MM/dd").withResolverStyle(ResolverStyle.STRICT);

        LocalDate date1 = LocalDate.parse(a, formatter);
        LocalDate date2 = LocalDate.parse(b, formatter);
        long day = ChronoUnit.DAYS.between(date1, date2);
        
        if (date2.compareTo(date1) >= 1) {
            if (date2.isAfter(date1.plusWeeks(4).minusDays(1)) && date2.isBefore(date1.plusWeeks(12).plusDays(1))) {
                System.out.println(ANSI_BLUE+"It's been "+ANSI_RESET+ANSI_RED+day+ANSI_RESET+ ANSI_BLUE+" days since the first injection"+ANSI_RESET);
                System.out.println(ANSI_RED+"!!!You have had your second injection on time |4Weeks(28days)--12Weeks(84days)!!!"+ANSI_RESET);

                return true;
            } else if (date2.isBefore(date1.plusWeeks(4))) {
                System.out.println(ANSI_BLUE+"It's been "+ANSI_RESET+ANSI_RED+day+ANSI_RESET+ ANSI_BLUE+" days since the first injection"+ANSI_RESET);
                System.out.print(ANSI_BLUE+"4Weeks(28days): "+ANSI_RESET+ANSI_RED+date1.plusWeeks(4)+ANSI_RESET);
                System.out.println(ANSI_BLUE+"--12Weeks(84days): "+ANSI_RESET+ANSI_RED+date1.plusWeeks(12)+ANSI_RESET);
                System.out.println(ANSI_RED+"!!!It's too EARLY to get a second injection, get it on time!!!"+ANSI_RESET);
                return false;
            } else if (date2.isAfter(date1.plusWeeks(12))) {
                System.out.println(ANSI_BLUE+"It's been "+ANSI_RESET+ANSI_RED+day+ANSI_RESET+ANSI_BLUE+ " days since the first injection"+ANSI_RESET);
                System.out.print(ANSI_BLUE+"4Weeks(28days): "+ANSI_RESET+ANSI_RED+date1.plusWeeks(4)+ANSI_RESET);
                System.out.println(ANSI_BLUE+"--12Weeks(84days): "+ANSI_RESET+ANSI_RED+date1.plusWeeks(12)+ANSI_RESET);
                System.out.println(ANSI_RED+"!!!It's too LATE to get a second injection, get it on time"+ANSI_RESET);
                return false;
            }

        } else {
            System.out.println(ANSI_RED+"!!! InjectionDate2 can't be before or equal InjectionDate1 !!!"+ANSI_RESET);
            
        }
        return false;

    }

}
