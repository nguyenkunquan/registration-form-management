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
import model.Program;
import util.Input;
import util.Validation;

/**
 * Tủ/mảng/danh sách chứa thông tin của các chương trình du học trong hệ thống
 * @author acer
 */
public class Programs extends HashMap<String, Program> {
    
    /**
     * Hiển thị thông tin của tất cả chương trình trong hệ thống
     */
    public void displayAllAbroadPrograms() {
        List<Program> list = new ArrayList<>(this.values());
        if (this.isEmpty()) {
            System.err.println("There is no abroad program in system!");
            return;
        }
        System.out.println("|No   |Id    |Name            |Time      |   From Registration Date|    End Registration Date"
                         + "|   Days|Location            |      Cost|             Content|");
        for (Program p : list) {
            System.out.println(p.toString());
        }
    }

    /**
     * Thêm một hồ sơ chứa các thông tin cần thiết của 1 chương trình vào trong tủ/mảng/dach sách
     */
    public void addNewAbroadProgram() {
        String id = null, name, time, fromRegistrationDate = null, endRegistrationDate = null, location, content;
        int no = this.size() + 1;
        int days;
        double cost;
        
        boolean flag1 = false;
        while (!flag1) {
            try {
                id = Input.getFormatString("Input the program id (Ex: E01): ", "^[E][0-9]{2}$");
                if (this.containsKey(id))
                    throw new Exception();
                flag1 = true;
            } catch (Exception e) {
                System.err.println("Duplicated ID!!!");
            }            
        }
        name = Input.getString("Input name program: ");
        time = Input.getTime("Input time (January, March, May, July, September, November): ");
        boolean flag2 = false;
        while (!flag2) {
            try {
                fromRegistrationDate = Input.getDate("Input From Registration Date in [dd/MM/yyyy] format: ");
                endRegistrationDate = Input.getDate("Input End Registration Date in [dd/MM/yyyy] format: ");
                if (Validation.compareDate(fromRegistrationDate, endRegistrationDate))
                    flag2 = true;
                else throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid registration date!!!");
            }
        }
        days = Input.getInboundNumber("Input days (from 30 to 40 days): ", 30, 40);
        location = Input.getString("Input location: ");
        cost = Input.getPositiveDouble("Input cost: ");
        content = Input.getFormatString("Input content (the path .doc of the file): ", "^[A-Za-z0-9]+[A-Za-z0-9].doc");
        this.put(id, new Program(no, id, name, time, fromRegistrationDate, endRegistrationDate, days, location, cost, content));
    }
    
    /**
     * Cập nhật lại thông tin của 1 chương trình theo các lựa chọn
     *
     * - 1: Cập nhật tên - 2: Cập nhật thời gian - 3: Cập nhật ngày bắt đầu chương trình
     * - 4: Cập nhật ngày kết thúc trương trình - 5: Cập nhật số ngày học
     * - 6: Cập nhật địa điểm - 7: Cập nhật chi phí - 8: Cập nhật nội dung
     * - 9: Thoát khỏi việc cập nhật
     */
    public void editAbroadProgram() {
        if (this.isEmpty()) {
            System.err.println("There is no abroad program in system!");
            return;
        }
        String id = Input.getFormatString("Entering the program’s id that you want to edit its detai: ", "^[E][0-9]{2}$");
        if (!this.containsKey(id)) {
            System.err.println("The program’s id does not exist!");
            return;
        }
        System.out.println("|-------------------------------------|");
        System.out.println("Do you want to change? (Choosing 1 - 5)");
        System.out.println("1. Edit name");
        System.out.println("2. Edit time");
        System.out.println("3. Edit From Registration Date");
        System.out.println("4. Edit End Registration Date");
        System.out.println("5. Edit days");
        System.out.println("6. Edit location");
        System.out.println("7. Edit cost");
        System.out.println("8. Edit content");
        System.out.println("9. Quit");
        int choice = Input.getInboundNumber("Choosing your option: ", 1, 9);
        if (choice != 9) {
            switch (choice) {
                case 1:                
                    this.get(id).setName(Input.getString("Input name program: "));
                    break;
                case 2:
                    this.get(id).setTime(Input.getTime("Input time (January, March, May, July, September, November): "));
                    break;
                case 3:
                    this.get(id).setFromRegistrationDate(Input.getDate("Input From Registration Date in [dd/MM/yyyy] format: "));
                    break;
                case 4:
                    this.get(id).setEndRegistrationDate(Input.getDate("Input End Registration Date in [dd/MM/yyyy] format: "));
                    break;
                case 5:
                    this.get(id).setDays(Input.getInboundNumber("Input days (from 30 to 40 days): ", 30, 40));
                    break;
                case 6:
                    this.get(id).setLocation(Input.getString("Input location: "));
                    break;
                case 7:
                    this.get(id).setCost(Input.getPositiveDouble("Input cost: "));
                    break;
                case 8:
                    this.get(id).setContent(Input.getFormatString("Input content (the path .doc of the file): ", "^[A-Za-z0-9]+[A-Za-z0-9].doc"));
                    break;
        }
            System.out.println("SUCCESS");
        }
    }
    
    /**
     * Hiển thị thông tin của 1 chương trình trong hệ thống theo mã số cần tìm (nếu có)
     */
    public void displayAbroadProgram() {
        if (this.isEmpty()) {
            System.err.println("There is no abroad program in system!");
            return;
        }
        String id = Input.getFormatString("Entering the program’s id that you want to display information: ", "^[E][0-9]{2}$");
        if (!this.containsKey(id)) {
            System.err.println("The program’s id does not exist!");
            return;
        }
        System.out.println("|No   |Id    |Name            |Time      |   From Registration Date|    End Registration Date"
                         + "|   Days|Location            |      Cost|             Content|");
        System.out.println(this.get(id).toString());
    }
    
    /**
     * Lưu dữ liệu thông tin các chương trình du học trong hệ thống vào file binary
     * @throws Exception ném ra ngoại lệ một cách rõ ràng
     */
    public void saveData() throws Exception {
        ArrayList<Program> list = new ArrayList<>(this.values());
        if (list.isEmpty()) {
            System.err.println("There is no program in system!");
        } else {
            FileOutputStream fileOut;
            ObjectOutputStream objectOut;
            try {
                final String pathPrograms = (System.getProperty("user.dir") + "/src/data/programs.dat");
                File file = new File(pathPrograms);
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
     * Tải lên dữ liệu thông tin các chương trình du học từ file binary lên hệ thống
     * @throws Exception ném ra ngoại lệ một cách rõ ràng
     */
    public void loadData() throws Exception {
        ArrayList<Program> arr = new ArrayList<>();
        FileInputStream fileIn = null;
        ObjectInputStream objectIn = null;
        try {
            final String pathPrograms = (System.getProperty("user.dir") + "/src/data/programs.dat");
            File file = new File(pathPrograms);
            fileIn = new FileInputStream(file);
            objectIn = new ObjectInputStream(fileIn);
            Object obj;
            while ((obj = objectIn.readObject()) != null) {
                if (obj instanceof Program) {
                    arr.add((Program) obj);
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
        for (Program p : arr) {
            this.put(p.getId(), p);
        }
    }
}
