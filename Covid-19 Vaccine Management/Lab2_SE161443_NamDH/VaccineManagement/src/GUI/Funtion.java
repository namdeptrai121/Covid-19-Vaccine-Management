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
public interface Funtion {
    void printAllWithSortByDate();
    void addInjection();
    void updateInjection();
    void removeByInjectionID();
    void searchByStudentID();
    boolean saveToFileInjection();
    boolean loadFileInjection();
    boolean loadFileStudent();
    boolean loadFileVaccine();
    boolean loadFileProvince();
}
