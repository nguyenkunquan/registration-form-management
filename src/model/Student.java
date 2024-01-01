
package model;

import java.io.Serializable;

/**
 * Nơi (Class) tạo dựng, khai báo những đặc tính/hành vi 
 * và dùng để đúc ra/tạo ra các object/đối tượng Student cần lưu trữ thông tin
 * @author acer
 */
public class Student implements Serializable{
    
    //khai báo các đặc điểm, chi tiết mà một object Student cần có
    private int no;
    private String id;
    private String name;
    private String major;
    private String email;
    private String phone;
    private String passport;
    private String address;

    /**
     * Constructor - Hàm khởi tạo đổ các value và đúc ra 1 object Student
     * @param no số thự tự của sinh viên trong danh sách
     * @param id mã số id của sinh viên
     * @param name họ tên của sinh viên
     * @param major chuyên ngành của sinh viên
     * @param email email của sinh viên (@fpt.edu.vn)
     * @param phone số điện thoại của sinh viên
     * @param passport hộ chiếu của sinh viên
     * @param address địa chỉ sinh sống của sinh viên
     */
    public Student(int no, String id, String name, String major, String email, String phone, String passport, String address) {
        this.no = no;
        this.id = id;
        this.name = name;
        this.major = major;
        this.email = email;
        this.phone = phone;
        this.passport = passport;
        this.address = address;
    }

    /**
     * Hàm trả về thông tin số thự tự của sinh viên trong danh sách
     * @return số thự tự của sinh viên trong danh sách
     */
    public int getNo() {
        return no;
    }

    /**
     * Hàm thay đổi thông tin số thự tự của sinh viên trong danh sách
     * @param no số thự mới mới của sinh viên trong danh sách
     */
    public void setNo(int no) {
        this.no = no;
    }
    
    /**
     * Hàm trả về thông tin mã số id của sinh viên
     * @return mã số id của sinh viên
     */
    public String getId() {
        return id;
    }

    /**
     * Hàm trả về thông tin họ tên của sinh viên
     * @return họ tên của sinh viên
     */
    public String getName() {
        return name;
    }

    /**
     * Hàm thay đổi thông tin họ tên của sinh viên
     * @param name họ tên mới của sinh viên
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Hàm trả về thông tin chuyên ngành của sinh viên
     * @return thông tin chuyên ngành của sinh viên
     */
    public String getMajor() {
        return major;
    }

    /**
     * Hàm thay đổi thông tin chuyên ngành của sinh viên
     * @param major chuyên ngành mới của sinh viên
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * Hàm trả về thông tin email của sinh viên
     * @return email của sinh viên
     */
    public String getEmail() {
        return email;
    }

    /**
     * Hàm thay đổi thông tin email của sinh viên
     * @param email email mới của sinh viên
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Hàm trả về thông tin số điện thoại của sinh viên
     * @return số điện thoại của sinh viên
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Hàm thay đổi thông tin số điện thoại của sinh viên
     * @param phone số điện thoại mới của sinh viên
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Hàm trả về thông tin hộ chiếu của sinh viên
     * @return thông tin hộ chiếu của sinh viên
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Hàm thay đổi thông tin hộ chiếu của sinh viên
     * @param passPort thông tin hộ chiếu mới của sinh viên
     */
    public void setPassport(String passPort) {
        this.passport = passPort;
    }

    /**
     * Hàm trả về thông tin địa chỉ sinh sống của sinh viên
     * @return địa chỉ sinh sống của sinh viên
     */
    public String getAddress() {
        return address;
    }

    /**
     * Hàm thay đổi thông tin địa chỉ sinh sống của sinh viên
     * @param address địa chỉ sinh sống mới của sinh viên
     */
    public void setAddress(String address) {
        this.address = address;
    }
    
    /**
     * Hàm trả về chuỗi các thông tin chi tiết của 1 Student
     * @return chuỗi thông tin chi tiết của 1 bạn sinh viên
     */
    @Override
    public String toString() {
        return String.format("|%-5d|%-10s|%-20s|%-8s|%-22s|%14s|%15s|%15s|",no, id, name, major, email, phone, passport, address);
    }
}
