
package model;

import java.io.Serializable;

/**
 * Nơi (Class) tạo dựng, khai báo những đặc tính/hành vi 
 * và dùng để đúc ra/tạo ra các object/đối tượng Program cần lưu trữ thông tin
 * @author acer
 */
public class Program implements Serializable{
    
    //khai báo các đặc điểm, chi tiết mà một object Program cần có
    private int no;
    private String id;
    private String name;
    private String time;
    private String fromRegistrationDate;
    private String endRegistrationDate;
    private int days;
    private String location;
    private double cost;
    private String content;

    /**
     * Constructor - Hàm khởi tạo đổ các value và đúc ra 1 object Program
     * @param no số thự tự của chương trình trong danh sách
     * @param id mã số của chương trình
     * @param name tên của chương trình
     * @param time thời gian (tháng) tổ chức chương trình
     * @param fromRegistrationDate ngày bắt đầu chương trình
     * @param endRegistrationDate ngày kết thúc chương trình
     * @param days số lượng ngày diễn ra chương trình
     * @param location địa điểm tổ chức chương trình
     * @param cost chi phí của chương trình
     * @param content đường dẫn file text chứa nội dung của chương trình
     */
    public Program(int no, String id, String name, String time, String fromRegistrationDate, String endRegistrationDate, int days, String location, double cost, String content) {
        this.no = no;
        this.id = id;
        this.name = name;
        this.time = time;
        this.fromRegistrationDate = fromRegistrationDate;
        this.endRegistrationDate = endRegistrationDate;
        this.days = days;
        this.location = location;
        this.cost = cost;
        this.content = content;
    }

    /**
     * Hàm trả về thông tin số thự tự của chương trình trong danh sách
     * @return số thứ tự của chương trình
     */
    public int getNo() {
        return no;
    }

    /**
     * Hàm thay đổi thông tin số thự tự của chương trình trong danh sách
     * @param no số thự tự mới của chương trình
     */
    public void setNo(int no) {
        this.no = no;
    }
    
    /**
     * Hàm trả về thông tin mã số id của chương trình
     * @return mã số id chương trình
     */
    public String getId() {
        return id;
    }

    /**
     * Hàm trả về thông tin tên của chương trình
     * @return tên chương trình
     */
    public String getName() {
        return name;
    }

    /**
     * Hàm thay đổi thông tin tên của chương trình
     * @param name tên mới của chương trình
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Hàm trả về thông tin thời gian (tháng) tổ chức chương trình
     * @return thời gian tổ chức chương trình
     */
    public String getTime() {
        return time;
    }

    /**
     * Hàm thay đổi thông tin thời gian (tháng) tổ chức chương trình
     * @param time thời gian mới của chương trình
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * Hàm trả về thông tin ngày bắt đầu chương trình
     * @return ngày bắt đầu chương trình
     */
    public String getFromRegistrationDate() {
        return fromRegistrationDate;
    }

    /**
     * Hàm thay đổi thông tin ngày bắt đầu chương trình
     * @param fromRegistrationDate ngày bắt đầu mới của chương trình
     */
    public void setFromRegistrationDate(String fromRegistrationDate) {
        this.fromRegistrationDate = fromRegistrationDate;
    }

    /**
     * Hàm trả về thông tin ngày kết thúc chương trình
     * @return ngày kết thúc chương trình
     */
    public String getEndRegistrationDate() {
        return endRegistrationDate;
    }

    /**
     * Hàm thay đổi thông tin ngày kết thúc chương trình
     * @param endRegistrationDate ngày kết thúc mới của chương trình
     */
    public void setEndRegistrationDate(String endRegistrationDate) {
        this.endRegistrationDate = endRegistrationDate;
    }

    /**
     * Hàm trả về thông tin số lượng ngày diễn ra chương trình
     * @return số lượng ngày diễn ra chương trình
     */
    public int getDays() {
        return days;
    }

    /**
     * Hàm thay đổi thông tin số lượng ngày diễn ra chương trình
     * @param days số lượng ngày diễn ra mới của chương trình
     */
    public void setDays(int days) {
        this.days = days;
    }

    /**
     * Hàm trả về thông tin địa điểm tổ chức chương trình
     * @return địa điểm tổ chức chương trình
     */
    public String getLocation() {
        return location;
    }

    /**
     * Hàm thay đổi thông tin địa điểm tổ chức chương trình
     * @param location địa điểm tổ chức mới của chương trình
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Hàm trả về thông tin chi phí của chương trình
     * @return chi phí của chương trình
     */
    public double getCost() {
        return cost;
    }

    /**
     * Hàm thay đổi thông tin chi phí của chương trình
     * @param cost chi phí mới của chương trình
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * Hàm trả về thông tin đường dẫn file text chứa nội dung của chương trình
     * @return đường dẫn file text
     */
    public String getContent() {
        return content;
    }

    /**
     * Hàm thay đổi thông tin đường dẫn file text chứa nội dung của chương trình
     * @param content đường dẫn file text mới
     */
    public void setContent(String content) {
        this.content = content;
    }
    
    /**
     * Hàm trả về chuỗi các thông tin chi tiết của 1 Program
     * @return chuỗi thông tin chi tiết của 1 chương trình
     */
    @Override
    public String toString() {
        return String.format("|%-5d|%-6s|%-16s|%-10s|%25s|%25s|%7d|%-20s|%10.1f|%20s|",
            no, id, name, time, fromRegistrationDate, endRegistrationDate, days, location, cost, content);
    }
}
