
package model;

/**
 * Nơi (Class) tạo dựng, khai báo những đặc tính/hành vi 
 * và dùng để đúc ra/tạo ra các object/đối tượng Registration cần lưu trữ thông tin
 * @author acer
 */
public class Registration {
    
    //khai báo các đặc điểm, chi tiết mà một object Program cần có
    private String registrationID;
    private Program p;
    private Student s;
    private String registrationDate;
    private String emailParents;
    private String phoneParents;

    /**
     * Constructor - Hàm khởi tạo đổ các value và đúc ra 1 object Registration
     * @param registrationID mã số của đơn đăng kí
     * @param p 1 object Program
     * @param s 1 object Student
     * @param registrationDate ngày đăng kí chương trình
     * @param emailParents email phụ huynh của sinh viên đăng kí chương trình
     * @param phoneParents số điện thoại phụ huynh của sinh viên đăng kí chương trình
     */
    public Registration(String registrationID, Program p, Student s, String registrationDate, String emailParents, String phoneParents) {
        this.registrationID = registrationID;
        this.p = p;
        this.s = s;
        this.registrationDate = registrationDate;
        this.emailParents = emailParents;
        this.phoneParents = phoneParents;
    }

    /**
     * Hàm trả về thông tin mã số của đơn đăng kí
     * @return mã số của đơn đăng kí
     */
    public String getRegistrationID() {
        return registrationID;
    }
   
    /**
     * Hàm trả về thông tin mã số của chương trình được đăng kí
     * @return mã số của chương trình được đăng kí
     */
    public String getProgramID() {
        return p.getId();
    }

    /**
     * Hàm trả về thông tin mã số của sinh viên đăng kí chương trình
     * @return mã số của sinh viên đăng kí chương trình
     */
    public String getStudentID() {
        return s.getId();
    }

    /**
     * Hàm trả về thông tin ngày đăng kí chương trình
     * @return ngày đăng kí chương trình
     */
    public String getRegistrationDate() {
        return registrationDate;
    }

    /**
     * Hàm thay đổi thông tin ngày đăng kí chương trình
     * @param registrationDate ngày đăng kí mới
     */
    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    /**
     * Hàm trả về thông tin email phụ huynh của sinh viên đăng kí chương trình
     * @return email phụ huynh của sinh viên đăng kí chương trình
     */
    public String getEmailParents() {
        return emailParents;
    }

    /**
     * Hàm thay đổi thông tin email phụ huynh của sinh viên đăng kí chương trình
     * @param emailParents email mới của phụ huynh
     */
    public void setEmailParents(String emailParents) {
        this.emailParents = emailParents;
    }

    /**
     * Hàm trả về thông tin số điện thoại phụ huynh của sinh viên đăng kí chương trình
     * @return số điện thoại phụ huynh của sinh viên đăng kí chương trình
     */
    public String getPhoneParents() {
        return phoneParents;
    }

    /**
     * Hàm thay đổi thông tin số điện thoại phụ huynh của sinh viên đăng kí chương trình
     * @param phoneParents số điện thoại mới của phụ huynh
     */
    public void setPhoneParents(String phoneParents) {
        this.phoneParents = phoneParents;
    }
    
    /**
     * Hàm trả về chuỗi các thông tin chi tiết của 1 Registration
     * @return chuỗi thông tin chi tiết của 1 đơn đăng kí
     */
    @Override    
    public String toString() {
        return String.format("----------------------------------------------------------------------------------")
            + String.format("----------------------------------------------------------------------------------\n")
            +  String.format("Information Student:")
            +  String.format("\n")
            +  String.format("|No   |Id        |Name                |Major   |Email                 "
                         + "|         Phone|       Passport|        Address|Email of parents      |  Phone of the parents|")
            + String.format("\n")
            + String.format(s.toString() + "%-22s|%22s|",emailParents, phoneParents)
            + String.format("\n")
            + String.format("\n")
            + String.format("Information of the abroad program:")
            + String.format("\n")
            + String.format("|No   |Id    |Name            |Time      |   From Registration Date|    End Registration Date"
                         + "|   Days|Location            |      Cost|             Content|")
            + String.format("\n")
            + String.format(p.toString())
            + String.format("\n")
            + String.format("\n")
            + String.format("Information of the registration: ")
            + String.format("\n")
            + String.format("registration date: " + getRegistrationDate())
            + String.format("\n----------------------------------------------------------------------------------")
            + String.format("----------------------------------------------------------------------------------");
    }
}
