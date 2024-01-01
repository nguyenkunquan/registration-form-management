
package business;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import model.Student;
import util.Input;

/**
 * Tủ/mảng/danh sách chứa thông tin của tất cả sinh viên trong hệ thống
 * @author acer
 */
public class Students extends HashMap<String, Student>{
    
    /**
     * Hiển thị thông tin của tất cả sinh viên trong hệ thống
     */
    public void displayAllStudents() {
        List<Student> list = new ArrayList<>(this.values());
        if (this.isEmpty()) {
            System.err.println("There is no student in system!");
            return;
        }
        System.out.println("|No   |Id        |Name                |Major   |Email                 "
                         + "|         Phone|       Passport|        Address|");
        for (Student s : list) { 
            System.out.println(s.toString());
        }
    }
    
    /**
     * Thêm một hồ sơ chứa các thông tin cần thiết của 1 sinh viên vào trong tủ/mảng/dach sách
     */
    public void addNewStudent() {
        int no = this.size() + 1;
        String id = null, name, major, email, phone, passport, address;
        
        boolean flag1 = false;
        while (!flag1) {
            try {
                id = Input.getStudentID();
                if (this.containsKey(id))
                    throw new Exception();
                flag1 = true;
            } catch (Exception e) {
                System.err.println("Duplicated ID!!!");
            }            
        }
        name = Input.getString("Input students's name: ");
        major = Input.getMajor();
        email = Input.getEmail();
        phone = Input.getFormatString("Input phone (Ex: 0xxxxxxxxx): ", "^0[1-9]{9}$");
        passport = Input.getString("Input passport: ");
        address = Input.getString("Input address: ");
        this.put(id, new Student(no, id, name, major, email, phone, passport, address));
    }
    
    /**
     * Cập nhật lại thông tin của 1 sinh viên theo các lựa chọn
     *
     * - 1: Cập nhật tên - 2: Cập nhật chuyên ngành - 3: Cập nhật email
     * - 4: Cập nhật số điện thoại - 5: Cập nhật hộ chiếu
     * - 6: Cập nhật địa chỉ - 7: Thoát khỏi việc cập nhật
     */
    public void editStudent() {
        if (this.isEmpty()) {
            System.err.println("There is no student in system!");
            return;
        }
        String id = Input.getStudentID();
        if (!this.containsKey(id)) {
            System.err.println("The student’s id does not exist!");
            return;
        }
        System.out.println("|-------------------------------------|");
        System.out.println("Do you want to change? (Choosing 1 - 5)");
        System.out.println("1. Edit name");
        System.out.println("2. Edit major");
        System.out.println("3. Edit email");
        System.out.println("4. Edit phone");
        System.out.println("5. Edit passport");
        System.out.println("6. Edit address");
        System.out.println("7. Quit");
        int choice = Input.getInboundNumber("Choosing your option: ", 1, 7);
        if (choice != 7) {
            switch (choice) {
                case 1:                
                    this.get(id).setName(Input.getString("Input students's name: "));
                    break;
                case 2:
                    this.get(id).setMajor(Input.getMajor());
                    break;
                case 3:
                    this.get(id).setEmail(Input.getEmail());
                    break;
                case 4:
                    this.get(id).setPhone(Input.getFormatString("Input phone (Ex: 0xxxxxxxxx): ", "^0[1-9]{9}$"));
                    break;
                case 5:
                    this.get(id).setPassport(Input.getString("Input passport: "));
                    break;
                case 6:
                    this.get(id).setAddress(Input.getString("Input address: "));
                    break;
        }
            System.out.println("SUCCESS");
        }
    }
    
    /**
     * Lưu dữ liệu thông tin các bạn sinh viên trong hệ thống vào file binary
     * @throws Exception ném ra ngoại lệ một cách rõ ràng
     */
    public void saveData() throws Exception {
        ArrayList<Student> list = new ArrayList<>(this.values());
        if (list.isEmpty()) {
            System.err.println("There is no student in system!");
        } else {
            FileOutputStream fileOut;
            ObjectOutputStream objectOut;
            try {
                final String pathStudents = (System.getProperty("user.dir") + "/src/data/students.dat");
                File file = new File(pathStudents);
                fileOut = new FileOutputStream(file);
                objectOut = new ObjectOutputStream(fileOut);
                for (Object obj : list) {
                    objectOut.writeObject(obj);
                }
                objectOut.flush();
                objectOut.close();
                fileOut.close();
                System.out.println("SAVED!!!");
            } catch (Exception ex) {
                System.out.println("FAIL!!!");
            }
        }
    }
    
    /**
     * Tải lên dữ liệu thông tin các bạn sinh viên từ file binary lên hệ thống
     * @throws Exception ném ra ngoại lệ một cách rõ ràng
     */
    public void loadData() throws Exception {
        ArrayList<Student> arr = new ArrayList<>();
        FileInputStream fileIn = null;
        ObjectInputStream objectIn = null;
        try {
            final String pathStudents = (System.getProperty("user.dir") + "/src/data/students.dat");
            File file = new File(pathStudents);
            fileIn = new FileInputStream(file);
            objectIn = new ObjectInputStream(fileIn);
            Object obj;
            while ((obj = objectIn.readObject()) != null) {
                if (obj instanceof Student) {
                    arr.add((Student) obj);
                }
            }
            objectIn.close();
            fileIn.close();
            System.out.println("LOADED!!!");
        } catch (EOFException eof) {
            System.out.println("LOADED!!!");
        } catch (Exception ex) {
            System.out.println("FAIL!!!");
            throw ex;
        } finally {
            if (objectIn != null) {
                objectIn.close();
            }
            if (fileIn != null) {
                fileIn.close();
            }
        }
        for (Student s : arr) {
            this.put(s.getId(), s);
        }
    }
}
