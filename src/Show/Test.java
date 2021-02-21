package Show;

import method.ManageStudent;

import java.io.*;
import java.util.*;

public class Test {
    public static void main(String[] args) throws IOException {

        int choice;
        Scanner sc = new Scanner(System.in);

        do {
            ManageStudent.showMenu();
            System.out.println("Nhap lua chon cua ban !");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    ManageStudent.addInfoStudent();
                    break;
                case 2:
                    ManageStudent.showInfoStudent();
                    break;
                case 3:
                    ManageStudent.findInfoStudent();
                    break;
                case 4:
                    ManageStudent.editInfoStudent();
                    break;
                case 5:
                    ManageStudent.deleteInfoStudent();
                    break;
                case 6:
                    ManageStudent.sortStudent();
                    break;
                case 7:
                    ManageStudent.checkMarkStudent();
                    break;
                case 8:
                    System.out.println("Cam on Quy Khach da su dung dich vu cua toi !");
                    break;
                default:
                    System.err.println("Ban chon sai ... Hay chon tu 1 - 8 lua chon toi co...thanks !");
            }

        } while (choice != 8);
    }
}
