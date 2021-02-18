package quanlysinhvien;

import java.io.*;
import java.util.*;1

public class Test {
    public static ArrayList<Student> studentList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        int choice;
        Scanner sc = new Scanner(System.in);

        do {
            showMenu();
            System.out.println("Nhap lua chon cua ban !");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    int n;
                    System.out.println("Nhap so luong sinh vien:");
                    n = Integer.parseInt(sc.nextLine());
                    for (int i = 0; i < n; i++) {
                        System.out.println("Nhap sinh vien thu " + (i + 1));
                        Student std = new Student();
                        std.inputInfo();
                        studentList.add(std);
                    }
                    break;
                case 2:
                    for (int i = 0; i < studentList.size(); i++) {
                        studentList.get(i).showInfo();
                    }
                    break;
                case 3:
                    int minIndex = 0;
                    int maxIndex = 0;

                    float minMark;
                    float maxMark;

                    minMark = studentList.get(0).getMark();
                    maxMark = studentList.get(0).getMark();

                    for (int i = 1; i < studentList.size(); i++) {
                        if (studentList.get(i).getMark() < minMark) {
                            minIndex = i;
                            minMark = studentList.get(i).getMark();
                        }
                        if (studentList.get(i).getMark() > maxMark) {
                            maxIndex = i;
                            maxMark = studentList.get(i).getMark();
                        }
                    }

                    System.out.println("Sinh vien co diem trung binh thap nhat la: ");
                    studentList.get(minIndex).showInfo();

                    System.out.println("Sinh vien co diem trung binh cao nhat la: ");
                    studentList.get(maxIndex).showInfo();
                    break;
                case 4:
                    System.out.println("Nhap ma sinh can tim: ");
                    String rollNoFind = sc.nextLine();

                    int count = 0;

                    for (Student std : studentList) {
                        if (std.getRollNo().equals(rollNoFind)) {
                            std.showInfo();
                            count++;
                        }
                    }
                    if (count == 0) {
                        System.err.println("Khong tim thay sinh vien trong danh sach !");
                    }
                    break;
                case 5:
                    Collections.sort(studentList, (o1, o2) -> {
                        int cpm = o1.getName().compareTo(o2.getName());
                        if (cpm >= 0) {
                            return 1;
                        } else {
                            return -1;
                        }
                    });
                    for (int i = 0; i < studentList.size(); i++) {
                        studentList.get(i).showInfo();
                    }
                    break;
                case 6:
                    Collections.sort(studentList, (o1, o2) -> o1.getMark() >= o2.getMark() ? -1 : 1);

                    for (int i = 0; i < studentList.size(); i++) {
                        studentList.get(i).showInfo();
                    }
                    break;
                case 7:
                    System.out.println("Good bye see again !");
                    break;
                default:
                    System.err.println("Ban chon sai ... Hay chon tu 1 - 7 lua chon toi co...thanks !");
            }

        } while (choice != 7);
    }

    static void showMenu() {
        System.out.println("1 - Nhap so luong sinh vien :");
        System.out.println("2 - Hien thi thong tin sinh vien :");
        System.out.println("3 - Hien thi diem Max va Min theo trung binh :");
        System.out.println("4 - Tim sinh vien theo MSV :");
        System.out.println("5 - Sap xep sinh vien theo A - Z va hien thi lai :");
        System.out.println("6 - Hien thi thong tin sv duoc hoc bong va sap xep theo diem cao - thap :");
        System.out.println("7 - Thoat :");
    }
}
