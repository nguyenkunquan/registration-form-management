
package util;

import java.util.Scanner;

/**
 * Nơi lưu trữ các hàm phục vụ cho việc nhập, xuất được tái sử dụng nhiều lần
 * @author acer
 */
public class Input {
    
    private static Scanner sc = new Scanner(System.in);
    
    /**
     * Hàm trả về một chuỗi không rỗng
     * @param msg thông điệp gửi tới người dùng
     * @return chuỗi có kí tự
     */
    public static String getString(String msg) {
        String s = null;
        boolean flag = false;
        while (!flag) {
            System.out.print(msg);
            s = sc.nextLine().trim();
            if (Validation.isEmpty(s))
                System.err.println("Empty input!");
            else flag = true;
        }
        return s;
    }
    
    /**
     * Hàm trả về một chuỗi theo đúng định dạng ta cần
     * @param msg thông điệp gửi tới người dùng
     * @param format định dạng mà ta muốn người dùng tuân theo
     * @return chuỗi đúng theo định dạng ta cần
     */
    public static String getFormatString(String msg, String format) {
        String s = null;
        boolean flag = false;
        while (!flag) {            
            System.out.print(msg);
            s = sc.nextLine().trim();
            if (Validation.isValidFormat(s, format))
                flag = true;
            else System.err.println("Wrong format input!");
        }
        return s;
    }
    
    /**
     * Hàm trả về chuỗi (tháng) có trong tập hữu hạn các tháng cho phép
     * @param msg thông điệp gửi tới người dùng
     * @return chuỗi (tháng) hợp lệ
     */
    public static String getTime(String msg) {
        String s = null;
        boolean flag = false;
        while (!flag) {            
            System.out.print(msg);
            s = sc.nextLine().trim();
            if (s.equalsIgnoreCase("January")   || s.equalsIgnoreCase("March") ||
                s.equalsIgnoreCase("May")       || s.equalsIgnoreCase("July")  ||
                s.equalsIgnoreCase("September") || s.equalsIgnoreCase("November"))
                flag = true;
            else System.err.println("Wrong format time!");
        }
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }
    
    /**
     * Hàm trả về chuỗi có là định dạng "ngày/tháng/năm"
     * @param msg thông điệp gửi tới người dùng
     * @return Trả về chuỗi có định dạng "ngày/tháng/năm"
     */
    public static String getDate(String msg) {
        String date = "";
        boolean flag = false;
        while (!flag) {
            date = getString(msg);
            if (Validation.checkDate(date)) {
                flag = true;
            } else {
                System.err.println("Please re-enter the date!");
            }
        }
        return date;
    }
    
    /**
     * Hàm trả về một số nguyên dương
     * @param msg thông điệp gửi tới người dùng
     * @return một số nguyên dương
     */
    public static int getPositiveInteger(String msg) {
        int i = 0;
        boolean flag = false;
        while (!flag) {
            try {
                System.out.print(msg);
                i = Integer.parseInt(sc.nextLine().trim());
                if (Validation.isPositiveInteger(i))
                    flag = true;
                else System.err.println("Please inputting a positive number!");
            } catch (Exception e) {
                System.err.println("Invalid number!");
            }        
        }
        return i;
    }
    
    /**
     * Hàm trả về một số thực dương
     * @param msg thông điệp gửi tới người dùng
     * @return một số thực dương
     */
    public static double getPositiveDouble(String msg) {
        double d = 0;
        boolean flag = false;
        while (!flag) {
            try {
                System.out.print(msg);
                d = Double.parseDouble(sc.nextLine().trim());
                if (Validation.isPositiveDouble(d))
                    flag = true;
                else System.err.println("Please inputting a positive number!");
            } catch (Exception e) {
                System.err.println("Invalid number!");
            }        
        }
        return d;
    }
    
    /**
     * Hàm trả về số nằm trong khoảng cho phép
     * @param msg thông điệp gửi tới người dùng
     * @param lowerBound số thấp nhất
     * @param upperBound số cao nhất
     * @return số nằm trong khoảng số thấp nhấp đến cao nhất
     */
    public static int getInboundNumber(String msg, int lowerBound, int upperBound) {
        int i = 0;
        boolean flag = false;
        while (!flag) {
            i = getPositiveInteger(msg);
            if (Validation.isInboundNumber(i, lowerBound, upperBound))
                flag = true;
            else System.err.println("Invalid number!");
        }
        return i;
    }
    
    /**
     * Hàm trả về mã số sinh viên theo đúng định dạng cho phép
     * @return mã số sinh viên hợp lệ
     */
    public static String getStudentID() {
        String s = null;
        boolean flag = false;
        while (!flag) {
            s = getString("Input the student id (Ex: SE1234): ");
            if (Validation.isValidFormatStudentID(s))
                flag = true;
            else System.err.println("Format student's id is invalid!");
            }
        return s;
    }
    
    /**
     * Hàm trả về mã chuyên ngành theo đúng định dạng cho phép
     * @return mã chuyên ngành hợp lệ
     */
    public static String getMajor() {
        String s = null;
        boolean flag = false;
        while (!flag) {
            s = getString("Input the major (SE/SB/GD/MC): ");
            if (Validation.isValidFormatMajor(s))
                flag = true;
            else System.err.println("Invalid major!");
            }
        return s.toUpperCase();
    }
    
    /**
     * Hàm trả về thông tin email sinh viên theo đúng định dạng cho phép (@fpt.edu.vn)
     * @return email sinh viên (contains @fpt.edu.vn)
     */
    public static String getEmail() {
        String s = null;
        boolean flag = false;
        while (!flag) {            
            s = getString("Input email: ");
            if (Validation.isValidFormat(s, "^[A-Za-z0-9]+[A-Za-z0-9]*@" + "fpt.edu.vn"))
                flag = true;
            else System.err.println("Invalid email!");
        }
        return s;
    }
    
    /**
     * Hàm trả về lựa chọn của người dùng
     * @param msg thông điệp gửi tới người dùng
     * @param errorMsg thông báo lỗi
     * @param min lựa chọn thấp nhất
     * @param max lựa chọn cao nhất
     * @return lựa chọn nằm trong khoảng lựa chọn thấp nhấp đến cao nhất
     */
    public static int getChoiceWithMess(String msg, String errorMsg, int min, int max) {
        int choice = 0;
        boolean flag = false;
        while (!flag) {
            try {
                System.out.print(msg);
                choice = Integer.parseInt(sc.nextLine());
                if (Validation.isInboundNumber(choice, min, max))
                    flag = true;
                else throw new Exception();
            } catch (Exception e) {
                System.err.println(errorMsg);
            }           
        }
        return choice;
    }
    
}
