package myFile;

import java.io.*;

public class File_IO {
    static File file = null;
    static FileInputStream fileInputStream = null;
    static FileOutputStream fileOutputStream = null;

    public static void readFile() throws IOException {
        file = new File("ManageStudent.txt");
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
        fileOutputStream = new FileOutputStream(file);

        String s = "";
        fileOutputStream.write(s.getBytes());

        fileOutputStream.close();
    }
}