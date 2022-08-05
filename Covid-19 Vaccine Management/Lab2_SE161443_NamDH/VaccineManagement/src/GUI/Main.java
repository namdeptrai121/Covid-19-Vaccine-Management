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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String[] options ={"Show information all students have been injected           ", 
                           "Add student's vaccine injection information                ", 
                           "Update injection information by InjectionID                ",
                           "Delete student vaccine injection information               ", 
                           "Search for injection information by studentID              ", 
                           "quit                                                       "};
        InjectionList list = new InjectionList() {}; 
        
        list.loadFileInjection();
        list.loadFileStudent();
        list.loadFileVaccine();
        list.loadFileProvince();
        int choice;
        do{
            choice = Menu.getChoice(options);
            switch(choice){
                case 1: list.printAllWithSortByDate();break;
                case 2: list.addInjection();break;
                case 3: list.updateInjection(); break;
                case 4: list.removeByInjectionID(); break;
                case 5: list.searchByStudentID();break;
                case 6: list.searchByStudentID1(); break;
                default: System.out.println("Thanks for using app");
            }
        }while(choice >= 0 && choice  < 7);
        
    }
    
    
  
}
