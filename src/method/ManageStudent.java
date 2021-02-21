package method;

import creeat.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ManageStudent {
    static List<Student> studentList = new ArrayList<>();

    static Student student = new Student();

    static Scanner sc = new Scanner(System.in);

    public static Student getInputInfoStudent() {

        System.out.println("Nhap ten: ");
        student.setName(sc.nextLine());

        System.out.println("Nhap gioi tinh: ");
        student.setGender(sc.nextLine());

        System.out.println("Nhap ngay sinh: ");
        student.setBirtday(sc.nextLine());

        System.out.println("Nhap dia chi: ");
        student.setAddress(sc.nextLine());

        System.out.println("Nhap ma sinh vien (msv can co 8 ky tu): ");
        while (true) {
            String rollNoInput = sc.nextLine();
            boolean check = student.setRollNo(rollNoInput);
            if (check) {
                break;
            }
        }

        System.out.println("Nhap diem trung binh: ");
            float markInput = Float.parseFloat(sc.nextLine());

        System.out.println("Nhap email (email can co ky tu '@' va khong chua ky tu ' ') : ");
        while (true) {
            String emailInput = sc.nextLine();
            boolean check = student.setEmail(emailInput);
            if (check) {
                break;
            }
        }
        return student;
    }

    public static void showInfoStudent() {
        for (int i = 0; i < studentList.size(); i++) {
            studentList.get(i).toString();
        }
    }

    public static void findInfoStudent() {
        System.out.println("Nhap ma sinh vien can tim: ");
        String rollNoFind = sc.nextLine();

        int count = 0;

        for (Student std : studentList) {
            if (std.getRollNo().equals(rollNoFind)) {
                std.toString();
                count++;
            }
        }
        if (count == 0) {
            System.err.println("Khong tim thay sinh vien trong danh sach !");
        }
    }

    public static void addInfoStudent() {
        int n;
        System.out.println("Nhap so luong sinh vien:");
        n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap sinh vien thu " + (i + 1));
            Student std;
            std = ManageStudent.getInputInfoStudent();
            studentList.add(std);
        }
    }

    public static void editInfoStudent() {
        int count = 0;
        System.out.println("Nhap ma sinh vien muon sua ?");
        String editRollNo = sc.nextLine();

        for (Student std : studentList) {
            if (std.getRollNo().equals(editRollNo)) {
                System.out.println("Moi sua thong tin !");
                std = ManageStudent.getInputInfoStudent();
                count++;
            }
        }
        if (count == 0) {
            System.err.println("Khong tim thay sinh vien trong danh sach !");
        }
    }

    public static void deleteInfoStudent() {
        int count = 0;
        System.out.println("Nhap ma sinh vien muon xoa ?");
        String removeRollNo = sc.nextLine();

        for (Student std : studentList) {
            if (std.getRollNo().equals(removeRollNo)) {
                studentList.remove(std);
                count++;
                break;
            }
        }
        if (count == 0) {
            System.err.println("Khong tim thay sinh vien trong danh sach !");
        }
    }

    public static void checkMarkStudent() {
        if (student.getMark() >= 8.0) {
            System.out.println("Hoc sinh Gioi !");
        } else if (student.getMark() < 8.0 && student.getMark() >= 6.5) {
            System.out.println("Hoc sinh Kha !");
        } else if (student.getMark() < 6.5 && student.getMark() >= 5.0) {
            System.out.println("Hoc sinh Trung Binh !");
        } else if (student.getMark() < 5.0) {
            System.out.println("Hoc lai nhe con yeu !");
        }
    }

    public static void sortStudent() {
        Collections.sort(studentList, (o1, o2) -> {
            int cpm = o1.getName().compareTo(o2.getName());
            if (cpm >= 0) {
                return 1;
            } else {
                return -1;
            }
        });
        for (int i = 0; i < studentList.size(); i++) {
            studentList.get(i).toString();
        }
    }

    public static void showMenu() {
        System.out.println("1 - Nhap thong tin sinh vien :");
        System.out.println("2 - Hien thi thong tin sinh vien :");
        System.out.println("3 - Sua thong tin SV :");
        System.out.println("4 - Sap xep sinh vien theo A - Z va hien thi lai :");
        System.out.println("5 - Hien thi thong tin Diem Trung Binh cua sinh vien :");
        System.out.println("6 - Xoa sinh vien :");
        System.out.println("7 - Them sinh vien :");
        System.out.println("8 - Thoat : ");
    }
}
