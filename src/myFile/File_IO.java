package myFile;

import creeat.Student;
import method.ManageStudent;

import java.io.*;

public class File_IO {
    static ManageStudent manageStudent = new ManageStudent();
    static final String filePath = "ManageStudent.txt";
    static FileInputStream fileInputStream = null;
    static FileOutputStream fileOutputStream = null;

    public static void readFile() throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
        }

        fileInputStream = new FileInputStream(file);
        int check = fileInputStream.read();
        while (check != -1) {
            System.out.println((char) check);
            check = fileInputStream.read();
        }

        fileInputStream.close();
    }

    public static void writeFile() throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
        }

        fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(manageStudent.studentList);

        fileOutputStream.close();
    }
}