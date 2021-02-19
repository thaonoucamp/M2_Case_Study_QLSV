package quanlysinhvien;

import java.io.*;
import java.util.ArrayList;

public class File_IO {

    public static ArrayList<Student> studentList1 = Test.studentList;

    public static void writeFile() throws IOException {
        FileOutputStream out = null;
        ObjectOutputStream objOut = null;

        try {
            out = new FileOutputStream("ManageStudent.txt");
            objOut = new ObjectOutputStream(out);
            for (Student s : studentList1) {
                objOut.writeObject(s);
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    public static ArrayList<Student> readFile() throws IOException {
        FileInputStream inFileStream = null;
        ObjectInputStream inObjStream = null;

        try {
            inFileStream = new FileInputStream("ManageStudent.txt");
            inObjStream = new ObjectInputStream(inFileStream);

            studentList1 = (ArrayList<Student>) inObjStream.readObject();

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

        for (int i = 0; i < studentList1.size(); i++) {
            studentList1.get(i).showInfo();
        }
        return studentList1;
    }

}
