package creeat;

import java.io.Serializable;
import java.util.Scanner;

public class Person implements Serializable {
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

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birtday='" + birtday + '\'' +
                ", address='" + address + '\''
                ;
    }
}
