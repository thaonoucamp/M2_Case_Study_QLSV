package creeat;

import java.io.Serializable;
import java.util.Scanner;

public class Student extends Person implements Serializable {
    private String rollNo;
    private float mark;
    private String email;


    Scanner sc = new Scanner(System.in);

    public Student() {
    }

    public Student(String rollNo, float mark, String email) {
        this.rollNo = rollNo;
        this.mark = mark;
        this.email = email;
    }

    public Student(String name, String gender, String birtday, String address, String rollNo, float mark, String email) {
        super(name, gender, birtday, address);
        this.rollNo = rollNo;
        this.mark = mark;
        this.email = email;
    }

    public String getRollNo() {
        return rollNo;
    }

    public boolean setRollNo(String rollNo) {     // Set dieu kien msv phai du 8 ky tu;

        if (rollNo != null && rollNo.length() == 8) {
            this.rollNo = rollNo;
            return true;
        } else {
            System.err.println("Ma sinh vien phai co du 8 ky tu !");
            return false;
        }
    }

    public float getMark() {
        return mark;
    }

    public boolean setMark(float mark) {
        if (mark >= 0 && mark <= 10) {
            this.mark = mark;
            return true;
        } else {
            System.err.println("Diem thi phai >= 0 && <= 10");
            return false;
        }
    }

    public String getEmail() {
        return email;
    }

    public boolean setEmail(String email) {
        if (email != null && email.contains("@") && !email.contains(" ")) {
            this.email = email;
            return true;
        } else {
            System.err.println("Ban nhap sai(email phai co ky tu '@' va ko chua khoang trang)");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Student{" + super.toString() +
                "rollNo='" + rollNo + '\'' +
                ", mark=" + mark +
                ", email='" + email + '\'' +
                '}';
    }
}

