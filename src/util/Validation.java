
package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Nơi lưu trữ các hàm boolean phục vụ cho việc kiểm tra tính đúng sai, được tái sử dụng nhiều lần
 * @author acer
 */
public class Validation {
    
    /**
     * Hàm kiểm tra chuỗi đầu vào có rỗng hay không
     * @param s chuỗi cần kiểm tra
     * @return true - không rỗng; false - rỗng
     */
    public static boolean isEmpty(String s) {
        boolean flag = false;
        if (s.isEmpty())
            flag = true;
        return flag;
    }
    
    /**
     * Hàm kiểm tra chuỗi đầu vào có đúng theo định dạng mà ta cần hay không
     * @param s chuỗi cần kiểm tra
     * @param format định dạng mà ta cần
     * @return true - khớp đúng định dạng; false - không đúng định dạng
     */
    public static boolean isValidFormat(String s, String format) {
        boolean flag = false;
        if (s.matches(format))
            flag = true;
        return flag;
    }
    
    /**
     * Hàm kiểm tra chuỗi đầu vào có đúng theo định dạng mã chuyên ngành hay không
     * @param s chuỗi cần kiểm tra
     * @return true - khớp đúng định dạng; false - không đúng định dạng
     */
    public static boolean isValidFormatMajor(String s) {
        boolean flag = false;
        if (s.equalsIgnoreCase("SE") || s.equalsIgnoreCase("SB") ||
            s.equalsIgnoreCase("GD") || s.equalsIgnoreCase("MC"))
            flag = true;
        return flag;
    }
    
    /**
     * Hàm kiểm tra chuỗi đầu vào có đúng theo định dạng mã số sinh viên hay không
     * @param s chuỗi cần kiểm tra
     * @return true - khớp đúng định dạng; false - không đúng định dạng
     */
    public static boolean isValidFormatStudentID(String s) {
        boolean flag = false;
        if (s.matches("^[S][E][0-9]{4}$") || s.matches("^[S][B][0-9]{4}$") ||
            s.matches("^[G][D][0-9]{4}$") || s.matches("^[M][C][0-9]{4}$"))
            flag = true;
        return flag;
    }
    
    /**
     * Hàm kiểm tra số nguyên đầu vào có phải là số nguyên dương hay không
     * @param number số nguyên cần kiểm tra
     * @return true - là số nguyên dương; false - không phải số nguyên dương
     */
    public static boolean isPositiveInteger(int number) {
        boolean flag = false;
        if (number > 0)
            flag = true;
        return flag;
    }
    
    /**
     * Hàm kiểm tra số thực đầu vào có phải là số thực dương hay không
     * @param number số thực cần kiểm tra
     * @return true - là số thực dương; false - không phải số thực dương
     */
    public static boolean isPositiveDouble(double number) {
        boolean flag = false;
        if (number > 0)
            flag = true;
        return flag;
    }
    
    /**
     * Hàm kiểm tra số nguyên đầu vào có nằm trong khoảng cho trước hay không
     * @param number số nguyên cần kiểm tra
     * @param lowerBound số thấp nhất trong khoảng cho trước
     * @param upperBound số lớn nhất trong khoảng cho trước
     * @return true - nằm trong khoảng cho trước; false - nằm ngoài khoảng cho trước
     */
    public static boolean isInboundNumber(int number, int lowerBound, int upperBound) {
        boolean flag = false;
        if(number >= lowerBound && number <= upperBound)
            flag = true;
        return flag;
    }
    
    /**
     * Hàm kiểm tra xem người dùng có nhập đúng định dạng ngày hay không
     * @param date chuỗi cần kiểm tra
     * @return true: chuỗi đúng theo định dạng ngày; false: chuỗi không đúng theo định dạng ngày
     */
    public static boolean checkDate(String date) {
        if (date == null) {
            return false;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            sdf.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    
    /**
     * Hàm so sánh việc nhập 2 ngày có hợp lệ hay không
     * @param startDate ngày bắt đầu
     * @param endDate ngày kết thúc
     * @return true: ngày bắt đầu nhỏ hơn hoặc trùng ngày kết thúc; false: ngày bắt đầu lớn hơn ngày kết thúc
     * @throws ParseException ném ra ngoại lệ một cách rõ ràng
     */
    public static boolean compareDate(String startDate, String endDate) throws ParseException{
        boolean flag = true;
        SimpleDateFormat sdformat = new SimpleDateFormat("dd/MM/yyyy");
        Date d1 = sdformat.parse(startDate);
        Date d2 = sdformat.parse(endDate);
        if(d1.compareTo(d2) > 0)
            flag = false;
        return flag;
    }
}
