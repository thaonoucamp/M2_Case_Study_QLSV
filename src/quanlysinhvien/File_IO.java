package quanlysinhvien;

import java.io.*;
import java.util.ArrayList;

public class File_IO {

    public static ArrayList<Student> studentList = Test.studentList;

    public static void writeFile() throws IOException {
        FileOutputStream out = null;
        ObjectOutputStream objOut = null;

        try {
            out = new FileOutputStream("ManageStudent.dat");
            objOut = new ObjectOutputStream(out);
            objOut.writeObject(studentList);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    public static void readFile() throws IOException {
        FileInputStream inFileStream = null;
        ObjectInputStream inObjStream = null;

        try {
            inFileStream = new FileInputStream("ManageStudent.dat");
            inObjStream = new ObjectInputStream(inFileStream);

            studentList = (ArrayList<Student>) inObjStream.readObject();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inFileStream != null) {
                inFileStream.close();
            }
            if (inObjStream != null) {
                inObjStream.close();
            }
        }

        for (int i = 0; i < studentList.size(); i++) {
            studentList.get(i).showInfo();
        }
    }
}
