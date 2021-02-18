package quanlysinhvien;

import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

public class Student extends Person implements Serializable {
    private String rollNo;
    private float mark;
    private String email;

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
    public void inputInfo() {
        super.inputInfo();

        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap ma sinh vien: ");         // Check msv chi nhan khi nhap dung dieu kien;
        while (true) {
            String rollNoInput = sc.nextLine();
            boolean check = this.setRollNo(rollNoInput);
            if (check) {
                break;
            }
        }

        System.out.println("Nhap diem trung binh: ");
        while (true) {
            float markInput = Float.parseFloat(sc.nextLine());
            boolean check = this.setMark(markInput);
            if (check) {
                break;
            }
        }

        System.out.println("Nhap email: ");         // email phai co ky tu (@) va ko chua ky tu(" ");
        while (true) {
            String emailInput = sc.nextLine();
            boolean check = this.setEmail(emailInput);
            if (check) {
                break;
            }
        }

        try {
            File_IO.readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            File_IO.writeFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showInfo() {
        System.out.println(this.toString());
        System.out.println("");

        try {
            File_IO.readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            File_IO.writeFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean checkScholarship() {      // Check sv duoc hoc bong;
        if (this.getMark() >= 8.0) {
            return true;
        } else {
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
