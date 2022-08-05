/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;



/**
 *
 * @author DELL
 */
public class Menu {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static int getChoice(Object[] option){
        
        System.out.println(" ----------------------------------------------------------------------------");
        System.out.println( ANSI_RED+"| Welcome to Vaccine Management - @ 2021 by <SE161443 - Duong Han Nam>          |"+ANSI_RESET);
        System.out.println(" ----------------------------------------------------------------------------");
        System.out.println(ANSI_RED+"| Select the options below:                                                  |"+ANSI_RESET);
        for(int i = 0; i<option.length;i++){
            String header = String.format("%15s",  "|");
            System.out.println("| "+ ( i+1) + "-" +option[i]+header);
        }
        System.out.println(" ----------------------------------------------------------------------------");
        int data = Inputter.inputInt("Choose 1..." + option.length +":\n",ANSI_RED+ "Please choose Options(1-6)"+ANSI_RESET, 1, 6);
        return data;
    }
}
