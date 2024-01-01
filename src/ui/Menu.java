package ui;

import java.util.ArrayList;
import util.Input;

public class Menu {
    
    //chứa các lựa chọn
    private String menuTitle;
    private ArrayList<String> optionList = new ArrayList();   
    
    /**
     * khởi tạo tên của app, tên của menu
     * @param menuTitle 
     */
    public Menu(String menuTitle) {
        this.menuTitle = menuTitle;
    }
    
    /**
     * Bổ sung một lựa chọn vào danh sách, bắt đầu xây dựng thực đơn/
       lựa chọn của chương trình
     * @param newOption 
     */
    public void addNewOption(String newOption) {
        optionList.add(newOption);        
    }
    
    /**
     * In ra danh sách các lựa chọn để người dùng chọn tính năng cần dùng
     */
    public void printMenu() {
        if (optionList.isEmpty()) {
            System.out.println("There is no item in the menu");
            return;
        }
        System.out.println("\n-------------------------------------------");
        System.out.println("Welcome to " + menuTitle);
        for (String x : optionList)
            System.out.println(x);  
    }
    
    /**
     * Hàm trả về con số người dùng chọn
     * @return option ứng với chức năng mà người dùng muốn app thực thi
     */
    public int getChoice() {
        int maxOption = optionList.size();
        //lựa chọn lớn nhất là số thứ tự ứng với số mục chọn
        String inputMsg = "Choose [1.." + maxOption + "]: ";
        String errorMsg = "You are required to choose the option 1.." + maxOption; 
        return Input.getChoiceWithMess(inputMsg, errorMsg, 1, maxOption);
        //in ra câu nhập: Choose[1..8]: , giả sử có 8 mục chọn trong
        //menu
    }
    
    /**
     * Hàm show ra sub menu của Function 1
     */
    public void manageAbroadPrograms() {
        System.out.println("\n-------------------------------------");
        System.out.println("1. Display all abroad programs");
        System.out.println("2. Add a new abroad program");
        System.out.println("3. Edit information a program by id");
        System.out.println("4. Search and display a program by id");
        System.out.println("5. Back to main menu");
    }
    
    /**
     * Hàm show ra sub menu của Function 2
     */
    public void manageStudents() {
        System.out.println("\n-----------------------------------");
        System.out.println("1. Display all students");
        System.out.println("2. Add a new student");
        System.out.println("3. Edit information a student by id");
        System.out.println("4. Back to main menu");
    }
    
    /**
     * Hàm show ra sub menu của Function 4
     */
    public void report() {
        System.out.println("\n------------------------------------------------------------");
        System.out.println("1. Print out the registration by student's id");
        System.out.println("2. Print out the students that registered more than 2 programs");
        System.out.println("3. Count students that registered the program");
        System.out.println("4. Back to main menu");
    }
}
