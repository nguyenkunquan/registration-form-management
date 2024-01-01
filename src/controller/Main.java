
package controller;

import business.Programs;
import business.Registrations;
import business.Students;
import java.text.ParseException;
import ui.Menu;
import util.Input;

//menu chính của app.
public class Main {

    public static void main(String[] args) throws ParseException, Exception {
        Menu menu = new Menu("Abroad Program Registration Form");
        menu.addNewOption("1. Manage abroad programs");
        menu.addNewOption("2. Manage students");
        menu.addNewOption("3. Register a program for a student");
        menu.addNewOption("4. Report");
        menu.addNewOption("5. Quit");
        
        //mua cái tủ, thùng đựng hồ sơ chứa thông tin.
        //Tủ có thể thêm/sửa/tìm các hồ sơ mà nó chứa bên trong
        Programs p = new Programs();
        Students s = new Students();
        Registrations r = new Registrations();      
        
        int choice;
        int choice1;
        boolean flag = false;
        s.loadData();
        p.loadData();
        do {
            menu.printMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    do {
                        menu.manageAbroadPrograms();
                        choice1 = Input.getInboundNumber("Your choice: ", 1, 5);
                        switch (choice1) {
                            case 1:
                                p.displayAllAbroadPrograms();
                                break;
                            case 2:
                                p.addNewAbroadProgram();
                                break;
                            case 3:
                                p.editAbroadProgram();
                                break;
                            case 4:
                                p.displayAbroadProgram();
                                break;
                        }
                    } while (choice1 != 5); 
                    break;
                case 2:
                    do {
                        menu.manageStudents();
                        choice1 = Input.getInboundNumber("Your choice: ", 1, 4);
                        switch (choice1) {
                            case 1:
                                s.displayAllStudents();
                                break;
                            case 2:
                                s.addNewStudent();
                                break;
                            case 3:
                                s.editStudent();
                                break;                    
                        }
                    } while (choice1 != 4);
                    break;
                case 3:
                    System.out.println("Register a program for a student: ");
                    r.addRegistration(p, s);
                    break;
                case 4:
                    do {
                        menu.report();
                        choice1 = Input.getInboundNumber("Your choice: ", 1, 4);
                        switch (choice1) {
                            case 1:
                                r.printOutRegistrationByID(s);
                                break;
                            case 2:
                                r.printOutStudentsRegisteredMore2(s);
                                break;
                            case 3:
                                r.countStudentsRegisteredAProgram(p);
                                break;
                        }
                    } while (choice1 != 4);
                    break;
                case 5:
                    System.out.println("Do you want to exit the program? (1: yes; 2: no)");
                    int confirm = Input.getInboundNumber("Your choice: ", 1, 2);
                    if (confirm == 1) {
                        flag = true;
                        s.saveData();
                        p.saveData();
                    }
                    break;
            }
        } while (!flag);
    }
    
}
