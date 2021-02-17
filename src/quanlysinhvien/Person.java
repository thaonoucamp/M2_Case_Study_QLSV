package quanlysinhvien;

import java.util.Scanner;

public class Person {
    private String name;
    private String gender;
    private String birtday;
    private String address;

    public Person() {
    }

    public Person(String name, String gender, String birtday, String address) {
        this.name = name;
        this.gender = gender;
        this.birtday = birtday;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirtday() {
        return birtday;
    }

    public void setBirtday(String birtday) {
        this.birtday = birtday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void inputInfo() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Nhap ten: ");
        this.setName(scan.nextLine());

        System.out.println("Nhap gioi tinh: ");
        this.setGender(scan.nextLine());

        System.out.println("Nhap ngay sinh: ");
        this.setBirtday(scan.nextLine());

        System.out.println("Nhap dia chi: ");
        this.setAddress(scan.nextLine());
    }

    public void showInfo() {
        this.toString();
    }
}
