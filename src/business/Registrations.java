package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import model.Registration;
import model.Student;
import util.Input;
import util.Validation;

/**
 * Tủ/mảng/danh sách chứa thông tin của các đơn đăng kí chương trình du học trong hệ thống
 * @author acer
 */
public class Registrations extends HashMap<String, Registration> {
    
    /**
     * Thêm một hồ sơ chứa các thông tin cần thiết của 1 đơn đăng kí vào trong tủ/mảng/dach sách, 
     * thông tin của đơn đăng kí sẽ tự động được lưa vào 1 file text trong folder RegistrationForm
     * @param p tủ/mảng/danh sách chứa thông tin của tất cả chương trình du học trong hệ thống
     * @param s tủ/mảng/danh sách chứa thông tin của tất cả sinh viên trong hệ thống
     * @throws ParseException ném ra ngoại lệ một cách rõ ràng
     */
    public void addRegistration(Programs p, Students s) throws ParseException {
        String registrationID = null, programID, studentID, registrationDate = null, emailParents, phoneParents;
        
        if (p.isEmpty()) {
            System.err.println("There is no abroad program in system!");
            return;
        }
        if (s.isEmpty()) {
            System.err.println("There is no student in system!");
            return;
        }
        
        programID = Input.getFormatString("Input the program id (Ex: E01): ", "^[E][0-9]{2}$");
        if (!p.containsKey(programID)) {
            System.err.println("The program's id does not exist!");
            return;
        }
                  
        studentID = Input.getStudentID();
        if (!s.containsKey(studentID)) {
            System.err.println("The student's id does not exist!");
            return;
        }
        
        boolean flag1 = false;
        while (!flag1) {            
            registrationID = Input.getFormatString("Input the registration id (Ex: R01): ", "^[R][0-9]{2}$");
            if (!this.containsKey(registrationID))
                flag1 = true;
            else System.err.println("Duplicated id!");
        }
        
        boolean flag2 = false;
        while (!flag2) {            
            registrationDate = Input.getDate("Input registration date: ");
            if (Validation.compareDate(p.get(programID).getFromRegistrationDate(), registrationDate)
                && Validation.compareDate(registrationDate, p.get(programID).getEndRegistrationDate()))
                flag2 = true;
            else System.err.println("Registration date must be between begin and end of the program’s registration date!");
        }
        
        emailParents = Input.getFormatString("Input parents's email: ", "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$");
        phoneParents = Input.getFormatString("Input parents's phone (Ex: 0xxxxxxxxx): ", "^0[1-9]{9}$");
        this.put(registrationID, new Registration(registrationID, p.get(programID), s.get(studentID), registrationDate, emailParents, phoneParents));
        saveData(studentID, programID, this.get(registrationID));
    }

    /**
     * Lưu thông tin của 1 đơn đăng kí vào 1 file text trong folder RegistrationForm,
     * 1 đơn đăng kí ứng với 1 file text riêng biệt
     * @param studentID mã sinh viên đăng kí chương trình
     * @param programID mã chương trình được đăng kí
     * @param r thông tin của đơn đăng kí chương trình
     */
    public void saveData(String studentID, String programID, Registration r) {      
        File f = new File(System.getProperty("user.dir") + "//RegistrationForm//" + studentID + "_" + programID + ".txt");     
        try {          
            if (!f.exists())
                f.createNewFile();
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(r.toString());
            bw.close();
            fw.close();
            System.out.println("SAVED!!!");
        } catch (Exception e) {
            System.err.println("FAILED!!!");
        }
    }

    /**
     * Đọc văn bản của 1 file text
     * @param path đường dẫn của file text cần đọc, nơi chứa thông tin của 1 đơn đăng kí
     */
    public void readData(String path) {
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            boolean flag = false;
            while (!flag) {    
                System.out.println(line);
                line = br.readLine();
                if(line == null) {
                    flag = true;
                }               
            }
        } catch (Exception e) {
            System.out.println("FAILED!");
        } 
    }
    
    /**
     * Lấy tất cả các tên tệp trong folder RegistrationForm
     * @return Danh sách chứa tên của tất cả các tệp trong folder RegistrationForm
     */
    public String[] allTextFiles() {
        String allFileNames = "";
        String folderPath = System.getProperty("user.dir") + "//RegistrationForm";
        File folder = new File(folderPath);
        File files[] = folder.listFiles();
        for (File file : files) {
            allFileNames += file.getName() + ",";
        }
        String[] fileName = allFileNames.split(",");
        return fileName;
    }
    
    /**
     * Hiển thị nội dung của file text có tên tệp chứa ID sinh viên đã nhập
     * @param s tủ/mảng/danh sách chứa thông tin của tất cả sinh viên trong hệ thống
     */
    public void printOutRegistrationByID(Students s) {
        if (s.isEmpty()) {
            System.err.println("There is no student in system!");
            return;
        }
        String studentID = Input.getStudentID();
        if (!s.containsKey(studentID)) {
            System.err.println("There is no " + studentID + " in registration!");
            return;
        }
        int count = 0;
        for (String string : allTextFiles()) {
            if (string.contains(studentID)) {
                readData(System.getProperty("user.dir") + "//RegistrationForm//" + string);
                count++;
            }                      
        }
        if (count == 0)
            System.err.println("The student's " + studentID + " does not any registration!");  
    }
    
    /**
     * Hiển thị thông tin của các sinh viên có nhiều hơn hơn 2 đơn đăng kí trong folder RegistrationForm
     * @param s tủ/mảng/danh sách chứa thông tin của tất cả sinh viên trong hệ thống
     */
    public void printOutStudentsRegisteredMore2(Students s) {
        if (s.isEmpty()) {
            System.err.println("There is no student in system!");
            return;
        }
        List<Student> list = new ArrayList<>(s.values());
        System.out.println("|No   |Id        |Name                |Major   |Email                 "
                         + "|         Phone|       Passport|        Address|");
        for (Student student : list) {
            int count = 0;
            for (String string : allTextFiles()) {
                if (string.contains(student.getId()))
                    count++;
            }
            if (count > 2)
                System.out.println(student.toString());
        }
    }
    
    /**
     * Người dùng nhập ID của chương trình, hệ thống sẽ in ra số lượng sinh viên đã đăng ký chương trình đó
     * @param p tủ/mảng/danh sách chứa thông tin của tất cả chương trình du học trong hệ thống
     */
    public void countStudentsRegisteredAProgram(Programs p) {
        if (p.isEmpty()) {
            System.err.println("There is no abroad program in system!");
            return;
        }
        int count = 0;
        String programID = Input.getFormatString("Input the program id (Ex: E01): ", "^[E][0-9]{2}$");
        if (!p.containsKey(programID)) {
            System.err.println("There is no " + programID + " id in system!");
            return;
        }
        for (String s : allTextFiles()) {
            if (s.contains(programID))
                count++;
        }
        System.out.println("We have " + count + " student(s) that registered this program.");
    }
}
