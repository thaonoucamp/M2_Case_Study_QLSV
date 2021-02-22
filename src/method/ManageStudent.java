package method;

import creeat.Student;
import myFile.File_IO;

import javax.management.remote.SubjectDelegationPermission;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ManageStudent implements Serializable{
    static String filePath = "/Users/thaodangxuan/IdeaProjects/QUAN_LY_SINH_VIEN/src/ManageStudent.dat";

    public static ArrayList<Student> studentList = (ArrayList<Student>) File_IO.readFromFile(filePath) == null ? new ArrayList<>(): (ArrayList<Student>) File_IO.readFromFile(filePath);


    static Scanner sc = new Scanner(System.in);

    public static Student getInputInfoStudent() {
        Student newStudent = new Student();

        System.out.println("Nhap ten: ");
        newStudent.setName(sc.nextLine());

        System.out.println("Nhap gioi tinh: ");
        newStudent.setGender(sc.nextLine());

        System.out.println("Nhap ngay sinh: ");
        newStudent.setBirtday(sc.nextLine());

        System.out.println("Nhap dia chi: ");
        newStudent.setAddress(sc.nextLine());

        System.out.println("Nhap ma sinh vien (msv can co 8 ky tu): ");
        while (true) {
            String rollNoInput = sc.nextLine();
            boolean check = newStudent.setRollNo(rollNoInput);
            if (check) {
                break;
            }
        }

        System.out.println("Nhap diem trung binh: ");
        while (true) {
            float markInput = Float.parseFloat(sc.nextLine());
            boolean check = newStudent.setMark(markInput);
            if (check) {
                break;
            }
        }

        System.out.println("Nhap email (email can co ky tu '@' va khong chua ky tu ' ') : ");
        while (true) {
            String emailInput = sc.nextLine();
            boolean check = newStudent.setEmail(emailInput);
            if (check) {
                break;
            }
        }
        return newStudent;
    }

    public static void showInfoStudent() throws IOException {
        File_IO.readFromFile(filePath);

        for (int i = 0; i < studentList.size(); i++) {
            System.out.println(studentList.get(i).toString());
        }
    }

    public static void findInfoStudent() {
        System.out.println("Nhap ma sinh vien can tim: ");
        String rollNoFind = sc.nextLine();

        int count = 0;

        for (Student std : studentList) {
            if (std.getRollNo().equals(rollNoFind)) {
                System.out.println(std.toString());
                count++;
            }
        }
        if (count == 0) {
            System.err.println("Khong tim thay sinh vien trong danh sach !");
        }
    }

    public static void addInfoStudent() throws IOException {
        int n;
        System.out.println("Nhap so luong sinh vien:");
        n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap sinh vien thu " + (i + 1));
            Student std = getInputInfoStudent();
            studentList.add(std);
        }

        File_IO.writeObjectToFile(studentList, filePath);
    }

    public static void editInfoStudent() throws IOException {
        File_IO.readFromFile(filePath);

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

        File_IO.writeObjectToFile(studentList, filePath);
    }

    public static void deleteInfoStudent() throws IOException {
        File_IO.readFromFile(filePath);

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

        File_IO.writeObjectToFile(studentList, filePath);
    }

    public static void checkMarkStudent() {
        int count = 0;
        System.out.println("Nhap ma sinh vien muon check diem trung binh ");
        String removeRollNo = sc.nextLine();

        for (Student std : studentList) {
            if (std.getRollNo().equals(removeRollNo)) {
                if (std.getMark() >= 8.0) {
                    System.err.println("Hoc sinh Gioi !");
                } else if (std.getMark() < 8.0 && std.getMark() >= 6.5) {
                    System.out.println("Hoc sinh Kha !");
                } else if (std.getMark() < 6.5 && std.getMark() >= 5.0) {
                    System.err.println("Hoc sinh Trung Binh !");
                } else if (std.getMark() < 5.0) {
                    System.err.println("Hoc lai nhe con yeu !");
                }
                count++;
                break;
            }
        }
        if (count == 0) {
            System.err.println("Khong tim thay sinh vien trong danh sach !");
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
        System.out.println("3 - Tim thong tin SV :");
        System.out.println("4 - Sua thong tin sinh vien :");
        System.out.println("5 - Xoa sinh vien :");
        System.out.println("6 - Them sinh vien :");
        System.out.println("7 - Hien thi thong tin Diem Trung Binh cua sinh vien :");
        System.out.println("8 - Thoat : ");
    }
}
